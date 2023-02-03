package RetakeExamApr2022.easterBasket;

import java.util.ArrayList;
import java.util.List;

public class Basket {

    private List<Egg> data;
    private String material;
    private int capacity;

    public Basket(String material, int capacity) {
        this.data = new ArrayList<>();
        this.material = material;
        this.capacity = capacity;
    }

    public void addEgg(Egg egg) {
        if (capacity > data.size()) {
            data.add(egg);
        }
    }

    public boolean removeEgg(String color)  {
        for (Egg e : data)  {
            if (e.getColor().equals(color)) {
                data.remove(e);
                return true;
            }
        }
        return false;
    }

    public Egg getStrongestEgg() {
        Egg strongestEgg = null;
        int maxStrength = Integer.MIN_VALUE;

        for (Egg e : data) {
            if (e.getStrength() > maxStrength) {
                maxStrength = e.getStrength();
                strongestEgg = e;
            }
        }
        return strongestEgg;
    }

    public Egg getEgg(String color) {
        for (Egg e : data) {
            if (e.getColor().equals(color)) {
                return e;
            }
        }
        return null;
    }

    public int getCount()   {
        return data.size();
    }

    public String report()  {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s basket contains:", material)).append(System.lineSeparator());
        this.data.forEach(e -> sb.append(e.toString()).append(System.lineSeparator()));

        return sb.toString().trim();
    }
}
