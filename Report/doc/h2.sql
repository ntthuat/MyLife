-- Create Schema REPORT
CREATE SCHEMA IF NOT EXISTS REPORT;
commit; -- TODO: NEED TO USE?

-------------------
-- REPORT.EMPLOYEE;
--DROP TABLE REPORT.EMPLOYEE;

CREATE TABLE REPORT.EMPLOYEE
(IDEMPLOYEE VARCHAR NOT NULL,
FIRSTNAME VARCHAR NOT NULL,
LASTNAME VARCHAR NOT NULL,
BIRTHDAY VARCHAR NOT NULL,
JOBTITLE VARCHAR NOT NULL,
COMPANY VARCHAR NOT NULL,
ADDRESS VARCHAR NOT NULL,
CITY VARCHAR NOT NULL,
COUNTRY VARCHAR NOT NULL,
PHONENUMBER VARCHAR NOT NULL,
PRIMARY KEY (IDEMPLOYEE));

INSERT INTO REPORT.EMPLOYEE VALUES ('001', 'Phuong','Doan Thi Lam', '1997','Supervisor','Tinh Hoa','Cam Lam','Khanh Hoa','Viet Nam','0164 918 5xxx');
INSERT INTO REPORT.EMPLOYEE VALUES ('002', 'Thuat', 'Nguyen Thien', '1992','Engineer',   'Codix',  'Ba Tri', 'Ben Tre',  'Viet Nam',  '0124 7679 xxx');
INSERT INTO REPORT.EMPLOYEE VALUES ('003', 'Nhung', 'Doan Thi Hong','1994','NA',         'NA',     'Cam Lam','Khanh Hoa','Viet Nam',  'NA');

SELECT * FROM REPORT.EMPLOYEE;

-------------------
-- REPORT.CLIENT;
--DROP TABLE REPORT.CLIENT;
CREATE TABLE REPORT.CLIENT
(IDCLIENT    VARCHAR NOT NULL,
 FIRSTNAME   VARCHAR NOT NULL,
 LASTNAME    VARCHAR NOT NULL,
 BIRTHDAY    DATE    NOT NULL,
 NUMBERPHONE VARCHAR NOT NULL,
 ADDRESS     VARCHAR NOT NULL,
 JOB         VARCHAR NOT NULL,
 COUNTRY     VARCHAR NOT NULL,
 CREATEDDATE DATE    NOT NULL,
 NOTE        VARCHAR NOT NULL,
PRIMARY KEY (IDCLIENT));

INSERT INTO REPORT.CLIENT VALUES('001', 'Anh', 'Hồ Võ Quốc', '1992-10-02', '01644032290', 'Hồ Chí Minh', 'Super Culi', 'Việt Nam', SYSDATE , 'Test');
INSERT INTO REPORT.CLIENT VALUES('002', 'Thuật', 'Nguyễn Thiện', '1992-01-16', '01247679629', 'Hồ Chí Minh', 'Coder', 'Việt Nam', SYSDATE , 'Test');