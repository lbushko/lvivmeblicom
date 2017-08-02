import framework.pages.GroopItems;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FilterItems extends BaseTest {

    @Test //TODO пересуває тільки на половину слайдеру
    public void fiterPriceTest(){
        GroopItems groopItems = new GroopItems(driver);
        groopItems.getGroopItemsPage();
        groopItems.setPriceFilter();
    }

    @Test
    public void sortTest() throws InterruptedException {
        GroopItems groopItems = new GroopItems(driver);
        groopItems.getGroopItemsPage();
        Assert.assertEquals("От дешевых к дорогим", groopItems.sortByPriceAsc());
        Thread.sleep(1000);
        Assert.assertEquals("От дорогих к дешевым", groopItems.sortByPriceDesc());
        Thread.sleep(1000);
        Assert.assertEquals("Популярные", groopItems.sortByPopular());
    }
}
