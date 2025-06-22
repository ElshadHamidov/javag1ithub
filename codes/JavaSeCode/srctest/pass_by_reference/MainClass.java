package pass_by_reference;

public class MainClass {
    public static void main(String[] args) {
        Person p = new Person("Elşad", "Həmidov", 4, "+994703451766");
        SalaryCalculator calc = new SalaryCalculator();
        calc.calculateSalary(p);
        p.printInfo();
    }
}
