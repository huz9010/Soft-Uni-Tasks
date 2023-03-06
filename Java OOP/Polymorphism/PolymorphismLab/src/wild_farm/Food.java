package wild_farm;

public abstract class Food {

    private int quantity;

    public Food(int quantity) {
        setQuantity(quantity);
    }

    private void setQuantity(int quantity)  {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }
}
