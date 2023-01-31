import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HashMap<String, Cat> cats = new HashMap<>();

        String input = scanner.nextLine();

        while (!input.equals("End"))    {
            String[] data = input.split("\\s+");
            String breed = data[0];
            String name = data[1];
            double value = Double.parseDouble(data[2]);

            switch (breed)  {
                case "Siamese":
                    Siamese siamese = new Siamese(breed, name, value);
                    cats.put(name, siamese);
                    break;

                case "Cymric":
                    Cymric cymric = new Cymric(breed, name, value);
                    cats.put(name, cymric);
                    break;

                case "StreetExtraordinaire":
                    StreetExtraordinaire streetExtraordinaire = new StreetExtraordinaire(breed, name, value);
                    cats.put(name, streetExtraordinaire);
                    break;
            }
            input = scanner.nextLine();
        }

        input = scanner.nextLine();

        System.out.println(cats.get(input));
    }
}
