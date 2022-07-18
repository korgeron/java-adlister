import beans.Album;
import beans.Author;
import beans.Quote;

import java.io.Serializable;
import java.util.ArrayList;

public class BeanTest implements Serializable {

    public static void main(String[] args) {

        Author author = new Author(1, "Billy Joe");
        ArrayList<Quote> quotes = new ArrayList<>();
        quotes.add(new Quote(1, author, "Oh yea!"));
        quotes.add(new Quote(2,author,"Not again!"));
        quotes.add(new Quote(3,author,"Yep...again..."));

        quotes.forEach((q) ->{
            System.out.println(q.getAuthor().getName() + ", " +  q.getQuote());
        });

        Album album = new Album();

    }
}
