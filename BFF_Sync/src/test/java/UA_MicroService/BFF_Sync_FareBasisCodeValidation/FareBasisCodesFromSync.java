package UA_MicroService.BFF_Sync_FareBasisCodeValidation;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import com.jayway.jsonpath.JsonPath;

import UA_MicroService.BFF_Sync_Logger.LogHelper;
import UA_MicroService.BFF_Sync_StatusCodeValidation.ValidateStatusCodesForSyncAndBFF;
import UA_MicroService.BFF_Sync_TestBase.TestBase;

public class FareBasisCodesFromSync extends TestBase {
	public static final Logger log = LogHelper.getLogger(FareBasisCodesFromSync.class);
	public static String syncResp;

	public static List<String> baisCodesFromSync() {
		syncResp = ValidateStatusCodesForSyncAndBFF
				.getResponceFromService_Get(ValidateStatusCodesForSyncAndBFF.syncEndPoint()).asString();
		List<String> numberOfFareComponents = JsonPath.read(syncResp, "$.Reservation.Prices[0].FareComponents");
		List<String> BaisCodeInEachFareComponent = new ArrayList<String>();
		for (int i = 0; i <= numberOfFareComponents.size() - 1; i++) {
			BaisCodeInEachFareComponent.add(
					JsonPath.read(syncResp, "$.Reservation.Prices[0].FareComponents[" + i + "].BasisCodes").toString());
		}
		return BaisCodeInEachFareComponent;
	}

	// public static int numberofBaisCodeFromSync() {
	// int numberOfBaisCodes = 0;
	// syncResp = ValidateStatusCodesForSyncAndBFF
	// .getResponceFromService_Get(ValidateStatusCodesForSyncAndBFF.syncEndPoint()).asString();
	// List<String> numberOfFareComponents = JsonPath.read(syncResp,
	// "$.Reservation.Prices[0].FareComponents");
	// List<String> BaisCodeInEachFareComponent;
	// for (int i = 0; i <= numberOfFareComponents.size() - 1; i++) {
	// BaisCodeInEachFareComponent = JsonPath.read(syncResp,
	// "$.Reservation.Prices[0].FareComponents[" + i + "].BasisCodes");
	// numberOfBaisCodes = numberOfBaisCodes + BaisCodeInEachFareComponent.size();
	// }
	// return numberOfBaisCodes;
	// }

}
