package ObjectsAndClassesExercise.groomingSalon;

import java.util.ArrayList;
import java.util.Collection;

public class GroomingSalon {

    private int capacity;
    private Collection<Pet> data;

    public GroomingSalon(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Pet pet)    {
        if (capacity > data.size()) {
            data.add(pet);
        }
    }

    public boolean remove(String name)  {
        for (Pet pet : data)    {
            if (pet.getName().equals(name)) {
                data.remove(pet);
                return true;
            }
        }
        return false;
    }

    public Pet getPet(String name, String owner)    {
        for (Pet pet : data)    {
            if (pet.getName().equals(name) && pet.getOwner().equals(owner)) {
                return pet;
            }
        }
        return null;
    }

    public int getCount()   {
        return data.size();
    }

    public String getStatistics()   {
        StringBuilder sb = new StringBuilder();
        sb.append("The grooming salon has the following clients:").append(System.lineSeparator());
        data.forEach(e -> sb.append(e.getName()).append(" ").append(e.getOwner()).append(System.lineSeparator()));

        return sb.toString().trim();
    }

}
