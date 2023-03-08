package magicGame.models.magics;

public class RedMagic extends MagicImpl {

    public RedMagic(String name, int bulletsCount) {
        super(name, bulletsCount);
    }

    int bullets = getBulletsCount();

    @Override
    public int fire() {
        if (bullets >= 1) {
            bullets -= 1;
            return 1;
        }
        return 0;
    }
}
