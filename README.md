[README.md](https://github.com/user-attachments/files/28256193/README.md)
# Library Management System

A simple terminal-based Library Management System built in Java using OOP concepts.

## Features

- Add books to the library
- View all books with availability status
- Register students
- Issue books to students
- Return books
- View student details (borrowed books, department, etc.)

## OOP Concepts Used

| Concept | Where Used |
|---|---|
| Class & Object | Book, Student, Librarian, Library, Main |
| Encapsulation | Private fields with getters/setters in all classes |
| Inheritance | Student and Librarian both extend Person |
| Polymorphism | `displayDetails()` overridden in Student and Librarian |
| Abstraction | `LibraryOperations` interface with `issueBook()` and `returnBook()` |
| Constructors | All classes use parameterized constructors |
| Exception Handling | Custom exceptions for book not found, already issued, borrow limit, etc. |

## How to Run

**Requirements:** Java JDK installed on your system

```bash
# Step 1 - Go to src folder
cd src

# Step 2 - Compile
javac *.java

# Step 3 - Run
java Main
```

## Book Issue Rules

- A student can borrow a maximum of **3 books** at a time
- Cannot issue a book that is already issued
- A student can only return books they have borrowed

## Project Structure

```
LibraryManagementSystem/
├── src/
│   ├── Main.java              (entry point, menu)
│   ├── Person.java            (abstract parent class)
│   ├── Student.java           (extends Person)
│   ├── Librarian.java         (extends Person)
│   ├── Book.java              (book entity)
│   ├── Library.java           (core logic, implements LibraryOperations)
│   ├── LibraryOperations.java (interface)
│   └── LibraryExceptions.java (custom exceptions)
└── README.md
```
