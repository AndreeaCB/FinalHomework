package stepdefs;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class StepDefRestAssured {
    private RequestSpecification request;
    private Response response;

    @Given("^The user has the credentials as username: \"([^\"]*)\" and password: \"([^\"]*)\" AND wants to perform a GET request$")
    public void theUserHasTheCredetentialsAsUsernameAndPasswordANDWantsToPerformAGETRequest(String ownerUser, String ownerPass) throws Throwable {
        request = given().baseUri("http://bhdtest.endava.com:8080/petclinicSecured/api").
                auth().
                preemptive().
                basic(ownerUser, ownerPass).
                contentType(ContentType.JSON);
    }

    @When("^The user goes on the \"([^\"]*)\"$")
    public void theUserGoesOnThe(String path) throws Throwable {
        response = request.when().get(path);
    }

    @Then("^The status will be \"([^\"]*)\"$")
    public void theStatusWillBe(int statusCode) throws Throwable {
        response.then().statusCode(statusCode);
        System.out.println(response.asString());
    }

    @Given("^The user wants a POST request by filling with the vets credentials as username: \"([^\"]*)\" and password: \"([^\"]*)\"$")
    public void theUserWantsAPOSTRequestWithTheVetsCredentialsAsUsernameAndPassword(String user, String pass) throws Throwable {
        request = given().baseUri("http://bhdtest.endava.com:8080/petclinicSecured/api").
                auth().
                preemptive().
                basic(user, pass).
                body("{\"id\": 101," +
                        "    \"firstName\": \"ACBJustAdded\"," +
                        "    \"lastName\": \"Meeee\"," +
                        "    \"specialties\": []}").
                contentType(ContentType.JSON);
    }

    @When("^The user performs a post request to \"([^\"]*)\"$")
    public void theUserPerformsAPutRequestTo(String path) throws Throwable {
        response = request.when().post(path);
    }

    @Given("^The user wants a DELETE request by filling with the credentials for owner as username: \"([^\"]*)\" and password: \"([^\"]*)\"$")
    public void theUserWantsADELETERequestByFillingWithTheCredentialsForOwnerAsUsernameAndPassword(String user, String pass) throws Throwable {
        request = given().baseUri("http://bhdtest.endava.com:8080/petclinicSecured/api").
                auth().
                preemptive().
                basic(user, pass).
                pathParam("ownerId", 2).
                contentType(ContentType.JSON);
    }

    @When("^The user performs a DELETE request to \"([^\"]*)\"$")
    public void theUserPerformsADELETERequestTo(String path) throws Throwable {
        response = request.when().delete(path);
    }
}
