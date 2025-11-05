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
  └── testng.xml                     # TestNG suite configuration
```

⚙️ How_to_Run_Tests:
  - Using_Maven: "mvn clean test"


🔧 Configuration:

  description: "You can store environment variables and base URLs inside config.properties"
  
  file_path: "src/main/resources/config.properties"
  
  example:
  
    base.url: "https://restful-booker.herokuapp.com"
    
    username: "admin"
    
    password: "password123"

🧠 Test_Scenarios_Covered:
  - test_class: "AddBookingTest.java"
    
    description: "Validate creating a new booking"
  - test_class: "UpdateBookingTest.java"
    
    description: "Validate updating existing booking"
  - test_class: "EndToEndFlow.java"
    
    description: "Complete flow: Create → Update → Get"
  - test_class: "CreateToken.java"
    
    description: "Generate auth token"
  
  - test_class: "GetAllIds.java"
    
    description: "Retrieve all booking IDs"

👨‍💻 Author:

  name: Mahmoud Mesalem
  
  title: Software Testing Engineer
  
  linkedin: https://www.linkedin.com/in/mahmoud--mesalem

🏁 Summary: |

  This project demonstrates end-to-end API test automation using clean code design
  and modular structure, focusing on maintainability, reusability, and reporting excellence.
