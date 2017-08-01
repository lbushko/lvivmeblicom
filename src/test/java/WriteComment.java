import framework.pages.Main;
import framework.pages.ReviewPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class WriteComment extends BaseTest {

    @Test
    public void writeCommentTest(){
        String comment = "test";
        String name = "test";

        SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy");

        Main main = new Main(driver);
        main.getMain();
        ReviewPage reviewPage = main.clickReviewLink();

        reviewPage.clickWriteReviewButton();
        reviewPage.writeComment(name,comment);

        Assert.assertEquals(comment, reviewPage.getOurComment());
        Assert.assertEquals(name, reviewPage.getOurName());
        Assert.assertEquals(df.format(new Date()), reviewPage.getTime());
    }
}
