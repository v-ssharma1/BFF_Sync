package UA_MicroService.BFF_Sync_Listeners;

import org.apache.log4j.Logger;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import UA_MicroService.BFF_Sync_Logger.LogHelper;

public class Retry implements IRetryAnalyzer {

	private Logger log = LogHelper.getLogger(Retry.class);
	private int retryCount = 0;
	private int maxRetryCount = 2;

	public boolean retry(ITestResult arg0) {
		if (retryCount < maxRetryCount) {
			log.info("Retrying test " + arg0.getName() + " with status " + getresultStatusName(arg0.getStatus())
					+ " for the " + (retryCount + 1) + " times.");
			retryCount++;
			return true;
		}
		return false;
	}

	public String getresultStatusName(int status) {
		String resultName = null;
		if (status == 1) {
			resultName = "SUCCESS";
		}
		if (status == 2) {
			resultName = "FAILURE";
		}
		if (status == 3) {
			resultName = "SKIP";
		}
		return resultName;
	}

}
