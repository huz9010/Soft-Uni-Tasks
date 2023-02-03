package ExamRetakeAug2022.sanctuary;

import java.util.ArrayList;
import java.util.List;

public class Habitat {

    private List<Elephant> data;
    private int capacity;

    public Habitat(int capacity) {
        this.data = new ArrayList<>();
        this.capacity = capacity;
    }

    public void add(Elephant elephant)  {
        if (this.capacity >= this.data.size() + 1)    {
            this.data.add(elephant);
        }
    }

    public boolean remove(String name)  {
        for (Elephant e : this.data) {
            if (e.getName().equals(name))   {
                data.remove(e);
                return true;
            }
        }
        return false;
    }

    public Elephant getElephant(String retiredFrom) {
        for (Elephant e : this.data) {
            if (e.getRetiredFrom().equals(retiredFrom)) {
                return e;
            }
        }
        return null;
    }

    public Elephant getOldestElephant() {
        Elephant oldestElephant = null;
        int maxAge = Integer.MIN_VALUE;

        for (Elephant e : this.data) {
            if (e.getAge() > maxAge)    {
                oldestElephant = e;
                maxAge = e.getAge();
            }
        }
        return oldestElephant;
    }

    public int getAllElephants()    {
        return this.data.size();
    }

    public String getReport()   {
        StringBuilder sb = new StringBuilder();

        sb.append("Saved elephants in the park:").append(System.lineSeparator());
        this.data.forEach(e -> sb.append(e.getName()).append(" came from: ").append(e.getRetiredFrom()).append(System.lineSeparator()));
        return sb.toString();
    }
}
