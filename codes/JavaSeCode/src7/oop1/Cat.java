package oop1;

public class Cat extends Animal {
    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }
    @Override
    public void makeNoise() {
        System.out.println(name + ": Noise!");
    }
}
