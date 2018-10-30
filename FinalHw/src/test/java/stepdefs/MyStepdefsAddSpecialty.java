package stepdefs;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MyStepdefsAddSpecialty {
    WebDriver webDr;

    @Given("^The user is on the petclinic site$")
    public void theUserIsOnThePetclinicSite() throws Throwable {
        webDr = new ChromeDriver();
        webDr.get("http://bhdtest.endava.com/petclinic/");
        webDr.manage().window().maximize();
        webDr.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
    }

    @When("^The user wants to access the Specialties tab$")
    public void theUserWantsToAccesTheSpecialtiesTab() throws Throwable {
        webDr.findElement(By.linkText("SPECIALTIES")).click();
    }

    @Then("^The specified page is displayed$")
    public void theSpecifiedPageIsDisplayed() throws Throwable {
        Assert.assertTrue(webDr.findElement(By.xpath("//h2[contains(text(),'Specialties')]")).isDisplayed());
        webDr.quit();
    }

    @Given("^The user is on the specialties page$")
    public void theUserIsOnTheSpecialtiesPage() throws Throwable {
        webDr = new ChromeDriver();
        webDr.get("http://bhdtest.endava.com/petclinic/specialties");
        webDr.manage().window().maximize();
        webDr.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
    }

    @When("^The user presses click on the add specialty button and fills the name field as \"([^\"]*)\"$")
    public void theUserPressesClickOnTheAddSpecialtyButtonAndFillsTheNameFieldAs(String newSpecialty) throws Throwable {
        webDr.findElement(By.xpath("//button[contains(text(),'Add')]")).click();
        webDr.findElement(By.id("name")).sendKeys(newSpecialty);
    }

    @Then("^the user clicks on the save button$")
    public void theUserClicksOnTheSaveButton() throws Throwable {
        webDr.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
        Assert.assertTrue(webDr.findElement(By.xpath("//button[contains(text(),'Save')]")).isDisplayed());
        webDr.quit();
    }

}
