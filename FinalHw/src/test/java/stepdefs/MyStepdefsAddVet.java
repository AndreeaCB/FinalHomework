package stepdefs;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class MyStepdefsAddVet {
    WebDriver webDr;
    
    @Given("^The user goes on Pet Clinic Site$")
    public void theUserGoesOnPetClinicSite() throws Throwable {
        webDr = new ChromeDriver();
        webDr.get("http://bhdtest.endava.com/petclinic/");
        webDr.manage().window().maximize();
        webDr.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
    }

    @When("^The user clicks on the Add New Owner Button$")
    public void theUserClicksOnTheAddNewOwnerButton() throws Throwable {
        webDr.findElement(By.xpath("//a[text()='Veterinarians']")).click();
        webDr.findElement(By.xpath("(//span[text()=' Add New'])[2]")).click();
    }

    @Then("^The add vet page should be displayed$")
    public void theAddVetPageShouldBeDisplayed() throws Throwable {
        Assert.assertTrue(webDr.findElement(By.xpath("//h2[contains(text(),'New Veterinarian')]")).isDisplayed());
        webDr.quit();
    }

    @Given("^The user is on the Add New Vet page$")
    public void theUserIsOnTheAddNewVetPage() throws Throwable {
        webDr = new ChromeDriver();
        webDr.get("http://bhdtest.endava.com/petclinic/vets/add");
        webDr.manage().window().maximize();
        webDr.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
    }

    @When("^The user fills the fields as firstName: \"([^\"]*)\", lastName: \"([^\"]*)\" AND clicks on Type field AND chooses a type from the dropdown list$")
    public void theUserFillsTheFieldsAsFirstNameLastNameANDClicksOnTypeFieldANDChoosesATypeFromTheDropdownList(String firstname, String lastname) throws Throwable {
        webDr.findElement(By.id("firstName")).sendKeys(firstname);
        webDr.findElement(By.id("lastName")).sendKeys(lastname);
        webDr.findElement(By.id("specialties")).click();
        webDr.findElement(By.xpath("//option[@value= \"0: Object\"]")).click();
    }

    @Then("^The Save button should be pressed$")
    public void theSaveButtonShouldBePressed() throws Throwable {
        webDr.findElement(By.xpath("//button[contains(text(),'Save Vet')]")).click();
        Assert.assertTrue(webDr.findElement(By.xpath("//button[contains(text(),'Save Vet')]")).isDisplayed());
        webDr.quit();
    }

    @Then("^An error message should be displayed AND the save button can be pressed$")
    public void anErrorMessageShouldBeDisplayedANDTheSaveButtonCanBePressed() throws Throwable {
        Assert.assertTrue(webDr.findElement(By.xpath("//span[contains(text(),'First name must be at least 2 characters long')]")).isDisplayed());
        webDr.findElement(By.xpath("//button[contains(text(),'Save Vet')]")).click();
        webDr.quit();
    }

    @Then("^An error message should be displayed for the last name field AND the save button can be pressed$")
    public void anErrorMessageShouldBeDisplayedForTheLastNameFieldANDTheSaveButtonCanBePressed() throws Throwable {
        Assert.assertTrue(webDr.findElement(By.xpath("//span[contains(text(),'Last name must be at least 2 characters long')]")).isDisplayed());
        webDr.findElement(By.xpath("//button[contains(text(),'Save Vet')]")).click();
        webDr.quit();
    }

    @When("^The user fills the fields as firstName: \"([^\"]*)\", lastName: \"([^\"]*)\" and no clicks on the type field$")
    public void theUserFillsTheFieldsAsFirstNameLastNameAndNoClicksOnTheTypeField(String firstname, String lastname) throws Throwable {
        webDr.findElement(By.id("firstName")).sendKeys(firstname);
        webDr.findElement(By.id("lastName")).sendKeys(lastname);
    }

    @Then("^The Save button cannot make the action to save$")
    public void theSaveButtonCannotMakeTheActionToSave() throws Throwable {
        Assert.assertTrue(webDr.findElement(By.xpath("//button[contains(text(),'Save Vet')]")).isSelected());
        webDr.quit();
    }
}
