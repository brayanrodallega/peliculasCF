# Utilizar una imagen base con Java y Maven instalados
FROM maven:3.8.4-openjdk-17-slim AS build

# Establecer el directorio de trabajo en la raíz del proyecto
WORKDIR /app

# Copiar el archivo pom.xml al directorio de trabajo
COPY pom.xml .

# Descargar las dependencias del proyecto
RUN mvn dependency:go-offline -B

# Copiar el resto de los archivos del proyecto al directorio de trabajo
COPY src ./src

# Compilar el proyecto
RUN mvn package -DskipTests

# Crear una imagen final con una versión más ligera de Java
FROM adoptopenjdk:17-jre-hotspot

# Establecer el directorio de trabajo en la raíz de la aplicación
WORKDIR /app

# Copiar el archivo JAR generado durante la compilación
COPY --from=build /app/target/peliculas-0.0.1-SNAPSHOT.jar ./app.jar

# Exponer el puerto en el que se ejecutará la aplicación
EXPOSE 8080

# Comando para ejecutar la aplicación cuando el contenedor se inicie
CMD ["java", "-jar", "app.jar"]
