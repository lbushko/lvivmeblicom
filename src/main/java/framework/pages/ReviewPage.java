package framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReviewPage extends BasePage {

    public ReviewPage(WebDriver driver){
        super(driver);
    }

    private WebElement writeReviewButton;

    By reviewButton = By.cssSelector("body > section > div > section > section > div > div > div > div.catalog_box > div.ch_tit_place.fm > a");

    private WebElement nameField;

    By nameFieldLocator = By.id("write_rev_name");

    private WebElement comment;

    By commentLocator = By.id("write_rev_text");

    private WebElement sentComment;

    By sentCommentLocator = By.cssSelector("#review_form > div.box-r.fm > a.common_but.submit");

    private WebElement ourComment;

    By ourCommentLocator = By.xpath("//*[@id=\"reviews_list\"]/div[last()]/div[@class='fmr or_txt']");

    private WebElement ourName;

    By ourNameLocator = By.xpath("//*[@id=\"reviews_list\"]/div[last()]/div[@class='or_author fm']");

    private WebElement ourTime;

    By ourTimeLocator = By.xpath("//*[@id=\"reviews_list\"]/div[last()]/div[@class='or_date fm']");

    WebDriverWait wait = new WebDriverWait(driver, 10);

    public void clickWriteReviewButton(){

        writeReviewButton = wait.until(ExpectedConditions.elementToBeClickable(reviewButton));
        writeReviewButton.click();
    }

    public void writeComment(String name, String commentText){

        nameField = wait.until(ExpectedConditions.presenceOfElementLocated(nameFieldLocator));
        nameField.clear();
        nameField.sendKeys(name);

        comment = wait.until(ExpectedConditions.presenceOfElementLocated(commentLocator));
        comment.clear();
        comment.sendKeys(commentText);

        sentComment = wait.until(ExpectedConditions.elementToBeClickable(sentCommentLocator));
        sentComment.click();
    }

    public String getOurComment(){
        ourComment = wait.until(ExpectedConditions.presenceOfElementLocated(ourCommentLocator));
        return ourComment.getAttribute("innerText");
    }

    public String getOurName(){
        ourName = wait.until(ExpectedConditions.presenceOfElementLocated(ourNameLocator));
        return ourName.getAttribute("innerText");
    }

    public String getTime(){
        ourTime = wait.until(ExpectedConditions.presenceOfElementLocated(ourTimeLocator));
        return ourTime.getAttribute("innerText");
    }

}
