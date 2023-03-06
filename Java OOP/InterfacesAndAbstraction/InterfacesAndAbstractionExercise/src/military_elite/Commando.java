package military_elite;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Commando extends SpecialisedSoldier implements CommandoInterface   {

    private List<Mission> missions;

    public Commando(int id, String firstName, String lastName, double salary, String corps) {
        super(id, firstName, lastName, salary, corps);
        this.missions = new ArrayList<>();
    }

    public void addMission(Mission mission) {
        if (MissionState.contains(mission.getState())) {
            missions.add(mission);
        }
    }

    public Collection<Mission> getMissions()    {
        return missions;
    }

    @Override
    public String toString()    {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Name: %s %s Id: %d Salary: %.2f%n" +
                "Corps: %s%n" +
                "Missions:%n", super.getFirstName(), super.getLastName(), super.getId(), super.getSalary(), super.getCorps()));
        this.missions.forEach(e -> sb.append("  ").append(e));
        return sb.toString();
    }
}
