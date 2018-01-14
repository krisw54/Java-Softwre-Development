/**
 *
 * @author chriswood
 */
public class Book {
    
    private String title;
    private String author;
    
    public Book(String title) {
        this.title = title;
        author = "Anon";
    }
    
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }    
}