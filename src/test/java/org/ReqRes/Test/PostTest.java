package org.ReqRes.Test;

import org.ReqRes.Base.BaseClass;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;  //for validation

public class PostTest extends BaseClass {
    @Test
    public void post(){
       given()
               .header("Content-Type" ,"application/json")
               .body("{\n" +
                       "    \"name\": \"morpheus\",\n" +
                       "    \"job\": \"leader\"\n" +
                       "}")
               .when()
                .post("https://reqres.in/api/users")
        //.then().log().all();
             //  .then().log().body().toString();
               .then().assertThat().statusCode(201).log().all();

    }
    // using Json Object
    @Test
    public void postJson()
    {
        JSONObject ref=new JSONObject();
        //ref.put("name","Lakshmi");
        ref.put("name","morpheus");
        ref.put("job","leader");

        Response res=given()
                .header("Content-Type" ,"application/json")
                .body(ref.toString())
                .when()
                .post("https://reqres.in/api/users")
               // .then().extract().response();
                       .then().assertThat().body("name",equalTo("morpheus")).extract().response();

        System.out.println(res.body().asPrettyString());
        System.out.println(res.statusCode());

    }




}
