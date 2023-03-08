package magicGame.models.magicians;

import magicGame.models.magics.Magic;

import static magicGame.common.ExceptionMessages.*;

public abstract class MagicianImpl implements Magician {

    private String username;
    private int health;
    private int protection;
    private boolean isAlive;
    private Magic magic;

    protected MagicianImpl(String username, int health, int protection, Magic magic) {
        setUsername(username);
        setHealth(health);
        setProtection(protection);
        setAlive();
        setMagic(magic);
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public int getHealth() {
        return this.health;
    };

    @Override
    public int getProtection() {
        return this.health;
    };

    @Override
       public Magic getMagic() {
        return this.magic;
    };

    @Override
    public boolean isAlive() {
        return this.isAlive;
    };

    @Override
    public void takeDamage(int points) {
        this.protection -= points;
        if (this.protection < 0){
            health += this.protection;
        }
        if (health <= 0)    {
            health = 0;
            protection = 0;
            isAlive = false;
        }
    }

    @Override
    public String toString()    {
        return String.format("%s: %s%n" +
                        "Health: %d%n" +
                        "Protection: %d%n" +
                        "Magic: %s%n", getClass().getSimpleName(), getUsername(),
                getHealth(), getProtection(), getMagic().getName());
    }

    public void setUsername(String username) {
        if (username.isEmpty() || username.equals(" ")) {
            throw new NullPointerException(INVALID_MAGICIAN_NAME);
        }
        this.username = username;
    }

    protected void setHealth(int health) {
        if (health < 0) {
            throw new IllegalArgumentException(INVALID_MAGICIAN_HEALTH);
        }
        this.health = health;
    }

    public void setAlive() {
        this.isAlive = health > 0;
    }

    protected void setProtection(int protection) {
        if (protection < 0) {
            throw new IllegalArgumentException(INVALID_MAGICIAN_PROTECTION);
        }
        this.protection = protection;
    }

    protected void setMagic(Magic magic) {
        if (magic == null)  {
            throw new NullPointerException(INVALID_MAGIC);
        }
        this.magic = magic;
    }
}
