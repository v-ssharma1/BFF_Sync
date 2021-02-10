package UA_MicroService.BFF_Sync_URLMaker;

import UA_MicroService.BFF_Sync_Configurations.PropertyReader;

public class UrlCreater {

	public static String returnUrl(String endPoint) {
		return new PropertyReader().getBaseURLFromPropertyFile() + endPoint;
	}
}
