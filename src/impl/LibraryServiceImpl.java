package impl;

import database.Database;
import models.Library;
import service.LibraryService;

import java.util.List;

public class LibraryServiceImpl implements LibraryService {


    @Override
    public List<Library> saveLibrary(List<Library> libraries) {
        Database.libraries.addAll(libraries);
        return Database.libraries;
    }

    @Override
    public List<Library> getAllLibraries() {
        return Database.libraries;
    }

    @Override
    public Library getLibraryById(Long id) {
        for (Library library : Database.libraries)
            if (library.getId() == id) {
                return library;
            }
        return null;
    }

    @Override
    public Library updateLibrary(Long id, Library newLibrary) {
        for (Library library : Database.libraries) {
            if (library.getId() == id) {
                library.setName(newLibrary.getName());
                library.setAddress(newLibrary.getAddress());

                return newLibrary;
            }
        }
        return null;
    }

    @Override
    public String deleteLibrary(Long id) {
        for (Library library : Database.libraries) {
            if (library.getId() == id) {
                Database.libraries.remove(library);
                return "Soccesfully deleted!";
            }
        }
        return "Library wish id:" + id + "not found!";
    }
}
