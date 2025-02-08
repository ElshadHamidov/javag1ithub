package oop1;

public class Lion extends Animal {
    public Lion(String name, int age) {
        this.name = name;
        this.age = age;
    }
    @Override
    public void makeNoise() {
        System.out.println(name + ": Noise!");
    }
}
