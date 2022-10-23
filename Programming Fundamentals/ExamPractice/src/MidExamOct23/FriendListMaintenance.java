package MidExamOct23;

import java.util.Scanner;

public class FriendListMaintenance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] friendsList = scanner.nextLine().split(", ");
        int blacklisted = 0;
        int lost = 0;

        String input = scanner.nextLine();

        while (!input.equals("Report")) {
            String command = input.split(" ")[0];

            switch (command)    {
                case "Blacklist":
                    String name = input.split(" ")[1];
                    boolean isFound = false;
                    for (int i = 0; i < friendsList.length; i++) {
                        if (friendsList[i].equals(name))    {
                            friendsList[i] = "Blacklisted";
                            System.out.println(name + " was blacklisted.");
                            blacklisted++;
                            isFound = true;
                            break;
                        }
                    }
                    if (!isFound)   {
                        System.out.println(name + " was not found.");
                    }
                    break;
                case "Error":
                    int index = Integer.parseInt(input.split(" ")[1]);
                    if (index >= 0 && index < friendsList.length)   {
                        if (!friendsList[index].equals("Blacklisted") && !friendsList[index].equals("Lost"))    {
                            String currentUser = friendsList[index];
                            friendsList[index] = "Lost";
                            lost++;
                            System.out.println(currentUser + " was lost due to an error.");
                        }
                    }
                    break;
                case "Change":
                    int changeIndex = Integer.parseInt(input.split(" ")[1]);
                    String newName = input.split(" ")[2];
                    if (changeIndex >= 0 && changeIndex < friendsList.length)   {
                        String currentName = friendsList[changeIndex];
                        friendsList[changeIndex] = newName;
                        System.out.printf("%s changed his username to %s.%n", currentName, friendsList[changeIndex]);
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.printf("Blacklisted names: %d%n", blacklisted);
        System.out.printf("Lost names: %d%n", lost);

        for (String element : friendsList)  {
            System.out.print(element + " ");
        }
    }
}
