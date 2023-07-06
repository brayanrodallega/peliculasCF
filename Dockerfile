# Utilizar la imagen base de Java 17
FROM openjdk:17

# Establecer el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiar los archivos pom.xml y el Maven Wrapper
COPY pom.xml .
COPY mvnw .
COPY .mvn .mvn

# Descargar las dependencias del proyecto utilizando el Maven Wrapper
RUN ./mvnw dependency:go-offline -B

# Copiar todo el contenido del proyecto al directorio de trabajo
COPY . .

# Compilar el proyecto utilizando el Maven Wrapper
RUN ./mvnw package -DskipTests

# Exponer el puerto 8080
EXPOSE 8080

# Ejecutar el comando para iniciar la aplicación Spring Boot
CMD ["java", "-jar", "target/peliculas-0.0.1-SNAPSHOT.jar"]
