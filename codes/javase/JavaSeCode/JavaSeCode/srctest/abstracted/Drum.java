package abstracted;

public class Drum extends Instrument {
    @Override
    void play() {
        System.out.println("Drum is playing: Boom Boom");
    }

    @Override
    String getMaterial() {
        return "Plastic and Leather";
    }
}
