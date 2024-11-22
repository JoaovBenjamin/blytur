# Etapa de Build
FROM maven:3.9.4-eclipse-temurin-17 AS build

# Define o diretório de trabalho dentro do container
WORKDIR /app

# Copia todos os arquivos do projeto para o container
COPY . .

# Executa o comando de build com Maven
RUN mvn clean install -DskipTests

# Etapa Final
FROM openjdk:17-jdk-slim

# Expõe a porta 8080
EXPOSE 8080

# Copia o arquivo JAR gerado na etapa de build para a imagem final
COPY --from=build /app/target/blytur-1.0.0.jar app.jar

# Comando de entrada para rodar o JAR
ENTRYPOINT ["java", "-jar", "app.jar"]
