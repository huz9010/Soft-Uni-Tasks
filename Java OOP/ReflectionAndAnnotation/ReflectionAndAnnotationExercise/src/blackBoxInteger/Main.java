package blackBoxInteger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws IOException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Class<BlackBoxInt> clazz = BlackBoxInt.class;
        Constructor<BlackBoxInt> constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        BlackBoxInt blackBoxInt = constructor.newInstance();

        Field field = clazz.getDeclaredField("innerValue");
        field.setAccessible(true);

        String input = reader.readLine();

        while (!input.equals("END"))    {
            String[] tokens = input.split("_");
            String command = tokens[0];
            int value = Integer.parseInt(tokens[1]);

            Method currentMethod = clazz.getDeclaredMethod(command, int.class);
            currentMethod.setAccessible(true);
            currentMethod.invoke(blackBoxInt, value);

            System.out.println(field.get(blackBoxInt));

            input = reader.readLine();
        }
    }
}
