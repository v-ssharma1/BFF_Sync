package UA_MicroService.BFF_Sync_Cucumber_Runner;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import UA_MicroService.BFF_Sync_Logger.LogHelper;
import UA_MicroService.BFF_Sync_TestBase.TestBase;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;

@Test(groups = "cucumber")
@CucumberOptions(features = "src/main/Resources/UA_MicroService/BFF_Sync_FeatureFiles", glue = {
		"UA_MicroService/BFF_Sync_StepDefinations" }, plugin = { "pretty",
				"html:src/test/TestResult/UA_MicroService.BFF_Sync_CucumberReport/cucumber-pretty",
				"json:src/test/TestResult/UA_MicroService.BFF_Sync_CucumberReport/CucumberReport.json",
				"rerun:src/test/TestResult/UA_MicroService.BFF_Sync_CucumberReport/rerun.txt" })
public class TestRunner extends TestBase {
	private TestNGCucumberRunner testNGCucumberRunner;
	public static final Logger log = LogHelper.getLogger(TestRunner.class);

	@BeforeClass(alwaysRun = true)
	public void setUpClass() {
		testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
		setBaseURI();
	}

	@Test(groups = "cucumber", description = "Run cucumber Feature", dataProvider = "features")
	public void Cucumberfeature(CucumberFeatureWrapper cucumberFeature) {
		log.info("**************Execution of " + cucumberFeature.getCucumberFeature().getGherkinFeature().getName()
				+ " feature file started**********");
		logExtentReport(
				"**************Execution of '" + cucumberFeature.getCucumberFeature().getGherkinFeature().getName()
						+ "' feature file started**********");
		testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
		log.info("**************Execution of '" + cucumberFeature.getCucumberFeature().getGherkinFeature().getName()
				+ "' feature file Finished**********");
		logExtentReport(
				"**************Execution of '" + cucumberFeature.getCucumberFeature().getGherkinFeature().getName()
						+ "' feature file Finished**********");
	}

	@DataProvider
	public Object[][] features() {
		return testNGCucumberRunner.provideFeatures();
	}

	@AfterClass(alwaysRun = true)
	public void testDownClass() {
		testNGCucumberRunner.finish();
	}

}
