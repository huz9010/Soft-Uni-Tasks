package StackIterator;

import java.util.*;

public class CustomStack implements Iterable<Integer> {

    private List<Integer> stack;

    public CustomStack() {
        stack = new ArrayList<>();
    }

    public void push(Integer... number)    {
        stack.addAll(Arrays.asList(number));
    }

    public void pop()    {
        if (stack.isEmpty())    {
            throw  new NoSuchElementException("No elements");
        }   else {
            stack.remove(stack.size() - 1);
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            int index = stack.size() - 1;
            @Override
            public boolean hasNext() {
                return index >= 0;
            }

            @Override
            public Integer next() {
                return stack.get(index--);
            }
        };
    }
}
