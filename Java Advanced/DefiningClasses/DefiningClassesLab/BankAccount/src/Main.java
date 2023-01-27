import java.util.LinkedHashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        LinkedHashMap<Integer, BankAccount> bankAccounts = new LinkedHashMap<>();

        while (!input.equals("End")) {
            String[] command = input.split("\\s+");
            switch (command[0]) {
                case "Create":
                    BankAccount bankAccount = new BankAccount();
                    bankAccounts.put(bankAccount.getId(), bankAccount);
                    System.out.println("Account ID" + bankAccount.getId() + " created");
                    break;
                case "Deposit":
                    int id = Integer.parseInt(command[1]);
                    double amount = Double.parseDouble(command[2]);
                    if (bankAccounts.containsKey(id)) {
                        bankAccounts.get(id).deposit(amount);
                        System.out.printf("Deposited %.0f to ID%d%n", amount, id);
                    } else {
                        System.out.println("Account does not exist");
                    }
                    break;
                case "SetInterest":
                    double interestRate = Double.parseDouble(command[1]);
                    BankAccount.setInterestRate(interestRate);
                    break;
                case "GetInterest":
                    id = Integer.parseInt(command[1]);
                    int years = Integer.parseInt(command[2]);

                    if (bankAccounts.containsKey(id)) {
                        System.out.printf("%.2f%n", bankAccounts.get(id).getInterestRate(years));
                    }   else {
                        System.out.println("Account does not exist");
                    }
                    break;
            }
            input = scanner.nextLine();
        }
    }
}