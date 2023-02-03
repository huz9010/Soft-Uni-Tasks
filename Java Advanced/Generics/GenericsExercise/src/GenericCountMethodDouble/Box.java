package GenericCountMethodDouble;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Box<T extends Comparable<T>> {
    private List<T> values;

    public Box() {
        values = new ArrayList<>();
    }

    @Override
    public String toString()    {
        StringBuilder sb = new StringBuilder();
        values.forEach(e -> sb.append(e.getClass().getName()).append(": ").append(e).append(System.lineSeparator()));
        return sb.toString();
    }

    public List<T> swap(int firstIndex, int secondIndex)    {
        Collections.swap(values, firstIndex, secondIndex);
        return values;
    }

    public void add(T element)  {
        values.add(element);
    }

    public int count(T element) {
        return (int) values.stream().filter(e -> e.compareTo(element) > 0).count();
    }
}
