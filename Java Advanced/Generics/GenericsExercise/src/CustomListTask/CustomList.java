package CustomListTask;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomList<T extends Comparable<T>> {
    private List<T> list;

    public CustomList() {
        list = new ArrayList<>();
    }

    public void add(T element)   {
        list.add(element);
    }

    public T remove(int index)  {
        return list.remove(index);
    }

    public boolean contains(T element)  {
        if (list.contains(element)) {
            return true;
        }
        return false;
    }

    public void swap (int firstIndex, int secondIndex)  {
        Collections.swap(list, firstIndex, secondIndex);
    }

    public int countGreaterThan(T element)  {
        return (int) list.stream().filter(e -> e.compareTo(element) > 0).count();
    }

    public T getMax()   {
        T max = list.get(0);

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).compareTo(max) > 0) {
                max = list.get(i);
            }
        }
        return max;
    }

    public T getMin()   {
        T min = list.get(0);

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).compareTo(min) < 0) {
                min = list.get(i);
            }
        }
        return min;
    }

    public void print() {
        list.forEach(System.out::println);
    }
}
