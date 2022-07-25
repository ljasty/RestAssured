package org.ReqRes.Test;

import org.ReqRes.Base.BaseClass;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PutMethod  extends BaseClass {
    @Test
    public void put() {
        given()
                .header("Content-Type", "application/json")
                .body("{\n" +
                        "    \"name\": \"morpheus\",\n" +
                        "    \"job\": \"zion resident\"\n" +
                        "}")
                .when()
                .put("https://reqres.in/api/users/2")
                //.then().log().all();
                //  .then().log().body().toString();
                .then().assertThat().statusCode(200).log().all();

    }

    @Test
    void putJson() {
        JSONObject ref = new JSONObject();
        //ref.put("name","Lakshmi");
        ref.put("name", "morpheus");
        ref.put("job", "zion resident");

        Response res = given()
                .header("Content-Type", "application/json")
                .body(ref.toString())
                .when()
                .post("https://reqres.in/api/users/2")
                // .then().extract().response();
                .then().assertThat().body("name", equalTo("morpheus")).extract().response();

        System.out.println(res.body().asPrettyString());
        System.out.println(res.statusCode());

    }
}

