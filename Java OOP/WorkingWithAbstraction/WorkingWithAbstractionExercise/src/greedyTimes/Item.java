package greedyTimes;

public class Item{

    String type;
    long amount;

    public Item(String type, long amount) {
        this.type = type;
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public long getAmount() {
        return amount;
    }

    @Override
    public String toString()    {
        return String.format("##%s - %d", type, amount);
    }
}