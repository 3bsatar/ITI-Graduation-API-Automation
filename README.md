  # 🚀 ITI Graduation API Automation Project

  ![Java](https://img.shields.io/badge/Language-Java-blue?logo=java)
  ![Maven](https://img.shields.io/badge/Build-Maven-orange?logo=apache-maven)
  ![TestNG](https://img.shields.io/badge/TestNG-Framework-yellow?logo=testng)

  Automated API Testing Framework built using **Java**, **RestAssured**, **TestNG**, and **Maven**.  
  This project was created as part of the **ITI Graduation Project** to validate API endpoints for a booking system.

  ---

  ## 🧩 Tech Stack
  - **Language:** Java  
  - **Build Tool:** Maven  
  - **Testing Framework:** TestNG  
  - **API Testing:** RestAssured  

  ---

  ## 📂 Project Structure
  ```plaintext
  ITI-GRADUATION-API-AUTOMATION/
  ├── src/
  │   ├── main/java/
  │   │   ├── pojo/                  # POJO classes (Request/Response models)
  │   │   │   ├── BookingPojo.java
  │   │   │   ├── CreateTokenPojo.java
  │   │   │   └── GetAllIdsPojo.java
  │   │   └── resources/             # Config files (config.properties, log4j2.xml)
  │   │
  │   └── test/java/
  │       ├── org/example/
  │       │   ├── apis/              # API request classes
  │       │   │   ├── CreateBooking.java
  │       │   │   ├── CreateToken.java
  │       │   │   ├── GetAllIds.java
  │       │   │   ├── TokenApi.java
  │       │   │   └── UpdateBooking.java
  │       │   │
  │       │   ├── base/              # Base setup and API initialization
  │       │   │   └── BaseApi.java
  │       │   │
  │       │   └── tests/             # Test cases (unit/integration/e2e)
  │       │       ├── AddAndUpdate.java
  │       │       ├── AddBookingTest.java
  │       │       ├── BaseTest.java
  │       │       ├── EndToEndFlow.java
  │       │       └── UpdateBookingTest.java
  │
  ├── pom.xml                        # Maven dependencies
```

  ## ▶️ Running Tests
  You can execute the tests using Maven:

  ```bash
  # Run all tests
  mvn clean test

  # Run a specific TestNG class (single test case)
  mvn clean test -Dtest=ClassName
  ```
## 🔧 Configuration
Store environment variables and base URLs inside `config.properties`:

```properties
base.url = "https://restful-booker.herokuapp.com"
username = "admin"
password = "password123"
```
## 🧠 Test Scenarios Covered

| Test Class           | Description                       |
|---------------------|-----------------------------------|
| AddBookingTest.java  | Validate creating a new booking   |
| UpdateBookingTest.java | Validate updating existing booking |
| EndToEndFlow.java    | Complete flow: Create → Update → Get |
| CreateToken.java     | Generate authentication token      |
| GetAllIds.java       | Retrieve all booking IDs           |



  ## 👤 Author
  **Mahmoud Mesalem**

  - [LinkedIn](https://www.linkedin.com/in/mahmoud--mesalem)
  - [GitHub](https://github.com/3bsatar)

  ## 🤝 Collaboration
  This repository is maintained by the author.  
  You are welcome to **fork** the project, experiment freely, and explore the code.  
  It's a great way to learn, test ideas, and get hands-on experience!  

  ![Fork](https://img.shields.io/badge/Fork-blue?style=for-the-badge) 
  ![Experiment](https://img.shields.io/badge/Experiment-brightgreen?style=for-the-badge) 
  ![Learn](https://img.shields.io/badge/Learn-orange?style=for-the-badge)
