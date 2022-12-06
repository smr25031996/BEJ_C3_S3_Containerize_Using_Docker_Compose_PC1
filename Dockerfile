FROM openjdk:19
WORKDIR usr/lib
ADD ./target/BEJ_C3_S3_Containerize_Using_Docker_Compose_PC1-0.0.1-SNAPSHOT.jar /usr/lib/BEJ_C3_S3_Containerize_Using_Docker_Compose_PC1-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","BEJ_C3_S3_Containerize_Using_Docker_Compose_PC1-0.0.1-SNAPSHOT.jar"]