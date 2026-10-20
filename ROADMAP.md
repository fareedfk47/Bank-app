# Console-Based Banking Application
## Complete Project Guide & Learning Roadmap

**Technology:** Core Java  
**Project Type:** Console-Based Application  
**Level:** Beginner to Intermediate  
**Initial Storage:** In-memory  
**Future Goal:** Spring Boot Backend with REST APIs and a Relational Database

---

# 1. Project Overview

The Console-Based Banking Application is a Java learning project designed to develop programming logic, strengthen Core Java fundamentals, and understand object-oriented programming through practical implementation.

The application will simulate basic banking operations, including account creation, balance checking, deposits, withdrawals, and transaction history.

The project will initially use only Core Java and the Java standard library. No frameworks, databases, or external libraries will be used in the first version.

The application will be developed incrementally. Each feature will be implemented, tested, reviewed, and improved before moving to the next milestone.

The ultimate goal is to evolve this application into a backend application using Spring Boot, REST APIs, and a relational database.

## Main Learning Objectives

- Improve programming logic and problem-solving skills.
- Strengthen Core Java fundamentals.
- Understand classes, objects, and object-oriented programming.
- Learn methods, parameters, return values, and validation.
- Work with collections and object relationships.
- Understand transaction processing and data persistence.
- Develop debugging and testing skills.
- Learn clean code and separation of responsibilities.
- Prepare for Java backend development with Spring Boot.

---

# 2. Project Scope

## Version 1: Core Java Banking Application

The initial version will support:

1. Displaying a welcome message and menu.
2. Creating a bank account.
3. Storing account details.
4. Displaying account information.
5. Depositing money.
6. Withdrawing money.
7. Checking the account balance.
8. Managing multiple accounts.
9. Searching for accounts by account number.
10. Displaying all accounts.
11. Recording transactions.
12. Viewing transaction history.
13. Validating user input.
14. Handling invalid operations.
15. Saving and loading data through files in a later milestone.

The application will run entirely in the console.

Initially, account data will be stored in memory and will disappear when the program terminates. File-based persistence will be introduced separately after the core application is working.

## What Version 1 Will Not Include

- Spring or Spring Boot.
- Hibernate or Spring Data JPA.
- JDBC or database integration.
- MySQL or PostgreSQL.
- REST APIs.
- Web interfaces.
- User authentication and authorization.
- Production-grade banking security.
- Distributed transactions or concurrent banking operations.

These features will be considered in later versions.

---

# 3. Technology Stack

## Initial Version

| Technology | Purpose |
|---|---|
| Java | Application logic |
| JDK | Compilation and execution |
| Scanner | Console input |
| System.out | Console output |
| BigDecimal | Monetary calculations |
| ArrayList | Storing multiple accounts |
| Enum | Representing transaction types |
| java.time | Recording transaction timestamps |
| Java I/O and NIO | File persistence in a later milestone |
| Git | Tracking source code changes |
| GitHub | Hosting the project repository |

No external dependencies will be required for the initial application.

JUnit may be introduced later as a testing dependency.

## Future Version

The project may eventually use:

- Maven for dependency management and builds.
- Spring Boot for backend application development.
- Spring Web for REST APIs.
- JDBC and SQL fundamentals for database access.
- MySQL or PostgreSQL for relational storage.
- Spring Data JPA for persistence.
- Bean Validation for request validation.
- Spring Security for authentication and authorization.
- JUnit and Mockito for automated testing.

Each technology will be introduced only when the existing project provides a practical reason to learn it.

---

# 4. Development Approach

This project will follow a task-based learning approach.

The complete application will not be generated in advance. Each feature will be implemented through small programming tasks.

For every task, the development process will be:

1. Understand the feature and its purpose.
2. Identify the relevant Java concepts.
3. Understand the expected design and responsibilities.
4. Review the task requirements and acceptance criteria.
5. Write the logic independently.
6. Implement the code.
7. Test the behavior.
8. Debug errors and correct mistakes.
9. Review the solution.
10. Improve the design when appropriate.

If an attempt is incorrect, the mentor will explain the first issue and provide one small hint at a time instead of immediately revealing the complete solution.

After solving the task, the learner will explain the code in their own words to confirm understanding.

The objective is to develop independent programming ability rather than memorize solutions.

---

# 5. Project Roadmap

## Milestone 0: Project Planning and Preparation

### Objective

Prepare the Java environment and establish the project structure before writing application logic.

### Activities

- Verify JDK installation.
- Select and configure an IDE.
- Create a plain Java project.
- Understand the source folder and package structure.
- Learn Java naming conventions.
- Establish basic Git and GitHub usage.
- Define project milestones and testing practices.

### Concepts

- JDK, JVM, and Java compilation basics.
- Source files and compiled class files.
- Packages and classes.
- Basic project organization.
- Git fundamentals.

### Completion Criteria

- Java environment is working.
- Project opens successfully in the IDE.
- A simple Java program compiles and runs.
- The learner understands where source files belong.

No banking functionality will be implemented during this milestone.

---

## Phase 1: Basic Console Application

### Objective

Create a menu-driven application that accepts user input and continues running until the user chooses to exit.

### Features

- Display a welcome message.
- Display a menu.
- Accept a menu choice.
- Handle the selected choice.
- Repeat the menu.
- Reject invalid menu choices.
- Exit the program correctly.

### Java Concepts

- `main()` method.
- Variables and data types.
- `System.out.println()`.
- `Scanner`.
- Conditional statements.
- `if-else`.
- `switch`.
- `while` and `do-while` loops.
- Operators and basic validation.

### Example Menu

    ===== Simple Banking System =====

    1. Create Account
    2. View Account
    3. Deposit Money
    4. Withdraw Money
    5. Check Balance
    0. Exit

    Enter your choice:

### Completion Criteria

- The menu appears when the application starts.
- Valid choices are recognized.
- Invalid choices display an appropriate message.
- The menu repeats after an operation.
- Selecting zero exits the application.
- The program does not terminate unexpectedly during normal menu usage.

The first implementation may use placeholder messages for features that have not yet been developed.

---

## Phase 2: Basic Account Operations

### Objective

Implement the basic logic required to manage one bank account.

### Features

- Create an account.
- Store an account number.
- Store an account holder name.
- Store the initial balance.
- Display account details.
- Deposit money.
- Withdraw money.
- Check the balance.

### Java Concepts

- Methods.
- Method parameters.
- Return values.
- Local and instance variables.
- Arithmetic operators.
- Conditions.
- Basic input validation.
- Method calls and control flow.

### Banking Rules

- A deposit must be greater than zero.
- A withdrawal must be greater than zero.
- A withdrawal cannot exceed the available balance.
- The account balance must not become negative.
- Invalid amounts must not change the balance.

### Completion Criteria

- Account details can be captured and displayed.
- Deposits increase the balance correctly.
- Withdrawals decrease the balance correctly.
- Invalid amounts are rejected.
- Insufficient funds are handled properly.
- Each operation can be tested independently.

This phase will focus on understanding the logic before introducing a more complete object-oriented design.

---

## Phase 3: Object-Oriented Programming

### Objective

Represent a bank account as an object instead of managing all its data through unrelated variables.

### Features

Refactor the existing account functionality into appropriate classes and methods.

### Java Concepts

- Classes and objects.
- Instance variables.
- Instance methods.
- Constructors.
- The `this` keyword.
- Encapsulation.
- `private` and `public` access modifiers.
- Data validation.
- Object creation and method invocation.
- Basic separation of responsibilities.

### Initial Model

The `Account` class will represent an individual bank account.

Its responsibilities will include maintaining account information and enforcing account-level rules, such as valid deposits and withdrawals.

The class will gradually contain:

- Account number.
- Account holder name.
- Account balance.
- Constructor logic.
- Methods for balance access.
- Deposit behavior.
- Withdrawal behavior.
- Necessary validation.

### Design Principle

Account data should not be freely modified from unrelated parts of the application.

For example, the balance should be protected from arbitrary changes. Operations should update it through controlled methods.

### Completion Criteria

- An account can be represented by an object.
- Constructors initialize account state.
- Encapsulation protects account data.
- Deposit and withdrawal operations preserve valid account state.
- The learner understands why the `Account` class exists.

---

## Phase 4: Multiple Account Management

### Objective

Manage several accounts within one application.

### Features

- Create multiple accounts.
- Store accounts in a collection.
- Search for an account by account number.
- Display account details.
- Deposit into a selected account.
- Withdraw from a selected account.
- Display all accounts.
- Reject duplicate account numbers.

### Java Concepts

- `ArrayList`.
- Generics.
- Collections.
- Loops and iteration.
- Object references.
- Searching algorithms.
- Equality comparisons.
- Basic collection management.

### Design Direction

The application will maintain a collection of account objects.

When the user requests an operation for a particular account, the application will search for that account and then perform the appropriate operation.

If an account does not exist, the application will display an error message rather than crash.

### Completion Criteria

- Multiple accounts can be created.
- Every account has a unique account number.
- Account searches return the correct account.
- Operations affect only the selected account.
- Invalid account numbers are handled safely.
- All stored accounts can be displayed.

---

## Phase 5: Transactions and Transaction History

### Objective

Record banking operations and provide a history of transactions associated with an account.

### Features

- Record deposit transactions.
- Record withdrawal transactions.
- Store transaction amounts.
- Store transaction types.
- Record transaction timestamps.
- View transaction history for a selected account.
- Handle invalid amounts and insufficient funds.

### Java Concepts

- Creating relationships between classes.
- Enums.
- `java.time`.
- Collections of transaction objects.
- Object references.
- Data validation.
- Basic record management.

### Transaction Model

A `Transaction` object will represent a completed deposit or withdrawal.

A transaction record may contain:

- Transaction identifier.
- Transaction type.
- Transaction amount.
- Transaction timestamp.

Transaction history will be associated with the relevant account.

A transaction should be recorded only after the corresponding operation succeeds. Failed operations must not be recorded as successful deposits or withdrawals.

### Completion Criteria

- Successful deposits generate transaction records.
- Successful withdrawals generate transaction records.
- Transaction types and amounts are correct.
- Timestamps are recorded.
- Transaction history belongs to the correct account.
- Failed transactions do not incorrectly change the balance or appear as successful transactions.

---

## Phase 6: Better Application Design

### Objective

Organize the application so that each class has a clear responsibility.

### Possible Classes

**Main**

Starts the application and connects its components.

**BankingMenu**

Displays menu options and manages console interaction.

**Account**

Represents an account and protects its state.

**Transaction**

Represents a completed banking operation.

**BankingService**

Coordinates banking operations, including account creation, account lookup, deposits, withdrawals, and transaction-related behavior.

The exact class structure will be introduced gradually and adjusted according to the application's actual needs.

### Java Concepts

- Separation of concerns.
- Service classes.
- Encapsulation.
- Method design.
- Exception handling.
- Interfaces when justified.
- Basic dependency management between classes.
- Refactoring.

### Design Principles

- Console input and output should not be mixed unnecessarily with banking rules.
- The account model should not depend on `Scanner`.
- Banking operations should not require console printing to function.
- File storage should remain separate from core banking behavior.
- Methods should perform clear, limited responsibilities.

### Completion Criteria

- The application is organized into understandable classes.
- Business rules can be tested without interacting with the console.
- Menu handling is separated from account operations.
- The code is easier to understand and maintain.
- The structure can support future backend development.

---

## Phase 7: File-Based Data Persistence

### Objective

Preserve account and transaction data after the application closes.

### Why This Is Necessary

When the application stores objects only in memory, those objects disappear when the process terminates.

File-based persistence introduces a way to store data outside the running application.

### Features

- Save account information.
- Load account information at startup.
- Preserve transaction history.
- Handle missing files.
- Handle read and write errors.
- Avoid leaving stored data in an inconsistent state.

### Java Concepts

- Java I/O.
- Java NIO.
- `Path` and `Files`.
- Reading and writing data.
- Resource management.
- Exception handling.
- Data serialization formats.
- Data validation during loading.

### Completion Criteria

- Account data survives application restarts.
- Saved accounts can be loaded.
- Transactions remain associated with their accounts.
- File errors are handled appropriately.
- Invalid or incomplete stored data does not silently corrupt application state.

The storage format will be selected when this milestone begins. We will prefer an understandable format and avoid introducing unnecessary complexity.

### Important Limitation

File-based storage is suitable for learning, but it does not provide the full transactional guarantees, concurrent access control, and reliability expected from a properly designed database-backed banking application.

---

## Phase 8: Testing, Debugging, and Code Quality

### Objective

Verify the application's behavior and improve the reliability and readability of the code.

### Testing Areas

- Account creation.
- Duplicate account prevention.
- Account lookup.
- Deposits.
- Withdrawals.
- Balance calculations.
- Transaction history.
- Invalid user input.
- File reading and writing.
- Application startup and shutdown.

### Important Edge Cases

| Scenario | Expected behavior |
|---|---|
| Deposit a positive amount | Balance increases |
| Deposit zero | Rejected |
| Deposit a negative amount | Rejected |
| Withdraw a positive amount within the balance | Balance decreases |
| Withdraw more than the balance | Rejected |
| Withdraw zero | Rejected |
| Search for a nonexistent account | Informative error |
| Create a duplicate account number | Rejected |
| Enter an invalid menu choice | Error message and menu continues |
| Restart after saving data | Saved data is restored |

### Java Concepts

- Debugging.
- Breakpoints and variable inspection.
- Exception handling.
- Test case design.
- Refactoring.
- Clean code.
- Unit testing.
- JUnit when appropriate.

### Completion Criteria

- Core banking operations pass their tests.
- Important edge cases are covered.
- Errors are handled deliberately.
- The code uses meaningful names and readable methods.
- Automated tests verify business logic independently of console interaction.

---

# 6. Important Banking Rules

These rules apply throughout development, even though this is a learning project.

## Monetary Representation

Use `BigDecimal` for monetary values rather than relying on `double`.

Binary floating-point types can represent many decimal amounts only approximately. `BigDecimal` allows decimal arithmetic with explicit precision and rounding behavior.

When implementing monetary calculations, use appropriate construction, comparison, and rounding practices.

For example, comparisons between `BigDecimal` amounts should use methods such as `compareTo()` rather than relying on reference equality.

## Deposit Validation

- Amount must be greater than zero.
- Invalid amounts must not change the balance.
- Successful deposits must update the balance correctly.
- A successful deposit must generate the appropriate transaction record.

## Withdrawal Validation

- Amount must be greater than zero.
- Amount cannot exceed the available balance.
- Invalid withdrawals must not change the balance.
- Successful withdrawals must generate the appropriate transaction record.

## Account Management

- Account numbers must be unique.
- Invalid account lookups must be handled safely.
- An operation must affect the intended account only.
- Account data must be protected from uncontrolled modification.

## Transaction Consistency

- Failed operations must not be recorded as successful.
- Transaction amounts and types must match the actual operation.
- Account balances and transaction records must remain consistent.
- Transfers, when introduced, must debit the source and credit the destination consistently.

A console application using in-memory objects or files cannot by itself provide the same guarantees as a properly designed database-backed system.

---

# 7. Recommended Initial Project Structure

Begin with a simple Java project.

    BankingApplication/
    ├── src/
    │   └── banking/
    │       └── Main.java
    └── README.md

This is the initial structure, not the final architecture.

As features are implemented, the project may evolve into:

    BankingApplication/
    ├── src/
    │   └── banking/
    │       ├── Main.java
    │       ├── Account.java
    │       ├── Transaction.java
    │       ├── BankingMenu.java
    │       └── BankingService.java
    └── README.md

The expanded structure is illustrative. Files will be added only when their responsibilities are needed.

A standard Maven directory structure will be introduced during the Spring Boot migration.

## Naming Conventions

| Element | Convention | Example |
|---|---|---|
| Package | Lowercase | `banking` |
| Class | UpperCamelCase | `BankingService` |
| Method | lowerCamelCase | `checkBalance()` |
| Variable | lowerCamelCase | `accountBalance` |
| Constant | UPPER_SNAKE_CASE | `MAX_ACCOUNTS` |

Names should describe purpose rather than implementation details.

---

# 8. Git and GitHub Workflow

Version control will be introduced when the project has its first working milestone.

Git will help track changes, compare implementations, and recover previous versions.

GitHub will provide a remote repository for the project.

## Recommended Workflow

1. Create the local Git repository.
2. Add a `.gitignore` suitable for the IDE and Java project.
3. Implement one small feature.
4. Run the program and test the feature.
5. Review the changes.
6. Commit the working version with a meaningful message.
7. Push the changes to GitHub when ready.

Example commit messages:

- `Create initial Java project`
- `Add console menu`
- `Handle invalid menu choices`
- `Implement account creation`
- `Add deposit validation`
- `Introduce account model`
- `Add transaction history`

Avoid committing passwords, secret keys, or sensitive personal data.

---

# 9. Manual Testing Strategy

Each feature must be tested immediately after implementation.

For each task:

1. Identify the expected behavior.
2. Prepare normal and invalid inputs.
3. Run the program.
4. Observe the output.
5. Compare the actual behavior with the expected result.
6. Debug any mismatch.
7. Repeat the tests after making corrections.

Testing will begin with simple menu behavior and gradually expand to account operations, transaction history, and file persistence.

Once the banking logic is separated from console interaction, automated unit tests will be introduced where they provide meaningful value.

---

# 10. Future Migration to Spring Boot

After the Core Java application is complete and reasonably well tested, it will serve as the foundation for a separate backend development phase.

The migration will be incremental rather than a complete rewrite without explanation.

## Step 1: Review the Core Java Application

- Identify responsibilities of each class.
- Review the account and transaction models.
- Separate banking logic from console input and output.
- Improve tests and validation.
- Identify the parts that need persistent storage.

## Step 2: Learn Maven

Understand project dependencies, build configuration, compilation, and testing.

Maven will manage the dependencies and build lifecycle of the backend application.

## Step 3: Introduce Spring Boot

Create a Spring Boot application and understand its entry point, application configuration, and dependency injection.

## Step 4: Build REST APIs

Replace console-based operations with HTTP endpoints.

Possible endpoints include:

| Method | Endpoint | Purpose |
|---|---|---|
| POST | `/api/accounts` | Create an account |
| GET | `/api/accounts` | List accounts |
| GET | `/api/accounts/{accountNumber}` | Retrieve an account |
| POST | `/api/accounts/{accountNumber}/deposits` | Deposit money |
| POST | `/api/accounts/{accountNumber}/withdrawals` | Withdraw money |
| GET | `/api/accounts/{accountNumber}/transactions` | Retrieve transaction history |

These are proposed endpoint designs and may be refined during implementation.

## Step 5: Introduce Database Fundamentals

Learn relational database concepts, SQL, primary keys, foreign keys, constraints, and basic querying.

Integrate MySQL or PostgreSQL into the application.

## Step 6: Understand JDBC and Persistence

Learn how Java applications communicate with relational databases through JDBC before or alongside the relevant integration work.

Introduce Spring Data JPA after understanding the underlying persistence concepts.

## Step 7: Add Validation and Error Handling

Introduce request validation, appropriate HTTP status codes, and centralized exception handling.

## Step 8: Add Automated Tests

Test business logic, service behavior, REST endpoints, and database interactions at suitable levels.

## Step 9: Introduce Authentication and Authorization

Add security after the basic account operations and persistence layer are stable.

## Step 10: Learn Transactions and Concurrency

Study database transactions, isolation, concurrent updates, and consistency requirements for transfers.

A transfer must not leave one account debited without the corresponding credit. In a database-backed implementation, appropriate transaction management and concurrency controls will be necessary.

## Step 11: Prepare for Deployment

Learn configuration management, environment variables, logging, packaging, deployment, and operational basics.

---

# 11. How the Core Java Version Maps to the Backend Version

| Core Java Concept | Future Backend Equivalent or Extension |
|---|---|
| Console menu | REST controllers and HTTP endpoints |
| Method parameters | Request data and method arguments |
| Account class | Domain model and potentially a JPA entity |
| BankingService | Spring-managed service |
| In-memory `ArrayList` | Database-backed persistence |
| File operations | Database storage and repository operations |
| Manual validation | Request validation and business-rule validation |
| Exceptions | Centralized exception handling and HTTP responses |
| Manual tests | JUnit and integration tests |
| Explicit object creation | Dependency injection where appropriate |
| Local application execution | Deployable backend service |

The concepts learned in Core Java will remain useful. Spring Boot will provide additional infrastructure around the business logic rather than replace the need to understand Java.

---

# 12. Progress Tracking

The project will use a milestone checklist to track progress.

## Current Status

- [x] Milestone 0: Project preparation.
- [x] Phase 1: Console menu.
- [x] Phase 2: Basic account operations.
- [x] Phase 3: Object-oriented design.
- [x] Phase 4: Multiple accounts.
- [x] Phase 5: Transactions and history.
- [x] Phase 6: Better application design.
- [x] Phase 7: File-based persistence.
- [ ] Phase 8: Testing and code quality.
- [ ] Phase 9: Spring Boot migration.

Each phase will contain smaller tasks with individual acceptance criteria.

A milestone will be marked complete only after the relevant implementation and tests have been reviewed.

---

# 13. Rules for the Mentorship

The following rules will guide the entire development process.

1. Do not generate the complete project at once.
2. Introduce one small task at a time.
3. Explain the goal before asking for implementation.
4. Let the learner write the logic and code independently.
5. Review correctness before suggesting improvements.
6. If the attempt is incorrect, identify the first issue and give one small hint.
7. Do not reveal the complete solution unless explicitly requested after an attempt.
8. Distinguish Java syntax errors from logic errors.
9. Test normal cases and important edge cases.
10. Explain concepts when they become relevant.
11. Introduce advanced design concepts only when they solve an actual problem.
12. Track progress and do not skip milestones.
13. Encourage the learner to explain their code in their own words.
14. Refactor working code gradually rather than demanding professional architecture immediately.
15. Keep the Core Java version independent of Spring Boot and database dependencies.
16. Preserve the ability to evolve the business logic into a backend application.

---

# 14. First Task: Prepare the Development Environment

The first task is project preparation, not banking logic.

## Requirements

- Install and verify a suitable JDK.
- Select an IDE or terminal-based workflow.
- Create a plain Java project named `BankingApplication`.
- Understand the source folder and package structure.
- Run a basic Java program successfully.
- Identify the location where project files will be stored.

## Acceptance Criteria

The task is complete when:

- The Java environment is working.
- The project can be opened.
- A simple Java program compiles and runs.
- Console output appears as expected.
- The learner understands where Java source files belong.

After this task is verified, the project will proceed to Phase 1, beginning with a welcome message and a repeating console menu.

No account classes, deposit logic, withdrawal logic, or other banking features should be implemented before their corresponding tasks are introduced.

---

# 15. Final Goal

By completing this project, the learner should be able to:

- Write and debug Java programs independently.
- Break problems into small, testable steps.
- Apply object-oriented programming to a practical problem.
- Use collections to manage related objects.
- Implement validation and business rules.
- Maintain transaction records.
- Persist and reload application data.
- Write and run meaningful tests.
- Organize code into maintainable classes.
- Understand how a Core Java application can evolve into a Spring Boot backend.
- Build REST APIs backed by a relational database.
- Understand the fundamentals of persistence, transactions, and backend security.

The project will grow from a simple console menu into a structured banking application and eventually into a database-backed Java backend.

**The guiding principle is simple: understand the problem, implement the logic, test the behavior, and improve the design one step at a time.**
