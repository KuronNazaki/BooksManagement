package view;

import controller.*;
import model.*;

import java.util.ArrayList;
import java.util.Scanner;

public class View {
    static DataController controller = new DataController();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice = 0;
        var bookFile = "Book.DAT";
        var books = new ArrayList<Book>();


        do {
            System.out.println("___________________MENU___________________");
            System.out.println("1. Add a new book to file.");
            System.out.println("2. Display all books in file.");
            System.out.println("0. Exit the program.");
            System.out.print("What do you choose : ");

            choice = scanner.nextInt();

            executeChoice(choice, bookFile);
        } while (choice != 0);
    }

    static void executeChoice (final int choice, final String fileName) {
        scanner.nextLine();

        switch (choice) {
            case 0:
                System.out.println("Thank you for using our program.");
                break;
            case 1:
                String bookName, author;
                int publishedYear, quantity, ordinal;
                System.out.println("You've chosen " + choice);
                System.out.print("Enter the book's name : ");
                bookName = scanner.nextLine();

                System.out.print("Enter the author's name : ");
                author = scanner.nextLine();

                System.out.print("Enter the book's genre.\n" +
                        "There are 5 types defined in our program " +
                        "(1.Science, 2.Art, 3.Economic, 4.IT, 5.Other) : ");
                ordinal = scanner.nextInt();
                Book.Genre genre = Book.Genre.getGenreByOrdinal(ordinal);

                scanner.nextLine();
                System.out.print("Enter the published year : ");
                publishedYear = scanner.nextInt();

                scanner.nextLine();
                System.out.print("Enter the quantity : ");
                quantity = scanner.nextInt();

                var book = new Book(bookName, author, genre, publishedYear, quantity);
                controller.writeBookToFile(book, fileName);

                break;
            case 2:
                break;
        }
    }
}
