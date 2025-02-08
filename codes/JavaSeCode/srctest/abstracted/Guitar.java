package abstracted;

public class Guitar extends Instrument {
    @Override
    void play() {
        System.out.println("Guitar is playing: Strum Strum");
    }
    
    @Override
    String getMaterial() {
        return "Wood and Nylon";
    }
}

