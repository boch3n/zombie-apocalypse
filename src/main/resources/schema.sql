DROP TABLE IF EXISTS PATIENTS_TB;

CREATE TABLE PATIENTS_TB (
                                ID INT AUTO_INCREMENT  PRIMARY KEY,
                                ILLNESS VARCHAR(250) NOT NULL,
                                PAIN INT NOT NULL,
                                HOSPITAL VARCHAR(250) NOT NULL,
                                PROCESS_TIME INT NOT NULL,
                                PATIENTS INT NOT NULL,
                                WAITING_TIME INT NOT NULL
);
