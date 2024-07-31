# ATM Machine Unit Testing
![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![JUnit](https://img.shields.io/badge/JUnit-25A162?style=for-the-badge&logo=junit5&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white)
![GitHub](https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white)
![Build Status](https://img.shields.io/badge/build-passing-brightgreen)
![Issues](https://img.shields.io/github/issues/sancakerkan/ATM-Machine-UnitTesting)
![License: MIT](https://img.shields.io/badge/License-MIT-blue.svg)

## Table of Contents

- [Introduction](#introduction)
- [Features](#features)
- [Installation](#installation)
- [Usage](#usage)
- [Testing](#testing)
- [Contributing](#contributing)
- [License](#license)
- [Acknowledgements](#acknowledgements)

## Introduction

This repository contains unit tests for an ATM Machine simulation program written in Java. The main goal of this project is to practice writing assertion cases and creating test suites. The ATM code is sourced from an existing project, while the unit tests and assertions have been written specifically for this repository.

## Features

- **Account Management:** Perform operations such as deposits, withdrawals, and transfers.
- **ATM Interface:** Run the ATM application and manage user interactions.
- **Option Menu:** Handle user inputs and perform account operations.
- **Unit Testing:** Comprehensive tests for the main classes using JUnit.

## UML Diagram and Project Structure

<img src="https://github.com/sancakerkan/ATM-Machine-UnitTesting/blob/main/.idea/ProjectUML.png" alt="UML Diagram" width="500"/>
<img src="https://github.com/sancakerkan/ATM-Machine-UnitTesting/blob/main/.idea/Project%20Structure.png" alt="Project Structure" width="300"/>

## Installation

### Prerequisites

- Java Development Kit (JDK) 8 or later
- An IDE with Maven support (IntelliJ IDEA, Eclipse, etc.)

### Cloning the Repository

1. **Using IntelliJ IDEA:** 
    - Go to `File` > `New` > `Project from Version Control`.
    - Enter the repository URL: `https://github.com/sancakerkan/ATM-Machine-UnitTesting.git`.
    - Click `Clone`.

2. **Using Eclipse:**
    - Go to `File` > `Import...`.
    - Select `Git` > `Projects from Git` > `Clone URI`.
    - Enter the repository URL: `https://github.com/sancakerkan/ATM-Machine-UnitTesting.git`.
    - Follow the prompts to complete the cloning process.
  
3. **OR Simply Download the ZIP file**
    - [ZIP File](https://github.com/sancakerkan/ATM-Machine-UnitTesting/archive/refs/heads/main.zip)

## Usage

### Running the ATM Application

1. **Using IntelliJ IDEA:**
    - Open the project.
    - Navigate to `src/main/java/ATM.java`.
    - Right-click `ATM.java` and select `Run 'ATM.main()'`.

2. **Using Eclipse:**
    - Open the project.
    - Navigate to `src/main/java/ATM.java`.
    - Right-click `ATM.java` and select `Run As` > `Java Application`.


## Testing

### Running All Tests

1. **Using IntelliJ IDEA:**
    - Right-click the `test` directory or the project root.
    - Select `Run 'All Tests'`.

2. **Using Eclipse:**
    - Right-click the `src/test/java` directory or the project root.
    - Select `Run As` > `JUnit Test`.

### Running Individual Test Classes

You can run individual test classes, especially the assertion case classes:

1. **Using IntelliJ IDEA:**
    - Navigate to the specific test class (e.g., `AccountTest.java`).
    - Right-click the class and select `Run 'AccountTest'`.

2. **Using Eclipse:**
    - Navigate to the specific test class (e.g., `AccountTest.java`).
    - Right-click the class and select `Run As` > `JUnit Test`.

 ### Test Structure
- `AccountTest`: Tests for account operations such as deposits, withdrawals, and transfers.
- `OptionMenuTest`: Tests for user interactions and menu options.
- `TestSuite`: A test suite that aggregates all the test classes for comprehensive testing.

## Contributing

Contributions are welcome! If you have any suggestions or improvements, feel free to open an issue or submit a pull request.

1. Fork the repository
2. Create your feature branch 
3. Commit your changes 
4. Push to the branch 
5. Open a pull request

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for more details.

## Acknowledgements
- The source code for the ATM Machine project is available under the MIT License from [ATM Machine Project](https://github.com/rajyash1904/ATM-Machine).
- Special thanks to the respective owners for providing the original ATM Machine code.
- Thanks to the contributors and the community for their support and feedback.


