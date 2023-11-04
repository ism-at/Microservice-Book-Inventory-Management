# The 12-Factor App: Implementation in Book Inventory Management Microservice


## 1. Codebase

### One codebase tracked in revision control, many deploys.

The Book Inventory Management service is maintained in a single codebase on GitHub, ensuring version control. Each commit can be built and deployed independently.

## 2. Dependencies

### Explicitly declare and isolate dependencies.

All dependencies are explicitly defined in the pom.xml file. This ensures that the build process is repeatable and consistent across all environments, especially inside the Docker container.

## 3. Config

### Store config in the environment.

Sensitive configurations, especially those that can vary between environments (like database credentials), can be externalized using environment variables in conjunction with Spring's @Value annotations.

## 4. Backing Services

### Treat backing services as attached resources.

The H2 in-memory database is used as a backing service. In a real-world scenario, switching to another database would involve only changes in the configuration without altering the code.

## 5. Build, Release, Run

### Strictly separate build and run stages.

The application uses Maven for building. Docker is then used to release (by creating an image) and run the application, ensuring a strict separation of stages.

## 6. Processes

### Execute the app as one or more stateless processes.

The Spring Boot application is inherently stateless. All data is stored in the H2 database (or an external database in a more realistic setup).

## 7. Port Binding

### Export services via port binding.

The service runs on port 8080, which is exported and can be accessed outside the Docker container, making the service available for consumption.

## 8. Concurrency

### Scale out via the process model.

The application can be scaled horizontally by running multiple Docker containers if needed.

## 9. Disposability

### Maximize robustness with fast startup and graceful shutdown.

Spring Boot ensures fast startup, and Docker facilitates graceful shutdown, ensuring that in-progress requests are processed before the service is terminated.

## 10. Dev/prod parity

### Keep development, staging, and production as similar as possible.

By using Docker, we ensure that the environment remains consistent across development, staging, and production, minimizing discrepancies.

## 11. Logs

### Treat logs as event streams.

Spring Boot logs to the console by default. When running inside Docker, logs are treated as event streams and can be viewed using the docker logs command.

## 12. Admin Processes

### Run admin/management tasks as one-off processes.

For this simple application, no explicit admin processes are defined. In a more comprehensive setup, tasks like database migrations could be run as one-off processes using tools like Flyway.


