package SetsAndMapsExercise;

import java.util.*;

public class HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        LinkedHashMap<String, HashSet<String>> players = new LinkedHashMap<>();
        LinkedHashMap<String, Integer> playerPoints = new LinkedHashMap<>();

        while (!input.equals("JOKER")) {
            String name = input.split(": ")[0];
            String cardCollection = input.split(": ")[1];

            String[] cards = cardCollection.split(", ");

            HashSet<String> cardSet = new HashSet<>(Arrays.asList(cards));

            if (!players.containsKey(name)) {
                players.put(name, cardSet);
            } else {
                HashSet<String> tempSet = players.get(name);
                tempSet.addAll(cardSet);
                players.put(name, tempSet);
            }
            input = scanner.nextLine();
        }


        for (Map.Entry<String, HashSet<String>> player : players.entrySet()) {
            int totalCardPower = 0;
            for (String s : player.getValue()) {
                String cardNum = s.substring(0, s.length() - 1);
                String cardType = s.substring(s.length() - 1);

                int cardPower = calculateCardPower(cardNum, cardType);
                totalCardPower += cardPower;
            }

            playerPoints.putIfAbsent(player.getKey(), 0);
            int currentPoints = playerPoints.get(player.getKey()) + totalCardPower;
            playerPoints.put(player.getKey(), currentPoints);
        }

        for (Map.Entry<String, Integer> player : playerPoints.entrySet()) {
            System.out.printf("%s: %d%n", player.getKey(), player.getValue());
        }
    }

    public static int calculateCardPower(String cardNum, String cardType)   {
        int cardNumber = 0;
        int cardPower = 0;
        switch (cardNum)    {
            case "J":
                cardNumber = 11;
                cardPower = getCardPower(cardType, cardNumber, cardPower);
                break;
            case "Q":
                cardNumber = 12;
                cardPower = getCardPower(cardType, cardNumber, cardPower);
                break;
            case "K":
                cardNumber = 13;
                cardPower = getCardPower(cardType, cardNumber, cardPower);
                break;
            case "A":
                cardNumber = 14;
                cardPower = getCardPower(cardType, cardNumber, cardPower);
                break;
            default:
                cardNumber = Integer.parseInt(cardNum);
                cardPower = getCardPower(cardType, cardNumber, cardPower);
                break;
        }
        return cardPower;
    }

    private static int getCardPower(String cardType, int cardNumber, int cardPower) {
        if (cardType.equals("S"))   {
            cardPower = 4 * cardNumber;
        } else if (cardType.equals("H")) {
            cardPower = 3 * cardNumber;
        } else if (cardType.equals("D")) {
            cardPower = 2 * cardNumber;
        } else if (cardType.equals("C")) {
            cardPower = cardNumber;
        }
        return cardPower;
    }
}
