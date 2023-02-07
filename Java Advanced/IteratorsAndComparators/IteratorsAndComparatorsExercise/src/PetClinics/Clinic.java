package PetClinics;

import java.util.Arrays;

public class Clinic {

    private String name;
    private Pet[] rooms;

    public Clinic(String name, int rooms) {
        if (rooms % 2 == 0) {
            throw new IllegalArgumentException("Invalid Operation!");
        } else {
            this.name = name;
            this.rooms = new Pet[rooms];
        }
    }

    public boolean hasEmptyRooms() {
        return true;
    }

    public String toString()    {
        StringBuilder sb = new StringBuilder();
        for (Pet room : rooms)  {
            sb.append(room.toString()).append(System.lineSeparator());
        }
        return sb.toString();
    }

    public String getName() {
        return name;
    }

    public Pet[] getRooms() {
        return rooms;
    }
}
