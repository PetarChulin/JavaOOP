package Problem7CollectionHierarchy;

import java.util.Arrays;

public class AddCollection extends Collection implements Addable{

    @Override
    public int add(String item) {
        super.getItems().add(item);
        return super.getItems().indexOf(item);
    }
    protected static void addition(String[] items, Addable collection) {

        Arrays.stream(items).forEach(e->System.out.print(collection.add(e) + " "));
        System.out.println();
    }
}
