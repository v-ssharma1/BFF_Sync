package UA_MicroService.BFF_Sync_PassangerTypeBFFValidation;

import org.apache.log4j.Logger;

import com.jayway.jsonpath.JsonPath;

import UA_MicroService.BFF_Sync_Logger.LogHelper;
import UA_MicroService.BFF_Sync_StatusCodeValidation.ValidateStatusCodesForSyncAndBFF;
import UA_MicroService.BFF_Sync_TestBase.TestBase;

public class PassengerInfoFromBFF extends TestBase {
	public static final Logger log = LogHelper.getLogger(PassengerInfoFromBFF.class);
	public static String bffResp;

	// public static String getCustomerTypeFromBFF() {
	// bffResp = ValidateStatusCodesForSyncAndBFF
	// .getResponceFromService_Get(ValidateStatusCodesForSyncAndBFF.bffEndPoint()).asString();
	// return JsonPath.read(bffResp, "$.Cart.Price.Fare.Prices[0].Type").toString();
	// }

	public static String getCustomerPaxtypeFromBFF() {
		bffResp = ValidateStatusCodesForSyncAndBFF
				.getResponceFromService_Get(ValidateStatusCodesForSyncAndBFF.bffEndPoint()).asString();
		return JsonPath.read(bffResp, "$.Cart.Price.Fare.Prices[0].DisplayPaxType").toString();
	}

	public static String getCustomerFirstNameFromBFF() {
		bffResp = ValidateStatusCodesForSyncAndBFF
				.getResponceFromService_Get(ValidateStatusCodesForSyncAndBFF.bffEndPoint()).asString();
		return JsonPath.read(bffResp, "$.Cart.Travelers[0].FirstName").toString().toLowerCase();
	}

	public static String getCustomerLastNameFromBFF() {
		bffResp = ValidateStatusCodesForSyncAndBFF
				.getResponceFromService_Get(ValidateStatusCodesForSyncAndBFF.bffEndPoint()).asString();
		return JsonPath.read(bffResp, "$.Cart.Travelers[0].LastName").toString().toLowerCase();
	}

	public static String getCustomerDOBFromBFF() {
		bffResp = ValidateStatusCodesForSyncAndBFF
				.getResponceFromService_Get(ValidateStatusCodesForSyncAndBFF.bffEndPoint()).asString();
		return JsonPath.read(bffResp, "$.Cart.Travelers[0].Birthdate");
	}
}