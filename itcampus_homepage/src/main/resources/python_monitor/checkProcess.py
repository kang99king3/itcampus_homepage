import os
import requests
import subprocess

def check_health_and_restart():
    if not check_root():
        print("Error: This script must be run with root privileges.")
        return

    url = "http://localhost:8080/actuator/health"  # Spring Actuator health 엔드포인트 URL
    try:
        response = requests.get(url)
        response.raise_for_status()  # HTTP 오류가 발생하면 예외를 발생시킴
        if "DOWN" in response.json().get("status", ""):
            restart_application()
    except requests.exceptions.RequestException as e:
        print(f"Error occurred while checking health: {e}")
        restart_application()
    except Exception as e:
        print(f"Error occurred: {e}")

def check_root():
    return os.geteuid() == 0

def restart_application():
    try:
        # 백그라운드에서 실행하는 명령어
        subprocess.Popen(["java", "-jar", "/Users/kwak/git/itcampus_homepage/itcampus_homepage/target/itcampus_homepage-4.2.0.jar"])
        print("Command executed in background!")
    except Exception as e:
        print("Command execution failed!")
        print("Error:", e)

if __name__ == "__main__":
    check_health_and_restart()

