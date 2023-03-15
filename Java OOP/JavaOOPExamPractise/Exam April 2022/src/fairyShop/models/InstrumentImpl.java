package fairyShop.models;

import static fairyShop.common.ExceptionMessages.INSTRUMENT_POWER_LESS_THAN_ZERO;

public class InstrumentImpl implements Instrument {

    private int power;

    public InstrumentImpl(int power) {
        setPower(power);
    }

    @Override
    public void use() {
        int powerDecreaseValue = 10;
        setPower(Math.max(0, this.power - powerDecreaseValue));
    }

    @Override
    public boolean isBroken() {
        return this.power == 0;
    }

    @Override
    public int getPower() {
        return this.power;
    }

    private void setPower(int power)    {
        if (power < 0)  {
            throw new IllegalArgumentException(INSTRUMENT_POWER_LESS_THAN_ZERO);
        }
        this.power = power;
    }
}
