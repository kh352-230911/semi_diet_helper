FROM tomcat:9-jdk17
COPY target/semi.war /usr/local/tomcat/webapps/semi.war
COPY src/main/resources/configs/Wallet_VLAOHSDEXLPS1JCQ /Wallet_VLAOHSDEXLPS1JCQ