package magicGame.models.magics;

import static magicGame.common.ExceptionMessages.*;

public abstract class MagicImpl implements Magic {

    private String name;
    private int bulletsCount;

    protected MagicImpl(String name, int bulletsCount) {
        setName(name);
        setBulletsCount(bulletsCount);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getBulletsCount() {
        return this.bulletsCount;
    }

    protected void setName(String name) {
        if (name.isEmpty() || name.equals(" ")) {
            throw new NullPointerException(INVALID_MAGIC_NAME);
        }
        this.name = name;
    }

    protected void setBulletsCount(int bulletsCount) {
        if (bulletsCount < 0)    {
            throw new IllegalArgumentException(INVALID_MAGIC_BULLETS_COUNT);
        }
        this.bulletsCount = bulletsCount;
    }
}
