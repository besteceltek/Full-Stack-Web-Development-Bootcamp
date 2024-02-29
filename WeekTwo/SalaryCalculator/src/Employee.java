public class Employee {
    String name;
    int salary, workHours, hireYear;
    double tax;

    Employee(String name,int salary,int workHours,int hireYear) {
        this.name = name;
        this.salary = salary;
        this.workHours = workHours;
        this.hireYear = hireYear;
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

    void bonus() {

    }

    void raiseSalary() {

    }
    void printEmp() {
        System.out.println(this.name);
        System.out.println(this.salary);
        System.out.println(this.workHours);
        System.out.println(this.hireYear);
        System.out.println("Tax: " + tax());
    }
}
