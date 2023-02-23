package shopping_spree;

import java.util.ArrayList;
import java.util.List;

public class Person {

    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        setName(name);
        setMoney(money);
        this.products = new ArrayList<>();
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty())   {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    public void setMoney(double money) {
        if (money < 0)  {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void buyProduct(Product product) {
        if (product.getCost() > money)  {
            throw new IllegalArgumentException(String.format("%s can't afford %s", this.name, product.getName()));
        }
            products.add(product);
            money -= product.getCost();
            System.out.printf("%s bought %s%n", this.name, product.getName());
    }

    private String productsToString()   {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < products.size() - 1; i++) {
            sb.append(products.get(i)).append(", ");
        }
        sb.append(products.get(products.size() - 1));

        return sb.toString();
    }

    @Override
    public String toString()    {
        if (this.products.isEmpty())    {
            return String.format("%s – Nothing bought", this.name);
        }
        return String.format("%s - %s", this.name, productsToString());
    }
}
