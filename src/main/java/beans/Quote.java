package beans;

import java.io.Serializable;

public class Quote implements Serializable {
    private long id;
    private Author author;
    private String quote;

    public Quote() {
    }

    public Quote(long id, Author author, String quote) {
        this.id = id;
        this.author = author;
        this.quote = quote;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }
}
