package Problem7CollectionHierarchy;

import java.util.Scanner;

import static Problem7CollectionHierarchy.AddCollection.addition;
import static Problem7CollectionHierarchy.AddRemoveCollection.removal;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] items = sc.nextLine().split("\\s+");
        int operations = Integer.parseInt(sc.nextLine());

        AddCollection addCollection = new AddCollection();
        AddRemoveCollection addRemoveCollection = new AddRemoveCollection();
        MyListImpl myListImpl = new MyListImpl();

        addition(items, addCollection);
        addition(items, addRemoveCollection);
        addition(items, myListImpl);

        removal(operations, addRemoveCollection);
        removal(operations, myListImpl);
    }
}
