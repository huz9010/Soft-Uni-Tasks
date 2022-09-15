import java.util.Scanner;

public class Volleyball {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String year = scanner.nextLine().toLowerCase();
        int p = Integer.parseInt(scanner.nextLine());    //holidays
        int h = Integer.parseInt(scanner.nextLine());    //weekends travel

        //Влади е студент, живее в София и си ходи от време на време до родния град. Той
        //е много запален по волейбола,  но е зает през работните дни и играе  волейбол
        //само през  уикендите  и в  празничните дни.  Влади играе  в София  всяка  събота,
        //когато не е на работа и не си пътува до родния град, както и в 2/3 от празничните
        //дни. Той пътува до родния си град h пъти в годината, където играе волейбол със
        //старите си приятели в неделя. Влади не е на работа 3/4 от уикендите, в които е в
        //София.  Отделно,  през високосните години  Влади играе с 15% повече  волейбол от
        //нормалното.  Приемаме,  че годината има точно  48  уикенда,  подходящи за
        //волейбол. Напишете програма, която изчислява колко пъти Влади е играл волей-бол  през годината.  Закръглете резултата  надолу до най-близкото цяло число
        //(напр. 2.15 -> 2; 9.95 -> 9).

        int sofiaWeekends = 48 - h;
        double sofiaPlay = sofiaWeekends * 3.0/4.0 + p * 2.0 / 3.0;
        double totalPlaytime = sofiaPlay + h;

        if (year.equals("leap")){
            System.out.println(Math.floor(totalPlaytime + totalPlaytime * 0.15));
        } else if (year.equals("normal")) {
            System.out.println(Math.floor(totalPlaytime));
        }
    }
}
