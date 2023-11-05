# Step1: Use the official OpenJDK base image
FROM openjdk:17-jdk-slim

# Step2: Set the application directory inside the container
WORKDIR /app

# Step3: Copy the Maven build output into the container
COPY ./target/book-inventory-0.0.1-SNAPSHOT.jar /app/book-inventory.jar

# Step4: Expose port 8080 for the application
EXPOSE 8080

# Step5: Command to run the application
CMD ["java", "-jar", "book-inventory.jar"]