IT IdeaTask JDBC

A Java application demonstrating JDBC database operations for managing tasks and users in an IT ideas tracking system.
Overview

This project implements a database management system for tracking IT ideas and tasks using Java JDBC with MySQL. The application provides functionality for user management, task operations, and database interactions through a console-based interface.
Features

    User Management: Create, read, update, and delete user accounts

    Task Management: Full CRUD operations for tasks including creation, assignment, and status tracking

    Database Operations: Comprehensive JDBC implementation with prepared statements

    Console Interface: User-friendly menu-driven interface for all operations

Prerequisites

    Java JDK 8 or higher

    MySQL Server

    MySQL Connector/J JDBC driver

Database Setup

    Create a MySQL database named it_idea_task

    The application will automatically create the necessary tables:

        users: Stores user information (id, username, email, password)

        tasks: Stores task details (id, title, description, status, due_date, user_id)

Installation

    Clone the repository:

bash

git clone https://github.com/Alejandroramirez07/it-ideataskjdbc.git

    Import the project into your preferred Java IDE

    Add MySQL Connector/J to your project classpath

    Update database connection details in the Java files if needed

Usage

Run the main class to start the application. The console menu provides the following options:

    User Operations

        Create new user

        View all users

        Update user information

        Delete user

    Task Operations

        Create new task

        View all tasks

        Update task information

        Delete task

        Assign task to user

Project Structure

    User.java: User entity class with getters and setters

    Task.java: Task entity class with getters and setters

    Database utility classes for CRUD operations

    Main application class with user interface

Database Schema
Users Table

    id (INT, Primary Key, Auto Increment)

    username (VARCHAR)

    email (VARCHAR)

    password (VARCHAR)

Tasks Table

    id (INT, Primary Key, Auto Increment)

    title (VARCHAR)

    description (TEXT)

    status (VARCHAR)

    due_date (DATE)

    user_id (INT, Foreign Key)

Recommended: mvn clean verify to get your test in target/site about test coverage

License

This project is open source and available under the MIT License.