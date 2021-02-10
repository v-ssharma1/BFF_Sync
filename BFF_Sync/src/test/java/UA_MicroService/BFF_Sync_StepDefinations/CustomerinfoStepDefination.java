package UA_MicroService.BFF_Sync_StepDefinations;

import org.apache.log4j.Logger;
import org.testng.Assert;

import UA_MicroService.BFF_Sync_Logger.LogHelper;
import UA_MicroService.BFF_Sync_PassangerTypeBFFValidation.PassengerInfoFromBFF;
import UA_MicroService.BFF_Sync_PassangerTypeBFFValidation.PassengerInfoFromSync;
import UA_MicroService.BFF_Sync_TestBase.TestBase;
import cucumber.api.java.en.Then;

public class CustomerinfoStepDefination extends TestBase {
	public static final Logger log = LogHelper.getLogger(CustomerinfoStepDefination.class);

	@Then("^User should be able to validate the BFF value of Customer's FirstName against sync$")
	public void user_should_be_able_to_validate_the_BFF_value_of_Customer_s_FirstName_against_sync() throws Throwable {
		Assert.assertEquals(PassengerInfoFromSync.getPassangerFirstNameFromSync(),
				PassengerInfoFromBFF.getCustomerFirstNameFromBFF());
		log.info("Customer's First Name " + PassengerInfoFromBFF.getCustomerFirstNameFromBFF()
				+ " successfully validated.");
		logExtentReport("Customer's First Name " + PassengerInfoFromBFF.getCustomerFirstNameFromBFF()
				+ " successfully validated.");
	}

	@Then("^User should be able to validate the BFF value of Customer's LastName against sync$")
	public void user_should_be_able_to_validate_the_BFF_value_of_Customer_s_LastName_against_sync() throws Throwable {
		Assert.assertEquals(PassengerInfoFromSync.getPassangerLastNameFromSync(),
				PassengerInfoFromBFF.getCustomerLastNameFromBFF());
		log.info("Customer's Last Name " + PassengerInfoFromBFF.getCustomerLastNameFromBFF()
				+ " successfully validated.");
		logExtentReport("Customer's Last Name " + PassengerInfoFromBFF.getCustomerLastNameFromBFF()
				+ " successfully validated.");
	}

	@Then("^User should be able to validate the BFF value of Customer's DOB against sync$")
	public void user_should_be_able_to_validate_the_BFF_value_of_Customer_s_DOB_against_sync() throws Throwable {
		Assert.assertEquals(PassengerInfoFromSync.getPassangerLastNameFromSync(),
				PassengerInfoFromBFF.getCustomerLastNameFromBFF());
		log.info("Customer's DOB " + PassengerInfoFromBFF.getCustomerDOBFromBFF() + " successfully validated.");
		logExtentReport("Customer's DOB " + PassengerInfoFromBFF.getCustomerDOBFromBFF() + " successfully validated.");
	}

	@Then("^User should be able to validate the BFF value of Customer's Type against sync$")
	public void user_should_be_able_to_validate_the_BFF_value_of_Customer_s_Type_against_sync() throws Throwable {
		String strSync = PassengerInfoFromSync.getPassangerTypeFromSync().toString();
		String strBFF = PassengerInfoFromBFF.getCustomerPaxtypeFromBFF();
		log.info("Sync " + strSync);
		log.info("BFF " + strBFF);
		// Strings are immutable hence object cannot be compared hence we cannot use
		// '==' in if condition becuase this is used to compare two obejcts
		if (strSync.equals("ADT")) {
			log.info("in if");
			Assert.assertEquals(strBFF, "Adult (18-64)");
			log.info("Customer's customer type " + PassengerInfoFromBFF.getCustomerPaxtypeFromBFF()
					+ " successfully validated.");
			logExtentReport("Customer's customer type " + PassengerInfoFromBFF.getCustomerPaxtypeFromBFF()
					+ " successfully validated.");
		} else {
			log.info("in else");
			Assert.assertNotEquals(strBFF, "Adult (18-64)");
			log.info("Customer's customer type " + PassengerInfoFromBFF.getCustomerPaxtypeFromBFF()
					+ " successfully validated.");
			logExtentReport("Customer's customer type " + PassengerInfoFromBFF.getCustomerPaxtypeFromBFF()
					+ " successfully validated.");
		}
	}
}
