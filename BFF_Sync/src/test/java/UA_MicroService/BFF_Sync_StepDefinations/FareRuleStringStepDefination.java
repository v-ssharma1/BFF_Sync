package UA_MicroService.BFF_Sync_StepDefinations;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import UA_MicroService.BFF_Sync_FareRuleBFFValidation.FareRuleStringFromSyncAndBFF;
import UA_MicroService.BFF_Sync_Logger.LogHelper;
import UA_MicroService.BFF_Sync_TestBase.TestBase;
import cucumber.api.java.en.Then;

public class FareRuleStringStepDefination extends TestBase {
	public static final Logger log = LogHelper.getLogger(FareRuleStringStepDefination.class);
	@Test
	@Then("^User should get the farerule string from /Sync service$")
	public static void user_should_get_the_farerule_string_from_Sync_service() throws Throwable {
		log.info("Farerule string from /Sync service : " + FareRuleStringFromSyncAndBFF.getFareRuleFromSync());
		logExtentReport("Farerule string from /Sync service : " + FareRuleStringFromSyncAndBFF.getFareRuleFromSync());
	}
    
	@Then("^User should get the farerule string from /BFF service$")
	@Test
	public static void user_should_get_the_farerule_string_from_BFF_service() throws Throwable {
		log.info("Number of components in FareCalculation list is: "
				+ FareRuleStringFromSyncAndBFF.getFareCalculationArraySizeFromBFF());
		logExtentReport("Number of components in FareCalculation list is: "
				+ FareRuleStringFromSyncAndBFF.getFareCalculationArraySizeFromBFF());
		log.info("Farerule string from /BFF service : " + FareRuleStringFromSyncAndBFF.getFareRuleFromBFF());
		logExtentReport("Farerule string from /BFF service : " + FareRuleStringFromSyncAndBFF.getFareRuleFromBFF());
	}
    @Test
	@Then("^User should get the same value of string returned by /BFF and /Sync APIs$")
	public static void user_should_get_the_same_value_of_string_returned_by_BFF_and_Sync_APIs() throws Throwable {
		Assert.assertEquals(FareRuleStringFromSyncAndBFF.getFareRuleFromSync(),
				FareRuleStringFromSyncAndBFF.getFareRuleFromBFF());
		log.info("Farerule strings from Sync vs BFF successfuly validated.");
		logExtentReport("Farerule strings from Sync vs BFF successfuly validated.");
	}
}
