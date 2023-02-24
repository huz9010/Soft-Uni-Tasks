package reusing_classes;

import java.util.ArrayList;
import java.util.List;

public class StackOfStrings {

    private List<String> data;

    public StackOfStrings() {
        this.data = new ArrayList<>();
    }

    public void push(String string) {
        this.data.add(string);
    }

    public boolean isEmpty()    {
        return data.size() == 0;
    }

    public String pop() {
        if (data.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        String text = data.get(data.size() - 1);
        data.remove(data.size() - 1);
        return text;
    }

    public String peek()    {
        if (data.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return data.get(data.size() - 1);
    }

}
