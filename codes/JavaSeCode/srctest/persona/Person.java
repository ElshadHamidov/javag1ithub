package persona;

public class Person {
    public String name;
    private int age;
    protected String profession;
    String city;

    public static int staticId = 100;

    public Person() {
        this.name = "Unknown";
    }

    private Person(String name) {
        this.name = name;
    }

    protected Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    Person(String name, int age, String profession) {
        this.name = name;
        this.age = age;
        this.profession = profession;
    }

    public void publicMethod() {
        System.out.println("This is a public method.");
    }

    protected void protectedMethod() {
        System.out.println("This is a protected method.");
    }

    void defaultMethod() {
        System.out.println("This is a default access method.");
    }

    private void privateMethod() {
        System.out.println("This is a private method.");
    }

    public void callProtectedMethod() {
        protectedMethod();
    }

    public void callDefaultMethod() {
        defaultMethod();
    }

    public void callPrivateMethod() {
        privateMethod();
    }

    public void printFinalValue(final String value) {
        System.out.println("Final parameter: " + value);
    }
}