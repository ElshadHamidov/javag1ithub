package polymorphism;

public class ElectronicBook extends Book {
    private String format;
    private double fileSize;
    public ElectronicBook(String name, String author, String format, double fileSize) {
        super(name, author);
        this.format = format;
        this.fileSize = fileSize;
    }

    @Override
    public void showInfo() {
        super.showInfo(); 
        System.out.println("Format: " + format);
        System.out.println("File Size: " + fileSize + " MB");
    }
}
