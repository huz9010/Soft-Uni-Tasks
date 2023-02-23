package pizza_calories;

public class Dough {

    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {
        setFlourType(flourType);
        setBakingTechnique(bakingTechnique);
        setWeight(weight);
    }

    public double calculateCalories()   {
        double bakingModifier = BakingTechniques.valueOf(bakingTechnique).getModifier();
        double flourModifier = FlourTypes.valueOf(flourType).getModifier();
        return 2 * weight * bakingModifier * flourModifier;
    }

    private void setFlourType(String flourType) {
        if (!FlourTypes.contains(flourType))    {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.flourType = flourType;
    }

    private void setBakingTechnique(String bakingTechnique) {
        if (!BakingTechniques.contains(bakingTechnique))    {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.bakingTechnique = bakingTechnique;
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 200) {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
        this.weight = weight;
    }
}
