package christmasPastryShop.entities.delicacies;

public class Gingerbread extends BaseDelicacy {

    public Gingerbread(String name, double price) {
        super(name, price);
        int initialGingerbreadPortion = 200;
        setPortion(initialGingerbreadPortion);
    }
}