package collection_hierarchy;

public class AddCollection extends Collection implements Addable    {

    @Override
    public int add(String string)   {
        items.add(string);
        return items.size() - 1;
    }
}
