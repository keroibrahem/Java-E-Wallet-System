# E-Wallet System

A comprehensive Java-based digital wallet application designed to manage user accounts, handle financial transactions, and provide secure authentication with a command-driven architecture.

## Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Architecture](#architecture)
- [Project Structure](#project-structure)
- [Technology Stack](#technology-stack)
- [Getting Started](#getting-started)
- [Usage](#usage)
- [Design Patterns](#design-patterns)
- [Code Structure](#code-structure)

## Overview

The E-Wallet System is a console-based financial management application that enables users to create accounts, authenticate securely, and perform various financial operations. The system implements industry-standard design patterns to ensure maintainability, scalability, and clean code architecture.

## Features

### Account Management
- **User Registration**: Create new accounts with validation
- **User Authentication**: Secure login system with password validation
- **Account Details**: View comprehensive account information
- **Profile Management**: Update account credentials

### Financial Operations
- **Deposit Funds**: Add money to wallet balance
- **Withdraw Funds**: Withdraw money with sufficient balance validation
- **Money Transfer**: Transfer funds between registered accounts
- **Balance Inquiry**: Real-time balance information

### Security Features
- Password protection for accounts
- Login state management
- Input validation for all operations
- Prevention of unauthorized transactions

## Architecture

The application follows a **layered architecture** with clear separation of concerns:

```
Presentation Layer (UI)
        ↓
Business Logic Layer (Service)
        ↓
Data Access Layer (Repository)
        ↓
Domain Models (Entity)
```

## Project Structure

```
E-Wallet_System/
├── src/
│   ├── Main.java                    # Application entry point
│   ├── model/
│   │   └── Account.java             # Account entity model
│   ├── service/
│   │   ├── AccountService.java      # Account business logic
│   │   └── AuthService.java         # Authentication logic
│   ├── repository/
│   │   └── AccountRepository.java   # Data persistence layer
│   ├── patterns/
│   │   ├── Command.java             # Command interface
│   │   ├── CommandFactory.java      # Factory for command creation
│   │   ├── CommandDeposit.java      # Deposit command implementation
│   │   ├── CommandWithdraw.java     # Withdrawal command implementation
│   │   ├── CommandTransfer.java     # Transfer command implementation
│   │   ├── CommandChangePassword.java # Password change command
│   │   ├── CommandShowDetails.java  # Account details command
│   │   ├── CommandLogout.java       # Logout command
│   │   └── CommandFactory.java      # Command factory pattern
│   ├── ui/
│   │   ├── FirstMenu.java           # Initial menu presentation
│   │   ├── LoginUI.java             # Login screen
│   │   ├── SignupUI.java            # Registration screen
│   │   └── MainMenuUI.java          # Main application menu
│   ├── validation/
│   │   └── AccountValidator.java    # Input validation logic
│   └── util/
│       └── ConsoleUtil.java         # Console utility functions
└── README.md                        # This file
```

## Technology Stack

| Component | Technology |
|-----------|-----------|
| Language | Java 25 LTS (Upgradable to Java 21 LTS) |
| Architecture Pattern | Command Pattern, Factory Pattern |
| Data Storage | In-Memory Repository (Singleton) |
| UI | Console-based (Scanner) |
| Build System | IDEs (Eclipse, IntelliJ) |

## Getting Started

### Prerequisites

- **Java Runtime Environment (JRE)**: Java 21 LTS or higher
- **IDE**: IntelliJ IDEA, Eclipse, or NetBeans (optional)
- **Terminal/Command Prompt**: For running the application

### Installation

1. **Clone or download** the project to your local machine
2. **Compile the project**:
   ```bash
   javac -d bin src/**/*.java
   ```
3. **Run the application**:
   ```bash
   java -cp bin Main
   ```

### Quick Start

1. Launch the application by running `Main.java`
2. Select from the initial menu:
   - **Login**: Access existing account
   - **Sign Up**: Create a new account
3. After authentication, access the main menu for transaction operations

## Usage

### Creating an Account

```
1. Select "Sign Up" from the initial menu
2. Enter username (alphanumeric)
3. Set a secure password
4. Provide your age and phone number
5. Initial balance setup (optional)
```

### Logging In

```
1. Select "Login" from the initial menu
2. Enter your username
3. Enter your password
4. Access the main menu upon successful authentication
```

### Performing Transactions

#### Deposit
```
Main Menu → Deposit
Enter amount to deposit
Confirm transaction
```

#### Withdraw
```
Main Menu → Withdraw
Enter withdrawal amount
Confirm (balance must be sufficient)
```

#### Transfer
```
Main Menu → Transfer
Enter recipient username
Enter transfer amount
Confirm transaction
```

#### Change Password
```
Main Menu → Change Password
Enter old password
Enter new password
Confirm change
```

## Design Patterns

### 1. **Command Pattern**
- Encapsulates financial operations as command objects
- Enables undo/redo functionality potential
- Separates operation logic from invocation
- **Implementation**: `Command.java`, `CommandFactory.java`, and command implementations

### 2. **Factory Pattern**
- Creates command instances based on user selection
- Centralizes command instantiation logic
- **Implementation**: `CommandFactory.java`

### 3. **Singleton Pattern**
- Ensures single instance of `AccountRepository`
- Manages centralized data storage
- **Implementation**: `AccountRepository.getInstance()`

### 4. **Layered Architecture**
- **Presentation**: UI classes handle user interaction
- **Service**: Business logic and validation
- **Repository**: Data persistence
- **Model**: Domain entities

## Code Structure

### Model Layer
**Account.java** - Represents a user account with properties:
- Username, Password, Balance
- Account Type, Phone, Age
- Login status

### Service Layer
**AccountService.java** - Handles business operations:
- Deposit transactions with validation
- Withdraw transactions with balance checks
- Money transfer between accounts
- Password change management

**AuthService.java** - Authentication operations:
- User login validation
- Account creation
- Credential verification

### Repository Layer
**AccountRepository.java** - Data management:
- Store and retrieve accounts
- Find accounts by username
- Maintain account registry

### Validation Layer
**AccountValidator.java** - Input validation:
- Username format validation
- Password strength verification
- Balance validation
- Phone number validation
- Age validation

### UI Layer
**FirstMenu.java** - Initial application menu
**LoginUI.java** - Login form
**SignupUI.java** - Registration form
**MainMenuUI.java** - Primary application interface

### Utility Layer
**ConsoleUtil.java** - Helper functions for console operations

## Future Enhancements

- [ ] Database integration (MySQL, PostgreSQL)
- [ ] Transaction history logging
- [ ] Encryption for password storage
- [ ] User role-based access control
- [ ] Transaction reversal (undo) functionality
- [ ] Multi-currency support
- [ ] REST API exposure
- [ ] Web-based UI using Spring Boot
- [ ] Unit and integration testing suite
- [ ] Liquidity analysis and reporting

## Best Practices Implemented

✅ **Clean Code Architecture**: Clear separation of concerns
✅ **Design Patterns**: Command and Factory patterns for maintainability
✅ **Validation**: Input sanitization at service layer
✅ **Error Handling**: Comprehensive error messages
✅ **Singleton Pattern**: Efficient resource management
✅ **Immutability**: Appropriate use of final fields

## Troubleshooting

### Issue: "Account not found" error
**Solution**: Verify username spelling and ensure the account exists in the system

### Issue: "Insufficient balance" error
**Solution**: Check current balance before attempting withdrawal or transfer

### Issue: Compilation errors
**Solution**: Ensure all Java files are in the correct package directories and properly compiled

## Contributing

For improvements or bug reports, please:
1. Document the issue clearly
2. Provide steps to reproduce
3. Suggest potential solutions

## License

This project is provided as-is for educational and commercial purposes.

## Contact & Support

For questions or support regarding this E-Wallet System, please refer to the code documentation or contact the development team.

---

**Last Updated**: December 2025
**Version**: 1.0.0
**Status**: Production Ready
