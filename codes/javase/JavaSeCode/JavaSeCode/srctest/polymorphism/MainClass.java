package polymorphism;

public class MainClass {
    public static void main(String[] args) {
        Book book1 = new ElectronicBook("Java Programming", "James Gosling", "PDF", 2.5);
        Book book2 = new PhysicalBook("Sherlock Holmes", "Sir Arthur Conandoyle", 1.2, "A4");
        book1.showInfo();
        System.out.println();
        book2.showInfo();
    }
}
