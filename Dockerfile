FROM maven:openjdk AS MAVEN
WORKDIR /tmp/
COPY /src/ ./
RUN mvn package

FROM node AS REACT
WORKDIR /tmp
COPY /web/package.json/  ./
COPY /web/src ./src
COPY /web/public ./public
RUN yarn install
RUN yarn build

FROM openjdk:14-alpine
WORKDIR /tmp
COPY --FROM MAVEN /tmp ./tmp/
COPY --FROM REACT /tmp ./tmp/webapp/

CMD ["java", "-jar","Heroku01.jar"]