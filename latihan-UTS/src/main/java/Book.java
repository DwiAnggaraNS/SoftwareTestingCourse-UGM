public class Book {
    private String id;
    private String title;
    private String author;
    private int publicationYear;
    private String category;
    private boolean isAvailable;

    public Book(String id, String title, String author, int publicationYear, String category) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.category = category;
        this.isAvailable = true;
    }

    // Getters and Setters
    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public int getPublicationYear() { return publicationYear; }
    public String getCategory() { return category; }
    public boolean isAvailable() { return isAvailable; }
    public void setAvailable(boolean available) { isAvailable = available; }
}
