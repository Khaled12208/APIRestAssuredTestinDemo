import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.Assert;

import file.payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class Demo {

    /************************** Global Variables ********************************/
    protected static String PlaceID;
    protected static String Newadd;

    /************************** main application ******************************/
    public static void main(String arh[]) {

	// add place to the Maps
	AddPlaceFun();
	// update place to the Maps
	Newadd = "Cairo,Egypt";
	UpdatePlaceFun(Newadd);

	// get the address
	String updtaedText = GetPlaceFun();
	Assert.assertEquals(updtaedText, Newadd);
    }

    /************************** Methods ***************************************/

    // perfome adding new place
    protected static void AddPlaceFun() {

	RestAssured.baseURI = "https://rahulshettyacademy.com";
	String Response = given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
		.body(payload.AddPlace()).when().post("/maps/api/place/add/json").then().assertThat().statusCode(200)
		.body("scope", equalTo("APP")).header("Server", equalTo("Apache/2.4.18 (Ubuntu)")).extract().response()
		.asString();
	// for parsing json
	JsonPath jason = new JsonPath(Response);
	PlaceID = jason.getString("place_id");
	System.out.println("place ID is : " + PlaceID);

    }
    // perfome updating new place

    protected static void UpdatePlaceFun(String Newadd) {

	RestAssured.baseURI = "https://rahulshettyacademy.com";
	given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
		.body(payload.UpdatePlace(PlaceID, Newadd)).when().put("/maps/api/place/update/json").then()
		.assertThat().statusCode(200).body("msg", equalTo("Address successfully updated"));
    }

    protected static String GetPlaceFun() {

	RestAssured.baseURI = "https://rahulshettyacademy.com";
	String Response = given().log().all().queryParam("key", "qaclick123").queryParam("place_id", PlaceID).when()
		.put("/maps/api/place/get/json").then().assertThat().statusCode(200).extract().body().asString();

	JsonPath jason = new JsonPath(Response);
	String actualaddress = jason.getString("address");

	return actualaddress;

    }

}
