FROM tomcat:9-jre8
#FROM tomee:8-jre8-webprofile

COPY /target/SpringMVCDemo.war /usr/local/tomcat/webapps/
#COPY /target/SpringMVCDemo.war /usr/local/tomee/webapps/