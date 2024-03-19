#!/bin/bash

# MySQL 서비스 상태를 확인합니다.
status=$(systemctl is-active mysqld)

if [ "$status" == "active" ]; then
    echo "MySQL is running."
else
    echo "MySQL is down. Attempting to restart."
    # MySQL 서비스를 재시작합니다. sudo가 필요한 경우, 스크립트를 root 권한으로 실행해야 합니다.
    systemctl restart mysqld

    # 재시작 후 상태를 확인합니다.
    if systemctl is-active --quiet mysqld; then
        echo "MySQL has been successfully restarted."
    else
        echo "Failed to restart MySQL."
    fi
fi