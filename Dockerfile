FROM openjdk:13
COPY ./build/libs/elastic-search-0.0.2.jar /usr/app/
WORKDIR /usr/app/
EXPOSE 9000:9000
ENTRYPOINT ["java", "-jar", "elastic-search-0.0.2.jar"]