public class Book {
    String title;
    String author;
    int bookID;

    public Book(String title, String author, int bookID) {
        this.title = title;
        this.author = author;
        this.bookID = bookID;
    }

    public int getId() {
        return bookID;
    }
}
