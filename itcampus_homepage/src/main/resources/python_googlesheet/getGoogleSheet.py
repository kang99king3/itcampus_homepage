import gspread
from oauth2client.service_account import ServiceAccountCredentials

# 사용할 Google 서비스 API 정의
scope = ['https://spreadsheets.google.com/feeds','https://www.googleapis.com/auth/drive']

# 서비스 계정 키 파일 위치
creds = ServiceAccountCredentials.from_json_keyfile_name('./service-account-file.json', scope)

client = gspread.authorize(creds)

# 구글 스프레드시트 파일 열기 (공유 설정에서 서비스 계정 이메일 주소에 권한 부여 필요)
#sheet = client.open("20240426_백엔드(응답)").sheet1
sheet = client.open("homepage_answer").sheet1
#sheet = client.open_by_key("22669812").sheet1

# 스프레드시트의 모든 레코드 읽기
records = sheet.get_all_records()
print(records)

# 첫 번째 행에 데이터 추가
#sheet.append_row(["new data1", "new data2", "new data3"])

# 특정 셀 읽기
cell_value = sheet.cell(1, 1).value

print(cell_value)

