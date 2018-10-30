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

public class MyStepdefsAddOwner {
    WebDriver webDr;

    @Given("^The user goes to the Pet Clinic Site$")
    public void theUserGoesToThePetClinicSite() throws Throwable {
        webDr = new ChromeDriver();
        webDr.get("http://bhdtest.endava.com/petclinic/");
        webDr.manage().window().maximize();
        webDr.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
    }

    @When("^The user clicks on  Add New Owner Button$")
    public void theUserClicksOnAddNewOwnerButton() throws Throwable {
        webDr.findElement(By.xpath("//a[text()='Owners']")).click();
        webDr.findElement(By.xpath("//a[@routerlink='/owners/add']")).click();
    }

    @Then("^The new owners page should be displayed$")
    public void theNewOwnersPageShouldBeDisplayed() throws Throwable {
        Assert.assertTrue(webDr.findElement(By.xpath("//h2[contains(text(),'New Owner')]")).isDisplayed());
        webDr.quit();
    }

    @Given("^The user is on the New Owner page$")
    public void theUserIsOnTheNewOwnerPage() throws Throwable {
        webDr = new ChromeDriver();
        webDr.get("http://bhdtest.endava.com/petclinic/owners/add");
        webDr.manage().window().maximize();
        webDr.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
    }

    @When("^The user completes the form by filling all the required fields as firstname: \"([^\"]*)\", lastname: \"([^\"]*)\", address: \"([^\"]*)\", city:\"([^\"]*)\", telephone:\"([^\"]*)\"$")
    public void theUserCompletesTheFormByFillingAllTheRequiredFieldsAsFirstnameLastnameAddressCityTelephone(String firstname, String lastname, String address, String city, String tel) throws Throwable {
        webDr.findElement(By.id("firstName")).sendKeys(firstname);
        webDr.findElement(By.id("lastName")).sendKeys(lastname);
        webDr.findElement(By.id("address")).sendKeys(address);
        webDr.findElement(By.id("city")).sendKeys(city);
        webDr.findElement(By.id("telephone")).sendKeys(tel);
    }

    @Then("^The new owner is created AND the owner as \"([^\"]*)\" exists on the All Owners page$")
    public void theNewOwnerIsCreatedANDTheOwnerAsExistsOnTheAllOwnersPage(String ownerName) throws Throwable {
        webDr.findElement(By.xpath("//button[@type='submit']")).click();
        List<String> textList = new ArrayList<String>();
        for(WebElement we : webDr.findElements(By.className("ownerFullName"))){
            textList.add(we.getText());
        }
        Assert.assertTrue(textList.contains(ownerName));
        webDr.quit();
    }

    @Then("^An error message is displayed$")
    public void anErrorMessageIsDisplayed() throws Throwable {
        Assert.assertTrue(webDr.findElement(By.xpath("//span[contains(text(),'Phone number only accept digits')]")).isDisplayed());
        webDr.quit();
    }


    @Then("^An error message for the firstName field is displayed$")
    public void anErrorMessageForTheFirstNameFieldIsDisplayed() throws Throwable {
        Assert.assertTrue(webDr.findElement(By.xpath("//span[contains(text(),'First name must be at least 2 characters long')]")).isDisplayed());
        webDr.quit();
    }

    @Then("^An error message for the LastName field is displayed$")
    public void anErrorMessageForTheLastNameFieldIsDisplayed() throws Throwable {
        Assert.assertTrue(webDr.findElement(By.xpath("//span[contains(text(),'Last name must be at least 2 characters long')]")).isDisplayed());
        webDr.quit();
    }

    @Then("^The AddOwner button is inactive$")
    public void theAddOwnerButtonIsInactive() throws Throwable {
        Assert.assertFalse(webDr.findElement(By.xpath("//button[@type='submit']")).isEnabled());
        webDr.quit();
    }

    @Given("^The user is on the All Owners page$")
    public void theUserIsOnTheAllOwnersPage() throws Throwable {
        webDr = new ChromeDriver();
        webDr.get("http://bhdtest.endava.com/petclinic/owners");
        webDr.manage().window().maximize();
        webDr.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
    }

    @When("^The user goes through all the owners list and asks for a specific owner as \"([^\"]*)\"$")
    public int theUserGoesThroughAllTheOwnersListAndAsksForASpecificOwnerAs(String ownerName) throws Throwable {
        List<String> textList = new ArrayList<String>();
        int poz = -1;
        for (WebElement we : webDr.findElements(By.xpath("//tbody//tr//td[1]"))) {
            textList.add(we.getText());
        }
        for (String name : textList) {
            if (name.contains(ownerName)) {
                poz = textList.indexOf(ownerName);
            }
        }
        return poz;
    }


    @Then("^The browser should say if the specified owner as \"([^\"]*)\" has pets$")
    public void theBrowserShouldSayIfTheSpecifiedOwnerAsHasPets(String ownerName) throws Throwable {
        List<String> pets = new ArrayList<String>();
        int param= theUserGoesThroughAllTheOwnersListAndAsksForASpecificOwnerAs(ownerName);
        for(WebElement pet : webDr.findElements(By.xpath("//tbody//tr//td[5]"))){
            pets.add(pet.getText());
        }
        Assert.assertEquals(pets.get(param), "");
        webDr.quit();
    }

    @Then("^The browser should find that owner as \"([^\"]*)\"$")
    public void theBrowserShouldFindThatOwnerAs(String ownerName) throws Throwable {
        List<String> textList = new ArrayList<String>();
        for (WebElement we : webDr.findElements(By.xpath("//tbody//tr//td[1]"))) {
            textList.add(we.getText());
        }
        Assert.assertTrue(textList.contains(ownerName));
        webDr.quit();
    }
}
