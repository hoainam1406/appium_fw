package pages;

import org.openqa.selenium.By;

public class SearchResultPage extends GeneralPage {

    private final By lstBookItem = By.id("com.goodreads:id/list_item_book");
    private final By btnWantToRead = By.id("com.goodreads:id/wtr_currentStatus");
    private final By lblCheckMark = By.id("com.goodreads:id/wtr_checkmark");

    public String getBookDescription() {
        waitForElementVisibility(lstBookItem);
        return getElement(lstBookItem).getAttribute("content-desc");
    }

    public void clickWantToRead() {
        waitForElementToBeClickable(btnWantToRead);
        click(btnWantToRead);
    }

    public boolean doesBookMarkedWantToRead() {
        return isVisible(lblCheckMark);
    }
}
