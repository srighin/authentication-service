create table GIG_ECONOMY.USER (
                                  ID int not null AUTO_INCREMENT,
                                  username VARCHAR(20),
                                  mfa boolean,
                                  FIRST_NAME VARCHAR(20),
                                  LAST_NAME VARCHAR(20),
                                  EMAIL  VARCHAR(50),
                                  PASSWORD VARCHAR(256),
                                  active boolean,
                                  secrets VARCHAR(200),
                                  created_dt datetime,
                                  PRIMARY KEY (ID),
                                  UNIQUE KEY (EMAIL)
);

create table GIG_ECONOMY.ROLE (
                                  ID INT NOT NULL AUTO_INCREMENT,
                                  NAME VARCHAR(20),
                                  PRIMARY KEY(ID)
);

CREATE TABLE GIG_ECONOMY.USER_ROLE(
                                      USER_ID int,
                                      ROLE_ID int,
                                      FOREIGN KEY (USER_ID) REFERENCES USER(ID),
                                      FOREIGN KEY (ROLE_ID) REFERENCES ROLE(ID)
);

insert into GIG_ECONOMY.ROLE values (1, 'ROLE_ADMIN');
insert into GIG_ECONOMY.ROLE values (2, 'ROLE_USER');
