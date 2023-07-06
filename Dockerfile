# Usa la imagen de Java 17 como base
FROM adoptopenjdk:17-jdk-hotspot

# Establece el directorio de trabajo en /app
WORKDIR /app

# Copia el archivo pom.xml al directorio de trabajo
COPY pom.xml .

# Instala Maven y descarga las dependencias del proyecto
RUN apt-get update && apt-get install -y maven && mvn dependency:go-offline

# Copia el resto de los archivos al directorio de trabajo
COPY src ./src

# Empaqueta la aplicación usando Maven
RUN mvn package -DskipTests

# Expone el puerto 8080
EXPOSE 8080

# Establece el comando de inicio de la aplicación
CMD ["java", "-jar", "target/peliculas-0.0.1-SNAPSHOT.jar"]
