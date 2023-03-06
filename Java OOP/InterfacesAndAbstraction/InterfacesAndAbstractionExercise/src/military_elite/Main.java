package military_elite;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();
        LinkedHashMap<Integer, Soldier> soldiers = new LinkedHashMap<>();

        while (!input.equals("End")) {
            String[] inputData = input.split("\\s+");

            String soldierType = inputData[0];
            int id = Integer.parseInt(inputData[1]);
            String firstName = inputData[2];
            String lastName = inputData[3];

            switch (soldierType) {
                case "Private":
                    double salary = Double.parseDouble(inputData[4]);
                    soldiers.put(id, new Private(id, firstName, lastName, salary));
                    break;
                case "LieutenantGeneral":
                    salary = Double.parseDouble(inputData[4]);
                    LieutenantGeneral lieutenantGeneral = new LieutenantGeneral(id, firstName, lastName, salary);
                    for (int i = 5; i < inputData.length; i++) {
                        lieutenantGeneral.addPrivate((Private) soldiers.get(Integer.parseInt(inputData[i])));
                    }
                    soldiers.put(id, lieutenantGeneral);
                    break;
                case "Engineer":
                    salary = Double.parseDouble(inputData[4]);
                    String corps = inputData[5];
                    if (isValidCorps(corps)) {
                        Engineer engineer = new Engineer(id, firstName, lastName, salary, corps);
                        for (int i = 6; i < inputData.length; i += 2) {
                            String partName = inputData[i];
                            int hoursWorked = Integer.parseInt(inputData[i + 1]);
                            engineer.addRepair(new Repair(partName, hoursWorked));
                        }
                        soldiers.put(id, engineer);
                    }
                    break;
                case "Commando":
                    salary = Double.parseDouble(inputData[4]);
                    corps = inputData[5];
                    if (isValidCorps(corps)) {
                        Commando commando = new Commando(id, firstName, lastName, salary, corps);
                        for (int i = 6; i < inputData.length; i += 2) {
                            String codeName = inputData[i];
                            String state = inputData[i + 1];
                            if (isValidMissionState(state)) {
                                commando.addMission(new Mission(codeName, state));
                            }
                        }
                        soldiers.put(id, commando);
                    }
                    break;
                case "Spy":
                    String codeNumber = inputData[4];
                    soldiers.put(id, new Spy(id, firstName, lastName, codeNumber));
                    break;
            }
            input = reader.readLine();
        }
        soldiers.values().forEach(System.out::print);
    }

    private static boolean isValidCorps(String corps) {
        return corps.equals(String.valueOf(Corps.Marines)) || corps.equals(String.valueOf(Corps.Airforces));
    }
    private static boolean isValidMissionState(String state) {
        return state.equals(String.valueOf(MissionState.finished)) || state.equals(String.valueOf(MissionState.inProgress));
    }
}
