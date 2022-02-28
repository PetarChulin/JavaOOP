package Problem3ShoppingSpree;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        Map<String, Person> finalInfo = new LinkedHashMap<>();
        Map<String, Product> productInfo = new LinkedHashMap<>();

        String[] customer = s.nextLine().split(";");

        for (String item : customer) {

            String[] line = item.split("=");
            String name = line[0];
            double money = Double.parseDouble(line[1]);
            Person person = new Person(name, money);
            finalInfo.put(person.getName(), person);
        }
        String[] productLine = s.nextLine().split(";");

        for (String value : productLine) {

            String[] line = value.split("=");
            String product = line[0];
            double price = Double.parseDouble(line[1]);
            Product productToBuy = new Product(product, price);
            productInfo.put(productToBuy.getName(), productToBuy);
        }

        String input = s.nextLine();
        while (!input.equals("END")) {

            String personName = input.split("\\s+")[0];
            String productName = input.split("\\s+")[1];
            try {
                Person person = finalInfo.get(personName);
                Product product = productInfo.get(productName);
                person.buyProduct(product);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
                input = s.nextLine();
            }
            finalInfo.values().forEach((e -> {
                System.out.print(e.getName() + " - ");
                if (e.getProducts().isEmpty()) {
                    System.out.println("Nothing bought");
                } else {
                    System.out.println(e.getProducts().stream().map(Product::getName).collect(Collectors.joining(", ")));
                }
            }));
        }
    }
