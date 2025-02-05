package accesModifiers.other;

import accesModifiers.Book;

public class MainClass {
    public static void main(String[] args) {
        Book book = new Book("Java Programming", "John Doe", "Tech Publishers", 350);
        book.title = "Advanced Java";
        book.setPageCount(500);

        System.out.println("Title: " + book.title);
        System.out.println("Page Count: " + book.getPageCount());
    }
}
