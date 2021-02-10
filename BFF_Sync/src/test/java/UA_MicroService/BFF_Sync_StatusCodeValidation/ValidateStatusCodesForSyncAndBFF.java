package UA_MicroService.BFF_Sync_StatusCodeValidation;

import static io.restassured.RestAssured.given;

import org.apache.log4j.Logger;

import UA_MicroService.BFF_Sync_EndPoints.EndPointUrls;
import UA_MicroService.BFF_Sync_Logger.LogHelper;
import UA_MicroService.BFF_Sync_TestBase.TestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class ValidateStatusCodesForSyncAndBFF extends TestBase {
	public static final Logger log = LogHelper.getLogger(ValidateStatusCodesForSyncAndBFF.class);
	public static ValidatableResponse vrespBFF;
	public static ValidatableResponse vrespSync;

	public static String bffEndPoint() {
		return EndPointUrls.bffAPI;
	}

	public static String syncEndPoint() {
		return EndPointUrls.syncAPI;
	}

	public static Response getResponceFromService_Get(String endPoint) {
		return given().get(endPoint);
	}

	public static int invokeSyncServiceToGetStatusCode(String endPointSync) {
		return getResponceFromService_Get(endPointSync).getStatusCode();
	}

	public static int invokeBFFServiceToGetStatusCode(String endPointBFF) {
		return getResponceFromService_Get(endPointBFF).getStatusCode();
	}

	public static String getBFFStatusCodeValidation(String endPointBFF) {
		log.info("Validation of Status Code for BFF get service is invoked.");
		logExtentReport("Validation of Status Code for BFF get service is invoked.");
		vrespBFF = given().when().get(endPointBFF).then().assertThat().statusCode(200).and()
				.contentType(ContentType.JSON);
		return vrespBFF.extract().asString();
	}

	public static String getSyncStatusCodeValidation(String endPointSync) {
		log.info("Validation of Status Code and status Linefor Sync get service is invoked.");
		logExtentReport("Validation of Status Code and status Linefor Sync get service is invoked.");
		ValidatableResponse vrespSync = given().when().get(endPointSync).then().assertThat().statusCode(200).and()
				.contentType(ContentType.JSON);
		return vrespSync.extract().asString();
	}
}
