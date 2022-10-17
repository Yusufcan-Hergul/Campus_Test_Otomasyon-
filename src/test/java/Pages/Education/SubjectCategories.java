package Pages.Education;


import Utils.DriverManager;
import lombok.experimental.FieldNameConstants;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SubjectCategories {
    public SubjectCategories(){
        PageFactory.initElements(DriverManager.getDriver(),this);
    }
    @FindBy(xpath = "//ms-add-button[contains(@tooltip,'TITLE.ADD')]//button")
    public WebElement addButton;

    @FindBy(css = "ms-text-field[formcontrolname='name'] > input")
    public WebElement nameInput;

    @FindBy(css = "ms-text-field[formcontrolname='code'] > input")
    public WebElement codeInput;

    @FindBy(xpath = "//ms-save-button//button")
    public WebElement saveButton;

    @FindBy(css = "ms-edit-button button")
    public WebElement editButton;

    @FindBy(xpath = "//ms-text-field[contains(@placeholder,'NAME')]//input")
    public WebElement searchBar;

    @FindBy(xpath = "//ms-search-button//button")
    public WebElement searchButton;

    @FindBy(xpath = "//div[contains(text(),'successfully')]")
    public WebElement successMessage;

    @FindBy(css = "ms-delete-button button")
    public WebElement deleteButton;

    @FindBy(xpath = "//ms-text-field[contains(@placeholder,'CODE')]//input")
    public WebElement searchCode;

    @FindBy(css = "tbody [class*='mat-no-data-row']")
    public List<WebElement> searchResultNoMatch;

    @FindBy(css = "button[type='submit']")
    public WebElement submitDelete;



}
