public class Student {
    String name, stuNo;
    int classes;
    double average;
    boolean isPass;
    Course math, phys, chem;

    Student(String name, int classes, String stuNo, Course math,Course phys,Course chem) {
        this.name = name;
        this.classes = classes;
        this.stuNo = stuNo;
        this.math = math;
        this.phys = phys;
        this.chem = chem;
        calcAvarage();
        this.isPass = false;
    }

    public void addBulkExamNote(int math, int phys, int chem, int mathPerf, int physPerf, int chemPerf) {
        if (math >= 0 && math <= 100) {
            this.math.grade = math;
        }
        if (phys >= 0 && phys <= 100) {
            this.phys.grade = phys;
        }
        if (chem >= 0 && chem <= 100) {
            this.chem.grade = chem;
        }
        if (mathPerf >= 0 && mathPerf <= 100) {
            this.math.perfGrade = mathPerf;
        }
        if (physPerf >= 0 && physPerf <= 100) {
            this.phys.perfGrade = physPerf;
        }
        if (chemPerf >= 0 && chemPerf <= 100) {
            this.chem.perfGrade = chemPerf;
        }
    }
    public void isPass () {
        if (this.math.grade == 0 || this.phys.grade == 0 || this.chem.grade == 0) {
            System.out.println("Notes are not entered yet.");
        }
        else {
            this.isPass = isCheckPass();
            printNote();
            System.out.println("Average: " + this.average);
            if (this.isPass) {
                System.out.println("Class Passed.");
            }
            else {
                System.out.println("Class Failed.");
            }
        }
    }
    public boolean isCheckPass() {
        calcAvarage();
        return this.average > 55;
    }

    public void calcAvarage() {
        double physAvg = (this.phys.grade * 0.80) + (this.phys.perfGrade * 0.20);
        double mathAvg = (this.math.grade * 0.80) + (this.math.perfGrade * 0.20);
        double chemAvg = (this.chem.grade * 0.80) + (this.chem.perfGrade * 0.20);
        this.average = (physAvg + mathAvg + chemAvg) / 3;
    }
    public void printNote() {
        System.out.println("=========================");
        System.out.println("Student : " + this.name);
        System.out.println("Mathematics Note : " + this.math.grade);
        System.out.println("Mathematics Performance Note : " + this.math.perfGrade);
        System.out.println("Physics Note : " + this.phys.grade);
        System.out.println("Physics Performance Note : " + this.phys.perfGrade);
        System.out.println("Chemistry Note : " + this.chem.grade);
        System.out.println("Chemistry Performance Note : " + this.chem.perfGrade);
    }
}
