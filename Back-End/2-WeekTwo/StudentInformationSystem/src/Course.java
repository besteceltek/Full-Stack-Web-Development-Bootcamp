public class Course {
    String name, code, prefix;
    int grade, perfGrade;
    Teacher courseTeacher;

    public Course(String name, String code, String prefix) {
        this.name = name;
        this.code = code;
        this.prefix = prefix;
        this.grade = 0;
        this.perfGrade = 0;
    }
    public void addTeacher(Teacher teacher) {
        if(this.prefix.equals(teacher.branch)) {
            this.courseTeacher = teacher;
            System.out.println("Operation Successful");
        }
        else {
            System.out.println(teacher.name + " cannot give this class.");
        }
    }

    public void printTeacher() {
        if (courseTeacher != null) {
            System.out.println("The teacher of the class " + this.name + " is " + courseTeacher.name);
        }
        else {
            System.out.println("A teacher is not assigned to the class " + this.name);
        }
    }
}
