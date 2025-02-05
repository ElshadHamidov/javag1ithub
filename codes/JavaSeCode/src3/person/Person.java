package person;

public class Person {
    public String name;
    protected int age;
    String profession;
    private double salary;

    public Person(String name, int age, String profession, double salary) {
        this.name = name;
        this.age = age;
        this.profession = profession;
        this.salary = salary;
    }

    protected Person(String name) {
        this.name = name;
    }

    Person(int age, String profession) {
        this.age = age;
        this.profession = profession;
    }

    private Person() {
        this.name = "Unknown";
    }

    public void showDetails() {
        System.out.println("Name: " + name + ", Age: " + age + ", Profession: " + profession + ", Salary: " + salary);
    }

    protected void updateAge(int age) {
        this.age = age;
    }

    void changeProfession(String newProfession) {
        this.profession = newProfession;
    }

    private void setSalary(double salary) {
        this.salary = salary;
    }

    public void calculateSalary(final double baseSalary) {
        double total = baseSalary + salary;
        System.out.println("Total Salary: " + total);
    }

    public static int employeeCount = 0;
}
