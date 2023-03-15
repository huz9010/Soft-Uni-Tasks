package fairyShop.models;

public class Sleepy extends BaseHelper {

    private static final int INITIAL_ENERGY = 50;

    public Sleepy(String name) {
        super(name, INITIAL_ENERGY);
    }

    @Override
    public void work()  {
        super.work();
        int additionalEnergyDecrease = 5;
        setEnergy(Math.max(0, getEnergy() - additionalEnergyDecrease));
    }

}
