package lesson9;

public class Person {
    private String name;
    private String surname;
    private int experienceYear;
    private double salary;
    private String phone;

    public Person() {
    }

    public Person(String name, String surname, int experienceYear, String phone) {
        this.name = name;
        this.surname = surname;
        this.experienceYear = experienceYear;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getExperienceYear() {
        return experienceYear;
    }

    public void setExperienceYear(int experienceYear) {
        this.experienceYear = experienceYear;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void printInfo() {
        System.out.println("Ad: " + name);
        System.out.println("Soyad: " + surname);
        System.out.println("İş Təcrübəsi: " + experienceYear + " il");
        System.out.println("Maaş: " + salary + " AZN");
        System.out.println("Telefon: " + phone);
    }
}
