package Problem7CollectionHierarchy;


import java.util.ArrayList;
import java.util.List;

public abstract class Collection {

    private static final int maxSize = 100;
    private List<String> items;

    public Collection() {
        this.items = new ArrayList<>();
    }

    public List<String> getItems() {
        return items;
    }
}
