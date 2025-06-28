package persona;

public class ModifiersDemo {
    public static void main(String[] args) {
        Person p1 = new Person();
        Person p2 = new Person("Alice");
        Person p3 = new Person("Bob", 25);
        Person p4 = new Person("Carol", 30, "Engineer");

        p1.publicMethod();
        p1.callProtectedMethod();
        p1.callDefaultMethod();
        p1.callPrivateMethod();

        p1.printFinalValue("Final example");

        System.out.println("Static ID: " + Person.staticId);
    }
}