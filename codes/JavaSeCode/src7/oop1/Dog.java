package oop1;

public class Dog extends Animal {
    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }
    @Override
    public void makeNoise() {
        System.out.println(name + ": Noise!");
    }
}
