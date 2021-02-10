package UA_MicroService.BFF_Sync_StepDefinations;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import UA_MicroService.BFF_Sync_Logger.LogHelper;
import UA_MicroService.BFF_Sync_StatusCodeValidation.ValidateStatusCodesForSyncAndBFF;
import UA_MicroService.BFF_Sync_TestBase.TestBase;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StatusCodeStepDefination extends TestBase {
	public static final Logger log = LogHelper.getLogger(StatusCodeStepDefination.class);

	@Test
	@Given("^the endpoint of BFF services$")
	public void the_endpoint_of_BFF_services() throws Throwable {
		log.info("Reading BFF API end point.");
		logExtentReport("Reading BFF API end point.");
		ValidateStatusCodesForSyncAndBFF.bffEndPoint();
	}

	@Test
	@Given("^the endpoint of Sync services$")
	public void the_endpoint_of_Sync_services() throws Throwable {
		log.info("Reading BFF Sync end point.");
		logExtentReport("Reading Sync API end point.");
		ValidateStatusCodesForSyncAndBFF.syncEndPoint();
	}

	@Test
	@When("^user invokes the BFF endPoint successfully$")
	public static void user_invokes_the_BFF_endPoint_successfully() throws Throwable {

		Assert.assertEquals(200, ValidateStatusCodesForSyncAndBFF
				.invokeBFFServiceToGetStatusCode(ValidateStatusCodesForSyncAndBFF.bffEndPoint()));
		log.info("BFF Service " + ValidateStatusCodesForSyncAndBFF.bffEndPoint() + " is invoked.");
		logExtentReport("BFF Service " + ValidateStatusCodesForSyncAndBFF.bffEndPoint() + " is invoked.");
	}

	@Test
	@When("^user invokes the sync endPoint successfully$")
	public static void user_invokes_the_sync_endPoint_successfully() throws Throwable {
		Assert.assertEquals(200, ValidateStatusCodesForSyncAndBFF
				.invokeSyncServiceToGetStatusCode(ValidateStatusCodesForSyncAndBFF.syncEndPoint()));
		log.info("Sync Service " + ValidateStatusCodesForSyncAndBFF.syncEndPoint() + " is invoked.");
		logExtentReport("Sync Service " + ValidateStatusCodesForSyncAndBFF.syncEndPoint() + " is invoked.");
	}

	@Test
	@Then("^User should get status code as (\\d+) for Sync service$")
	public static void user_should_get_status_code_as_for_Sync_service(int arg1) throws Throwable {
		ValidateStatusCodesForSyncAndBFF.getSyncStatusCodeValidation(ValidateStatusCodesForSyncAndBFF.bffEndPoint());
		log.info("Status code " + arg1 + " of Sync service is validated successfully.");
		logExtentReport("Status code " + arg1 + " of Sync service is validated successfully.");
	}

	@Test
	@Then("^User should get status code as (\\d+) for BFF service$")
	public static void user_should_get_status_code_as_for_BFF_service(int arg1) throws Throwable {
		ValidateStatusCodesForSyncAndBFF.getBFFStatusCodeValidation(ValidateStatusCodesForSyncAndBFF.syncEndPoint());
		log.info("Status code " + arg1 + " of BFF service is validated successfully.");
		logExtentReport("Status code " + arg1 + " of BFF service is validated successfully.");
	}

}
