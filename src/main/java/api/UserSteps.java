package api;

import api.base.BurgerRestClient;
import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class UserSteps extends BurgerRestClient {

    private static final String ORDER_URI = BASE_URI + "/auth";

    @Step("Delete user info {user}")
    public ValidatableResponse delete(String token) {
        return given()
                .spec(getBaseReqSpec())
                .headers("authorization", token)
                .when()
                .delete(ORDER_URI + "/user")
                .then();
    }
}
