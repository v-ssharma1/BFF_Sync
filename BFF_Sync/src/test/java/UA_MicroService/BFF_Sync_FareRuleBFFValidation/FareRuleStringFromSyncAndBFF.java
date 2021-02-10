package UA_MicroService.BFF_Sync_FareRuleBFFValidation;

import java.util.List;

import org.apache.log4j.Logger;

import UA_MicroService.BFF_Sync_Logger.LogHelper;
import UA_MicroService.BFF_Sync_StatusCodeValidation.ValidateStatusCodesForSyncAndBFF;
import UA_MicroService.BFF_Sync_TestBase.TestBase;
import com.jayway.jsonpath.JsonPath;

public class FareRuleStringFromSyncAndBFF extends TestBase {
	public static final Logger log = LogHelper.getLogger(FareRuleStringFromSyncAndBFF.class);
	public static String syncResp;
	public static String bffResp;

	public static List<String> fareCalculation_BFF;

	public static String getFareRuleFromSync() {
		syncResp = ValidateStatusCodesForSyncAndBFF
				.getResponceFromService_Get(ValidateStatusCodesForSyncAndBFF.syncEndPoint()).asString();
		return JsonPath.read(syncResp, "$.Reservation.Prices[0].FareCalculation");
	}

	public static String getFareRuleFromBFF() {
		String temp = null;
		String FareCalculationText;
		for (int i = 0; i <= getFareCalculationArraySizeFromBFF() - 1; i++) {
			FareCalculationText = JsonPath.read(bffResp, "$.Cart.Price.FareCalculation[0].Calculation[" + i + "].Text");
			if (temp != null) {
				if (JsonPath.read(bffResp,
						"$.Cart.Price.FareCalculation[0].Calculation[" + i + "].IsBasisCode") == "false") {
					temp = temp + " " + FareCalculationText;
				} else {
					temp = temp + FareCalculationText;
				}

			} else {
				temp = FareCalculationText;
			}
		}
		return temp;
	}

	public static int getFareCalculationArraySizeFromBFF() {
		bffResp = ValidateStatusCodesForSyncAndBFF
				.getResponceFromService_Get(ValidateStatusCodesForSyncAndBFF.bffEndPoint()).asString();
		fareCalculation_BFF = JsonPath.read(bffResp, "$.Cart.Price.FareCalculation[0].Calculation");
		return fareCalculation_BFF.size();
	}
}
