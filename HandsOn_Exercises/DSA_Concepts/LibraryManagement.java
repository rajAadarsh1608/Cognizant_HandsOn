class Book {
    int bookId;
    String title;
    String author;

    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    public void display() {
        System.out.println(bookId + " " + title + " " + author);
    }
}

public class LibraryManagement {

    public static Book linearSearch(Book[] books, String title) {
        for (Book book : books) {
            if (book.title.equalsIgnoreCase(title)) {
                return book;
            }
        }

        return null;
    }

    public static Book binarySearch(Book[] books, String title) {
        int low = 0;
        int high = books.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int comparison = books[mid].title.compareToIgnoreCase(title);

            if (comparison == 0) {
                return books[mid];
            }

            if (comparison < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return null;
    }

    public static void main(String[] args) {

        Book[] books = {
            new Book(101, "The Alchemist", "Paulo Coelho"),
            new Book(102, "Wings of Fire", "A.P.J. Abdul Kalam"),
            new Book(103, "Harry Potter", "J.K. Rowling"),
            new Book(104, "Java Programming", "James Gosling")
        };

        Book[] sortedBooks = {
            new Book(101, "Harry Potter", "J.K. Rowling"),
            new Book(102, "Java Programming", "James Gosling"),
            new Book(103, "The Alchemist", "Paulo Coelho"),
            new Book(104, "Wings of Fire", "A.P.J. Abdul Kalam")
        };

        System.out.println("Linear Search:");

        Book result1 = linearSearch(books, "Harry Potter");

        if (result1 != null) {
            result1.display();
        } else {
            System.out.println("Book not found.");
        }

        System.out.println("\nBinary Search:");

        Book result2 = binarySearch(sortedBooks, "Harry Potter");

        if (result2 != null) {
            result2.display();
        } else {
            System.out.println("Book not found.");
        }
    }
}
