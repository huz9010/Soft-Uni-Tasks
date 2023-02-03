package ExamOct2022.shelter;

import java.util.ArrayList;
import java.util.List;

public class Shelter {

    private List<Animal> data;
    private int capacity;

    public Shelter(int capacity) {
        this.data = new ArrayList<>();
        this.capacity = capacity;
    }

    public void add(Animal animal)  {
        if (this.capacity >= this.data.size() + 1)   {
            this.data.add(animal);
        }
    }

    public boolean remove(String name)  {
        for (Animal a : this.data)   {
            if (a.getName().equals(name))   {
                this.data.remove(a);
                return true;
            }
        }
        return false;
    }

    public Animal getAnimal(String name, String caretaker)  {
        for (Animal a : this.data)   {
            if (a.getName().equals(name) && a.getCaretaker().equals(caretaker)) {
                return a;
            }
        }
        return null;
    }

    public Animal getOldestAnimal() {
        Animal oldestAnimal = null;
        int maxAge = Integer.MIN_VALUE;
        for (Animal a : this.data)   {
            if (a.getAge() > maxAge)    {
                oldestAnimal = a;
                maxAge = a.getAge();
            }
        }
        return oldestAnimal;
    }

    public int getCount()   {
        return this.data.size();
    }

    public String getStatistics()   {
        StringBuilder sb = new StringBuilder();
        sb.append("The shelter has the following animals:").append(System.lineSeparator());
        data.forEach(e -> sb.append(e.getName()).append(" ").append(e.getCaretaker()).append(System.lineSeparator()));
        return sb.toString();
    }
}
