package harvestingFields;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		Class<RichSoilLand> clazz = RichSoilLand.class;

		Field[] fields = clazz.getDeclaredFields();

		String input = reader.readLine();

		while (!input.equals("HARVEST"))	{
			switch (input)	{
				case "private":
					printPrivate(fields);
					break;
				case "protected":
					printProtected(fields);
					break;
				case "public":
					printPublic(fields);
					break;
				case "all":
					printAll(fields);
					break;
			}

			input = reader.readLine();
		}

	}

	public static void printPrivate(Field[] fields)	{
		Arrays.stream(fields).filter(e -> Modifier.isPrivate(e.getModifiers()))
				.forEach(e -> System.out.printf("%s %s %s%n", Modifier.toString(e.getModifiers()), e.getType().getSimpleName(), e.getName()));
	}

	public static void printProtected(Field[] fields)	{
		Arrays.stream(fields).filter(e -> Modifier.isProtected(e.getModifiers()))
				.forEach(e -> System.out.printf("%s %s %s%n", Modifier.toString(e.getModifiers()), e.getType().getSimpleName(), e.getName()));
	}

	public static void printPublic(Field[] fields)	{
		Arrays.stream(fields).filter(e -> Modifier.isPublic(e.getModifiers()))
				.forEach(e -> System.out.printf("%s %s %s%n", Modifier.toString(e.getModifiers()), e.getType().getSimpleName(), e.getName()));
	}

	public static void printAll(Field[] fields)	{
		Arrays.stream(fields).forEach(e -> System.out.printf("%s %s %s%n", Modifier.toString(e.getModifiers()), e.getType().getSimpleName(), e.getName()));
	}
}
