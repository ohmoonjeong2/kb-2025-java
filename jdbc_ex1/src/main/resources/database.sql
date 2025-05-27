CREATE TABLE users (
  ID varchar(12) NOT NULL,
  PASSWORD varchar(12) NOT NULL,
  NAME varchar(30) NOT NULL,
  ROLE varchar(6) NOT NULL,
  PRIMARY KEY (ID)
);

INSERT INTO users VALUES 
('admin',	'admin123',	'관리자',	'ADMIN'),
('guest',	'guest123',	'방문자',	'USER'),
('member',	'member123',	'일반회원',	'USER'); 