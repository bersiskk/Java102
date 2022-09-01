public class Book implements Comparable<Book> {
    private String name;
    private int pageCount;
    private String author;
    private int releaseYear;

    public Book(String name, int pageCount, String author, int releaseYear) {
        this.name = name;
        this.pageCount = pageCount;
        this.author = author;
        this.releaseYear = releaseYear;
    }

    @Override
    public int compareTo(Book o) {
        return getName().compareTo(o.getName());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

}
