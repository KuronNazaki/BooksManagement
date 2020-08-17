package model;

import java.text.ParseException;

public class Book {
    public enum Genre {
        Science(1), Art(2), Economic(3), IT(4), Other(5);

        private int ordinal;

        Genre (int ordinal) {
            this.ordinal = ordinal;
        }

        public static Genre getGenreByOrdinal (int ordinal) {
            for (Genre genre : Genre.values()) {
                if (genre.ordinal == ordinal) {
                    return genre;
                }
            }

            return null;
        }
    }

    private static int id = 100000;
    private int bookID;
    private String bookName;
    private String author;
    private Genre genre;
    private int publishedYear;
    private int quantity;

    public Book () {}

    public Book (int bookID) {
        this.bookID = bookID;
    }

    public Book (String bookName, String author, Genre genre,
                 int publishedYear, int quantity) {
        this.bookID = id++;
        this.bookName = bookName;
        this.author = author;
        this.genre = genre;
        this.quantity = quantity;
        this.publishedYear = publishedYear;
    }

    public Book (int bookID, String bookName, String author, Genre genre,
                 int publishedYear, int quantity) {
        this.bookID = bookID;
        this.bookName = bookName;
        this.author = author;
        this.genre = genre;
        this.quantity = quantity;
        this.publishedYear = publishedYear;
    }

    public static void setId (int newId) {
        id = newId;
    }

    public int getBookID () {
        return bookID;
    }

    public void setBookID (int bookID) {
        this.bookID = bookID;
    }

    public String getBookName () {
        return bookName;
    }

    public void setBookName (String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor () {
        return author;
    }

    public void setAuthor (String author) {
        this.author = author;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public int getPublishedYear() {
        return publishedYear;
    }

    public void setPublishedYear (int publishedYear) {
        this.publishedYear = publishedYear;
    }

    public int getQuantity () {
        return quantity;
    }

    public void setQuantity (int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Book [ " + this.bookID + " | '" + this.bookName + "' | '" +
                this.author + "' | " + this.publishedYear + " | Genre:" +
                this.genre + " | Qty:" + this.quantity + " ]";
    }
}
