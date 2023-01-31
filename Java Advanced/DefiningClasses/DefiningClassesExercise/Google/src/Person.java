import java.util.LinkedHashSet;

public class Person {

    private String name;
    private Company company;
    private Car car;
    private LinkedHashSet<Parent> parents = new LinkedHashSet<>();
    private LinkedHashSet<Child> children = new LinkedHashSet<>();
    private LinkedHashSet<Pokemon> pokemons = new LinkedHashSet<>();

    public Person(String name) {
        this.name = name;
    }

//GeorgeJohnson
//Company:
//JeleInc Jelior 777.77
//Car:
//AudiA4 180
//Pokemon:
//Onyx Rock
//Charizard Fire
//Parents:
//SaraJohnson 13/03/1933
//Children:
//SamJohnson 01/01/2001

    public void printPerson()    {
        System.out.printf("%s%nCompany:%n", this.name);

        if (company != null)  {
            System.out.printf("%s %s %.2f%n", this.company.getName(), this.company.getDepartment(), this.company.getSalary());
        }
        System.out.println("Car:");

        if (car != null)    {
            System.out.printf("%s %d%n", this.car.getModel(), this.car.getSpeed());
        }
        System.out.println("Pokemon:");

        if (!pokemons.isEmpty())    {
            pokemons.forEach(pokemon -> System.out.printf("%s", pokemon.toString()));
        }
        System.out.println("Parents:");

        if (!parents.isEmpty()) {
            parents.forEach(parent -> System.out.printf("%s", parent.toString()));
        }

        System.out.println("Children:");

        if (!parents.isEmpty()) {
            children.forEach(child -> System.out.printf("%s", child.toString()));
        }
    }


    public void setCompany(String name, String department, double salary) {
        this.company = new Company(name, department, salary);
    }


    public void setCar(String model, int speed) {
        this.car = new Car(model, speed);
    }

    public void setParents(String name, String birthday) {
        this.parents.add(new Parent(name, birthday));
    }


    public void setChildren(String name, String birthday) {
        this.children.add(new Child(name, birthday));
    }

    public void setPokemons(String name, String type) {
        this.pokemons.add(new Pokemon(name, type));
    }
}
