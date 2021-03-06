package Problem3ShoppingSpree;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Person {

    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        this.setName(name);
        this.setMoney(money);
        this.products = new ArrayList<>();
    }

    public List<Product> getProducts() {
        return products;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }

    public void buyProduct(Product product) {
        if (this.money >= product.getCost()) {
            products.add(product);
            money -= product.getCost();
            System.out.printf("%s bought %s\n" , this.name , product.getName());
        } else {
            throw new IllegalArgumentException(this.name + " can't afford " + product.getName());
        }
    }
    public static void getCustomer(Map<String, Person> finalInfo, String[] customer) {
        for (String item : customer) {

            String[] line = item.split("=");
            String name = line[0];
            double money = Double.parseDouble(line[1]);
            Person person = new Person(name, money);
            finalInfo.put(person.getName(), person);
        }
    }
    public static void getCustomerInfo(Scanner s, Map<String, Person> finalInfo) {
        String[] customer = s.nextLine().split(";");

        for (String item : customer) {

            String[] line = item.split("=");
            String name = line[0];
            double money = Double.parseDouble(line[1]);
            Person person = new Person(name, money);
            finalInfo.put(person.getName(), person);
        }
    }
}
