# 🧪 Rest Assured API Testing Practice

This repository contains my practice work using **Rest Assured** for API automation testing and **POJOs (Plain Old Java Objects)** for handling request and response data models.  

---

## 🚀 Project Overview

The goal of this project is to learn and demonstrate:
- How to automate RESTful APIs using **Rest Assured**.
- How to structure API tests cleanly using **TestNG**.
- How to use **POJO classes** to map JSON requests and responses.
- How to separate API logic, data models, and test cases for better maintainability.

---

## 🧰 Tech Stack

| Tool | Purpose |
|------|----------|
| **Java 11+** | Programming language |
| **Rest Assured** | API testing library |
| **TestNG** | Test framework for organizing and executing tests |
| **Maven** | Build automation and dependency management |
| **JSON** | Data format for requests and responses |

---

## 🗂️ Project Structure

src
└── test
└── java
├── org.example.apis # API call classes (CreateBooking, UpdateBooking, etc.)
├── org.example.tests # Test classes (AddAndUpdate, CreateBookingTest, etc.)
└── pojo # POJO classes (BookingPojo, CreateTokenPojo, etc.)

markdown
Copy code

- **APIs folder** → contains reusable classes for making HTTP requests (POST, PUT, GET).
- **POJOs folder** → contains data model classes used for serialization/deserialization.
- **Tests folder** → contains TestNG test classes for verifying API responses.

---

## 🧠 Key Concepts Practiced

- Creating and updating bookings using **Rest Assured**.
- Generating **tokens** for authentication.
- Validating response **status codes**, **headers**, and **JSON body**.
- Handling dynamic data using **Java Random**.
- Designing clean test structure by separating:
  - API layer
  - Data (POJO)
  - Tests

---

## ⚙️ How to Run the Tests

1. **Clone the repository**
   ```bash
   git clone https://github.com/<your-username>/<your-repo-name>.git
Open in your IDE (IntelliJ IDEA / Eclipse)

Install dependencies

bash
Copy code
mvn clean install
Run the tests

bash
Copy code
mvn test
or directly from the IDE using TestNG runner.

🧾 Example API Used
The project interacts with the public API:
👉 Restful Booker

Example endpoints:

bash
Copy code
POST /booking
GET /booking/{id}
PUT /booking/{id}
📸 Sample Test Example
java
Copy code
@Test
public void testCreateBooking() {
    BookingPojo.BookingDates dates = new BookingPojo.BookingDates("2024-01-01", "2024-01-05");
    BookingPojo booking = new BookingPojo("Jim", "Brown", 111, true, dates, "Breakfast");

    Response response = CreateBooking.createBooking(booking);
    Assert.assertEquals(response.getStatusCode(), 200);
}
🧑‍💻 Author
Mahmoud Mesalem
📍 Software QA Engineer | API & Automation Enthusiast
📧 your.email@example.com
🌐 https://github.com/your-github-username

⭐ Future Improvements
Add JSON Schema validation.

Integrate with CI/CD (e.g., GitHub Actions).

Add data-driven tests using external files (Excel or JSON).

Include reporting (Allure / Extent Reports).

💬 If you like this project, don't forget to ⭐ the repo!
yaml
Copy code

---

Would you like me to fill in your **real GitHub username and email** so you can copy it once and it’s 100% ready?
