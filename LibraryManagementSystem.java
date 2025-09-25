import java.util.ArrayList;
import java.util.Scanner;

// Book Class
class Book {
    int id;
    String title;
    String author;
    boolean isIssued;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }

    public void issueBook() {
        isIssued = true;
    }

    public void returnBook() {
        isIssued = false;
    }

    @Override
    public String toString() {
        return id + " | " + title + " | " + author + " | " + (isIssued ? "Issued" : "Available");
    }
}

// User Class
class User {
    int id;
    String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return id + " | " + name;
    }
}

// Library Class
class Library {
    ArrayList<Book> books = new ArrayList<>();
    ArrayList<User> users = new ArrayList<>();

    public void addBook(Book b) {
        books.add(b);
    }

    public void addUser(User u) {
        users.add(u);
    }

    public void viewBooks() {
        for (Book b : books) {
            System.out.println(b);
        }
    }

    public void viewUsers() {
        for (User u : users) {
            System.out.println(u);
        }
    }

    public void issueBook(int bookId, int userId) {
        for (Book b : books) {
            if (b.id == bookId) {
                if (!b.isIssued) {
                    b.issueBook();
                    System.out.println("✅ Book '" + b.title + "' issued to User ID: " + userId);
                } else {
                    System.out.println("⚠️ Book already issued!");
                }
                return;
            }
        }
        System.out.println("❌ Book not found!");
    }

    public void returnBook(int bookId) {
        for (Book b : books) {
            if (b.id == bookId) {
                if (b.isIssued) {
                    b.returnBook();
                    System.out.println("✅ Book returned successfully!");
                } else {
                    System.out.println("⚠️ Book was not issued.");
                }
                return;
            }
        }
        System.out.println("❌ Book not found!");
    }
}

// Main Class
public class LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library library = new Library();

        // 🔹 Demo Data
        library.addBook(new Book(101, "HTML, CSS and JS", "Tim Berners-Lee"));
        library.addBook(new Book(102, "Python Programming", "Guido van Rossum"));
        library.addBook(new Book(103, "Java Programming", "James Gosling"));
        library.addBook(new Book(104, "C++", "Bjarne Stroustrup"));


        library.addUser(new User(101, "Ashish"));
        library.addUser(new User(102, "Prasoon"));
        library.addUser(new User(103, "Anit"));

        while (true) {
            System.out.println("\n=== Library Management System ===");
            System.out.println("1. Add Book");
            System.out.println("2. Add User");
            System.out.println("3. View Books");
            System.out.println("4. View Users");
            System.out.println("5. Issue Book");
            System.out.println("6. Return Book");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    int bId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Book Title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();
                    library.addBook(new Book(bId, title, author));
                    System.out.println("✅ Book Added!");
                    break;

                case 2:
                    System.out.print("Enter User ID: ");
                    int uId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter User Name: ");
                    String name = sc.nextLine();
                    library.addUser(new User(uId, name));
                    System.out.println("✅ User Added!");
                    break;

                case 3:
                    System.out.println("\n--- Book List ---");
                    library.viewBooks();
                    break;

                case 4:
                    System.out.println("\n--- User List ---");
                    library.viewUsers();
                    break;

                case 5:
                    System.out.print("Enter Book ID to Issue: ");
                    int issueId = sc.nextInt();
                    System.out.print("Enter User ID: ");
                    int issueUser = sc.nextInt();
                    library.issueBook(issueId, issueUser);
                    break;

                case 6:
                    System.out.print("Enter Book ID to Return: ");
                    int returnId = sc.nextInt();
                    library.returnBook(returnId);
                    break;

                case 7:
                    System.out.println("👋 Exiting... Thank you!");
                    sc.close();
                    return;

                default:
                    System.out.println("❌ Invalid choice!");
            }
        }
    }
}
