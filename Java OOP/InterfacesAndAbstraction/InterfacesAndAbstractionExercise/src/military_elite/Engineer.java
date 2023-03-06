package military_elite;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Engineer extends SpecialisedSoldier implements EngineerInterface{

    private List<Repair> repairs;

    public Engineer(int id, String firstName, String lastName, double salary, String corps) {
        super(id, firstName, lastName, salary, corps);
        repairs = new ArrayList<>();
    }

    public void addRepair(Repair repair)    {
        repairs.add(repair);
    }

    public Collection<Repair> getRepairs()  {
        return this.repairs;
    }

    @Override
    public String toString()    {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Name: %s %s Id: %d Salary: %.2f%n" +
                "Corps: %s%n" +
                "Repairs:%n", super.getFirstName(), super.getLastName(), super.getId(), super.getSalary(), super.getCorps()));
        repairs.forEach(e -> sb.append("  ").append(e).append(System.lineSeparator()));
        return sb.toString();
    }
}
