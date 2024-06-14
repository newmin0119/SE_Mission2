package Books;

/**
 * The {@code Book} class represents a book with an id, title, author, and year of publication.
 * It provides methods to retrieve the book's id and a formatted string with the book's information.
 * <p>
 * Instances of this class are immutable cause there is no update method of this class.
 * Try delete and re-create data object when you want to change information.
 * </p>
 *
 * <pre>
 * Example usage:
 * {@code
 * Book book = new Book(1, "software Engineer", "sangHyeok", 2010);
 * System.out.println(book.getInfoStr());
 * }
 * </pre>
 *
 * @author 이상혁
 */
public class Book{
    private final int id;
    private final String title;
    private final String author;
    private final int year;

    /**
     * Constructs a new {@code Book} with the specified id, title, author, and year of publication.
     *
     * @param id     the unique identifier of the book
     * @param title  the title of the book
     * @param author the author of the book
     * @param year   the year the book was published
     */
    public Book(int id, String title, String author, int year) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
    }

    /**
     * return the unique identifier of the book
     * @return id of the book
     */
    public int getId() {
        return id;
    }

    /**
     * Returns a formatted string containing the book's information.
     *
     * @return a string representation of the book's information in the format
     *         "Book{id: '%d', 제목: '%s', 저자: '%s', 출판년도: %d}"
     */
    public String getInfoStr() {
        return String.format(
                "Book{id: '%d', 제목: '%s', 저자: '%s', 출판년도: %d}",
                id, title, author, year);
    }


}