package UA_MicroService.BFF_Sync_TestBase;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import UA_MicroService.BFF_Sync_Configurations.PropertyReader;
import UA_MicroService.BFF_Sync_Logger.LogHelper;
import UA_MicroService.BFF_Sync_Utils.ExtentManager;
import io.restassured.RestAssured;
//import cucumber.api.testng.CucumberFeatureWrapper;

public class TestBase {
	public static final Logger log = LogHelper.getLogger(TestBase.class);
	public static File reportDirectory;
	public static ExtentReports extent;
	public static ExtentTest test;
	public static String baseuri;

	public static void logExtentReport(String s1) {
		test.log(Status.INFO, s1);
	}

	// @BeforeClass
	public static void setBaseURI() {
		baseuri = PropertyReader
				.readPropertyFiles("/src/main/Resources/UA_MicroService/BFF_Sync_InputTestData/BaseURIs.properties")
				.getProperty("baseURI");
		RestAssured.baseURI = baseuri;
		logExtentReport("Base URI is : " + baseuri);
		// bacis Authentication
		RestAssured.authentication = RestAssured.preemptive().basic("ToolsQA", "TestPassword");
	}

	@BeforeSuite
	public void beforeSuite() {
		extent = ExtentManager.getInstance();
	}

	@BeforeTest
	public void beforeTest() throws Exception {
		// ObjectReader.reader = new PropertyReader();
		// reportDirectory = new File(ResourcePathGenerator
		// .getResorcePath("/src/test/TestResults/com/uiAutomationRetailSite/Expedia/GCO/ScreenShots/"));
		// setUpDriver(ObjectReader.reader.getBrowserTypeValueFromPropertyFile());
		test = extent.createTest(getClass().getSimpleName());
	}

	@BeforeMethod
	public void beforeMethod(Method method) {
		test.log(Status.INFO, "**************" + method.getName() + " test started***************");

		log.info("**************" + method.getName() + " Started***************");
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, result.getThrowable());
			// String imagePath = captureScreenShot(result.getName(), driver);
			// test.addScreenCaptureFromPath(imagePath);
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, result.getName() + " is pass");
			// String imagePath = captureScreenShot(result.getName(), driver);
			// test.addScreenCaptureFromPath(imagePath);
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, result.getThrowable());
		}
		log.info("**************" + result.getName() + "Finished***************");
		// log.info("**************" + result.getInstance().getClass() +
		// "Finished***************");
		extent.flush();
	}
}
