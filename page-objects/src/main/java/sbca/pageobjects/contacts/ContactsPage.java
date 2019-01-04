package sbca.pageobjects.contacts;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import sbca.framework.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

public class ContactsPage extends BasePage {

    @FindBy(css = "h1[contains(text(), 'Contacts')]")
    private WebElement pageTitle;

    @FindBy(id = "filter_search_text")
    private WebElement searchBox;

    @FindBy(css = "button[name='submit']")
    private WebElement searchButton;

    @FindBy(css = "table[class='grid-layout']")
    private WebElement contactsTable;

    @FindBy(css = "span[class='records'")
    private WebElement numberOfContacts;

    @FindBy(css = "a[data-role='primary_action']")
    private WebElement newCustomerButton;

    @FindBy(css = "a[data-role='new_vendor']")
    private WebElement newSupplierButton;

    public ContactsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isInitialized() {
        return newCustomerButton.isDisplayed();
    }

    public void enterSearchText(String text) {
        waitForElementToBeVisible(searchBox);
        searchBox.clear();
        searchBox.sendKeys(text);
    }

    public void clickSearchButton() {
        waitForElementToBeVisible(searchButton);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", searchButton);
    }

    public List<WebElement> getContactsTableRows() {
        waitForElementToBeVisible(contactsTable);
        return contactsTable.findElements(By.xpath(".//tr"));
    }

    public String getContactsTableCellText(int row, int cell) {
        List<WebElement> tableRows = getContactsTableRows();
        WebElement tableRow = tableRows.get(row);
        WebElement tableRowCell = tableRow.findElement(By.xpath(".//td[" + cell + "]"));
        return tableRowCell.getText();
    }

    public void checkContactsTableCellText(int row, int cell, String expectedText) {
        String cellText = getContactsTableCellText(row, cell);
        assertEquals(cellText, expectedText);
    }

    public int getNumberOfContactsInTable() {
        waitForElementToBeVisible(numberOfContacts);
        String recordsText = numberOfContacts.getText();
        int numberOfRecords = Integer.parseInt(recordsText);

        return numberOfRecords;
    }

    public void waitForNumberOfContactsInTableToEqual(String text) {
        wait.until(ExpectedConditions.textToBePresentInElement(numberOfContacts, text));
    }

    public void clickNewCustomerButton() {
        waitForElementToBeVisible(newCustomerButton);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", newCustomerButton);
    }

    public void clickNewSupplierButton() {
        waitForElementToBeVisible(newSupplierButton);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", newSupplierButton);
    }

}
