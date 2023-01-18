#FROM ubuntu:latest
#LABEL authors="User"
#
#ENTRYPOINT ["top", "-b"]

# Указываем базовый образ с нужной версией Java
FROM openjdk:21-jdk

# Устанавливаем рабочую директорию
WORKDIR /app

# Копируем файл с зависимостями
COPY pom.xml .
COPY src ./src
COPY pom.xml ./
COPY mvnw ./
COPY .mvn ./.mvn

# Собираем приложение
RUN ./mvnw clean package -DskipTests

# Копируем скомпилированный jar файл
COPY target/BankCardManagementSystem-0.0.1-SNAPSHOT.jar app.jar

# Указываем команду для запуска приложения
ENTRYPOINT ["java", "-jar", "app.jar"]
