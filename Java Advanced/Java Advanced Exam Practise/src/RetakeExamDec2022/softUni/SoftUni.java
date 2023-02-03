package RetakeExamDec2022.softUni;

import java.util.ArrayList;
import java.util.List;

public class SoftUni {

    private int capacity;
    private List<Student> data;

    public SoftUni(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public int getCount() {
        return this.data.size();
    }

    public String insert(Student student)   {
        if (getCount() + 1 > this.capacity)    {
            return "The hall is full.";
        } else {
            if (this.data.contains(student)) {
                return "Student is already in the hall.";
            }   else {
                this.data.add(student);
                return String.format("Added student %s %s.", student.getFirstName(), student.getLastName());
            }
        }
    }

    public String remove(Student student) {
            if(this.data.contains(student)){
                this.data.remove(student);
                return String.format("Removed student %s %s.", student.getFirstName(), student.getLastName());
        }
        return "Student not found.";
    }

    public Student getStudent(String firstName, String lastName)  {
        for (Student s : this.data) {
            if (s.getFirstName().equals(firstName) && s.getLastName().equals(lastName)) {
                return s;
            }
        }
        return null;
    }

    public String getStatistics()   {
        StringBuilder sb = new StringBuilder();
        sb.append("Hall size: ").append(getCount()).append(System.lineSeparator());
        this.data.forEach(student -> sb.append(student.toString()).append(System.lineSeparator()));
        return sb.toString();
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Student> getData() {
        return data;
    }

    public void setData(List<Student> data) {
        this.data = data;
    }
}
