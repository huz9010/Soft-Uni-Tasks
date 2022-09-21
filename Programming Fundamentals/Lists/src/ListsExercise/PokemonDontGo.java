package ListsExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PokemonDontGo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> pokemonsList = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int removedSum = 0;

        while (pokemonsList.size() > 0) {
            int index = Integer.parseInt(scanner.nextLine());
            int currentPokemon = 0;
             if (index < 0) {
                 currentPokemon = pokemonsList.get(0);
                 removedSum += currentPokemon;
                 pokemonsList.remove(0);
                 pokemonsList.add(0, pokemonsList.get(pokemonsList.size() - 1));
             } else if (index >= pokemonsList.size()) {
                 currentPokemon = pokemonsList.get(pokemonsList.size() - 1);
                 removedSum += currentPokemon;
                 pokemonsList.remove(pokemonsList.size() - 1);
                 int temp = pokemonsList.size();
                 pokemonsList.add(pokemonsList.size(), pokemonsList.get(0));
             }  else {
                 currentPokemon = pokemonsList.get(index);
                 removedSum += currentPokemon;
                 pokemonsList.remove(index);
             }
            for (int i = 0; i < pokemonsList.size(); i++) {
                if (pokemonsList.get(i) <= currentPokemon)  {
                    pokemonsList.set(i, pokemonsList.get(i) + currentPokemon);
                }   else {
                    pokemonsList.set(i, pokemonsList.get(i) - currentPokemon);
                }
            }
        }
        System.out.println(removedSum);
    }
}
