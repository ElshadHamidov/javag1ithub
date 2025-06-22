package pass_by_reference;

public class SalaryCalculator {
    public void calculateSalary(Person person) {
        if (person.experienceYear <= 0) {
            person.salary = 0;
        } else {
            person.salary = 500 * person.experienceYear;
        }
    }
}
