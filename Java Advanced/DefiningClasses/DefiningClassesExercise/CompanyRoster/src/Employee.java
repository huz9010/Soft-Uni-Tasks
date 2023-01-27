public class Employee {

    private String name;
    private double salary;
    private String position;
    private String department;
    private String email = "n/a";
    private int age = -1;

    public Employee(String name, double salary, String position, String department, String email, int age) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
    }

    public Employee(String name, double salary, String position, String department, String email)   {
        this(name, salary, position, department, email, -1);
    }

    public Employee(String name, double salary, String position, String department, int age)   {
        this(name, salary, position, department, "n/a", age);
    }

    public Employee(String name, double salary, String position, String department)   {
        this(name, salary, position, department, "n/a", -1);
    }

    @Override
    public String toString(){
        return String.format("%s %.2f %s %d", this.name, this.salary, this.email, this.age);
    }

    public String getName(){
        return this.name;
    }

    public double getSalary() {
        return salary;
    }

    public String getPosition() {
        return position;
    }

    public String getDepartment() {
        return department;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
