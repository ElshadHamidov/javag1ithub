package oop;

class Person {
    int id;
    String name;
    String surname;
    int age;
    String phone;
    String address;

    public void printInfo() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Surname: " + surname);
        System.out.println("Age: " + age);
        System.out.println("Phone: " + phone);
        System.out.println("Address: " + address);
    }
}

class Employee extends Person {
    double salary;
    String department;
    String username;
    String password;

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Salary: " + salary);
        System.out.println("Department: " + department);
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
    }
}

public class Main {
    public static void main(String[] args) {
        Employee emp = new Employee();
        emp.id = 1;
        emp.name = "Ali";
        emp.surname = "Quliyev";
        emp.age = 30;
        emp.phone = "0501234567";
        emp.address = "Bakı şəhəri";

        emp.salary = 1200.50;
        emp.department = "IT";
        emp.username = "aliq";
        emp.password = "12345";

        emp.printInfo();
    }
}
