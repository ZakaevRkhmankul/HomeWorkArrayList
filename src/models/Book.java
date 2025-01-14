package models;

public class Book {
    private long id;
    private String name;
    private String author;
    private enums.Genre genre;

    public Book(){

    }


    public Book(long id, String name, String author, enums.Genre genre){
        this.id = id;
        this.name = name;
        this.author = author;
        this.genre = genre;
    }

    public long getId(){
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName (){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getAuthor(){
        return author;
    }

    public void setAuthor(String author){
        this.author = author;
    }

    public enums.Genre getGenre(){
        return genre;
    }

    public void setGenre(enums.Genre genre){
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "\nBook{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", genre=" + genre +
                '}';
    }
}
