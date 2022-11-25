package FinalExam04;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class HeroesOfCodeAndLogicVII {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int heroesCount = Integer.parseInt(scanner.nextLine());
        Map<String, Integer> heroesHP = new LinkedHashMap<>();
        Map<String, Integer> heroesMP = new LinkedHashMap<>();

        for (int i = 1; i <= heroesCount; i++) {
            String[] heroStats = scanner.nextLine().split(" ");
            String name = heroStats[0];
            int HP = Integer.parseInt(heroStats[1]);
            int MP = Integer.parseInt(heroStats[2]);

            heroesHP.put(name, HP);
            heroesMP.put(name, MP);
        }

        String input = scanner.nextLine();

        while (!input.equals("End"))    {
            String[] inputCommand = input.split(" - ");
            String command = inputCommand[0];
            String name = inputCommand[1];

            switch (command)    {
                case "CastSpell":
                    int mpNeeded = Integer.parseInt(inputCommand[2]);
                    String spellName = inputCommand[3];

                    if (heroesMP.get(name) >= mpNeeded) {
                        int mpLeft = heroesMP.get(name) - mpNeeded;
                        heroesMP.put(name, mpLeft);
                        System.out.printf("%s has successfully cast %s and now has %d MP!%n", name, spellName, heroesMP.get(name));
                    }   else {
                        System.out.printf("%s does not have enough MP to cast %s!%n", name, spellName);
                    }
                    break;
                case "TakeDamage":
                    int damage = Integer.parseInt(inputCommand[2]);
                    String attacker = inputCommand[3];

                    int hpLeft = heroesHP.get(name) - damage;

                    if (hpLeft > 0) {
                        heroesHP.put(name, hpLeft);
                        System.out.printf("%s was hit for %d HP by %s and now has %d HP left!%n", name, damage, attacker, heroesHP.get(name));
                    }   else {
                        heroesHP.remove(name);
                        heroesMP.remove(name);
                        System.out.printf("%s has been killed by %s!%n", name, attacker);
                    }
                    break;
                case "Recharge":
                    int mpAmount = Integer.parseInt(inputCommand[2]);

                    int currentMP = heroesMP.get(name) + mpAmount;

                    if (currentMP > 200)    {
                        currentMP = 200;
                        mpAmount = 200 - heroesMP.get(name);
                    }
                    heroesMP.put(name, currentMP);
                    System.out.printf("%s recharged for %d MP!%n", name, mpAmount);
                    break;
                case "Heal":
                    int healthAmount = Integer.parseInt(inputCommand[2]);

                    int currentHP = heroesHP.get(name) + healthAmount;

                    if (currentHP > 100)    {
                        currentHP = 100;
                        healthAmount = 100 - heroesHP.get(name);
                    }
                    heroesHP.put(name, currentHP);
                    System.out.printf("%s healed for %d HP!%n", name, healthAmount);
                    break;
            }
            input = scanner.nextLine();
        }
        for (Map.Entry<String, Integer> entry : heroesHP.entrySet()) {
            System.out.printf("%s%n  HP: %d%n  MP: %d%n", entry.getKey(), entry.getValue(), heroesMP.get(entry.getKey()));
        }
    }
}
