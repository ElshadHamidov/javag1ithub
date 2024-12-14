package oop1;

public class Main {
    public static void main(String[] args) {
        Animal myCat = new Cat("Tom", 3);
        myCat.makeNoise();
        Animal myDog = new Dog("Buddy", 5);
        myDog.makeNoise();
        Animal myLion = new Lion("Alex", 7);
        myLion.makeNoise();
    }
}
