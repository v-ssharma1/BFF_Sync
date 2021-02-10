package UA_MicroService.BFF_Sync_ResourcePathGenerator;

public class ResourcePathGenerator {
	public static String getResorcePath(String path) {
		return System.getProperty("user.dir")+path;
	}

}
