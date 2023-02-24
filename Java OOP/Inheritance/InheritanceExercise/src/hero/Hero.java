package hero;

public class Hero {

    protected String username;
    protected int level;

    public Hero(String username, int level) {
        this.username = username;
        this.level = level;
    }

    @Override
    public String toString()    {
        return String.format("Type: %s Username: %s Level: %s", getClass().getName(), this.getUsername(), this.getLeve());
    }

    public String getUsername() {
        return username;
    }

    public int getLeve() {
        return level;
    }
}
