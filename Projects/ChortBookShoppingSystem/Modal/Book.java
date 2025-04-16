package Projects.ChortBookShoppingSystem.Modal;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Book extends Product{


    private  Author author;
    private LocalDate publishedDate;
    private LocalDateTime createdDate;

    public Book(String name, double price,Author author,LocalDate publishedDate) {
        super(name, price);
        this.author=author;
        this.publishedDate=publishedDate;
        this.createdDate=LocalDateTime.now();
    }

    public Author getAuthor() {
        return author;
    }

    public LocalDate getPublishedDate() {
        return publishedDate;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    @Override
    public String toString() {
        return """
           📖 Book Details
           ────────────────
           Name          : %s
           Price         : %.2f ₺
           Author        : %s
           Published Date: %s
           Created Date  : %s
           """.formatted(getName(),getPrice(), author, publishedDate, createdDate);
    }
}
