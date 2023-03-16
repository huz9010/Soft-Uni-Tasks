package catHouse.core;

import catHouse.entities.cat.Cat;
import catHouse.entities.cat.LonghairCat;
import catHouse.entities.cat.ShorthairCat;
import catHouse.entities.houses.House;
import catHouse.entities.houses.LongHouse;
import catHouse.entities.houses.ShortHouse;
import catHouse.entities.toys.Ball;
import catHouse.entities.toys.Mouse;
import catHouse.entities.toys.Toy;
import catHouse.repositories.Repository;
import catHouse.repositories.ToyRepository;

import java.util.ArrayList;
import java.util.Collection;

import static catHouse.common.ConstantMessages.*;
import static catHouse.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {

    private Repository toys;
    private Collection<House> houses;

    public ControllerImpl() {
        this.toys = new ToyRepository();
        this.houses = new ArrayList<>();

    }

    @Override
    public String addHouse(String type, String name) {
        if (type.equals("ShortHouse"))  {
            this.houses.add(new ShortHouse(name));
        } else if (type.equals("LongHouse")) {
            this.houses.add(new LongHouse(name));
        } else {
            throw new NullPointerException(INVALID_HOUSE_TYPE);
        }

        return String.format(SUCCESSFULLY_ADDED_HOUSE_TYPE, type);
    }

    @Override
    public String buyToy(String type) {
        if (type.equals("Ball"))    {
            this.toys.buyToy(new Ball());
        } else if (type.equals("Mouse")) {
            this.toys.buyToy(new Mouse());
        }   else {
            throw new IllegalArgumentException(INVALID_TOY_TYPE);
        }

        return String.format(SUCCESSFULLY_ADDED_TOY_TYPE, type);
    }

    @Override
    public String toyForHouse(String houseName, String toyType) {
        House house = houses.stream().filter(e -> e.getName().equals(houseName)).findFirst().orElse(null);
        Toy toy = toys.findFirst(toyType);

        if (toy == null)    {
            throw new IllegalArgumentException(String.format(NO_TOY_FOUND, toyType));
        }

        assert house != null;
        house.buyToy(toy);
        return String.format(SUCCESSFULLY_ADDED_TOY_IN_HOUSE, toyType, houseName);
    }

    @Override
    public String addCat(String houseName, String catType, String catName, String catBreed, double price) {
        Cat cat;
        if (catType.equals("ShorthairCat")) {
            cat = new ShorthairCat(catName, catBreed, price);
        } else if (catType.equals("LonghairCat")) {
            cat = new LonghairCat(catName, catBreed, price);
        } else {
            throw new IllegalArgumentException(INVALID_CAT_TYPE);
        }

        House house = this.houses.stream().filter(e -> e.getName().equals(houseName)).findFirst().orElse(null);

        String output;

        assert house != null;
        if (isSuitableHouse(catType, house))    {
            house.addCat(cat);
            output = String.format(SUCCESSFULLY_ADDED_CAT_IN_HOUSE, catType, houseName);
        }   else {
            output = UNSUITABLE_HOUSE;
        }

        return output;
    }

    private boolean isSuitableHouse(String catType, House house) {
        String houseType = house.getClass().getSimpleName();
        return catType.equals("ShorthairCat") && houseType.equals("ShortHouse") || catType.equals("LonghairCat") && houseType.equals("LongHouse");
    }

    @Override
    public String feedingCat(String houseName) {
        House house = this.houses.stream().filter(e -> e.getName().equals(houseName)).findFirst().orElse(null);
        assert house != null;
        house.feeding();
        return String.format(FEEDING_CAT, house.getCats().size());
    }

    @Override
    public String sumOfAll(String houseName) {
        House house = this.houses.stream().filter(e -> e.getName().equals(houseName)).findFirst().orElse(null);
        assert house != null;
        double catsPrice = house.getCats().stream().mapToDouble(Cat::getPrice).sum();
        double toysPrice = house.getToys().stream().mapToDouble(Toy::getPrice).sum();
        return String.format(VALUE_HOUSE, houseName, catsPrice + toysPrice);
    }

    @Override
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        this.houses.forEach(e -> sb.append(String.format("%s", e.getStatistics())));
        return sb.toString().trim();
    }
}
