Created by Wolfgang Unger, 6.2017


Simple Liquibase example with JEE/CDI startup


Pre-Conditions:
Local Postgres DB (Standard Installation) with Schema 'lb'
User postgres, Password postgres
Connection Pool and JDBC Resource on App Server (jdbc/lb)


you will see 
######### Starting Liquibase
In the console on startup

After App start there will be 4 tables
databasechangelog(liquibase table)
databasechangeloglock(liquibase table)
t_example1(created by sql)
t_example2 (created by xml)

in table t_example2 will be one entry (by liquibase insert)
