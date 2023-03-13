package christmasPastryShop.entities.cocktails;

public class Hibernation extends BaseCocktail {

    public Hibernation(String name, int size, String brand) {
        super(name, size, brand);
        double hibernationPrice = 4.50;
        setPrice(hibernationPrice);
    }
}
