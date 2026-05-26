import java.util.ArrayList;

public class Student extends Person {
    private String department;
    private ArrayList<Integer> borrowedBooks;  // stores book IDs

    private static final int MAX_BORROW_LIMIT = 3;

    public Student(int id, String name, String department) {
        super(id, name);
        this.department = department;
        this.borrowedBooks = new ArrayList<>();
    }

    public String getDepartment() {
        return department;
    }

    public ArrayList<Integer> getBorrowedBooks() {
        return borrowedBooks;
    }

    public boolean canBorrowMore() {
        return borrowedBooks.size() < MAX_BORROW_LIMIT;
    }

    public boolean hasBorrowed(int bookId) {
        return borrowedBooks.contains(bookId);
    }

    public void borrowBook(int bookId) {
        borrowedBooks.add(bookId);
    }

    public void returnBook(int bookId) {
        borrowedBooks.remove(Integer.valueOf(bookId));
    }

    @Override
    public void displayDetails() {
        System.out.println("Student ID   : " + getId());
        System.out.println("Name         : " + getName());
        System.out.println("Department   : " + department);
        System.out.println("Books Borrowed: " + borrowedBooks.size() + " / " + MAX_BORROW_LIMIT);
        if (borrowedBooks.isEmpty()) {
            System.out.println("Borrowed Books: None");
        } else {
            System.out.println("Borrowed Book IDs: " + borrowedBooks);
        }
        System.out.println("---------------------------");
    }
}
