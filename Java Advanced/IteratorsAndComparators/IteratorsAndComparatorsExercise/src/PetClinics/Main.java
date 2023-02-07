package PetClinics;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HashMap<String, Pet> pets = new HashMap<>();
        HashMap<String, Clinic> clinics = new HashMap<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");

            switch (input[0])   {
                case "Create":
                    String name = input[2];
                    if (input[1].equalsIgnoreCase("pet"))   {
                        createPet(pets, input, name);
                    } else if (input[1].equalsIgnoreCase("clinic")) {
                        createClinic(clinics, input, name);
                    }
                    break;

                case "Add":

                    break;

                case "Release":

                    break;

                case "HasEmptyRooms":
                    String clinicName = input[1];
                    System.out.println(clinics.get(clinicName).hasEmptyRooms());
                    break;

                case "Print":
                    clinicName = input[1];
                    if (input.length == 2)  {
                        System.out.print(clinics.get(clinicName));
                    }   else {
                        int room = Integer.parseInt(input[2]);
                        System.out.println(clinics.get(clinicName).getRooms()[room - 1]);
                    }

                    break;
            }
        }
    }

    private static void createClinic(HashMap<String, Clinic> clinics, String[] input, String name) {
        int rooms = Integer.parseInt(input[3]);
        try {
            clinics.put(name, new Clinic(name, rooms));
        }   catch (IllegalArgumentException e)  {
            System.out.println(e.getMessage());
        }
    }

    private static void createPet(HashMap<String, Pet> pets, String[] input, String name) {
        int age = Integer.parseInt(input[3]);
        String kind = input[4];
        pets.put(name, new Pet(name, age, kind));
    }
}
