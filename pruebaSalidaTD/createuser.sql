-- create new user
alter session set "_ORACLE_SCRIPT"=true;
CREATE USER pruebaSalidaTD IDENTIFIED BY pruebaSalidaTD;

-- grant priviledges
GRANT CONNECT, RESOURCE, DBA TO pruebaSalidaTD;