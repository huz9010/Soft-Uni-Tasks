package student_system;

public class Student {
    private String name;
    private int age;
    private double grade;

    public Student(String name, int age, double grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    @Override
    public String toString()    {
        String commentary = "";
        if (this.grade >= 5.00) {
            commentary = Commentary.Excellent.getText();
        } else if (this.grade >= 3.50) {
            commentary = Commentary.Average.getText();
        }   else {
            commentary = Commentary.Nice.getText();
        }
        return String.format("%s is %d years old. %s.", this.name, this.age, commentary);
    }
}
