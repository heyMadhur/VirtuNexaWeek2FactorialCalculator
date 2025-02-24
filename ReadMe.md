# Factorial Calculator Application

## Overview

This project is a Java-based application designed to calculate the factorial of a given number using both iterative and recursive methods. It’s a practical tool that not only computes the factorial but also saves each calculation along with your username, the method used, and the date/time of the calculation. The project uses Maven for dependency management and building, and an H2 database (in file mode) for storing calculation records.

## Features

- **Factorial Calculation:**  
  Quickly calculate the factorial of a non-negative integer using either:
    - **Iterative Method:** Computes the factorial using a loop.
    - **Recursive Method:** Computes the factorial using recursion.

- **Calculation History:**  
  Every calculation is saved along with your username, the method used, and the timestamp. You can view your entire calculation history at any time.

- **User-Friendly CLI:**  
  The application runs from the command line, guiding you through the process with clear instructions.

- **Error Handling:**  
  The program validates your input to ensure it’s a non-negative integer and provides helpful feedback if an invalid input is detected.

## Setup

### Prerequisites

- **Java JDK:** Version 22 or later is required.
- **Maven:** Used to compile, package, and run the project.
- **H2 Database:** The application uses H2 in file mode, and Maven manages this dependency automatically.

### Installation Steps

1. **Download or Clone the Repository:**  
   Get the project files onto your computer.

2. **Navigate to the Project Directory:**  
   Open your terminal or PowerShell and use the `cd` command to move into the project folder (where the `pom.xml` file is located).

3. **Build the Project:**  
   Run the following command to compile the code and package it:
   ```bash
   mvn clean package
   ```
   This command creates a JAR file in the `target` directory.

4. **Run the Application:**  
   To run the application with all necessary dependencies, use the following command in PowerShell:
   ```powershell
   mvn --% exec:java -Dexec.mainClass=com.virtunexa.CLIFrontend
   ```
   (Note: In CMD you might need different quoting or configuration, but PowerShell has been confirmed to work well.)

## Usage

Once the application is running, you’ll see a welcome message along with simple instructions. Here’s how it works:

- **Enter Your Username:**  
  The application starts by asking for your username to track your calculation history.

- **Calculation Instructions:**
    - **Choose the Method:**  
      Select between the iterative and recursive methods by entering the corresponding option.
    - **Input a Number:**  
      Enter a non-negative integer to calculate its factorial.
    - **View History:**  
      Type `3` to see all your previous calculations.
    - **Exit:**  
      Type `4` to close the application.

## Example Interaction

```
-------- Welcome to VirtuNexa Factorial Converter --------

Enter your username: Madhur Gupta

Instructions:
1. Input a non-negative integer and choose the method to calculate its factorial.
2. To view calculation history, type "3".
3. To exit, type "4".

Select an option:
1. Iterative Method
2. Recursive Method
3. View Calculation History
4. Exit

Enter your choice: 1
Enter a non-negative integer: 5
Factorial of 5 is: 120

Select an option: 3
----- Calculation History -----
ID: 1 | User: Madhur Gupta | Method: Iterative | Number: 5 | Result: 120 | Date: 2025-02-23 11:29:00
--------------------------------

Select an option: 4
Hope you liked it...
Developed By- Madhur Gupta
Exiting...
```

## Additional Information

- **Error Handling:**  
  If you enter an invalid value (such as a negative number or a non-integer), the application will alert you and prompt for a correct input.

- **Data Storage:**  
  All calculation records are saved in an H2 database file located in the `./data` directory within the project folder. This file is automatically created when the application runs.

## Final Thoughts

This application is both a useful utility and a demonstration of how to combine core Java programming with persistent data storage. It showcases how to implement both iterative and recursive algorithms in a clean, user-friendly manner. If you have any questions or feedback, please feel free to reach out.
