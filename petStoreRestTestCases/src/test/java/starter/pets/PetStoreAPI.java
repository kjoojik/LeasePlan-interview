package starter.pets;

import io.restassured.RestAssured;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class PetStoreAPI {

    private static String PET_BY_PET_ID = "http://petstore.swagger.io/v2/pet/{petId}";

    @Step("Get pet by pet {0}")
    public void fetchPetByPetId(String petid) {
        SerenityRest.given()
                .pathParam("petId", petid)
                .get(PET_BY_PET_ID);
    }
}
