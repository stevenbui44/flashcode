# FlashCode

FlashCode is a web application designed to help users study LeetCode questions more effectively. This project allows users to create and study flashcard sets specifically tailored for LeetCode problems, where each card contains a problem's question, solution, approach, and time/space complexity. 

## Features

- **User Registration and Authentication**: Secure account creation and login system with Spring Security
- **Assortment Creation**: Ability to create multiple flashcard sets for different topics and difficulty levels
- **Comprehensive Card Content**: Each flashcard contains the question, code solution, approach explanation, time complexity, and space complexity
- **Assortment Search**: Ability to search assortments by name
- **Study Mode**: Flip-card functionality to test knowledge retention, where users can mark cards as 'Still Learning' or 'Know'
- **In-Study Note-Taking**: Option to add temporary notes underneath each card while studying
- **Shuffle Cards**: Randomize the order of cards during study sessions
- **Automatic Indentation**: Starting a new line automatically indents to match the previous line
- **Tab Support**: Pressing tab indents your code and notes, and pressing ctrl+tab outdents (goes back one tab)
- **Real-time Saving**: All card content is automatically saved to the MySQL database using REST APIs as the user types
- **Color Themes**: Toggle between dark and light themes for user convenience

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
1. Open the application in localhost:8080
<img width="1440" alt="image" src="https://github.com/user-attachments/assets/48567cc8-8f1c-416f-bed5-fc210ce7148b">

2. Create a new account (if you do not have an account)
<img width="1440" alt="image" src="https://github.com/user-attachments/assets/2345877f-8a08-49bd-b374-6a28e9a8044b">

3. Create a new assortment by pressing 'Create New Assortment' in the top right corner
<img width="1440" alt="image" src="https://github.com/user-attachments/assets/8a0f3957-1095-4f2f-a4e8-0a5281b439ab">

4. Create cards with question, code, approach, time complexity, and space complexity sections
<img width="1440" alt="image" src="https://github.com/user-attachments/assets/7f12b628-7d2c-4d2b-b4f4-8ba558eebdb7">

5. Press 'Study' in the top right corner to study the assortment
<img width="1440" alt="image" src="https://github.com/user-attachments/assets/caf4b97b-a7d9-4c31-ace1-fc1f41365fe3">
<img width="1440" alt="image" src="https://github.com/user-attachments/assets/4a71442e-9072-426d-90a5-a48d2ac5f794">

6. Finish studying and study again!
<img width="1440" alt="image" src="https://github.com/user-attachments/assets/6c390a52-94b0-4195-bcbc-2f60e429935e">



