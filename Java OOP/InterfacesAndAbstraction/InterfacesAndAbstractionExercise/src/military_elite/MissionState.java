package military_elite;

public enum MissionState {

    inProgress,
    finished;

    public static boolean contains(String test) {
        for (MissionState state : values()) {
            if (state.name().equals(test)) {
                return true;
            }
        }
        return false;
    }
}
