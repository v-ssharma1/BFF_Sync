package UA_MicroService.BFF_Sync_Configurations;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import UA_MicroService.BFF_Sync_ResourcePathGenerator.ResourcePathGenerator;

public class PropertyReader implements ConfigReader {
	public static String filePath;
	public static File file;
	private static FileInputStream inputstream;
	public static Properties prop;

	// public PropertyReader() {
	// try {
	// filePath = ResourcePathGenerator
	// .getResorcePath("/src/main/Resources/UA_MicroService/BFF_Sync_InputTestData/BaseURIs.properties");
	// file = new File(filePath);
	// inputstream = new FileInputStream(file);
	// prop = new Properties();
	// try {
	// prop.load(inputstream);
	// } catch (IOException e) {
	// e.printStackTrace();
	// }
	// } catch (FileNotFoundException e) {
	// e.printStackTrace();
	// }

	// }

	public static Properties readPropertyFiles(String path) {
		try {
			filePath = ResourcePathGenerator.getResorcePath(path);
			file = new File(filePath);
			inputstream = new FileInputStream(file);
			prop = new Properties();
			try {
				prop.load(inputstream);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return prop;
	}

	@Override
	public String getBaseURLFromPropertyFile() {
		readPropertyFiles("/src/main/Resources/UA_MicroService/BFF_Sync_InputTestData/BaseURIs.properties");
		return prop.getProperty("baseURI");
	}

	@Override
	public String getInputDataForPayloadsFromPropertyFile() {
		// TODO Auto-generated method stub
		return null;
	}

}
