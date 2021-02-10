package UA_MicroService.BFF_Sync_FareBasisCodeValidation;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import com.jayway.jsonpath.JsonPath;

import UA_MicroService.BFF_Sync_Logger.LogHelper;
import UA_MicroService.BFF_Sync_StatusCodeValidation.ValidateStatusCodesForSyncAndBFF;
import UA_MicroService.BFF_Sync_TestBase.TestBase;

public class FareBasisCodeFromBFF extends TestBase {
	public static final Logger log = LogHelper.getLogger(FareBasisCodeFromBFF.class);
	public static String bffResp;

	public static List<String> baisCodesFromBFF() {
		List<String> fareBasicCodes_BFF = new ArrayList<String>();
		bffResp = ValidateStatusCodesForSyncAndBFF
				.getResponceFromService_Get(ValidateStatusCodesForSyncAndBFF.bffEndPoint()).asString();
		List<String> numberOfFareComponents = JsonPath.read(bffResp, "$.Cart.Price.FareCalculation[0].Calculation");
		for (int i = 0; i <= numberOfFareComponents.size() - 1; i++) {
			if (JsonPath.read(bffResp, "$.Cart.Price.FareCalculation[0].Calculation[" + i + "].IsBasisCode")) {
				fareBasicCodes_BFF.add(JsonPath
						.read(bffResp, "$.Cart.Price.FareCalculation[0].Calculation[" + i + "].Text").toString());
			}
		}
		return fareBasicCodes_BFF;
	}
}
