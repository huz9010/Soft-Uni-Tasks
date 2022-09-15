import java.util.Scanner;

public class Yard {
    public static void main(String[] args) {

        //Напишете програма, която изчислява необходимате сума,
        // които Божидара ще трябва да заплати на фирмата изпълнител на проекта.
        // Цената на един кв. м. е 7.61 лв със ДДС. Понеже нейният двор е доста голям,
        // фирмата изпълнител предлага 18% отстъпка от крайната цена.

        Scanner scanner = new Scanner(System.in);

        double area = Double.parseDouble(scanner.nextLine());
        double discount = area*7.61*0.18;
        double finalprice = area*7.61 - discount;

        System.out.printf("The final price is: %f lv.%n", finalprice);
        System.out.printf("The discount is: %f lv.%n", discount);
    }
}
