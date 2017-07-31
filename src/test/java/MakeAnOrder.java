import framework.pages.*;
import org.junit.Assert;
import org.testng.annotations.Test;

public class MakeAnOrder extends BaseTest{

    @Test
    public void makeAnOrderTest() throws Exception{
        GroopItems groopItems = new GroopItems(driver);
        groopItems.getGroopItemsPage();
        ItemPage itempage = groopItems.goItemPage();
        CartPopUp cartPopUp = itempage.clickAddToCart();
        OrderPage orderPage = cartPopUp.clickMakeAnOrder();
        OrderSent orderSent = orderPage.enterOrderInfo();
        Assert.assertEquals("Спасибо за заказ!", orderSent.getH2());
        Assert.assertEquals("Вскоре с вами свяжется наш менеджер.", orderSent.getH2Manager());
    }
}
