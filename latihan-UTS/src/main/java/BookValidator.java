public class BookValidator {
    // Validates a book ID - must be alphanumeric with 5 to 10 characters
    public boolean validateBookId(String id) {
        if (id == null || id.isEmpty()) {
            return false;
        }

        // Check length (5-10 characters)
        if (id.length() < 5 || id.length() > 10) {
            return false;
        }

        // Check if alphanumeric
        return id.matches("^[a-zA-Z0-9]+$");
    }

    // Validates publication year - must be between 1000 and current year + 1
    public boolean validatePublicationYear(int year) {
        int currentYear = java.time.Year.now().getValue();
        return year >= 1000 && year <= currentYear + 1;
    }

    // Validates author name - must not be empty and contain only letters, spaces, and hyphens
    public boolean validateAuthor(String author) {
        if (author == null || author.trim().isEmpty()) {
            return false;
        }

        return author.matches("^[a-zA-Z\\s\\-]+$");
    }
}