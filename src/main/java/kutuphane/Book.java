package kutuphane;

public class Book {

    String bookName;
    String writerName;
    Integer releaseYear;
    long price;

    public Book(String bookName, String writerName, int releaseYear, long price) {
        this.bookName = bookName;
        this.writerName = writerName;
        this.releaseYear = releaseYear;
        this.price = price;
    }

    @Override
    public String toString() {
        return "information: {" +
                "bookName='" + bookName + '\'' +
                ", writerName='" + writerName + '\'' +
                ", releaseYear=" + releaseYear +
                ", price=" + price +
                '}';
    }
}
