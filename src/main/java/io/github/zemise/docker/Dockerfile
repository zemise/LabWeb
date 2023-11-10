FROM mdsol/java17-jdk
# 设置作者信息
LABEL maintainer="zemise <373933306@qq.com>"

VOLUME /tmp
ARG JAR_FILE
COPY ${JAR_FILE} app.jar
#COPY labweb-0.0.1-SNAPSHOT.jar app.jar
#COPY ./src/docker/run.sh .
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app.jar"]