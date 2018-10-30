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

public class MyStepdefsMenu {
    WebDriver webDr;

    @Given("^The user goes on the PetClinic Site$")
    public void theUserGoesOnThePetClinicSite() throws Throwable {
        webDr = new ChromeDriver();
        webDr.get("http://bhdtest.endava.com/petclinic/");
        webDr.manage().window().maximize();
        webDr.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
    }

    @When("^The user clicks on the SpringTab$")
    public void theUserClicksOnTheSpringTab() throws Throwable {
        webDr.findElement(By.xpath("//a[@class='navbar-brand']//span")).click();
    }

    @When("^The user clicks on the HomeTab$")
    public void theUserClicksOnTheHomeTab() throws Throwable {
        webDr.findElement(By.xpath("//a[@title='home page']")).click();
    }

    @Then("^The home page is displayed$")
    public void theHomePageIsDisplayed() throws Throwable {
        Assert.assertTrue(webDr.findElement(By.xpath("//h2[contains(text(),'Welcome')]")).isDisplayed());
        webDr.quit();
    }

    @When("^The user clicks on the OwnersTab$")
    public void theUserClicksOnTheOwnersTab() throws Throwable {
        webDr.findElement(By.xpath("//a[text()='Owners']")).click();
    }

    @Then("^A dropdownlist for owners with All and Add New Buttons is displayed$")
    public void aDropdownlistForOwnersWithAllAndAddNewButtonsIsDisplayed() throws Throwable {
        Assert.assertTrue(webDr.findElement(By.xpath("//li[@class='dropdown open']//ul[@class='dropdown-menu']")).isDisplayed());
        webDr.quit();
    }

    @When("^The user clicks on the VeterinariansTab$")
    public void theUserClicksOnTheVeterinariansTab() throws Throwable {
        webDr.findElement(By.xpath("//a[text()='Veterinarians']")).click();
    }
    
    @Then("^A dropdownlist for vets with All and Add New Buttons is displayed$")
    public void aDropdownlistForVetsWithAllAndAddNewButtonsIsDisplayed() throws Throwable {
        Assert.assertTrue(webDr.findElement(By.xpath("//li[@class='dropdown open']//ul[@class='dropdown-menu']")).isDisplayed());
        webDr.quit();
    }

    @When("^The user clicks on the PetTypesTab$")
    public void theUserClicksOnThePetTypesTab() throws Throwable {
        webDr.findElement(By.xpath("//a[@title='pettypes']")).click();
    }

    @Then("^The PetType page is displayed$")
    public void thePetTypePageIsDisplayed() throws Throwable {
        Assert.assertTrue(webDr.findElement(By.xpath("//h2[contains(text(),'Pet Types')]")).isDisplayed());
        webDr.quit();
    }

    @When("^The user clicks on the SpecialtiesTab$")
    public void theUserClicksOnTheSpecialtiesTab() throws Throwable {
        webDr.findElement(By.xpath("//a[@title='specialties']")).click();
    }

    @Then("^The Specialties page is displayed$")
    public void theSpecialtiesPageIsDisplayed() throws Throwable {
        Assert.assertTrue(webDr.findElement(By.xpath("//h2[contains(text(),'Specialties')]")).isDisplayed());
        webDr.quit();
    }
}
