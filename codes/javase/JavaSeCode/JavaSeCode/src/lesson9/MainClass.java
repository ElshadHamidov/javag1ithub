package lesson9;

public class MainClass {
    public static void main(String[] args) {
        Person person = new Person();
        person.setName("Əli");
        person.setSurname("Mehdiyev");
        person.setExperienceYear(4);
        person.setPhone("0123456789");

        SalaryCalculator salaryCalculator = new SalaryCalculator();
        salaryCalculator.calculateSalary(person);

        person.printInfo();
        Circle myCircle = new Circle(5.0);

        Calculator calculator = new Calculator();
        calculator.calculateCircleLength(myCircle);

        System.out.println("Circle uzunluğu: " + myCircle.length);
    }
}
