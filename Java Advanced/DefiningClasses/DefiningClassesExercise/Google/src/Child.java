public class Child {

    private String name;
    private String birthday;


    public Child(String name, String birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    @Override
    public String toString()    {
        return String.format("%s %s%n", this.name, this.birthday);
    }
}
