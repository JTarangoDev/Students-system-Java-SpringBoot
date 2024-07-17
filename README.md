# Spring Boot Student Management System

## Description

This project is a Java-based Student Management System built with Spring Boot. It's an evolution of a previous JDBC-based system, now leveraging the power of Spring Framework, JPA with Hibernate for ORM, and Lombok for reducing boilerplate code. The application continues to provide CRUD (Create, Read, Update, Delete) operations on student records, but with a more robust and scalable architecture.

## Features

- List all students
- Search for a specific student
- Add a new student
- Modify existing student information
- Delete a student
- MySQL database integration using JPA/Hibernate
- User-friendly terminal interface

## Technologies Used

- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- Lombok
- Maven (for dependency management)

## Project Structure

The project follows a typical Spring Boot application structure:

1. `Estudiante` entity: Represents a student with JPA annotations and Lombok
2. `EstudianteRepositorio` interface: Extends JpaRepository for database operations
3. `IEstudianteServicio` interface: Declares methods for business logic
4. `EstudianteServicio` class: Implements `IEstudianteServicio`, using `EstudianteRepositorio` for database interactions
5. Main application class: Provides the user interface and interactions

## Prerequisites

- Java Development Kit (JDK) 8 or higher
- MySQL Server
- Maven

## How to Run

1. Ensure you have Java, Maven, and MySQL installed on your system.
2. Clone this repository to your local machine.
3. Configure the database connection in `application.properties`.
4. Navigate to the project directory in your terminal.
5. Build the project using Maven.
6. Run the application.

## Usage

Upon running the program, you'll be presented with a menu in the terminal:

1. Enter a number to select an operation:
- 1: List all students
- 2: Search for a student
- 3: Add a new student
- 4: Modify student information
- 5: Delete a student
- 6: Exit the application
2. Follow the prompts to interact with the student database.
3. The program will continue running until you choose to exit.

## Project Status

This project is completed but may be updated with additional features in the future.

## Learning Objectives

This project demonstrates advanced Java and Spring concepts including:
- Spring Boot application setup
- Data persistence with Spring Data JPA and Hibernate
- Use of Lombok for code simplification
- Implementation of service layer pattern
- Integration of a Spring application with MySQL
- Command-line interface design in a Spring Boot context

## Implementation Details

- The `Estudiante` entity uses JPA annotations for ORM and Lombok annotations to reduce boilerplate.
- `EstudianteRepositorio` extends `JpaRepository`, providing standard CRUD operations out of the box.
- `IEstudianteServicio` defines the business logic interface.
- `EstudianteServicio` implements the service interface, utilizing the repository for database operations.
- Spring Boot's auto-configuration handles much of the setup, including database connection.
- The application uses Spring's dependency injection for loose coupling between components.

## Note

The code comments and variable names in this project are written in Spanish as it was developed for personal learning purposes. The logic and structure of the code remain universal.

---

This project showcases the power and simplicity of building a database application with Spring Boot and JPA. It's an excellent resource for learning about Spring ecosystem and ORM concepts. Feel free to explore, contribute, or use it as a learning tool for Spring Boot development!