@echo off

set "CATALINA_HOME=%CD%\server\apache-tomcat-9.0.58"

echo "starting Camunda Platform 7.17.0 on Apache Tomcat 9.0.58"

cd server\apache-tomcat-9.0.58\bin\
start startup.bat

ping -n 5 localhost > NULL
start http://localhost:8080/camunda-welcome/index.html
 