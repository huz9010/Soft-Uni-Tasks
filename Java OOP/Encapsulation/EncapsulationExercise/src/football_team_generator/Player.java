package football_team_generator;

public class Player {

    private String name;
    private int endurance;
    private int sprint;
    private int dribble;
    private int passing;
    private int shooting;

    public Player(String name, int endurance, int sprint, int dribble, int passing, int shooting) {
        setName(name);
        setEndurance(endurance);
        setSprint(sprint);
        setDribble(dribble);
        setPassing(passing);
        setShooting(shooting);
    }

    public double overallSkillLevel()   {
        return (endurance + sprint + dribble + passing + shooting) / 5.0;
    }

    private boolean isStatValid(int stat)   {
        return stat >=0 && stat <= 100;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.trim().isEmpty())  {
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }

    private void setEndurance(int endurance) {
        if (!isStatValid(endurance)) {
            throw new IllegalArgumentException("Endurance should be between 0 and 100.");
        }
        this.endurance = endurance;
    }

    private void setSprint(int sprint) {
        if (!isStatValid(sprint)) {
            throw new IllegalArgumentException("Sprint should be between 0 and 100.");
        }
        this.sprint = sprint;
    }

    private void setDribble(int dribble) {
        if (!isStatValid(dribble)) {
            throw new IllegalArgumentException("Dribble should be between 0 and 100.");
        }
        this.dribble = dribble;
    }

    private void setPassing(int passing) {
        if (!isStatValid(passing)) {
            throw new IllegalArgumentException("Passing should be between 0 and 100.");
        }
        this.passing = passing;
    }

    private void setShooting(int shooting) {
        if (!isStatValid(shooting)) {
            throw new IllegalArgumentException("Shooting should be between 0 and 100.");
        }
        this.shooting = shooting;
    }
}
