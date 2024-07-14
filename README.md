# FlashCode

FlashCode is a web application designed to help users study LeetCode questions more effectively. This project allows users to create and study flashcard sets specifically tailored for LeetCode problems, where each card contains a problem's question, solution, approach, and time/space complexity. 

## Features

- **User Registration and Authentication**: Secure account creation and login system with Spring Security
- **Assortment Creation**: Ability to create multiple flashcard sets for different topics and difficulty levels
- **Comprehensive Card Content**: Each flashcard contains the question, code solution, approach explanation, time complexity, and space complexity
- **Study Mode**: Flip-card functionality to test knowledge retention, where users can mark cards as 'Still Learning' or 'Know'
- **In-Study Note-Taking**: Option to add temporary notes underneath each card while studying
- **Shuffle Cards**: Randomize the order of cards during study sessions
- **Real-time Saving**: All card content is automatically saved to the MySQL database using REST APIs as the user types
- **Color Themes**: Toggle between dark and light themes for user convenience
- **Assortment Search**: Ability to search assortments by name

## Tech Stack

- **Backend**: Java with Spring Boot framework
- **Frontend**: HTML, CSS, Thymeleaf
- **Database**: MySQL
- **Security**: Spring Security

## Installation

1. Ensure that you have the following prerequisites installed:
  - Java Development Kit (JDK), version 8 or higher
  - Eclipse IDE for Enterprise Java and Web Developers
  - MySQL Server
2. Open Eclipse
3. Go to Git Repositories > Clone a Git Repository > Clone URI
4. Enter the repository URL:
```
https://github.com/yourusername/flashcode.git
```
5. Locate src/main/resources/application.properties
6. Update configurations:
```
spring.application.name=flashcode
spring.datasource.url=jdbc:mysql://localhost:3306/flashcode?useSSL=false&serverTimeZone=EST&useLegacyDattimeCode=false&createDatabaseIfNotExist=true
spring.datasource.username=[YOUR_MYSQL_USERNAME_HERE]
spring.datasource.password=[YOUR_MYSQL_PASSWORD_HERE]
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.web.resources.add-mappings=true
spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect
spring.jpa.hibernate.ddl-auto=update
logging.level.org.hibernate.SQL=DEBUG
```
7. Right click on the project > Run As > Java Application > FlashcodeApplication

## Usage
1. Open the application in http://localhost:8080
