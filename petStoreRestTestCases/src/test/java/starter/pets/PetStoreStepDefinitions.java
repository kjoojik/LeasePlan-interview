package starter.pets;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;

import org.json.simple.parser.ParseException;

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

    @Then("the response status should be {}")
    public void theResponseStatusShouldBe(Integer status) {
        restAssuredThat(response -> response.statusCode(status));
    }
    @Then("the response body should contain field {} with value {}")
    public void theResponseBodyShouldContainFieldWithValue(String field, String value) {
        restAssuredThat(response -> response.body(field, equalTo(value)));
    }

    @When("I create a pet with name {word} and data given in file {word}")
    public void createAPetWithName(String name, String file) throws IOException, ParseException {
        petStoreAPI.createAPetWithName(name, file);
    }

    @When("I update a pet with name {word} and data given in file {word}")
    public void updateAPetWithName(String name, String file) throws IOException, ParseException {
        petStoreAPI.updateAPetWithName(name, file);
    }

    @When("I I upload image for a pet with pet Id {word}")
    public void uploadImageAPetWithId(String id) throws IOException, ParseException {
        petStoreAPI.uploadImageAPetWithId(id);
    }    
 
        @When("I delete a pet with id {word}")
    public void deleteAPet(String petId) throws IOException, ParseException {
        petStoreAPI.removeAPet(petId);
    }

    @When("I order a pet from the store with data given in file {word}")
    public void orderANewPetWithNameFromStore(String file) throws IOException, ParseException {
        petStoreAPI.orderAPet(file);
    }

    @When("I create user with name {word} and data given in file {word}")
    public void createAUserWithName(String name, String file) throws IOException, ParseException {
        petStoreAPI.createAUserWithName(name, file);
    }

    @When("I create user with data given in file {word}")
    public void createAUserWithDataInFile(String file) throws IOException, ParseException {
        petStoreAPI.createSimpleUSerWithDataFromFile(file);
    }
}
