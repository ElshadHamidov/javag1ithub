package animal;

abstract class Animal {
    String name;
    int age;

    public abstract void makeNoise();
}

class Cat extends Animal {
    public void makeNoise() {
        System.out.println("Meow");
    }
}

class Dog extends Animal {
    public void makeNoise() {
        System.out.println("Woof");
    }
}

class Lion extends Animal {
    public void makeNoise() {
        System.out.println("Roar");
    }
}

public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.makeNoise();

        Dog dog = new Dog();
        dog.makeNoise();

        Lion lion = new Lion();
        lion.makeNoise();
    }
}
