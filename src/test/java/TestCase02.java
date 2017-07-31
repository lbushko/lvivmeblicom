import framework.pages.GroopItems;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase02 extends BaseTest {
    @Test
    public void TestCase02(){
        GroopItems groopItems = new GroopItems(driver);
        groopItems.getGroopItemsPage();
        Assert.assertEquals("Купить витрины, цены Львов - lvivmebli", driver.getTitle());
    }
}
