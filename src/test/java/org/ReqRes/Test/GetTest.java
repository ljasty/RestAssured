package org.ReqRes.Test;

import org.ReqRes.Base.BaseClass;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class GetTest extends BaseClass {

    @Test
    public void get3() {
/*  this is only for java
        Response res= RestAssured.get("https://reqres.in/api/users/2");
        System.out.println(res.asPrettyString());
        System.out.println(res.statusCode());    */

        given()
                .when()
                .get("https://reqres.in/api/users/2")
                .then()

                 .assertThat().statusCode(200).log().all();
              //  .assertThat().log().body().toString();


    }

    @Test
    public void get1() {
        Response res1 = given()
                .when()
                .get("https://reqres.in/api/users/2")
                /*  .then()
                  .assertThat().statusCode(200).log().all();
                   .assertThat().log().body().toString(); */
               .then().extract().response();
        System.out.println(res1.body().asPrettyString());

    }

    @Test

    public void delete1() {

        given()
                .when()
                  .delete("https://reqres.in/api/users/2")
                 .then()
                 .assertThat().statusCode(204);


    }
}