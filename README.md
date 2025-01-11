# Automation Testing for STORE (demoblaze.com)

## Project Overview
This project automates the testing of key functionalities on the Demoblaze website, focusing on user sign-up and product purchase scenarios. The automation is implemented using Selenium WebDriver.

---

## Tools and Technologies Used
- **Programming Language:** Java
- **Automation Framework:** Selenium WebDriver
- **Test Framework:** TestNG
- **Build Tool:** Maven
- **IDE:** IntelliJ IDEA 
- **Browser:** Chrome (using ChromeDriver)
- **Test Data Management:** Hardcoded values for this demo

---

## Scenarios Covered
### Scenario 1: Verify User Can Sign Up Successfully
1. Navigate to the Demoblaze website (https://demoblaze.com).
2. Click on the **Sign up** button in the header.
3. Fill in the username and password in the Sign-up form.
4. Validate that the success message is: **"Sign up successful."**

### Scenario 2: Verify Two Products Can Be Purchased Successfully
1. Navigate to the Demoblaze website (https://demoblaze.com).
2. Click on the **Log in** button in the header.
3. Fill in the username and password in the Log-in form.
4. Validate that the account opens successfully.
5. Click on the **Laptops** category on the home page.
6. Select the first product.
7. Click on the **Add to cart** button.
8. Validate that the product is successfully added.
9. Select the second product.
10. Click on the **Add to cart** button.
11. Validate that the product is successfully added.
12. Click on the **Cart** button in the header.
13. Validate that the two products, including their **title** and **price**, are displayed on the products page.
14. Validate that the total amount is calculated correctly.
15. Click on the **Place Order** button.
16. Validate that the total amount is calculated correctly on the Place Order page.
17. Fill in the following fields in the Place Order form:
    - Name
    - Country
    - City
    - Credit Card
    - Month
    - Year
18. Click on the **Purchase** button.
19. Validate that the message **"Thank you for your purchase!"** is displayed.

---

## How to Run the Tests
### Prerequisites
1. Install Java Development Kit (JDK 8 or higher).
2. Install Maven for dependency management.
3. Install IntelliJ IDEA or Eclipse IDE.
4. Clone this repository to your local machine.

### Steps to Execute
1. Open the project in your IDE.
2. Configure the Maven dependencies by running:
   ```bash
   mvn clean install
   ```
3. Open the test file containing the scenarios.
4. Execute the tests using TestNG. You can do this by:
   - Right-clicking the TestNG XML file and selecting **Run**.
   - Using the Maven command:
     ```bash
     mvn test
     ```

---

## Test Structure
- **Test Classes:** Each scenario is implemented in separate methods for modularity.
- **Assertions:** Validations are performed using TestNG assertions.
- **Test Data:** Hardcoded in the test methods (can be externalized for scalability).
- **Browser Configurations:** Tests use ChromeDriver, but can be extended to support other browsers.

---

## Reporting
TestNG generates a default HTML report upon execution. You can find the report in the `test-output` folder of the project.

---







