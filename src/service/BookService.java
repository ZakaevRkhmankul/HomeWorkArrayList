package service;

import models.Book;

import java.util.List;

public interface BookService {

    Book saveBook(long libraryId,Book book);

    List<Book>getAllBooks(long libraryId);

    Book getBookDById(long libraryId, long bookId);

    String deleteBook(long LibraryId,long bookId);

    void clearBooksByLibrary(long libraryId);
}
