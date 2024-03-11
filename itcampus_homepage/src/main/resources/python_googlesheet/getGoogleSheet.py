import gspread
from oauth2client.service_account import ServiceAccountCredentials

import mysql.connector
from datetime import datetime, timedelta

# itcampus@gmail.com 계정으로 API 셋팅  
# https://console.cloud.google.com/welcome?project=homepage-reservation&authuser=1

# 사용할 Google 서비스 API 정의
scope = ['https://spreadsheets.google.com/feeds','https://www.googleapis.com/auth/drive']

# 서비스 계정 키 파일 위치
creds = ServiceAccountCredentials.from_json_keyfile_name('./service-account-file.json', scope)

client = gspread.authorize(creds)

# 구글 스프레드시트 파일 열기 (공유 설정에서 서비스 계정 이메일 주소에 권한 부여 필요)
#sheet = client.open("20240426_백엔드(응답)").sheet1
sheet = client.open("^Hhomepage_answer").sheet1
#sheet = client.open_by_key("22669812").sheet1

# MySQL 연결 설정
mydb = mysql.connector.connect(
  host="192.168.219.99",
  user="homepage",
  password="homepage",
  database="homepage"
)

# 커서 생성
mycursor = mydb.cursor()

# 데이터베이스의 기존 데이터 삭제
#delete_query = "DELETE FROM your_table"
#mycursor.execute(delete_query)
#mydb.commit()


# 스프레드시트의 모든 레코드 읽기
records = sheet.get_all_records()
# 모든 딕셔너리의 키를 출력합니다.
dbkeys = ['registertime', 'email', 'agree', 'name', 'birth', 'phone', 'addr', 'sex', 'edulevel', 'major', 'qualifications', 'card', 'path', 'questions']
for item in records:
    keys = item.keys()
    values = [item[key] for key in keys]
    placeholders = ', '.join(['%s'] * (len(values)-3))
    insert_query = f"INSERT INTO qna ({', '.join(dbkeys)}) VALUES ({placeholders})"
    # 0번째 timestamp를 연산이 가능하도록 변경한다. 
    timestamp_str = values[0] 
    # '오후'가 있는지 확인하여 오후인 경우에만 12시간을 더해줌
    if '오후' in timestamp_str:
        timestamp_obj = datetime.strptime(timestamp_str, '%Y. %m. %d 오후 %I:%M:%S')
        timestamp_obj += timedelta(hours=12)
    else:
        timestamp_obj = datetime.strptime(timestamp_str, '%Y. %m. %d 오전 %I:%M:%S') 
    # 변환된 한국 시간을 포맷에 맞춰서 문자열로 변환
    formatted_timestamp = timestamp_obj.strftime('%Y-%m-%d %H:%M:%S')
    # values 리스트의 첫 번째 항목을 변환된 문자열로 업데이트
    values[0] = formatted_timestamp    
    values = values[:-3] 
    
     # DB에 같은 타임스탬프가 있는지 확인
    check_query = "SELECT COUNT(*) FROM qna WHERE registertime = %s"
    mycursor.execute(check_query, (values[0],))
    if mycursor.fetchone()[0] > 0: 
        print(formatted_timestamp , values[3], " 가 이미 존재함")
        continue  # 타임스탬프가 이미 존재하면 추가하지 않음 


    print(insert_query,tuple(values))
    mycursor.execute(insert_query, tuple(values))
    mydb.commit()

# 첫 번째 행에 데이터 추가
#sheet.append_row(["new data1", "new data2", "new data3"])
# 특정 셀 읽기
#cell_value = sheet.cell(1, 1).value

mycursor.close()
mydb.close()
