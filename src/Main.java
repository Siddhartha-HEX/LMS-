import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static Library library = new Library("College Central Library");

    public static void main(String[] args) {
        System.out.println("Welcome to " + library.getLibraryName());
        System.out.println("=========================================");

        int choice = -1;

        while (choice != 7) {
            printMenu();

            try {
                choice = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    library.viewAllBooks();
                    break;
                case 3:
                    addStudent();
                    break;
                case 4:
                    issueBook();
                    break;
                case 5:
                    returnBook();
                    break;
                case 6:
                    viewStudentDetails();
                    break;
                case 7:
                    System.out.println("Exiting... Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }

            System.out.println();
        }

        sc.close();
    }

    static void printMenu() {
        System.out.println("---------- MENU ----------");
        System.out.println("1. Add Book");
        System.out.println("2. View All Books");
        System.out.println("3. Add Student");
        System.out.println("4. Issue Book");
        System.out.println("5. Return Book");
        System.out.println("6. View Student Details");
        System.out.println("7. Exit");
        System.out.print("Enter your choice: ");
    }

    static void addBook() {
        System.out.print("Enter Book ID: ");
        int id;
        try {
            id = Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Invalid Book ID.");
            return;
        }

        System.out.print("Enter Book Name: ");
        String name = sc.nextLine().trim();

        System.out.print("Enter Author Name: ");
        String author = sc.nextLine().trim();

        Book book = new Book(id, name, author);
        library.addBook(book);
    }

    static void addStudent() {
        System.out.print("Enter Student ID: ");
        int id;
        try {
            id = Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Invalid Student ID.");
            return;
        }

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine().trim();

        System.out.print("Enter Department: ");
        String dept = sc.nextLine().trim();

        Student student = new Student(id, name, dept);
        library.addStudent(student);
    }

    static void issueBook() {
        System.out.print("Enter Student ID: ");
        int studentId;
        try {
            studentId = Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Invalid Student ID.");
            return;
        }

        System.out.print("Enter Book ID: ");
        int bookId;
        try {
            bookId = Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Invalid Book ID.");
            return;
        }

        library.issueBook(studentId, bookId);
    }

    static void returnBook() {
        System.out.print("Enter Student ID: ");
        int studentId;
        try {
            studentId = Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Invalid Student ID.");
            return;
        }

        System.out.print("Enter Book ID: ");
        int bookId;
        try {
            bookId = Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Invalid Book ID.");
            return;
        }

        library.returnBook(studentId, bookId);
    }

    static void viewStudentDetails() {
        System.out.print("Enter Student ID: ");
        int studentId;
        try {
            studentId = Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Invalid Student ID.");
            return;
        }
        library.viewStudentDetails(studentId);
    }
}
