create database hospitaldb;

connect hospitaldb;

create table patient_tbl (
   patientid INT NOT NULL,
   patientname  VARCHAR(45) NULL,
   age  INT NULL,
   PRIMARY KEY ( patientid )
);

INSERT INTO patient_tbl VALUES (1, 'Richa',40);
INSERT INTO patient_tbl VALUES (2, 'Ram',65);
INSERT INTO patient_tbl VALUES (3, 'Sita',60);
INSERT INTO patient_tbl VALUES (4, 'Priyanka',30);
INSERT INTO patient_tbl VALUES (5, 'Priya',12);
INSERT INTO patient_tbl VALUES (6, 'Prashant',33);
INSERT INTO patient_tbl VALUES (7, 'John',50);
INSERT INTO patient_tbl VALUES (8, 'Harry',40);

create table appointment_tbl(
	appointmentid INT NOT NULL,
	patientid INT,
	doctorid INT,
	appointmentdate DATE,
	analysisReport VARCHAR(40),
	tests VARCHAR(40) NULL,
	PRIMARY KEY ( appointmentid )
);


INSERT INTO appointment_tbl VALUES(1,1,102,'2017-01-09',null,null);
INSERT INTO appointment_tbl VALUES(2,1,102,'2017-01-04','Patient suffering from continous Headache','BloodSugar,StressTest,LipidProfile,B12');
INSERT INTO appointment_tbl VALUES(3,2,102,'2017-01-10',null,null);
INSERT INTO appointment_tbl VALUES(4,4,107,'2017-01-10',null);
INSERT INTO appointment_tbl VALUES(5,6,104,'2017-01-09','Regualer health checkup','StressTest,XRay,ECG');
INSERT INTO appointment_tbl VALUES(6,3,105,'2017-01-09',null,null);
INSERT INTO appointment_tbl VALUES(7,3,103,'2017-01-09','Perform the suggested test','BloodTest,Thyroid,B12');
INSERT INTO appointment_tbl VALUES(8,5,107,'2017-01-05','Sweling and pain obsered in left leg','XRay');
INSERT INTO appointment_tbl VALUES(9,6,101,'2017-01-09',null,null);
INSERT INTO appointment_tbl VALUES(10,7,104,'2017-01-09','Regualer health checkup','StressTest,XRay,ECG');