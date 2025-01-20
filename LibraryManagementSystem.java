import java.util.ArrayList;
import java.util.Scanner;

public class LibraryManagementSystem {

    static class Book {
        private String isbn;
        private String title;
        private String author;
        private boolean isBorrowed;

        public Book(String isbn, String title, String author) {
            this.isbn = isbn;
            this.title = title;
            this.author = author;
            this.isBorrowed = false;
        }

        public String getIsbn() {
            return isbn;
        }

        public String getTitle() {
            return title;
        }

        public String getAuthor() {
            return author;
        }

        public boolean isBorrowed() {
            return isBorrowed;
        }

        public void borrowBook() {
            if (!isBorrowed) {
                isBorrowed = true;
                System.out.println("The book has been borrowed.");
            } else {
                System.out.println("The book is already borrowed.");
            }
        }

        public void returnBook() {
            if (isBorrowed) {
                isBorrowed = false;
                System.out.println("The book has been returned.");
            } else {
                System.out.println("The book was not borrowed.");
            }
        }

        @Override
        public String toString() {
            return "ISBN: " + isbn + ", Title: " + title + ", Author: " + author + (isBorrowed ? " [Borrowed]" : " [Available]");
        }
    }

    private ArrayList<Book> books = new ArrayList<>();

    public void addBook(String isbn, String title, String author) {
        books.add(new Book(isbn, title, author));
        System.out.println("Book added successfully.");
    }

    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
        } else {
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    public void borrowBook(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                book.borrowBook();
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public void returnBook(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                book.returnBook();
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public void searchByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                System.out.println(book);
                return;
            }
        }
        System.out.println("No books found with the given title.");
    }

    public void searchByAuthor(String author) {
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                System.out.println(book);
            }
        }
    }

    public static void main(String[] args) {
        LibraryManagementSystem library = new LibraryManagementSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Book");
            System.out.println("2. Display Books");
            System.out.println("3. Borrow Book");
            System.out.println("4. Return Book");
            System.out.println("5. Search Book by Title");
            System.out.println("6. Search Book by Author");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter ISBN: ");
                    String isbn = scanner.nextLine();
                    System.out.print("Enter Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Author: ");
                    String author = scanner.nextLine();
                    library.addBook(isbn, title, author);
                    break;
                case 2:
                    library.displayBooks();
                    break;
                case 3:
                    System.out.print("Enter ISBN to borrow: ");
                    String borrowIsbn = scanner.nextLine();
                    library.borrowBook(borrowIsbn);
                    break;
                case 4:
                    System.out.print("Enter ISBN to return: ");
                    String returnIsbn = scanner.nextLine();
                    library.returnBook(returnIsbn);
                    break;
                case 5:
                    System.out.print("Enter Title to search: ");
                    String searchTitle = scanner.nextLine();
                    library.searchByTitle(searchTitle);
                    break;
                case 6:
                    System.out.print("Enter Author to search: ");
                    String searchAuthor = scanner.nextLine();
                    library.searchByAuthor(searchAuthor);
                    break;
                case 7:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
