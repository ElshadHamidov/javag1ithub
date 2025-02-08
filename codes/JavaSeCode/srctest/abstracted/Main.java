package abstracted;

public class Main {
    public static void main(String[] args) {
        Instrument piano = new Piano();
        Instrument guitar = new Guitar();
        Instrument drum = new Drum();

        piano.play();
        System.out.println("Material: " + piano.getMaterial());

        guitar.play();
        System.out.println("Material: " + guitar.getMaterial());

        drum.play();
        System.out.println("Material: " + drum.getMaterial());
    }
}