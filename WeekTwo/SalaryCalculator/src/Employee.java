public class Employee {
    String name;
    int workHours, hireYear, bonus;
    double salary, tax, raise, taxSalary, totalSalary;

    Employee(String name,int salary,int workHours,int hireYear) {
        this.name = name;
        this.salary = salary;
        this.workHours = workHours;
        this.hireYear = hireYear;
        tax = tax();
        bonus = bonus();
        raise = raiseSalary();
        taxSalary = this.salary - tax + bonus;
        totalSalary = taxSalary + raise;
    }
    double tax() {
        if (this.salary < 1000) {
            tax = 0;
        }
        else {
            tax = this.salary * 0.03;
        }
        return tax;
    }

    int bonus() {
        if (this.workHours > 40) {
            bonus = (this.workHours - 40) * 30;
        } else {
            bonus = 0;
        }
        return bonus;
    }

    double raiseSalary() {
        double raise;
        if ((2024 - this.hireYear) < 10) {
            raise = this.salary * 0.05;
        } else if ((2024 - this.hireYear) > 9 && (2024 - this.hireYear) < 20) {
            raise = this.salary * 0.10;
        } else {
            raise = this.salary * 0.15;
        }
        return raise;
    }
    void printEmp() {
        System.out.println("Name: " + this.name);
        System.out.println("Salary: " + this.salary);
        System.out.println("Work Hours: " + this.workHours);
        System.out.println("Hire Year: " + this.hireYear);
        System.out.println("Tax: " + tax);
        System.out.println("Bonus: " + bonus);
        System.out.println("Raise: " + raise);
        System.out.println("Salary with the Tax and Bonus: " + taxSalary);
        System.out.println("Total Salary: " + totalSalary);
    }
}
