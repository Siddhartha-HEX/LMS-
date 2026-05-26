import java.util.ArrayList;

public class Library implements LibraryOperations {
    private String libraryName;
    private ArrayList<Book> books;
    private ArrayList<Student> students;

    public Library(String libraryName) {
        this.libraryName = libraryName;
        this.books = new ArrayList<>();
        this.students = new ArrayList<>();
    }

    // add a book to library
    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added successfully: " + book.getBookName());
    }

    // add a student to library records
    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Student registered: " + student.getName());
    }

    // display all books
    public void viewAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in library.");
            return;
        }
        System.out.println("\n===== All Books =====");
        for (Book b : books) {
            b.displayDetails();
        }
    }

    // find book by ID - throws exception if not found
    private Book findBook(int bookId) throws BookNotFoundException {
        for (Book b : books) {
            if (b.getBookId() == bookId) {
                return b;
            }
        }
        throw new BookNotFoundException("Book with ID " + bookId + " not found.");
    }

    // find student by ID - throws exception if not found
    private Student findStudent(int studentId) throws StudentNotFoundException {
        for (Student s : students) {
            if (s.getId() == studentId) {
                return s;
            }
        }
        throw new StudentNotFoundException("Student with ID " + studentId + " not found.");
    }

    @Override
    public void issueBook(int studentId, int bookId) {
        try {
            Student student = findStudent(studentId);
            Book book = findBook(bookId);

            if (!book.isAvailable()) {
                throw new BookAlreadyIssuedException("Sorry! Book '" + book.getBookName() + "' is already issued.");
            }

            if (!student.canBorrowMore()) {
                throw new BorrowLimitExceededException("Student " + student.getName() + " has reached max borrow limit of 3 books.");
            }

            // all good - issue the book
            book.setAvailable(false);
            student.borrowBook(bookId);
            System.out.println("Book '" + book.getBookName() + "' issued to " + student.getName() + " successfully.");

        } catch (BookNotFoundException | StudentNotFoundException |
                 BookAlreadyIssuedException | BorrowLimitExceededException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @Override
    public void returnBook(int studentId, int bookId) {
        try {
            Student student = findStudent(studentId);
            Book book = findBook(bookId);

            if (!student.hasBorrowed(bookId)) {
                System.out.println("Error: This student did not borrow book '" + book.getBookName() + "'.");
                return;
            }

            // return the book
            book.setAvailable(true);
            student.returnBook(bookId);
            System.out.println("Book '" + book.getBookName() + "' returned by " + student.getName() + " successfully.");

        } catch (BookNotFoundException | StudentNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void viewStudentDetails(int studentId) {
        try {
            Student student = findStudent(studentId);
            System.out.println("\n===== Student Details =====");
            student.displayDetails();
        } catch (StudentNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void viewAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students registered.");
            return;
        }
        System.out.println("\n===== All Students =====");
        for (Student s : students) {
            s.displayDetails();
        }
    }

    public String getLibraryName() {
        return libraryName;
    }
}
