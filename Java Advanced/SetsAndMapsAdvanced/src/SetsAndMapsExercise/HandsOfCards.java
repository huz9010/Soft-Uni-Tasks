package SetsAndMapsExercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        LinkedHashMap<String, Integer> players = new LinkedHashMap<>();

        while (!input.equals("JOKER"))  {
            String name = input.split(": ")[0];
            String cardCollection = input.split(": ")[1];

            String[] cards = cardCollection.split(", ");
            int totalCardPower = 0;

            for (int i = 0; i < cards.length; i++) {
                String cardNum = cards[i].substring(0, cards[i].length() - 1);
                String cardType = cards[i].substring(cards[i].length() - 1);

                int cardPower = calculateCardPower(cardNum, cardType);
                totalCardPower += cardPower;
            }

            players.putIfAbsent(name, 0);
            int currentPoints = players.get(name) + totalCardPower;
            players.put(name, currentPoints);

            input = scanner.nextLine();
        }

        for (Map.Entry<String, Integer> player : players.entrySet()) {
            System.out.printf("%s: %d%n", player.getKey(), player.getValue());
        }
    }

    public static int calculateCardPower(String cardNum, String cardType)   {
        int cardNumber = 0;
        int cardPower = 0;
        switch (cardNum)    {
            case "J":
                cardNumber = 11;
                if (cardType.equals("S"))   {
                    cardPower = 4 * cardNumber;
                } else if (cardType.equals("H")) {
                    cardPower = 3 * cardNumber;
                } else if (cardType.equals("D")) {
                    cardPower = 2 * cardNumber;
                } else if (cardType.equals("C")) {
                    cardPower = cardNumber;
                }
                break;
            case "Q":
                cardNumber = 12;
                if (cardType.equals("S"))   {
                    cardPower = 4 * cardNumber;
                } else if (cardType.equals("H")) {
                    cardPower = 3 * cardNumber;
                } else if (cardType.equals("D")) {
                    cardPower = 2 * cardNumber;
                } else if (cardType.equals("C")) {
                    cardPower = cardNumber;
                }
                break;
            case "K":
                cardNumber = 13;
                if (cardType.equals("S"))   {
                    cardPower = 4 * cardNumber;
                } else if (cardType.equals("H")) {
                    cardPower = 3 * cardNumber;
                } else if (cardType.equals("D")) {
                    cardPower = 2 * cardNumber;
                } else if (cardType.equals("C")) {
                    cardPower = cardNumber;
                }
                break;
            case "A":
                cardNumber = 14;
                cardPower = switch (cardType) {
                    case "S" -> 4 * cardNumber;
                    case "H" -> 3 * cardNumber;
                    case "D" -> 2 * cardNumber;
                    case "C" -> cardNumber;
                    default -> cardPower;
                };
                break;
            default:
                cardNumber = Integer.parseInt(cardNum);
                if (cardType.equals("S"))   {
                    cardPower = 4 * cardNumber;
                } else if (cardType.equals("H")) {
                    cardPower = 3 * cardNumber;
                } else if (cardType.equals("D")) {
                    cardPower = 2 * cardNumber;
                } else if (cardType.equals("C")) {
                    cardPower = cardNumber;
                }
                break;
        }
        return cardPower;
    }
}
