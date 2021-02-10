package UA_MicroService.BFF_Sync_StepDefinations;

import org.apache.log4j.Logger;
import org.testng.Assert;

import UA_MicroService.BFF_Sync_FareBasisCodeValidation.FareBasisCodeFromBFF;
import UA_MicroService.BFF_Sync_FareBasisCodeValidation.FareBasisCodesFromSync;
import UA_MicroService.BFF_Sync_Logger.LogHelper;
import UA_MicroService.BFF_Sync_TestBase.TestBase;
import cucumber.api.java.en.Then;

public class FareBaisCodeStepDefination extends TestBase {
	public static final Logger log = LogHelper.getLogger(FareBaisCodeStepDefination.class);

	@Then("^User should get same number of farebasis code in /BFF as provided by /Sync service$")
	public void user_should_get_same_number_of_farebasis_code_in_BFF_as_provided_by_Sync_service() throws Throwable {
		log.info("Number of basic code from Sync : " + FareBasisCodesFromSync.baisCodesFromSync().size());
		logExtentReport("Number of basic code from Sync : " + FareBasisCodesFromSync.baisCodesFromSync().size());
		log.info("Number of basic code from BFF : " + FareBasisCodeFromBFF.baisCodesFromBFF().size());
		logExtentReport("Number of basic code from BFF : " + FareBasisCodeFromBFF.baisCodesFromBFF().size());
		Assert.assertEquals(FareBasisCodesFromSync.baisCodesFromSync().size(),
				FareBasisCodeFromBFF.baisCodesFromBFF().size());
		log.info("Number of Basic codes in BFF API response is successfully validated for given farerule.");
		logExtentReport("Number of Basic codes in BFF API response is successfully validated for given farerule.");
	}

	@Then("^User should get same farebasis code in /BFF as provided by /Sync service$")
	public void user_should_get_same_farebasis_code_in_BFF_as_provided_by_Sync_service() throws Throwable {
		for (int i = 0; i <= FareBasisCodesFromSync.baisCodesFromSync().size() - 1; i++) {
			Assert.assertEquals(FareBasisCodesFromSync.baisCodesFromSync().get(i),
					"[\"" + FareBasisCodeFromBFF.baisCodesFromBFF().get(i) + "\"]");
			log.info("BaisCode_" + i + "_Sync: " + FareBasisCodesFromSync.baisCodesFromSync().get(0));
			log.info("BaisCode_" + i + "_BFF: " + "[\"" + FareBasisCodeFromBFF.baisCodesFromBFF().get(0) + "\"]");
			logExtentReport("BaisCode_" + (i + 1) + "_Sync: " + FareBasisCodesFromSync.baisCodesFromSync().get(0));
			logExtentReport(
					"BaisCode_" + (i + 1) + "_BFF: " + "[\"" + FareBasisCodeFromBFF.baisCodesFromBFF().get(0) + "\"]");
		}
		log.info(
				"The value of all fare basiccodes in BFF API response is successfully validated for the given farerule.");
		logExtentReport(
				"The value of all fare basiccodes in BFF API response is successfully validated for the given farerule.");
	}
}
