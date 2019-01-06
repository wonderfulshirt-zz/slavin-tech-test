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
    private WebElement searchTextBox;

    @FindBy(css = "button[name='submit']")
    private WebElement searchButton;

    @FindBy(css = "table[class='grid-layout']")
    private WebElement contactsTable;

    @FindBy(css = "span[class='records'")
    private WebElement numberOfRecordsText;

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

    public void clickNewCustomerButton() {
        clickElementWithJS(newCustomerButton);
    }

    public void clickNewSupplierButton() {
        clickElementWithJS(newSupplierButton);
    }

    public void setSearchTextBox(String text) {
        enterTextInElement(searchTextBox, text);
    }

    public void clickSearchButton() {
        clickElementWithJS(searchButton);
    }

    public List<WebElement> getContactsTableRows() {
        waitForElementToBeVisible(contactsTable);
        return contactsTable.findElements(By.xpath(".//tbody/tr"));
    }

    public WebElement getContactsTableCell(int row, int cell) {
        List<WebElement> tableRows = getContactsTableRows();
        WebElement tableRow = tableRows.get(row);
        WebElement tableRowCell = tableRow.findElement(By.xpath(".//td[" + cell + "]"));

        return tableRowCell;
    }

    public String getContactsTableCellText(int row, int cell) {
        WebElement tableCell = getContactsTableCell(row, cell);
        return tableCell.getText();
    }

    public void validateContactsTableCellText(int row, int cell, String text) {
        String tableCellText = getContactsTableCellText(row, cell);
        assertEquals(tableCellText, text);
    }

    public void waitForNumberOfRecordsTextToEqual(String text) {
        waitForElementTextToBe(numberOfRecordsText, text);
    }

    public void clickTableCell(int row, int cell) {
        clickElementWithJS(getContactsTableCell(row, cell));
    }

}
