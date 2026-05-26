public class Book {
    private int bookId;
    private String bookName;
    private String authorName;
    private boolean isAvailable;

    public Book(int bookId, String bookName, String authorName) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.authorName = authorName;
        this.isAvailable = true;  // by default every new book is available
    }

    // getters
    public int getBookId() {
        return bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    // setters
    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public void displayDetails() {
        String status = isAvailable ? "Available" : "Issued";
        System.out.println("Book ID   : " + bookId);
        System.out.println("Book Name : " + bookName);
        System.out.println("Author    : " + authorName);
        System.out.println("Status    : " + status);
        System.out.println("---------------------------");
    }
}
