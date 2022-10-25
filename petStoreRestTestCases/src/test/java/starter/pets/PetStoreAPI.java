package starter.pets;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.Util.FileUtil;
import starter.model.Pet;

public class PetStoreAPI {

    private static String BASE_URL = "https://petstore.swagger.io/v2";
    private static String PET = BASE_URL + "/pet";
    private static String PET_BY_PET_ID = BASE_URL + PET +"/{petId}";
    private static String ORDER = BASE_URL + "/store/order";

    @Step("Get pet by pet {0}")
    public void fetchPetByPetId(String petid) {
        SerenityRest.given()
                .pathParam("petId", petid)
                .get(PET_BY_PET_ID);
    }

    @Step("Post a pet with name {0} and data given in file {1}")
    public Pet createAPetWithName(String petName, String fileName) throws IOException, ParseException {
        String filePath = "src/test/resources/data/"+fileName+".json";
        Object obj = FileUtil.readJsonFile(filePath);

        JSONObject jbody = (JSONObject) obj;
        jbody.put("name",petName);
        System.out.println("jbody is: "+jbody.toJSONString());
        Response response = SerenityRest.given()
                .accept("application/json")
                .contentType("application/json")
                .body(jbody.toJSONString())
                .post(PET);
        Integer petId = response.jsonPath().get("id");    
        return Pet.builder()
                    .petId(petId)
                    .petName(petName)
                    .build();
    }

    @Step("Buy a pet with data given in file {0}")
    public void orderAPet(String fileName) throws IOException, ParseException {
        String filePath = "src/test/resources/data/"+fileName+".json";
        Object obj = FileUtil.readJsonFile(filePath);

        JSONObject jbody = (JSONObject) obj;
        jbody.put("id", createAPetWithName("pet", "pet").petId);
        System.out.println("jbody is: "+jbody.toJSONString());
        SerenityRest.given()
                .accept("application/json")
                .contentType("application/json")
                .body(jbody.toJSONString())
                .post(ORDER);
    }
}
