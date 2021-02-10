package UA_MicroService.BFF_Sync_PassangerTypeBFFValidation;

import org.apache.log4j.Logger;

import com.jayway.jsonpath.JsonPath;

import UA_MicroService.BFF_Sync_Logger.LogHelper;
import UA_MicroService.BFF_Sync_StatusCodeValidation.ValidateStatusCodesForSyncAndBFF;
import UA_MicroService.BFF_Sync_TestBase.TestBase;

public class PassengerInfoFromSync extends TestBase {
	public static final Logger log = LogHelper.getLogger(PassengerInfoFromSync.class);
	public static String syncResp;

	public static String getPassangerTypeFromSync() {
		syncResp = ValidateStatusCodesForSyncAndBFF
				.getResponceFromService_Get(ValidateStatusCodesForSyncAndBFF.syncEndPoint()).asString();
		return JsonPath.read(syncResp, "$.Reservation.Travelers[0].Person.Type").toString();
	}

	public static String getPassangerLastNameFromSync() {
		syncResp = ValidateStatusCodesForSyncAndBFF
				.getResponceFromService_Get(ValidateStatusCodesForSyncAndBFF.syncEndPoint()).asString();
		return JsonPath.read(syncResp, "$.Reservation.Travelers[0].Person.Surname").toString().toLowerCase();
	}

	public static String getPassangerFirstNameFromSync() {
		syncResp = ValidateStatusCodesForSyncAndBFF
				.getResponceFromService_Get(ValidateStatusCodesForSyncAndBFF.syncEndPoint()).asString();
		return JsonPath.read(syncResp, "$.Reservation.Travelers[0].Person.GivenName").toString().toLowerCase();
	}

	public static String getPassangerDOBFromSync() {
		syncResp = ValidateStatusCodesForSyncAndBFF
				.getResponceFromService_Get(ValidateStatusCodesForSyncAndBFF.syncEndPoint()).asString();
		return JsonPath.read(syncResp, "$.Reservation.Travelers[0].Person.DateOfBirth");
	}

	// public static String getPassangerGenderFromSync() {
	// syncResp = ValidateStatusCodesForSyncAndBFF
	// .getResponceFromService_Get(ValidateStatusCodesForSyncAndBFF.syncEndPoint()).asString();
	// return JsonPath.read(syncResp, "$.Reservation.Travelers[0].Person.Sex");
	// }
}
