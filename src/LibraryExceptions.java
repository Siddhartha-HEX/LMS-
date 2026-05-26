// Book not found in library
class BookNotFoundException extends Exception {
    public BookNotFoundException(String msg) {
        super(msg);
    }
}

// Book is already issued to someone
class BookAlreadyIssuedException extends Exception {
    public BookAlreadyIssuedException(String msg) {
        super(msg);
    }
}

// Student has reached max borrow limit
class BorrowLimitExceededException extends Exception {
    public BorrowLimitExceededException(String msg) {
        super(msg);
    }
}

// Student not found
class StudentNotFoundException extends Exception {
    public StudentNotFoundException(String msg) {
        super(msg);
    }
}
