FROM maven:3-amazoncorretto-21
EXPOSE 8081
COPY . .
RUN mvn clean install -Dmaven.test.skip=true
CMD mvn spring-boot:run