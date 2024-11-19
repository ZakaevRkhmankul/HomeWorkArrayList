package models;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private long id;
    private String name;
    private String address;
    private List<Book> books= new ArrayList<>();
    private List<Reader>readers= new ArrayList<>();

    public Library(){

    }

    public Library(long id, String name) {
        this.id = id;
        this.name = name;

    }

    public Library(long id, String name, String address, List<Book>books, List<Reader>readers){
        this.id = id;
        this.name = name;
        this.address = address;
        this.books = books;
        this.readers = readers;
    }

    public long getId(){
        return id;
    }

    public void setId(long id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getAddress(){
        return address;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public List<Book> getBooks(){
        return books;
    }

    public void setBooks(List<Book>books){
        this.books = books;
    }

    public List<Reader> getReaders(){
        return readers;
    }

    public void setReaders(List<Reader>readers){
        this.readers = readers;
    }

    @Override
    public String toString() {
        return "\nLibrary{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", books=" + books +
                ", readers=" + readers +
                '}';
    }
}

