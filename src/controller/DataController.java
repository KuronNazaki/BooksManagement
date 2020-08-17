package controller;

import model.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class DataController {
    private FileWriter fileWriter;
    private BufferedWriter bufferedWriter;
    private PrintWriter printWriter;
    private Scanner scanner;

    public DataController () {}

    public void openFileToWrite (String fileName) {
        try {
            fileWriter = new FileWriter(fileName, true);
            bufferedWriter = new BufferedWriter(fileWriter);
            printWriter = new PrintWriter(bufferedWriter);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void openFileToRead (String fileName) {
        try {
            scanner = new Scanner(Paths.get(fileName), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Reader> readReadersFromFile (String fileName) {
        openFileToRead(fileName);
        ArrayList<Reader> readers = new ArrayList<>();
        while (scanner.hasNext()) {
            String data = scanner.nextLine();
            Reader reader = createReaderFromData(data);
            readers.add(reader);
        }
        closeFileAfterRead();
        return readers;
    }

    public ArrayList<Book> readBooksFromFile (String fileName) {
        openFileToRead(fileName);
        ArrayList<Book> books = new ArrayList<>();
        while (scanner.hasNext()) {
            String data = scanner.nextLine();
            try {
                books.add(createBookFromData(data));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        closeFileAfterRead();
        return books;
    }

    public ArrayList<BookReaderManager> readBookReaderManagerFromFile (String fileName) {
        openFileToRead(fileName);
        ArrayList<BookReaderManager> managers = new ArrayList<>();
        while (scanner.hasNext()) {
            String data = scanner.nextLine();
            managers.add(createBookReaderManagerFromFile(data));
        }
        return managers;
    }

    public void writeBookToFile (Book book, String fileName) {
        openFileToWrite(fileName);
        printWriter.println(book.getBookID() + "|" + book.getBookName() + "|" +
                book.getAuthor() + "|" + book.getGenre() + "|" +
                book.getPublishedYear() + "|" + book.getQuantity());
        closeFileAfterWrite();
    }

    public void writeReaderToFile (Reader reader, String fileName) {
        openFileToWrite(fileName);
        printWriter.println(reader.getReaderID() + "|" + reader.getFullName() + "|" +
                reader.getAddress() + "|" + reader.getPhoneNumber());
        closeFileAfterWrite();
    }

    public void writeBookReaderManagerToFile (BookReaderManager brm, String fileName) {
        openFileToWrite(fileName);
        printWriter.println(brm.getBook().getBookID() + "|" + brm.getReader().getReaderID()
                + "|" + brm.getNumOfBorrow() + "|" + brm.getState());
        closeFileAfterWrite();
    }

    public Book createBookFromData (String data) throws ParseException {
        String[] dataSet = data.split("\\|");
        //int bookID|String bookName|String author|
        // Book.Genre genre|int publishedYear|int quantity
        return new Book(Integer.parseInt(dataSet[0]), dataSet[1], dataSet[2],
                Book.Genre.valueOf(dataSet[3]), Integer.parseInt(dataSet[4]),
                Integer.parseInt(dataSet[5]));
    }

    public Reader createReaderFromData (String data) {
        String[] dataSet = data.split("\\|");
        // readerID|fullName|address|phoneNumber
        return new Reader(Long.parseLong(dataSet[0]), dataSet[1], dataSet[2], dataSet[3]);
    }

    public BookReaderManager createBookReaderManagerFromFile (String data) {
        String[] dataSet = data.split("\\|");
        //brm.getBook().getBookID()|brm.getReader().getReaderID()|brm.getNumOfBorrow()|brm.getState()
        return new BookReaderManager(new Book(Integer.parseInt(dataSet[0])),
                new Reader(Long.parseLong(dataSet[1])), Integer.parseInt(dataSet[2]),
                dataSet[3], 0);
    }

    public void closeFileAfterWrite () {
        try {
            printWriter.close();
            bufferedWriter.close();
            fileWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void closeFileAfterRead () {
        try {
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
