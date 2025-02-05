package classes;

public class ClassandObject {

    public static void main(String[] args) {
        Book bookFirst = new Book();
        bookFirst.id = 1;
        bookFirst.name = "Chronicles Of Narnia: The Magician’s Nephew";
        bookFirst.author = "C.S.Lewis";
        bookFirst.pageCount = 224;
        bookFirst.description = "The book provides a mythic explanation for the world of Narnia, similar to creation myths in other cultures.";
        Book bookSecond = new Book();
        bookSecond.id = 2;
        bookSecond.name = "Chronicles Of Narnia: The Lion, the Witch and the Wardrobe";
        bookSecond.author = "C.S.Lewis";
        bookSecond.pageCount = 208;
        bookSecond.description = "The central struggle between Aslan, who represents good, and the White Witch, who embodies evil, is a key theme throughout the novel.";
        System.out.println("Book 1:");
        System.out.println("ID: " + bookFirst.id);
        System.out.println("Name: " + bookFirst.name);
        System.out.println("Author: " + bookFirst.author);
        System.out.println("Page Count: " + bookFirst.pageCount);
        System.out.println("Description: " + bookFirst.description);
        System.out.println("Book 2:");
        System.out.println("ID: " + bookSecond.id);
        System.out.println("Name: " + bookSecond.name);
        System.out.println("Author: " + bookSecond.author);
        System.out.println("Page Count: " + bookSecond.pageCount);
        System.out.println("Description: " + bookSecond.description);
    }
}
