import framework.pages.Main;
import framework.pages.SearchResultPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchItems extends BaseTest {

    @Test
    public void searchItemsTest(){
        String item = "кресло";

        Main main = new Main(driver);
        main.getMain();

        SearchResultPage searchResultPage = main.search(item);

        for (String itemName: searchResultPage.getSearchItems()
             ) {
            Assert.assertTrue(itemName.toLowerCase().contains(item));
        }

        Assert.assertTrue(searchResultPage.searchItemCout() > 0);
    }

    @Test
    public void chechSearchItemCout(){
        String item = "кресло";

        Main main = new Main(driver);
        main.getMain();

        SearchResultPage searchResultPage = main.search(item);

        Assert.assertTrue(searchResultPage.searchItemCout() == searchResultPage.getAllItems().size());
    }
}
