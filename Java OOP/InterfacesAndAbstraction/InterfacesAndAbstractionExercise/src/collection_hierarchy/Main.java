package collection_hierarchy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] strings = reader.readLine().split("\\s+");
        int removeCount = Integer.parseInt(reader.readLine());

        AddCollection addCollection = new AddCollection();
        AddRemoveCollection addRemoveCollection = new AddRemoveCollection();
        MyListImpl myList = new MyListImpl();

        addToCollection(strings, addCollection);
        addToCollection(strings, addRemoveCollection);
        addToCollection(strings, myList);


        removeFromCollection(removeCount, addRemoveCollection);
        removeFromCollection(removeCount, myList);
    }

    public static void addToCollection(String[] strings, Addable collection)    {
        for (String string : strings) {
            System.out.print(collection.add(string) + " ");
        }
        System.out.println();
    }

    public static void removeFromCollection(int removeCount, AddRemovable collection)    {
        for (int i = 0; i < removeCount; i++) {
            System.out.print(collection.remove() + " ");
        }
        System.out.println();
    }
}
