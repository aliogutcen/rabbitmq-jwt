# SpringMicroservices




## Prerequisites

    PostgreSql 42.5.3 or higher
    SpringBoot 2.7.9 or higher
    SpringCloud 3.1.5 or higher
    Lombok 1.18.26 or higher
    Mapstruck 1.5.3.Final or higher
    Jwt 4.3.0 or higher
    RabbitMQ 3.x.x or higher


## Installation

    git clone https://github.com/aliogutcen/stockcontrolapp.git
    cd proje-ad
    npm install
    npm start

* Clone the project to your local machine.
* Run "mvn install" in each microservice directory.
* Rename the .yml files to application.yml and configure as necessary.
* Start the services by running mvn spring-boot:run in each microservice directory.


### User Registration and Security

During user registration, I use SHA is the Secure Hash Algorithm library to encrypt passwords. Registration information is stored in the PostgreSql database, and the data is encrypted using JSON Web Token (JWT) to enhance security.

### Inter-Microservice Communication

To enable communication between microservices, I created message queues using RabbitMQ. Each service creates a queue to listen for messages and sends messages as needed. This allows microservices to communicate with each other and facilitates a decoupled architecture.

### Configuration

I use Spring Cloud Config Server to store configuration files in the project. This enables all microservices to use the same configurations and makes updates easier.

### Security

After completing the login process, I generate a token using JSON Web Token (JWT). This token can be sent to other microservices for security purposes and can be used to authenticate the user's identity.

### Testing

To test the microservices, you can use the mvn test command for each one.

### Contributing

* Fork this project.
* Create a branch for new features.
* Open a pull request (PR) for the changes you made.

## **License**

_This project is licensed under the MIT License._