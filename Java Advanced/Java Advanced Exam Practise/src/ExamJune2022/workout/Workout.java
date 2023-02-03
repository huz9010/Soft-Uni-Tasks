package ExamJune2022.workout;

import java.util.ArrayList;
import java.util.List;

public class Workout {

    private List<Exercise> exercises;
    private String type;
    private int exerciseCount;

    public Workout(String type, int exerciseCount) {
        this.exercises = new ArrayList<>();
        this.type = type;
        this.exerciseCount = exerciseCount;
    }

    public void addExercise(Exercise exercise)  {
        if (this.exerciseCount >= this.exercises.size() + 1)    {
            this.exercises.add(exercise);
        }
    }

    private static boolean isExerciseExists(String name, String muscle, Exercise e) {
        return e.getName().equals(name) && e.getMuscle().equals(muscle);
    }

    public boolean removeExercise(String name, String muscle)   {

        for (Exercise e : this.exercises)    {
            if (isExerciseExists(name, muscle, e))   {
                this.exercises.remove(e);
                return true;
            }
        }
        return false;
    }

    public Exercise getExercise(String name, String muscle) {

        for (Exercise e : this.exercises)   {
            if (isExerciseExists(name, muscle, e))  {
                return e;
            }
        }
        return null;
    }

    public Exercise getMostBurnedCaloriesExercise() {
        if (this.exercises.isEmpty()) {
            return null;
        }

            Exercise exerciseToReturn = null;
            int maxCalories = Integer.MIN_VALUE;

            for (Exercise e : this.exercises) {
                if (e.getBurnedCalories() > maxCalories) {
                    exerciseToReturn = e;
                    maxCalories = e.getBurnedCalories();
                }
            }
            return exerciseToReturn;
        }


    public int getExerciseCount()   {
        return this.exercises.size();
    }

    public String getStatistics()   {
        StringBuilder sb = new StringBuilder();

        sb.append("Workout type: ").append(this.type).append(System.lineSeparator());
        this.exercises.forEach(e -> sb.append(e).append(System.lineSeparator()));

        return sb.toString();
    }
}
