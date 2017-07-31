import framework.pages.Main;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase01 extends BaseTest {
    @Test
    public void TestCase01(){
        Main main = new Main(driver);
        main.getMain();
        Assert.assertEquals("Интернет-магазин мебели lvivmebli.com", driver.getTitle());
    }
}
