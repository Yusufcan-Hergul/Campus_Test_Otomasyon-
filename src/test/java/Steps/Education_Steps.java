package Steps;

import Pages.Education.SubjectCategories;
import Pages.SideNav;
import Utils.DriverManager;
import Utils.Tools;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Education_Steps {

    SideNav sideNav =new SideNav();

    Tools wul=new Tools();
    WebDriver driver= DriverManager.getDriver();
    static String sasie;
    static String codeİnput;

    WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
    SubjectCategories sc=new SubjectCategories();

    @And("Navigate to Grade Level page")
    public void navigateToGradeLevelPage() {
        Tools.navigateToMenu(
                sideNav.Education,
                sideNav.Education_Setup,
                sideNav.Education_Setup_SubjectCategories);
        Tools.waitUntilLoading();
    }

    @When("User should be able to add Subject Categories")
    public void userShouldBeAbleToAddSubjectCategories() {
        wait.until(ExpectedConditions.elementToBeClickable(sc.addButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(sc.nameInput));
        Tools.waitPopUp();
        sc.nameInput.sendKeys("sasie");
        sc.codeInput.sendKeys("codeİnput");
        sc.saveButton.click();
        Tools.waitUntilLoading();
    }

    @Then("Subject Categories should appear in the list")
    public void subjectCategoriesShouldAppearInTheList() {
       wait.until(ExpectedConditions.elementToBeClickable(sc.searchBar)).sendKeys("sasie");
        sc.searchCode.sendKeys("codeİnput");
        sc.searchButton.click();

        Tools.waitUntilLoading();
        Assert.assertEquals(sc.searchResultNoMatch.size(),0);
    }

    @When("User should be able to edit Subject Categories")
    public void userShouldBeAbleToEditSubjectCategories() {
        wait.until(ExpectedConditions.elementToBeClickable(sc.searchBar)).sendKeys("sasie");
        sc.searchCode.sendKeys("codeİnput");
        sc.searchButton.click();
        Tools.waitUntilLoading();
        wait.until(ExpectedConditions.elementToBeClickable(sc.editButton)).click();
        Tools.waitPopUp();
        sc.nameInput.clear();
        Tools.waitUntilLoading();
        sc.nameInput.sendKeys("bomonti");
        sc.saveButton.click();
        Tools.waitUntilLoading();

    }

    @Then("position category should have changed")
    public void positionCategoryShouldHaveChanged() {
        Assert.assertEquals(sc.searchResultNoMatch,0);
    }

    @When("User should be able to delete Subject Categories")
    public void userShouldBeAbleToDeleteSubjectCategories() {
        wait.until(ExpectedConditions.elementToBeClickable(sc.searchBar)).sendKeys("bomonti");
        sc.searchCode.sendKeys("codeİnput");
        sc.searchButton.click();
        Tools.waitUntilLoading();
        sc.deleteButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(sc.submitDelete)).click();
        Tools.waitUntilLoading();


    }

    @Then("Delete message should be able to displayed successfully")
    public void deleteMessageShouldBeAbleToDisplayedSuccessfully() {
    }




}
