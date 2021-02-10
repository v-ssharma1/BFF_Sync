package UA_MicroService.BFF_Sync_Logger;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import UA_MicroService.BFF_Sync_ResourcePathGenerator.ResourcePathGenerator;

public class LogHelper {
	public static boolean root = false;

	public static Logger getLogger(@SuppressWarnings("rawtypes") Class cls) {
		if (root) {
			return Logger.getLogger(cls);
		}
		PropertyConfigurator.configure(ResourcePathGenerator
				.getResorcePath("/src/main/Resources/UA_MicroService/BFF_Sync_Log4J/log4j.properties"));
		root = true;
		return Logger.getLogger(cls);
	}
}
