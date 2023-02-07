package PetClinics;

public class Pet {

    private String name;
    private int age;
    private String kind;

    public Pet(String name, int age, String king) {
        this.name = name;
        this.age = age;
        this.kind = kind;
    }

    public String toString()    {
        return String.format("%s %d %s", this.name, this.age, this.kind);
    }
}
