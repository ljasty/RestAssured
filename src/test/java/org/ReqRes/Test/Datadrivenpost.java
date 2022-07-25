package org.ReqRes.Test;

import io.restassured.response.Response;
import org.ReqRes.Base.BaseClass;
import org.ReqRes.Util.ExcelUtils;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Datadrivenpost extends BaseClass {
@Test
    public void postDataDriven()

    {
       String excelPath="/Users/lakshmiguntupalli/IdeaProjects/RestAssured/src/test/Data/RestassuredTestData.xlsx";
        // String excelPath = " ./Data/RestassuredTestData.xlsx";
        String sheetName = "Sheet1";
        ExcelUtils excel = new ExcelUtils(excelPath,sheetName);

       int row  = excel.getRowcount();
        JSONObject ref = new JSONObject();

           for(int i=0;i<row;i++) {
               ref.put("name", excel.getCellData(i, 0));
               ref.put("job", excel.getCellData(i, 1));

               Response res = given()
                       .header("Content-Type", "application/json")
                       .body(ref.toString())
                       .when()
                       .post("https://reqres.in/api/users")
                       .then().extract().response();
               //.then().assertThat().body("name", equalTo("morpheus")).extract().response();

               System.out.println(res.body().asPrettyString());
               System.out.println(res.statusCode());
           }
    }
}