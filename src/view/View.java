package view;

import controller.*;
import model.*;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class View {
    static DataController controller = new DataController();
    static Scanner scanner = new Scanner(System.in);
    static boolean isBookFileChecked = false;

    public static void main(String[] args) {
        int choice = 0;
        var bookFile = "Book.hp";
        var books = new ArrayList<Book>();

        do {
            System.out.println("___________________MENU___________________");
            System.out.println("1. Add a new book to file.");
            System.out.println("2. Display all books in file.");
            System.out.println("0. Exit the program.");
            System.out.print("What do you choose : ");
            choice = scanner.nextInt();
            System.out.println("------------------------------------------");

            executeChoice(choice, bookFile);
        } while (choice != 0);

    }

    private static void checkBookID(DataController controller, String fileName) {
        ArrayList<Book> books = controller.readBooksFromFile(fileName);
        Book.setId(books.get(books.size() - 1).getBookID() + 1);
        isBookFileChecked = true;
    }

    static void executeChoice (final int choice, final String fileName) {

        scanner.nextLine();
        System.out.println("You've chosen " + choice);

        switch (choice) {
            case 0:
                System.out.println("------------------------------------------");
                System.out.println("Thank you for using our program.");

                break;

            case 1:
                try {
                    if (!isBookFileChecked) {
                        checkBookID(controller, fileName);
                    }
                    String bookName, author;
                    int publishedYear, quantity, ordinal;
                    System.out.print("Enter the book's name : ");
                    bookName = scanner.nextLine();

                    System.out.print("Enter the author's name : ");
                    author = scanner.nextLine();

                    do {
                        System.out.print("Enter the book's genre.\n" +
                                "There are 5 types defined in our program.\n" +
                                "  1. Science\n  2. Art\n  3. Economic\n  4. IT\n  5. Other\n" +
                                "Your choice : ");
                        ordinal = scanner.nextInt();
                    } while (ordinal < 1 || ordinal > 5);
                    Book.Genre genre = Book.Genre.getGenreByOrdinal(ordinal);

                    scanner.nextLine();
                    System.out.print("Enter the published year : ");
                    publishedYear = scanner.nextInt();

                    scanner.nextLine();
                    System.out.print("Enter the quantity : ");
                    quantity = scanner.nextInt();

                    var book = new Book(bookName, author, genre, publishedYear, quantity);
                    controller.writeBookToFile(book, fileName);
                } catch (InputMismatchException e) {
                    scanner.nextLine();
                    System.out.println("\n!!! The program has crashed. " +
                            "You must have entered a number !!!");
                }

                break;

            case 2:
                System.out.println("These are all the books stored in " + fileName + " : ");
                for (Book b : controller.readBooksFromFile(fileName)) {
                    System.out.println(b.toString());
                }

                break;

            default:
                System.out.println("We've not added this feature yet!!!");

                break;
        }
    }
}
