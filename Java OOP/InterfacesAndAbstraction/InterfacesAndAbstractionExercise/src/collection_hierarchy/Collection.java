package collection_hierarchy;

import java.util.ArrayList;
import java.util.List;

public abstract class Collection {

    int MAX_SIZE = 100;
    protected List<String> items;
    private int maxSize;

    public Collection() {
        items = new ArrayList<>();
        maxSize = MAX_SIZE;
    }
}
