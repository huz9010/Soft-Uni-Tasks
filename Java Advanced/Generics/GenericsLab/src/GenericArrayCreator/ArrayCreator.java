package GenericArrayCreator;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayCreator<T> {

    public static<T> T[] create(int length, T item)   {
        T[] array = (T[]) new Object[length];
        Arrays.fill(array, item);
        return array;
    }

    public static <T> T[] create(Class<T> clazz, int length, T item)    {
        T[] array = (T[]) Array.newInstance(clazz, length);
        Arrays.fill(array, item);
        return array;
    }
}
