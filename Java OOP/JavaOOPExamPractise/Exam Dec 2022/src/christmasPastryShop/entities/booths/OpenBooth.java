package christmasPastryShop.entities.booths;

import christmasPastryShop.entities.booths.BaseBooth;

public class OpenBooth extends BaseBooth {

    public OpenBooth(int boothNumber, int capacity) {
        super(boothNumber, capacity);
        double pricePerPerson = 2.50;
        setPricePerPerson(pricePerPerson);
    }
}
