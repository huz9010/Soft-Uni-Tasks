package ListUtilities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        Collections.addAll(list, 1, 3, -2, 5, -9);

        Integer min = ListUtils.getMin(list);
        Integer max = ListUtils.getMax(list);

        System.out.println(min);
        System.out.println(max);
    }
}
