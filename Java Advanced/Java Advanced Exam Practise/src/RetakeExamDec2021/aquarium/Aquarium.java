package RetakeExamDec2021.aquarium;

import java.util.ArrayList;
import java.util.List;

public class Aquarium {

    private String name;
    private int capacity;
    private int size;
    private List<Fish> fishInPool;

    public int getFishInPool()  {
        return fishInPool.size();
    }

    public void add(Fish fish)  {
        if (fishInPool.size() < capacity) {
            fishInPool.add(fish);
        }
    }

    public boolean remove(String name)  {
        for (Fish fish : fishInPool)  {
            if (fish.getName().equals(name))    {
                fishInPool.remove(fish);
                return true;
            }
        }
        return false;
    }

    public Fish findFish(String name)   {
        for (Fish fish : fishInPool)  {
            if (fish.getName().equals(name))    {
                return fish;
            }
        }
        return null;
    }

    public String report()  {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Aquarium: %s ^ Size: %d", this.name, this.size)).append(System.lineSeparator());
        for (Fish fish : fishInPool)  {
            sb.append(fish).append(System.lineSeparator());
        }
        return sb.toString();
    }

    public Aquarium(String name, int capacity, int size) {
        this.name = name;
        this.capacity = capacity;
        this.size = size;
        this.fishInPool = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getSize() {
        return size;
    }
}
