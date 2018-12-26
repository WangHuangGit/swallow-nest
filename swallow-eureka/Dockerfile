FROM java:8
VOLUME /tmp
ADD eureka.jar eureka.jar
RUN bash -c 'touch /eureka.jar'
ENTRYPOINT ["java","-jar","/eureka.jar"]