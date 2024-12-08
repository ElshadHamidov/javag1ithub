package abstracted;

public class Piano extends Instrument {
    @Override
    void play() {
        System.out.println("Piano is playing: Do Re Mi");
    }

    @Override
    String getMaterial() {
        return "Wood and Steel";
    }
}
