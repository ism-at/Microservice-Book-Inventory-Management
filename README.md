# Microservice-Book-Inventory-Management
This microservice allows users to CRUD (Add books with details, Retrieve the list of books, Update book details and Delete a book from the inventory).

## Technology
Java with Spring Boot, an embedded H2 database and Docker.

## Requirments
The only will be needed is a Docker. Ensure you have Docker installed on your computer.

## Setup & Execution

### Clone the Repository
    Clone the GitHub repository containing the Book Inventory Management microservice to your local machine, using:
    git clone https://github.com/ism85/Microservice-Book-Inventory-Management.git
    And then navigate to the project directory on you local machine, , using:
    cd [PROJECT_DIRECTORY]

### Build Docker Image
    Now you have to be on the root directory of the project, build the Docker image, using:
    docker build -t book-inventory:latest .
    This command will read the Dockerfile present in the root directory and build an image named book-inventory with the tag latest.

### Run Docker Container
    Start the microservice inside a Docker container, using:
    docker run -p 8080:8080 book-inventory:latest
    This will start the Spring Boot application inside a Docker container and the application will be accessible at http://localhost:8080/books.

### Endpoints
    - POST /books: Add a new book. Requires a book object in the request body.
    - GET  /books: Retrieve all books in the inventory.
    - GET  /books/{id}: Retrieve a specific book by its ID.
    - PUT  /books/{id}: Update an existing book. Requires a book object in the request body.
    - DELETE /books/{id}: Delete a specific book by its ID.

## Conclusion

    Since Docker is the only expected runtime environment on the executing machine, 
    this setup ensures easy deployment and provides a consistent environment for running the microservice regardless of where Docker is running.
    






   
