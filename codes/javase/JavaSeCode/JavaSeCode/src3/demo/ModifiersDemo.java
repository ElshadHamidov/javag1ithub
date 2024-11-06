package demo;

import person.Person;

public class ModifiersDemo {
    public static void main(String[] args) {
        Person person1 = new Person("Bob", 25, "Engineer", 1500);
        Person person2 = new Person("Bob", 25, "Engineer", 1500);
        Person person3 = new Person("Bob", 25, "Engineer", 1500);
        Person person4 = new Person("Bob", 25, "Engineer", 1500);

        System.out.println("Public variable: " + person1.name);
        person1.showDetails();
        person1.calculateSalary(1000);
        System.out.println("Public variable: " + person2.name);
        person2.showDetails();
        person2.calculateSalary(1000);
        System.out.println("Public variable: " + person3.name);
        person3.showDetails();
        person3.calculateSalary(1000);
        System.out.println("Public variable: " + person4.name);
        person4.showDetails();
        person4.calculateSalary(1000);
    }
}
