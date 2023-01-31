import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        LinkedHashMap<String, Trainer> trainers = new LinkedHashMap<>();

        while (!input.equals("Tournament")) {
            String[] data = input.split("\\s+");

            String trainerName = data[0];
            String pokemonName = data[1];
            String pokemonElement = data[2];
            int pokemonHealth = Integer.parseInt(data[3]);

            if (trainers.containsKey(trainerName)) {
                trainers.get(trainerName).getPokemons().add(new Pokemon(pokemonName, pokemonElement, pokemonHealth));
            } else {

                Trainer trainer = new Trainer(trainerName, pokemonName, pokemonElement, pokemonHealth);
                trainers.put(trainerName, trainer);
            }

            input = scanner.nextLine();
        }

        input = scanner.nextLine();

        while (!input.equals("End")) {


            for (Map.Entry<String, Trainer> trainer : trainers.entrySet()) {
                if (trainer.getValue().hasPokemonWithElement(input)) {
                    trainer.getValue().winBadge();

                } else {
                    trainer.getValue().getPokemons().forEach(Pokemon::dropHealth);
                    trainer.getValue().pokemonDies();
                }
            }
            input = scanner.nextLine();
        }
        trainers.values().stream().sorted((f, s) -> Integer.compare(s.getBadges(), f.getBadges())).forEach(System.out::println);
    }
}
