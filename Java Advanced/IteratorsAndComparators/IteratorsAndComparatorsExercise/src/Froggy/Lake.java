package Froggy;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Lake implements Iterable<Integer>   {

    private List<Integer> lake;

    public Lake(Integer... numbers) {
        lake = Arrays.asList(numbers);
    }


    @Override
    public Iterator iterator() {
        return new Frog();
    }

    class Frog implements Iterator<Integer> {

        int index = 0;

        @Override
        public boolean hasNext() {
            if (index >= lake.size() && index % 2 == 0)   {
                index = 1;
            }
            return index < lake.size();
        }

        @Override
        public Integer next() {
            Integer num = lake.get(index);
            index += 2;
            return num;
        }
    }
}
