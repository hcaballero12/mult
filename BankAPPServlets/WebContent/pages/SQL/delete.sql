--------------------------------------------------------
--  File created - Friday-July-31-2015   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Procedure DELETE_BANKCUSTOMER
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "DELETE_BANKCUSTOMER" (p_userid IN BANKCUSTOMER.ACCOUNT%TYPE)
IS
BEGIN
 
  DELETE BANKCUSTOMER WHERE ACCOUNT= p_userid;
 
  COMMIT;
 
END;

/
