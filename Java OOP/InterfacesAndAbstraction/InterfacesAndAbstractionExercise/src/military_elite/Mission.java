package military_elite;

public class Mission {

    private String codeName;
    private MissionState missionState;

    public Mission(String codeName, String missionState) {
        this.codeName = codeName;
        this.missionState = MissionState.valueOf(missionState);
    }

    public String getState() {
        return String.valueOf(missionState);
    }

    public String toString()    {
        return String.format("Code Name: %s State: %s%n", codeName, missionState);
    }
}
