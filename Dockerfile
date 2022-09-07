FROM tomcat:8.0.20-jre8
#FROM tomee:8-jre-1.7.2-webprofile

COPY /target/SpringMVCDemo.war /usr/local/tomcat/webapps/
#COPY /target/SpringMVCDemo.war /usr/local/tomee/webapps/