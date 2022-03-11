package Problem7CollectionHierarchy;



public class AddRemoveCollection extends Collection implements AddRemovable {




    @Override
    public String remove() {
        int index = getItems().size() - 1;
        return getItems().remove(index);

    }

    @Override
    public int add(String item) {
        super.getItems().add(0 , item);
        return 0;
    }

    protected static void removal(int operations, AddRemovable removeCollection) {

        while (operations-- > 0) {
            System.out.print(removeCollection.remove() + " ");
        }
        System.out.println();
    }
}
