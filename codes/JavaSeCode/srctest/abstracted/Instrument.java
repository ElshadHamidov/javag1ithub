package abstracted;

abstract class Instrument {
    abstract void play();

    String getMaterial() {
        return "Unknown material";
    }
}
