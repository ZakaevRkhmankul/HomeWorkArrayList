import database.Database;
import enums.Gender;
import enums.Genre;
import impl.BookServiceImpl;
import impl.LibraryServiceImpl;
import impl.ReaderServiceImpl;
import models.Book;
import models.Library;
import models.Reader;
import service.BookService;
import service.LibraryService;
import service.ReaderService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        Scanner scanner3 = new Scanner(System.in);
        LibraryService libraryService = new LibraryServiceImpl();
        BookService bookService = new BookServiceImpl(libraryService);
        ReaderService readerService = new ReaderServiceImpl(libraryService);

//        TODO LIBRARY SERVISE
        List<Library> libraries = new ArrayList<>(Arrays.asList(
                new Library(1L, "BookHouse"),
                new Library(2L, "А.Осмонов")));


        while (true) {
            System.out.println("""
                    \n1.Save library
                    2.Get all libraries
                    3.Get library by id
                    4.Update library
                    5.Delete library
                    6.Save book
                    7.Get all books
                    8.Get book by id
                    9.Delete book
                    10.Clear books by library
                    11.Save reader
                    12.Get all readers
                    13.Get reader by id
                    14.Update reader
                    15.Assing reader to library
                    16.Exit
                    """);
            System.out.print("Choice option:");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> {
                    System.out.println("Save library!");
                    System.out.println(libraryService.saveLibrary(libraries));
                }
                case 2 -> {
                    System.out.println("Get all libraries!");
                    System.out.println(libraryService.getAllLibraries());
                }
                case 3 -> {
                    System.out.println("Get library by id");
                    System.out.print("Libraries id 1 or 2: ");
                    long scannerLong = scanner.nextLong();
                    if (scannerLong <= 3) {
                        System.out.println(libraryService.getLibraryById(scannerLong));
                    } else {
                        System.out.println("Ошибка!");
                    }
                }
                case 4 -> {
                    System.out.println("Update library");
                    System.out.print("Libraries id 1 or 2: ");
                    long scannerLong = scanner.nextLong();
                    if (scannerLong <= 3) {
                        System.out.println(libraryService.updateLibrary(1L, new Library(1L, "Okurman")));
                    } else {
                        System.out.println("Ошибка!");
                    }
                }
                case 5 -> {
                    System.out.println("Delete library");
                    System.out.print("Libraries id 1 or 2: ");
                    long scannerLong = scanner.nextLong();
                    if (scannerLong <= 3) {
                        System.out.println(libraryService.deleteLibrary(scannerLong));
                    } else {
                        System.out.println("Ошибка!");
                    }
                }
                case 6 -> {
                    System.out.println("Save book");

                    System.out.println(bookService.saveBook(1L, new Book(1L, "Ежевичная зима", "Сара Джио", Genre.NOVEL)));
                    System.out.println(bookService.saveBook(1L, new Book(2L, "Немой свидетель", "Агата Кристи", Genre.DETECTIVE)));
                    System.out.println(bookService.saveBook(2L, new Book(1L, "Цветы для Элджернона", "Даниль Киз", Genre.CLASSIC)));
                    System.out.println(bookService.saveBook(2L, new Book(2L, "Фиалки в марте", "Сара Джио", Genre.NOVEL)));
                }
                case 7 -> {
                    System.out.println("Get all books:");
                    System.out.print("Library id: ");
                    long scannerLong = scanner.nextLong();
                    System.out.println(bookService.getAllBooks(scannerLong));
                }
                case 8 -> {
                    System.out.println("Get book by id:");
                    System.out.print("Library id: ");
                    long scannerLong = scanner.nextLong();
                    System.out.print("Book id: ");
                    long scannLong = scanner.nextLong();
                    if (scannerLong <= 3) {
                        System.out.println(bookService.getBookDById(scannerLong,(scannLong)));
                    } else {
                        System.out.println("Ошибка!");
                    }
                }
                case 9 -> {
                    System.out.println("Delete book:");
                    System.out.print("library id: ");
                    long scannerLong = scanner.nextLong();
                    System.out.print("Book id: ");
                    long scannLong = scanner.nextLong();
                    System.out.println(bookService.deleteBook(scannerLong, scannLong));
                }
                case 10 -> {
                    System.out.println("Clear books by library:");
                    System.out.print("library id: ");
                    bookService.clearBooksByLibrary(scanner.nextLong());
                }
                case 11 -> {
                    System.out.println("Save reader:");

                    System.out.print("Full Name: ");
                    String name = scanner1.nextLine();
                    System.out.print("Email: ");
                    String email = scanner2.nextLine();
                    System.out.print("Phone number: ");
                    String phoneNum = scanner3.nextLine();
                    readerService.saveReader(new Reader(1, name, email, phoneNum, Gender.MALE));

                    System.out.print("Full Name: ");
                    String name2 = scanner1.nextLine();
                    System.out.print("Email: ");
                    String email2 = scanner2.nextLine();
                    System.out.print("Phone number: ");
                    String phoneNum2 = scanner3.nextLine();
                    readerService.saveReader(new Reader(2, name2, email2, phoneNum2, Gender.MALE));

                    System.out.print("Full Name: ");
                    String name3 = scanner1.nextLine();
                    System.out.print("Email: ");
                    String email3 = scanner2.nextLine();
                    System.out.print("Phone number: ");
                    String phoneNum3 = scanner3.nextLine();
                    readerService.saveReader(new Reader(3, name3, email3, phoneNum3, Gender.MALE));
                }
                case 12 -> {
                    System.out.println("Get all readers:");
                    System.out.println(readerService.getAllReaders());
                }
                case 13 -> {
                    System.out.println("Get reader by id:");
                    System.out.print("Write readers id 1 ,2 or 3: ");
                    long scannerLong = scanner.nextLong();
                    System.out.println(readerService.getReaderById(scannerLong));
                }
                case 14 -> {
                    System.out.println("Update reader:");
                    System.out.print("Library id: ");
                    long scannerLong = scanner.nextLong();
                    System.out.print("Reader id: ");
                    long scannlong = scanner.nextLong();
                    System.out.print("Full name: ");
                    String scann1 = scanner1.nextLine();
                    System.out.print("Email: ");
                    String scann = scanner2.nextLine();
                    System.out.print("Phone number: ");
                    String scann2 = scanner3.nextLine();

                    if (scannerLong <= 3) {
                        System.out.println(readerService.updateReader(scannerLong, new Reader(scannlong, scann1, scann, scann2, Gender.MALE)));
                    } else {
                        System.out.println("Ошибка!");
                    }
                }
                case 15 -> {
                    System.out.println("Assing reader to library");
                    long scannerLong = scanner.nextLong();
                    readerService.assignReaderToLibrary(scannerLong, scannerLong);
                }
                case 16 -> {
                    return;
                }
            }
        }
    }
}