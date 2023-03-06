package military_elite;

import java.util.ArrayList;
import java.util.List;

public class LieutenantGeneral extends Private  {

    private List<Private> privates;

    public LieutenantGeneral(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName, salary);
        this.privates = new ArrayList<>();
    }


    public void addPrivate(Private priv)    {
        privates.add(priv);
    }

    @Override
    public String toString()    {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Name: %s %s Id: %d Salary: %.2f%n" +
                "Privates:%n", super.getFirstName(), super.getLastName(), super.getId(), super.getSalary()));
        privates.stream().sorted((e1, e2) -> Integer.compare(e2.getId(), e1.getId()))
                .forEach(e -> sb.append("  ").append(e));
        return sb.toString();
    }
}
