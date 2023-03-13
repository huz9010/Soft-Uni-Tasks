import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {

        Class<Reflection> clazz = Reflection.class;

//        System.out.println(clazz);
//        System.out.println(clazz.getSuperclass());
//        Class<?>[] interfaces = clazz.getInterfaces();
//        Arrays.stream(interfaces).forEach(System.out::println);
//        Reflection instance = clazz.getDeclaredConstructor().newInstance();
//        System.out.println(instance);

        Set<Method> getters = new TreeSet<>(Comparator.comparing(Method::getName));
        Set<Method> setters = new TreeSet<>(Comparator.comparing(Method::getName));

        Method[] methods = clazz.getDeclaredMethods();

        for (Method method : methods)   {
            if (method.getName().startsWith("get")) {
                getters.add(method);
            } else if (method.getName().startsWith("set")) {
                setters.add(method);
            }
        }
//
//        getters.forEach(e -> System.out.printf("%s will return class %s%n", e.getName(), e.getReturnType().getName()));
//        setters.forEach(e -> System.out.printf("%s and will set field of class %s%n", e.getName(), e.getParameterTypes()[0].getName()));

        Set<Field> fields = new TreeSet<>(Comparator.comparing(Field::getName));
        fields.addAll(Arrays.asList(clazz.getDeclaredFields()));

        fields.stream().filter(e -> !Modifier.isPrivate(e.getModifiers())).forEach(e -> System.out.printf("%s must be private!%n", e.getName()));
        getters.stream().filter(e -> !Modifier.isPublic(e.getModifiers())).forEach(e -> System.out.printf("%s have to be public!%n", e.getName()));
        setters.stream().filter(e -> !Modifier.isPrivate(e.getModifiers())).forEach(e -> System.out.printf("%s have to be private!%n", e.getName()));
    }
}
