package ListyIterator;

import java.util.Arrays;
import java.util.List;

public class ListyIterator {

    private List<String> strings;

    public ListyIterator(String... strings) {
        this.strings = Arrays.asList(strings);
    }

    public void setStrings(String[] strings) {
        this.strings = Arrays.asList(strings);
    }

    int index = 0;
    public boolean move()   {
        if (hasNext())  {
            index++;
            return true;
        }
        return false;
    }

    public boolean hasNext()    {
        return index < strings.size() - 1;
    }

    public void print() {
        if (strings.isEmpty()) {
            throw new IllegalStateException("Invalid Operation!");
        } else {
            System.out.println(strings.get(index));
        }
    }
}
