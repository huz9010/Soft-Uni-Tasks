import java.util.LinkedHashSet;

public class Person {

    private String name;
    private String birthday;
    private LinkedHashSet<Person> parents = new LinkedHashSet<>();
    private LinkedHashSet<Person> children = new LinkedHashSet<>();


    public Person(String data) {
        if (Character.isDigit(data.charAt(0)))  {
            this.birthday = data;
        }   else {
            this.name = name;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}
