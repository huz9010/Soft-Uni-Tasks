package military_elite;

public class Spy extends Soldier implements SpyInterface  {

    private String codeNumber;

    public Spy(int id, String firstName, String lastName, String codeNumber) {
        super(id, firstName, lastName);
        this.codeNumber = codeNumber;
    }

    @Override
    public String getCodeNumber()   {
        return codeNumber;
    }

    @Override
    public String toString()   {
        return String.format("Name: %s %s Id: %d%nCode Number: %s%n",
                super.getFirstName(), super.getLastName(), super.getId(), codeNumber);
    }
}
