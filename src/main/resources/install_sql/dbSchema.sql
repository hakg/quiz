# 마리아 디비 세팅 참고 사이트
 ㄴ cmd root 계정으로 처리시 - http://ducj3.iptime.org/mariadb/
 ㄴ

mariadb DB생성 후 계정 생성 및 권한 부여
1. 터미널접속   : win + s => mysql client 실행
2. root계정접속 : root 계정 비밀번호 입력하여 접속
3. DB생성       : create database quiz CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
4. 계정생성     : create user 'javauser'@'%';
5. 계정PW 변경  : SET PASSWORD FOR 'javauser'@'%'=password('1234');
6. 권한부여     : GRANT ALL PRIVILEGES ON *.* TO javauser@'%' IDENTIFIED BY '1234' WITH GRANT OPTION;
              GRANT ALL PRIVILEGES ON *.* TO javauser@localhost IDENTIFIED BY '1234' WITH GRANT OPTION;
              GRANT ALL PRIVILEGES ON *.* TO javauser@localhost.localdomain IDENTIFIED BY '1234' WITH GRANT OPTION;
7. 처리건 적용  : flush privileges;
8. 계정 조회    : select user, host, password from mysql.user;


# USER 테이블 생성 스키마
CREATE TABLE `USER` (
  `EMAIL` VARCHAR(100) NOT NULL,
  `USER_NAME` VARCHAR(100) NOT NULL,
  `PASSWORD` VARCHAR(100) NOT NULL,
  `USER_GUBUN` VARCHAR(1) DEFAULT 'U',
  `INSERT_DATE` DATETIME NOT NULL,
  `MODIFY_DATE` DATETIME NOT NULL,
  `LAST_LOGIN_DATE` DATETIME DEFAULT NULL,
  `PASSWORD_UPDATE_DATE` DATETIME NOT NULL,
  PRIMARY KEY (`EMAIL`)
);

# Menu 테이블 생성 스키마
CREATE TABLE `menu` (
  `menu_code` varchar(10) NOT NULL,
  `menu_name` varchar(100) NOT NULL,
  `menu_gubun` char(1) NOT NULL,
  `parentAuthID` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`menu_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
