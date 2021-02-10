package UA_MicroService.BFF_Sync_Configurations;

public interface ConfigReader {
	public String getBaseURLFromPropertyFile();
	public String getInputDataForPayloadsFromPropertyFile();
}
