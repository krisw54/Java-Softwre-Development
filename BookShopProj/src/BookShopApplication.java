import java.util.Scanner;
/**
 *
 * @author chriswood
 */
public class BookShopApplication {
    
    public static void main(String[] args) {
        
        Book[] books = new Book[10];
        Scanner kybd = new Scanner(System.in);
        for(int i=0; i < books.length; i++)
        {
            books[i]=getBook(kybd);
        }
        printBookDetails(books);    
    }
    
    public static Book getBook(Scanner kybd)
    {
       Book book;
        System.out.println("What is the title of the next book? > ");
        String title = kybd.nextLine();
        System.out.println("What is the name of the author? >  ");
        String author = kybd.nextLine();
        if (author.equals(""))
        {
            book = new Book(title);  
        } else 
        {
            book = new Book (title, author);
        }
        return book;
    }
    
    public static void printBookDetails (Book[] books)
    {
        System.out.println("\nBook list");
        System.out.println("\tTitle\t\tAuthor");
        System.out.println("\t=======\t\t=======");
        
        for(int i=0; i < books.length; i++)
        {
            System.out.println("\t" + books[i].getTitle() + "\t\t" + books[i].getAuthor());
        }
    }
    
}
