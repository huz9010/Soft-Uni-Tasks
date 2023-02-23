package football_team_generator;

import java.util.ArrayList;
import java.util.List;

public class Team {

    private String name;
    private List<Player> players;

    public Team(String name) {
        setName(name);
        players = new ArrayList<>();
    }

    public void addPlayer(Player player)   {
        players.add(player);
    }

    public void removePlayer(String name)   {
        boolean isRemoved = players.removeIf(p -> p.getName().equals(name));
        if (!isRemoved) {
            throw new IllegalArgumentException(String.format("Player %s is not in %s team.", name, this.name));
        }
    }

    public double getRating()   {
        return players.stream().mapToDouble(Player::overallSkillLevel).average().orElse(0);
    }

    private void setName(String name) {
        if (name.trim().isEmpty())  {
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
