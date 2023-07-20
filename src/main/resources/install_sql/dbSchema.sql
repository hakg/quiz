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
  `USER_ID` VARCHAR(100) NOT NULL,
  `USER_NAME` VARCHAR(100) NOT NULL,
  `PASSWORD` VARCHAR(100) NOT NULL,
  `USER_ROLE` VARCHAR(20) DEFAULT 'UESR' NOT NULL,
  `USER_STATUS` VARCHAR(1) DEFAULT '1',
  `LAST_LOGIN_DATE` DATETIME DEFAULT NULL,
  `PASSWORD_UPDATE_DATE` DATETIME NOT NULL,
  `INSERT_ID` VARCHAR(100) NOT NULL,
  `INSERT_DATE` DATETIME NOT NULL,
  `MODIFY_ID` VARCHAR(100) NOT NULL,
  `MODIFY_DATE` DATETIME NOT NULL,
  PRIMARY KEY (`USER_ID`)
);

# Menu 테이블 생성 스키마
CREATE TABLE `menu` (
  `menu_code` varchar(10) NOT NULL,
  `menu_name` varchar(100) NOT NULL,
  `menu_gubun` char(1) NOT NULL,
  `parentAuthID` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`menu_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;

INSERT INTO menu
(menu_code, menu_name, menu_gubun, parent_menu_id, menu_url, submenu_name)
VALUES('0100', '퀴즈', 'A', '0100', NULL, NULL);
INSERT INTO menu
(menu_code, menu_name, menu_gubun, parent_menu_id, menu_url, submenu_name)
VALUES('0110', '자바', 'A', '0100', '/java/question', '문제풀기');
INSERT INTO menu
(menu_code, menu_name, menu_gubun, parent_menu_id, menu_url, submenu_name)
VALUES('0120', '스프링', 'A', '0100', NULL, '문제풀기');
INSERT INTO menu
(menu_code, menu_name, menu_gubun, parent_menu_id, menu_url, submenu_name)
VALUES('0200', '관리자', 'U', '0200', NULL, NULL);
INSERT INTO menu
(menu_code, menu_name, menu_gubun, parent_menu_id, menu_url, submenu_name)
VALUES('0210', '회원정보', 'U', '0200', '/account', '회원정보');
INSERT INTO menu
(menu_code, menu_name, menu_gubun, parent_menu_id, menu_url, submenu_name)
VALUES('0220', '문제관리', 'U', '0200', NULL, '문제추가');
# 회원정보 노출 정보
update menu
   set menu_url = '/account'
 where menu_code = '0210';


CREATE TABLE QUIZ (
  QUIZ_ID int(11) NOT NULL AUTO_INCREMENT,
  CATEGORY varchar(50) NOT NULL,
  QUIZ_INFO varchar(100) NOT NULL,
  INSERT_ID varchar(100) NOT NULL,
  INSERT_DATE date NOT NULL,
  MODIFY_ID varchar(100) DEFAULT NULL,
  MODIFY_DATE date NULL,
  PRIMARY KEY (`quiz_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE ANSWER (
  ANSWER_ID INT(11) NOT NULL AUTO_INCREMENT,
  QUIZ_ID INT(11) NOT NULL,
  ANSWER_DESC varchar(500) NOT NULL,
  ANSWER_KEYWORD varchar(500) NOT NULL,
  INSERT_ID varchar(30),
  INSERT_DATE TIMESTAMP,
  MODIFY_ID varchar(30),
  MODIFY_DATE TIMESTAMP,
  PRIMARY KEY (ANSWER_ID),
  FOREIGN KEY (QUIZ_ID) REFERENCES QUIZ(QUIZ_ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;