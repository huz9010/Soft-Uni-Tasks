package collection_hierarchy;

public class MyListImpl extends AddRemoveCollection implements MyList   {

    int used = items.size();

    public MyListImpl() {
    }

    @Override
    public int add(String string)   {
        items.add(0, string);
        return 0;
    }

    @Override
    public String remove()  {
        return items.remove(0);
    }

    @Override
    public int getUsed()    {
        return used;
    }
}
