FROM adoptopenjdk/openjdk11-openj9:jre-11.0.9_11_openj9-0.23.0

ENV APP_HOME=/usr/app/
# ENV JAVA_TOOL_OPTIONS "-Dspring.profiles.active=docker"

RUN mkdir $APP_HOME

WORKDIR $APP_HOME

COPY target/dev-java-simple-crud.jar application.jar

EXPOSE 8787

CMD ["java","-jar","application.jar"]