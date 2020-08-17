package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

    public Book () {

    }

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
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");
//        try {
//            this.publishedYear = dateFormat.parse(Integer.toString(publishedYear));
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
    }

    public Book (int bookID, String bookName, String author, Genre genre,
                 int publishedYear, int quantity) {
        this.bookID = bookID;
        this.bookName = bookName;
        this.author = author;
        this.genre = genre;
        this.quantity = quantity;
        this.publishedYear = publishedYear;
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");
//        try {
//            this.publishedYear = dateFormat.parse(Integer.toString(publishedYear));
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
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
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");
//        dateFormat.format(publishedYear);
//        return Integer.parseInt(publishedYear.toString());
        return publishedYear;
    }

    public void setPublishedYear (int publishedYear) throws ParseException {
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");
//        this.publishedYear = dateFormat.parse(Integer.toString(publishedYear));
        this.publishedYear = publishedYear;
    }

    public int getQuantity () {
        return quantity;
    }

    public void setQuantity (int quantity) {
        this.quantity = quantity;
    }
}
