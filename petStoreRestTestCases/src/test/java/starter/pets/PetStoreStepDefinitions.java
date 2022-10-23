package starter.pets;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;

public class PetStoreStepDefinitions {

    @Steps
    PetStoreAPI petStoreAPI;

    @When("I look up a pet by {word}")
    public void lookUpAPet(String petid) {
        petStoreAPI.fetchPetByPetId(petid);
    }

    @Then("the resulting location for pet should be {}")
    public void theResultingLocationForPetShouldBe(String name) {
        restAssuredThat(response -> response.statusCode(200));
        restAssuredThat(response -> response.body(LocationResponse.PET_NAME, equalTo(name)));
    }
}
