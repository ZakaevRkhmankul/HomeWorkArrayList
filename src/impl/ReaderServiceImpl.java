package impl;

import database.Database;
import models.Library;
import models.Reader;
import service.LibraryService;
import service.ReaderService;

import java.util.List;

public class ReaderServiceImpl implements ReaderService {
   private final LibraryService libraryService;

    public ReaderServiceImpl(LibraryService libraryService) {
        this.libraryService = libraryService;
    }


    @Override
    public void saveReader(Reader reader) {
        System.out.println(Database.readers.add(reader));
    }

    @Override
    public List<Reader> getAllReaders() {
        return Database.readers;
    }

    @Override
    public Reader getReaderById(Long id) {
        for (Reader reader: Database.readers){
            if (reader.getId()==id){
                return reader;
            }
        }
        return null;
    }

    @Override
    public Reader updateReader(Long id, Reader newReader) {
        for (Reader reader: Database.readers){
            if (reader.getId()==id){
                reader.setFullName(newReader.getFullName());
                return newReader;
            }
        }
        return null;
    }

    @Override
    public void assignReaderToLibrary(Long readerId, Long libraryId) {
        for (Library library: libraryService.getAllLibraries()){
            if (library.getId()==libraryId){
                for (Reader reader: Database.readers){
                    if (reader.getId()==readerId){
                        System.out.println(library.getReaders().add(reader));
                    }
                }
            }
        }
    }
}
