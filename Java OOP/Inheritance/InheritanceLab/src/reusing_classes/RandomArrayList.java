package reusing_classes;

import java.util.ArrayList;
import java.util.Random;

public class RandomArrayList extends ArrayList<Object> {

    private Random rnd;

    public RandomArrayList() {
        this.rnd = new Random();
    }

    public Object getRandomElement()    {

        int index = this.rnd.nextInt(super.size());
        Object element = super.get(index);
        super.remove(index);
        return element;
    }
}
