package Problem3ShoppingSpree;

import java.util.*;
import java.util.stream.Collectors;

import static Problem3ShoppingSpree.Person.getCustomerInfo;
import static Problem3ShoppingSpree.Product.getProductInfo;

public class Main {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        Map<String, Person> finalInfo = new LinkedHashMap<>();
        Map<String, Product> productInfo = new LinkedHashMap<>();

        getCustomerInfo(s, finalInfo);
        getProductInfo(s, productInfo);

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
