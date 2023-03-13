package christmasPastryShop.entities.cocktails;

public class MulledWine extends BaseCocktail {

    public MulledWine(String name, int size, String brand) {
        super(name, size, brand);
        double mulledWinePrice = 3.50;
        setPrice(mulledWinePrice);
    }
}
