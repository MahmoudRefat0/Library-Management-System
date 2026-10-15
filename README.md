# 📚 Bayt Al Hekma — Library Management System

A console-based Java application that manages a library's catalogue (books, magazines, DVDs), members, loans and fines, built with **OOP** principles.

## Features
- View the catalogue and search items by ID or status
- Register members with membership types (`STUDENT`, `STAFF`, `PUBLIC`) and discounts on fines
- Borrow, return and renew loans
- Late fines calculated per item type
- Pay outstanding fines, mark items as lost
- Library report and member list

## Concepts used
| Concept | Where |
| --- | --- |
| Abstraction | Abstract `LibraryItem` base class |
| Inheritance | `Book`, `Magazine`, `DVD` extend `LibraryItem` |
| Polymorphism | Each item overrides `getFine()` |
| Interfaces | `Renewable`, implemented by `Book` and `Magazine` only |
| Enums | `ItemStatus`, `MembershipType` (with a discount value) |
| Encapsulation | Private state, changed only through methods |

## Project structure
```
Library_Management_System/src
├── Main.java            # Console menu (11 options)
├── Library.java         # Business logic
├── LibraryItem.java     # Abstract base class
├── Book.java
├── Magazine.java
├── DVD.java
├── Renewable.java
├── Member.java
├── MembershipType.java
└── ItemStatus.java
```

## How to run
1. Open the `Library_Management_System` folder in IntelliJ IDEA (JDK 17+).
2. Run `Main.java`.

Or from the terminal:
```bash
cd Library_Management_System/src
javac *.java && java Main
```
