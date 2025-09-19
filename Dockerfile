# Use uma imagem com JDK 17
FROM eclipse-temurin:17-jdk-alpine

# Define o diretório da aplicação
WORKDIR /app

# Copia o pom.xml e baixa dependências
COPY pom.xml .
RUN ./mvnw dependency:go-offline -B

# Copia todo o código fonte
COPY src ./src

# Build da aplicação
RUN ./mvnw package -DskipTests

# Define porta exposta
EXPOSE 8080

# Comando para rodar a aplicação
CMD ["java", "-jar", "target/jfpersonalapi-0.0.1.jar"]
