package lesson9;

public class SalaryCalculator {
    public void calculateSalary(Person person) {
        int experience = person.getExperienceYear();
        double calculatedSalary = 0;

        if (experience == 1) {
            calculatedSalary = 500;
        } else if (experience == 2) {
            calculatedSalary = 1000;
        } else if (experience == 3) {
            calculatedSalary = 1500;
        } else if (experience > 3) {
            calculatedSalary = 1500 + (experience - 3) * 500;
        }

        person.setSalary(calculatedSalary);
    }
}
