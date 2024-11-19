package impl;

import models.Book;
import database.Database;
import models.Library;
import service.BookService;
import service.LibraryService;

import java.util.List;

public class BookServiceImpl implements BookService {
    private final LibraryService libraryService;

    public BookServiceImpl(LibraryService libraryService) {
        this.libraryService = libraryService;
    }


    @Override
    public Book saveBook(long libraryId, Book book) {
        for (Library library : libraryService.getAllLibraries()) {
            if (library.getId() == libraryId) {
                library.getBooks().add(book);
                return book;
            }
        }

        return null;
    }

    @Override
    public List<Book> getAllBooks(long libraryId) {
        for (Library library : libraryService.getAllLibraries()) {
            if (library.getId() == libraryId) {
                return library.getBooks();
            }
        }
        return null;
    }

    @Override
    public Book getBookDById(long libraryId, long bookId) {
        for (Library library : libraryService.getAllLibraries()) {
            if (library.getId() == libraryId) {
                for (Book book : getAllBooks(libraryId)) {
                    if (book.getId() == bookId) {
                        return book;
                    }
                }
                return null;
            }
        }
        return null;
    }

    @Override
    public String deleteBook(long libraryId, long bookId) {
        for (Library library : libraryService.getAllLibraries()) {
            if (library.getId() == libraryId) {
                for (Book book : getAllBooks(libraryId)) {
                    if (book.getId() == bookId) {
                        library.getBooks().remove(book);
                       return  "Книга успешно удалена!";
                    }
                }
            }
        }
        return null;
    }

    @Override
    public void clearBooksByLibrary(long libraryId) {
        for (Library library: libraryService.getAllLibraries()){
            if (library.getId()==libraryId){
                library.getBooks().clear();
                System.out.println(getAllBooks(libraryId));
            }
        }
    }
}
