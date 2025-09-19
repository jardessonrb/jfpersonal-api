# Imagem com Maven + JDK 17
FROM maven:3.9.5-eclipse-temurin-17

WORKDIR /app

# Copia pom.xml e baixa dependências offline (cache)
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copia código fonte
COPY src ./src

# Build da aplicação
RUN mvn package -DskipTests

EXPOSE 8080

CMD ["java", "-jar", "target/jfpersonalapi-0.0.1.jar"]
