FROM ghcr.io/graalvm/graalvm-ce:ol8-java17-22

ENV APP_HOME=/usr/app/

RUN mkdir $APP_HOME

WORKDIR $APP_HOME

COPY target/dev-java-simple-crud.jar application.jar

EXPOSE 8787

CMD ["java","-jar","application.jar"]