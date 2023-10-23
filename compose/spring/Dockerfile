FROM openjdk:17
VOLUME /tmp
EXPOSE 5000
ADD devtest-1.0.0.jar devtest.jar
ENTRYPOINT ["java","-jar","devtest.jar"]