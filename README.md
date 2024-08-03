# Advanced Java Lab - ISL48

**RAMAIAH INSTITUTE OF TECHNOLOGY, BANGALORE – 560054**  
**DEPARTMENT OF INFORMATION SCIENCE AND ENGINEERING**  
**Course Code and Name: ISL48 Advanced Java Lab**

## Question Bank

### 1. String Methods
- **Determine Frequency of Substrings in a String**
- **Check for Anagrams (Two Strings Having Same Characters)**

### 2. Generic Stack Class
- Create a generic Stack class with `push()`, `pop()`, `clear()`, `isEmpty()`, and `display()` methods.
- Demonstrate the creation of Stack of String and Integer objects.

### 3. Missed Calls Simulation
- Simulate a telephone that records missed incoming calls with details such as the time of call, telephone number, and name of the caller.
- Features:
  - Numbers are recalled in the order they arrive.
  - User options after each number display:
    - Delete the call.
    - Display call details (number, caller name, and time).
- Helper class to represent an incoming call.
- Tester class to store several numbers and simulate user interactions.

### 4. Book Database using Collection List
- Book collection includes title, author, publisher, and price.
- Sort books in ascending order of price and store in another list.
- Maintain book details with respect to a unique book id.
- Prompt for an author name and list all books by the same author.

### 5. Extended Book Database
- Similar to the above, but also create a new list holding all book details with a price greater than a user-specified price.
- Prompt for a publisher name and list all books by the same publisher.

### 6. Student Information Application
- Desktop Java application using Swing to enter student information.
- Validations on all fields with appropriate popup messages.
- Compute CGPA and display student details in a collection.

### 7. Shopping Application using Swing
- Enter item purchased by giving item id and quantity.
- Display item name and total cost.
- Provide discount options and print the final cost.

### 8. Customer Database Application using Swing and JDBC
- Create a table named `Customer (CustNo, CustName, State, Credit_Limit)` in MySQL.
- Use Swing components to insert values and populate the table.
- Display the Customer table using JDBC.

### 9. Representative Database Application using Swing and JDBC
- Create a table named `Representative (RepNo, RepName, State, Commission, Rate)` in MySQL.
- Use Swing components to insert values and populate the table.
- Display the Representative table using JDBC.

### 10. T-Shirt Purchase Application using JSP and Servlet
- Frontend display with checkboxes for accessories, a text area for tag-line, a radio-button for T-Shirt option, a combo box for T-Shirt color, and a button.
- Insert details into a table called `TShirts (tagLine, Accessories, Color, tShirtOption)`.
- Display all records of the `TShirts` table in tabular form.

## Running SQL Programs

### Adding External JAR in Build Path
For running SQL-related programs, you need to add the MySQL Connector JAR file to your build path. You can download it from [MySQL Connector/J](https://dev.mysql.com/downloads/connector/j/).

### Module Configuration
Make sure to include the following in your `module-info.java` file:

```java
module packageName {
    requires java.desktop;
    requires java.sql;
}
```

## How to Run
1. **Clone the Repository:**
   ```sh
   git clone https://github.com/your-username/advanced-java-lab.git
   cd advanced-java-lab
   ```

2. **Set Up Database:**
   - Create the required MySQL databases and tables using the provided SQL scripts.
   - Update the database connection details in the respective Java files.

3. **Compile and Run:**
   - Use your IDE (such as Eclipse) to compile and run the Java programs.
   - Ensure you have added the MySQL Connector JAR to your project build path.

4. **Deploy JSP and Servlet:**
   - Deploy the JSP and Servlet code on a web server (like Apache Tomcat).

---
