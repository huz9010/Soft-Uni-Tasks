package kindergarten;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Kindergarten {
    private String name;
    private int capacity;
    private List<Child> registry;

    public Kindergarten(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.registry = new ArrayList<>();
    }

    public boolean addChild(Child child)    {
        if (capacity > registry.size()) {
            registry.add(child);
            return true;
        }
        return false;
    }

    public boolean removeChild(String firstName)    {
        for (Child child : registry)    {
            if (child.getFirstName().equals(firstName)) {
                registry.remove(child);
                return true;
            }
        }
        return false;
    }

    public int getChildrenCount()   {
        return registry.size();
    }

    public Child getChild(String firstName)     {
        for (Child child : registry)    {
            if (child.getFirstName().equals(firstName)) {
                return child;
            }
        }
        return null;
    }

    public String registryReport()      {
        registry.sort(Comparator.comparingInt(Child::getAge).thenComparing(Child::getFirstName).thenComparing(Child::getLastName));

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Registered children in %s:", this.name)).append(System.lineSeparator()).append("--").append(System.lineSeparator());

        for (int i = 0; i < registry.size(); i++) {
            if (i != registry.size() - 1)   {
                sb.append(registry.get(i)).append(System.lineSeparator()).append("--").append(System.lineSeparator());
            }   else sb.append(registry.get(i)).append(System.lineSeparator());
        }
        return sb.toString();
    }
}
