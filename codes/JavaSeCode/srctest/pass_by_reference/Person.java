package pass_by_reference;

public class Person {
    String name;
    String surname;
    int experienceYear;
    double salary;
    String phone;

    public Person(String name, String surname, int experienceYear, String phone) {
        this.name = name;
        this.surname = surname;
        this.experienceYear = experienceYear;
        this.phone = phone;
        this.salary = 0;
    }

    public void printInfo() {
        System.out.println("Name: " + name);
        System.out.println("Surname: " + surname);
        System.out.println("Experience Year: " + experienceYear);
        System.out.println("Salary: " + salary);
        System.out.println("Phone: " + phone);
    }
}
