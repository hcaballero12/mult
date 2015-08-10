--------------------------------------------------------
--  File created - Friday-July-31-2015   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Procedure UPDATE_BANKCUSTOMER
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "UPDATE_BANKCUSTOMER" (
	   p_id IN  BANKCUSTOMER.ACCOUNT%TYPE,
	   p_firstname IN  BANKCUSTOMER.FIRSTNAME%TYPE,
                   p_lastname IN  BANKCUSTOMER.LASTNAME%TYPE,
                   p_username IN  BANKCUSTOMER.USERNAME%TYPE,
                   p_password IN  BANKCUSTOMER.PASSWORD%TYPE,
	   p_balance IN  BANKCUSTOMER.BALANCE%TYPE)

IS
BEGIN
 
  UPDATE BANKCUSTOMER SET   FIRSTNAME = p_firstname, LASTNAME = p_lastname, USERNAME = p_username, PASSWORD = p_password, BALANCE = p_balance WHERE ACCOUNT= p_id;
 
  COMMIT;
 
END;

/
