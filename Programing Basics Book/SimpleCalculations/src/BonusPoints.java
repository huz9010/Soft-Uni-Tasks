import java.util.Scanner;

public class BonusPoints {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int a = Integer.parseInt(scanner.nextLine());
        double bonus = 0;

        //•  Ако числото е до 100 включително, бонус точките са 5.
        //•  Ако числото е по-голямо от 100, бонус точките са 20% от числото.
        //•  Ако числото е по-голямо от 1000, бонус точките са 10% от числото.
        //•  Допълнителни бонус точки (начисляват се отделно от предходните):
        //o  За четно число → + 1 т.
        //o  За число, което завършва на 5 → + 2 т.

        if (a % 2 == 0){
            bonus +=1;
        }
        else if (a % 5 == 0){
            bonus +=2;
        }

        if (a <= 100){
            bonus += 5;
        }   else if (a > 100 && a <= 1000){
            bonus = bonus + a * 0.2;
        } else if (a > 1000) {
            bonus = bonus + a * 0.1;

        }

        System.out.println(bonus);
        System.out.println(a + bonus);
    }
}
