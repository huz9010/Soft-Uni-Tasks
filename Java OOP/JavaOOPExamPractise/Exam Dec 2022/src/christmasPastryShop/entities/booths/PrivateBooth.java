package christmasPastryShop.entities.booths;

import christmasPastryShop.entities.booths.BaseBooth;

public class PrivateBooth extends BaseBooth {

    public PrivateBooth(int boothNumber, int capacity) {
        super(boothNumber, capacity);
        double pricePerPerson = 3.50;
        setPricePerPerson(pricePerPerson);
    }
}
