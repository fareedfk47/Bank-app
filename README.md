# Console-Based Banking Application

A clean, modular console banking system built in Core Java with object-oriented design and file persistence. Designed as a foundational project preparing for future migration to a Spring Boot backend.

---

## Features

- **Account Management**: Create accounts with automatic account numbers, customer names, account types (Savings/Current), and initial deposits.
- **Transactions**:
  - Deposit and withdrawal with balance validation.
  - Account-to-account funds transfer.
  - Financial precision handled using `BigDecimal`.
- **Statement & History**: Detailed transaction statements displaying timestamp, transaction type, amount, and updated balance.
- **File Persistence**: Automatic saving and loading using Java serialization (`accounts.dat`), allowing data to survive app restarts.
- **Layered Architecture**: Clear separation of concerns following enterprise packaging conventions (`model`, `service`, `ui`).

---

## Project Structure

```text
src/
└── banking/
    ├── Main.java               # Application entry point
    ├── model/
    │   ├── Account.java        # Account entity with balance & transaction history
    │   └── Transaction.java    # Immutable transaction record
    ├── service/
    │   └── BankingService.java # Business logic and persistence handling
    └── ui/
        └── BankingMenu.java    # Interactive console interface and input parsing
```

---

## Getting Started

### Prerequisites

- Java Development Kit (JDK 11 or higher)

### Build and Run

1. **Clone the repository:**
   ```bash
   git clone https://github.com/fareedfk47/Bank-app.git
   cd Bank-app
   ```

2. **Compile the source files:**
   ```bash
   javac -d out src/banking/model/*.java src/banking/service/*.java src/banking/ui/*.java src/banking/*.java
   ```

3. **Run the application:**
   ```bash
   java -cp out banking.Main
   ```

---

## Menu Preview

```text
==================================================
          CONSOLE BANKING APPLICATION             
==================================================

----------------- MAIN MENU ------------------
 [1] Create New Account
 [2] Deposit Money
 [3] Withdraw Money
 [4] Transfer Money
 [5] View Account Statement
 [6] List All Accounts
 [7] Search Account
 [0] Exit Application
----------------------------------------------
Select an option: 
```

---

## Future Roadmap

This project is planned to evolve into a Spring Boot backend with RESTful APIs, Spring Data JPA, and a relational database. For the full learning milestones and mentorship roadmap, see [ROADMAP.md](ROADMAP.md).
