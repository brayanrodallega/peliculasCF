# Use an official OpenJDK runtime as the base image
FROM openjdk:17

# Set the working directory inside the container
WORKDIR /app

# Copy the Maven project file
COPY pom.xml .

# Download all the dependencies to build the application
RUN mvn dependency:go-offline -B

# Copy the source code to the container
COPY src ./src

# Build the application
RUN mvn package -DskipTests

# Set the entry point to run the application
ENTRYPOINT ["java", "-jar", "target/peliculas-0.0.1-SNAPSHOT.jar"]
