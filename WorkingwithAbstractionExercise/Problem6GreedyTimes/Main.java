package WorkingwithAbstractionExercise.Problem6GreedyTimes;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        long capacity = Long.parseLong(scanner.nextLine());
        String[] safe = scanner.nextLine().split("\\s+");

        Map<String, LinkedHashMap<String, Long>> bag = new LinkedHashMap<>();

        for (int i = 0; i < safe.length; i += 2) {
            String itemName = safe[i];

            long itemValue = Long.parseLong(safe[i + 1]);

            String itemType = "";

            if (itemName.length() == 3) {
                itemType = "Cash";
            } else if (itemName.toLowerCase().endsWith("gem")) {
                itemType = "Gem";
            } else if (itemName.equals("Gold")) {
                itemType = "Gold";
            }
            long itemsTotalSum = bag.values().stream().map(Map::values)
                    .flatMap(Collection::stream).mapToLong(e -> e).sum() + itemValue;

            if (itemType.equals("")) {
                continue;
            } else if (capacity < itemsTotalSum) {
                continue;
            }

            switch (itemType) {
                case "Gem":
                    if (getSumOfItems(bag, itemValue, itemType, "Gold")) continue;
                    break;
                case "Cash":
                    if (getSumOfItems(bag, itemValue, itemType, "Gem")) continue;
                    break;
            }
            bag.putIfAbsent(itemType , new LinkedHashMap<>());
            bag.get(itemType).putIfAbsent(itemName , 0L);
            bag.get(itemType).put(itemName, bag.get(itemType).get(itemName) + itemValue);
        }

        for (Map.Entry<String, LinkedHashMap<String, Long>> entry : bag.entrySet()) {
            long sumValues = entry.getValue().values().stream().mapToLong(v -> v).sum();

            System.out.printf("<%s> $%s%n", entry.getKey(), sumValues);

            entry.getValue().entrySet().stream().sorted((e1, e2) -> e2.getKey()
                    .compareTo(e1.getKey())).forEach(e -> System.out.println("##" + e.getKey() + " - " + e.getValue()));

        }
    }

    private static boolean getSumOfItems(Map<String, LinkedHashMap<String, Long>>
                                                 bag, long itemValue, String itemType, String gold) {
        if (!bag.containsKey(itemType)) {
            if (bag.containsKey(gold)) {
                return itemValue > bag.get("Gold").values().stream().mapToLong(e -> e).sum();
            } else {
                return true;
            }
        } else return bag.get(itemType).values().stream().mapToLong(e -> e)
                .sum() + itemValue > bag.get(gold).values().stream().mapToLong(e -> e).sum();
    }
}