package collection_hierarchy;

public class AddRemoveCollection extends AddCollection implements AddRemovable  {

    public AddRemoveCollection() {
    }

    @Override
    public int add(String string)   {
        items.add(0, string);
        return 0;
    }

    @Override
    public String remove()  {
        return items.remove(items.size() - 1);
    }
}
