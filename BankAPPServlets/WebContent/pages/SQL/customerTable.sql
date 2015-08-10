--------------------------------------------------------
--  File created - Friday-July-31-2015   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table BANKCUSTOMER
--------------------------------------------------------

  CREATE TABLE "BANKCUSTOMER" 
   (	"ACCOUNT" NUMBER, 
	"FIRSTNAME" VARCHAR2(100 BYTE), 
	"LASTNAME" VARCHAR2(100 BYTE), 
	"USERNAME" VARCHAR2(100 BYTE), 
	"PASSWORD" VARCHAR2(100 BYTE), 
	"BALANCE" NUMBER
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
REM INSERTING into BANKCUSTOMER
SET DEFINE OFF;
Insert into BANKCUSTOMER (ACCOUNT,FIRSTNAME,LASTNAME,USERNAME,PASSWORD,BALANCE) values (1,'Alta	','Dillon','alta23','1234',2329);
Insert into BANKCUSTOMER (ACCOUNT,FIRSTNAME,LASTNAME,USERNAME,PASSWORD,BALANCE) values (23,'Rosa','Melano','melano12','1234',2000);
Insert into BANKCUSTOMER (ACCOUNT,FIRSTNAME,LASTNAME,USERNAME,PASSWORD,BALANCE) values (22,'Lola','Meras','meras123','1234',-10000);
Insert into BANKCUSTOMER (ACCOUNT,FIRSTNAME,LASTNAME,USERNAME,PASSWORD,BALANCE) values (7,'Martha','Lombardo','lombardo2','1234',400);
Insert into BANKCUSTOMER (ACCOUNT,FIRSTNAME,LASTNAME,USERNAME,PASSWORD,BALANCE) values (3,'Wilfred	','Carter','wilfred234','1234',50);
Insert into BANKCUSTOMER (ACCOUNT,FIRSTNAME,LASTNAME,USERNAME,PASSWORD,BALANCE) values (4,'Arlene	','Fisher','fisher45','1234',0);
Insert into BANKCUSTOMER (ACCOUNT,FIRSTNAME,LASTNAME,USERNAME,PASSWORD,BALANCE) values (5,'Patsy','Guerrero','guerrero23','1234',0);
Insert into BANKCUSTOMER (ACCOUNT,FIRSTNAME,LASTNAME,USERNAME,PASSWORD,BALANCE) values (6,'Tracey','Brady','tracey12','1234',400);
Insert into BANKCUSTOMER (ACCOUNT,FIRSTNAME,LASTNAME,USERNAME,PASSWORD,BALANCE) values (8,'Tracey','Lombardo','lombardo2','1234',400);
--------------------------------------------------------
--  DDL for Index BANKCUSTOMER_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "BANKCUSTOMER_PK" ON "BANKCUSTOMER" ("ACCOUNT") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  Constraints for Table BANKCUSTOMER
--------------------------------------------------------

  ALTER TABLE "BANKCUSTOMER" ADD CONSTRAINT "BANKCUSTOMER_PK" PRIMARY KEY ("ACCOUNT")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS"  ENABLE;
 
  ALTER TABLE "BANKCUSTOMER" MODIFY ("BALANCE" NOT NULL ENABLE);
--------------------------------------------------------
--  DDL for Trigger BI_BANKCUSTOMER
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "BI_BANKCUSTOMER" 
  before insert on "BANKCUSTOMER"               
  for each row  
begin   
    select "BANKCUSTOMER_SEQ".nextval into :NEW.ACCOUNT from dual; 
end; 

/
ALTER TRIGGER "BI_BANKCUSTOMER" ENABLE;