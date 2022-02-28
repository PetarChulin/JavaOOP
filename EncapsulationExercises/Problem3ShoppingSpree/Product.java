package Problem3ShoppingSpree;

import java.util.Map;
import java.util.Scanner;

public class Product {

    private String name;
    private double cost;

    public Product(String name, double cost) {
        this.setName(name);
        this.setCost(cost);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    private void setCost(double cost) {
        if (cost < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.cost = cost;
    }
    public static void getProductInfo(Scanner s, Map<String, Product> productInfo) {
        String[] productLine = s.nextLine().split(";");
        for (String value : productLine) {

            String[] line = value.split("=");
            String product = line[0];
            double price = Double.parseDouble(line[1]);
            Product productToBuy = new Product(product, price);
            productInfo.put(productToBuy.getName(), productToBuy);
        }
    }
}
