package christmasPastryShop.entities.booths;

import christmasPastryShop.entities.booths.interfaces.Booth;
import christmasPastryShop.entities.cocktails.interfaces.Cocktail;
import christmasPastryShop.entities.delicacies.interfaces.Delicacy;
import java.util.ArrayList;
import java.util.Collection;

import static christmasPastryShop.common.ExceptionMessages.*;

public abstract class BaseBooth implements Booth {

    private Collection<Delicacy> delicacyOrders;
    private Collection<Cocktail> cocktailOrders;
    private int boothNumber;
    private int capacity;
    private int numberOfPeople;
    private double pricePerPerson;
    private boolean isReserved;
    private double price;

    public BaseBooth(int boothNumber, int capacity, double pricePerPerson) {
        delicacyOrders = new ArrayList<>();
        cocktailOrders = new ArrayList<>();
        setBoothNumber(boothNumber);
        setCapacity(capacity);
        setPricePerPerson(pricePerPerson);
        this.numberOfPeople = 0;
        this.price = 0;
        this.isReserved = false;
    }

    public BaseBooth(int boothNumber, int capacity) {
        delicacyOrders = new ArrayList<>();
        cocktailOrders = new ArrayList<>();
        setBoothNumber(boothNumber);
        setCapacity(capacity);
        this.numberOfPeople = 0;
        this.price = 0;
        this.isReserved = false;
    }

    @Override
    public void reserve(int numberOfPeople) {
        if (numberOfPeople <= 0)    {
            throw new IllegalArgumentException(INVALID_NUMBER_OF_PEOPLE);
        }
        this.numberOfPeople = numberOfPeople;
        this.price = this.numberOfPeople * this.pricePerPerson;
        isReserved = true;
    }

    @Override
    public double getBill() {
        double bill = 0;
        bill += cocktailOrders.stream().mapToDouble(Cocktail::getPrice).sum();
        bill += delicacyOrders.stream().mapToDouble(Delicacy::getPrice).sum();
        bill += getPrice();

        return bill;
    }

    @Override
    public void clear() {
        cocktailOrders.clear();
        delicacyOrders.clear();
        setNumberOfPeople(0);
        setPrice(0);
        isReserved = false;
    }

    public void setBoothNumber(int boothNumber) {

        this.boothNumber = boothNumber;
    }

    public void setCapacity(int capacity) {
        if (capacity < 0)   {
            throw new IllegalArgumentException(INVALID_TABLE_CAPACITY);
        }
        this.capacity = capacity;
    }

    public void setPricePerPerson(double pricePerPerson) {
        this.pricePerPerson = pricePerPerson;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public int getBoothNumber() {
        return this.boothNumber;
    }

    @Override
    public int getCapacity() {
        return this.capacity;
    }

    @Override
    public boolean isReserved() {
        return this.isReserved;
    }

    @Override
    public double getPrice() {
        return this.price;
    }
}
