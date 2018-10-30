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

public class MyStepdefsEditVetsTests {
    WebDriver webDr;

    @Given("^The user is on the All Vets page$")
    public void theUserIsOnTheAllVetsPage() throws Throwable {
        webDr = new ChromeDriver();
        webDr.get("http://bhdtest.endava.com/petclinic/vets");
        webDr.manage().window().maximize();
        webDr.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
    }

    @When("^The user iterates through the all vets list and wants a specific vet as \"([^\"]*)\"$")
    public void theUserIteratesThroughTheAllVetsListAndWantsASpecificVetAsToBeEdited(String vetName) throws Throwable {
        List<String> vets = new ArrayList<String>();
        int poz = -1;
        for (WebElement we : webDr.findElements(By.xpath("//table/tbody/tr/td[1]"))) {
            vets.add(we.getText());
        }
        for (String name : vets) {
            if (name.contains(vetName)) {
                poz = vets.indexOf(vetName);
            }
        }
        webDr.findElements(By.xpath("//button[contains(text(),'Edit')]")).get(poz).click();
    }



    @Then("^The user clicks on the fields as fallows: firstName: \"([^\"]*)\", lastName: \"([^\"]*)\" AND chooses a favourite type AND clicks on the edit button in order to edit the vet$")
    public void theUserClicksOnTheFiledsAsFallowsFirstNameLastNameANDChoosesAFavouriteTypeANDClicksOnTheEditButtonInOrderToEditTheVet(String firstName, String lastName) throws Throwable {
        webDr.findElement(By.id("firstName")).clear();
        webDr.findElement(By.id("firstName")).sendKeys(firstName);
        webDr.findElement(By.id("lastName")).clear();
        webDr.findElement(By.id("lastName")).sendKeys(lastName);
        webDr.findElement(By.xpath("//div[@class='mat-select-arrow-wrapper']")).click();
        webDr.findElement(By.xpath("(//*[contains(@class, 'mat-option-text')])[1]")).click();
        webDr.findElement(By.xpath("//button[contains(text(),'Save Vet')]")).click();
        webDr.quit();
    }

    @When("^The user iterates through the all vets list and wants to find a specific vet as \"([^\"]*)\" AND clicks delete on that vet$")
    public void theUserIteratesThroughTheAllVetsListAndWantsToFindASpecificVetAsANDClicksDeleteOnThatVet(String vetName) throws Throwable {
        List<String> vets = new ArrayList<String>();
        int poz = -1;
        for (WebElement we : webDr.findElements(By.xpath("//table/tbody/tr/td[1]"))) {
            vets.add(we.getText());
        }
        for (String name : vets) {
            if (name.contains(vetName)) {
                poz = vets.indexOf(vetName);
            }
        }
        webDr.findElements(By.xpath("//button[contains(text(),'Delete')]")).get(poz).click();
    }

    @Then("^The browser is searching for the vet called \"([^\"]*)\" and if it doesn't find it, it shuts down$")
    public void theBrowserIsSearchingForTheVetCalledAndIfItDoesnTFindItItShutsDown(String vetName) throws Throwable {
        Assert.assertFalse(webDr.findElements(By.xpath("//table/tbody/tr/td[1]")).contains(vetName));
        webDr.quit();


    }
}
