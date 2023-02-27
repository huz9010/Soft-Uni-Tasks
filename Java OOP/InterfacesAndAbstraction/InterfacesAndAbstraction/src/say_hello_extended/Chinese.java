package say_hello_extended;

public class Chinese extends BasePerson {

    private String name;

    public Chinese(String name) {
        super(name);
    }

    @Override
    public String sayHello() {
        return "Djydjybydjy";
    }
}
