import framework.pages.Main;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MainPageTest extends BaseTest{

//    @Test //TODO not working
//    public void menuTest() {
//        Main main = new Main(driver);
////        main.getMain();
//        main.clickMenu();
//    }

    @Test
    public void loginTest() throws Exception{
        String email = "lybomur.bushko@gmail.com";
        String password = "a13fg7h11";
        Main main = new Main(driver);
        main.getMain();
        main.getLogin(email,password);
        Thread.sleep(1000);
        Assert.assertEquals("Заказы", driver.getTitle());
    }

    @Test
    public void checkPhones(){
        String phoneMTS = "0660579364";
        String phoneKyivstar = "0685525464";
        String phoneLife = "0933053964";

        Main main = new Main(driver);
        main.getMain();

        String arr[] = main.getPhones();

        Assert.assertEquals(phoneMTS, arr[0]);
        Assert.assertEquals(phoneKyivstar, arr[1]);
        Assert.assertEquals(phoneLife, arr[2]);
    }
}
