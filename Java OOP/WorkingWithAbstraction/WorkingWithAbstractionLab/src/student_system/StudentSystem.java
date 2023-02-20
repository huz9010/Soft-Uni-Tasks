package student_system;

import java.util.HashMap;
import java.util.Map;

public class StudentSystem {
    private Map<String, Student> repo;

    public StudentSystem()
    {
        this.repo = new HashMap<>();
    }

    public void ParseCommand(String[]args)
    {
        String command = args[0];
        if (command.equals("Create"))
        {
            String name = args[1];
            int age = Integer.parseInt(args[2]);
            double grade =Double.parseDouble(args[3]);

            createStudent(name, age, grade);
        }
        else if (command.equals("Show"))
        {
            String name = args[1];
            if (repo.containsKey(name)) {
                printStudent(name);
            }
        }
    }

    private void createStudent(String name, int age, double grade)  {
        if (!repo.containsKey(name))    {
            repo.put(name, new Student(name, age, grade));
        }
    }

    private void printStudent(String name)  {
            System.out.println(repo.get(name));
    }
}
