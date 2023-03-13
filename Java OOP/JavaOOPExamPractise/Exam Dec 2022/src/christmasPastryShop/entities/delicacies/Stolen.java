package christmasPastryShop.entities.delicacies;

public class Stolen extends BaseDelicacy {

    public Stolen(String name, double price) {
        super(name, price);
        int InitialStolenPortion = 250;
        setPortion(InitialStolenPortion);
    }
}
