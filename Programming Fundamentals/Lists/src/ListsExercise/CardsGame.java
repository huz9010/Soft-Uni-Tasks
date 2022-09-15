package ListsExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CardsGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> player1Cards = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> player2Cards = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        while (player1Cards.size() != 0 && player2Cards.size() != 0)    {
            if (player1Cards.get(0) > player2Cards.get(0))  {
                player1Cards.add(player1Cards.get(0));
                player1Cards.add(player2Cards.get(0));
                player1Cards.remove(0);
                player2Cards.remove(0);
            } else if (player1Cards.get(0) < player2Cards.get(0)) {
                player2Cards.add(player2Cards.get(0));
                player2Cards.add(player1Cards.get(0));
                player1Cards.remove(0);
                player2Cards.remove(0);
            } else {
                player1Cards.remove(0);
                player2Cards.remove(0);
            }
        }
        int sum = 0;
        if (player1Cards.size() == 0)   {
            for (int element : player2Cards)    {
                sum += element;
            }
            System.out.println("Second player wins! Sum: " + sum);
        }   else {
            for (int element : player1Cards)    {
                sum += element;
            }
            System.out.println("First player wins! Sum: " + sum);
        }
    }
}
