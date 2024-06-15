import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        // Create a TreeSet to store books
        Set<Book> bookSet = new TreeSet<>();

        // Create book objects
        Book harryPotter = new Book("Harry Potter", "J.K. Rowling", 353, 1997);
        Book lotr = new Book("Lord of the Rings", "J.R.R. Tolkien", 514, 1954);
        Book gameOfThrones = new Book("Game of Thrones", "George R.R. Martin", 847, 1996);
        Book prideAndPrejudice = new Book("Pride and Prejudice", "Jane Austen", 439, 1813);
        Book callOfCthulhu = new Book("Call of Cthulhu", "H.P. Lovecraft", 151, 1928);

        // Add books to the TreeSet
        bookSet.add(harryPotter);
        bookSet.add(lotr);
        bookSet.add(gameOfThrones);
        bookSet.add(prideAndPrejudice);
        bookSet.add(callOfCthulhu);

        System.out.println("---- Book List Sorted by Name ----");
        System.out.printf("%-20s %-11s %-19s %-11s\n", "Name", "PageNumber", "Author", "PublishDate");

        // Sort books by book name and print them to the console
        for(Book book : bookSet) {
            System.out.printf("%-20s %-11d %-19s %-11s\n",book.getBookName(), book.getBookPage(),book.getAuthorName(), book.getPublishDate());
        }

        // Create a TreeSet to sort books by page number
        Set<Book> bookSetComparedByPage = new TreeSet<>(new Comparator<Book>() {
            @Override
            public int compare(Book book1, Book book2) {
                return book1.getBookPage()-book2.getBookPage();
            }
        });

        // Add books to the TreeSet
        bookSetComparedByPage.addAll(bookSet);

        // Sort books by page number and print them to the console
        System.out.println();
        System.out.println("---- Book List Sorted by Page Number ----");
        System.out.printf("%-20s %-11s %-19s %-11s\n", "Name", "PageNumber", "Author", "PublishDate");

        // Sort books by book page and print them to the console
        for(Book book : bookSetComparedByPage) {
            System.out.printf("%-20s %-11d %-19s %-11s\n",book.getBookName(), book.getBookPage(),book.getAuthorName(), book.getPublishDate());
        }
    }
}