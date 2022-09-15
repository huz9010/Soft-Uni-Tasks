import java.util.Scanner;

public class Hospital {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int period = Integer.parseInt(scanner.nextLine());
        int treatedPatients = 0;
        int untreatedPatients = 0;
        int doctors = 7;

        for (int i = 1; i <= period; i++) {
            int patients = Integer.parseInt(scanner.nextLine());

            if ((i % 3 == 0 ) && (untreatedPatients > treatedPatients)){
                doctors++;
            }
            if (patients > doctors){
                treatedPatients += doctors;
                untreatedPatients += patients - doctors;
            }   else {
                treatedPatients += patients;
            }
        }
        System.out.printf("Treated patients: %d.%nUntreated patients: %d.", treatedPatients, untreatedPatients);
    }
}
