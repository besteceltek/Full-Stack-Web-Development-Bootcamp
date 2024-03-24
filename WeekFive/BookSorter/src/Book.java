public class Book implements Comparable<Book>{
    String bookName, authorName;
    int bookPage, publishDate;

    public Book(String bookName, String authorName, int bookPage, int publishDate) {
        this.bookName = bookName;
        this.authorName = authorName;
        this.bookPage = bookPage;
        this.publishDate = publishDate;
    }

    @Override
    public int compareTo(Book book) {
        return this.bookName.compareTo(book.bookName);
    }

    public String getBookName() {
        return bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public int getBookPage() {
        return bookPage;
    }

    public int getPublishDate() {
        return publishDate;
    }
}
