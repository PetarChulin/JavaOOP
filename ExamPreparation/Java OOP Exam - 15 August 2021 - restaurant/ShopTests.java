package shopAndGoods;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertNull;

public class ShopTests {

    private Map<String, Goods> shelves;
    private Goods good;
    private Shop shop;

    @Before
    public void setShop() {
        shop = new Shop();
        shelves = new HashMap<>();
        good = new Goods("Bread" , "0001");

    }
    @Test
    public void testForGoodName () {
        Assert.assertEquals("Bread" , good.getName());
    }
    @Test
    public void testForGoodCode() {
        Assert.assertEquals("0001" , good.getGoodsCode());
    }
    @Test (expected = UnsupportedOperationException.class)
    public void testForChangingCollection () {
        shop.getShelves().clear();
    }
    @Test
    public void testRemovedGoodsInShelveValueIsNull() throws OperationNotSupportedException {

        shop.addGoods("Shelves1", good);
        shop.removeGoods("Shelves1", good);
        Goods empty = shop.getShelves().get("Shelves1");
        Assert.assertNull(empty);
    }
    @Test (expected = IllegalArgumentException.class)
    public void testForNonExistingShelf () throws OperationNotSupportedException {
        shop.addGoods("Shelf" , good);
    }
    @Test (expected = IllegalArgumentException.class)
    public void testForExistingShelf () throws OperationNotSupportedException {
        Goods good1 = new Goods("Beer"  , "0002");
        shop.addGoods("Shelves11" , good);
        shop.addGoods("Shelves11" , good1);
    }
    @Test (expected = OperationNotSupportedException.class)
    public void testForExistingGoods () throws OperationNotSupportedException {

        shop.addGoods("Shelves11" , good);
        shop.addGoods("Shelves12" , good);
    }
    @Test
    public void testApprovalForAddingOfGood() throws OperationNotSupportedException {
        String added = shop.addGoods("Shelves1" , good);

        Assert.assertEquals(added , "Goods: 0001 is placed successfully!");
    }
    @Test (expected = IllegalArgumentException.class)
    public void testForRemoveGoodsFromNonExistingShelf () throws OperationNotSupportedException {
        shop.addGoods("Shelves11" , good);
        shop.removeGoods("Shelf" , good);
    }
    @Test (expected = IllegalArgumentException.class)
    public void testForRemovalOfNonExistingGoodsFromShelf () {
        shop.removeGoods("Shelves11" , good);
    }

    @Test
    public void testForRemovalApproval() throws OperationNotSupportedException {
        shop.addGoods("Shelves1", good);
        String remove = shop.removeGoods("Shelves1", good);
        Assert.assertEquals(remove , "Goods: 0001 is removed successfully!");
    }
}