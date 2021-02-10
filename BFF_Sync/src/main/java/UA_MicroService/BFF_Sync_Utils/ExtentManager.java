package UA_MicroService.BFF_Sync_Utils;

import org.apache.log4j.Logger;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import UA_MicroService.BFF_Sync_GenericClasses.DateFormator;
import UA_MicroService.BFF_Sync_Logger.LogHelper;
import UA_MicroService.BFF_Sync_ResourcePathGenerator.ResourcePathGenerator;
import UA_MicroService.BFF_Sync_TestBase.TestBase;

public class ExtentManager extends TestBase {
	private static Logger log = LogHelper.getLogger(ExtentManager.class);
	public static ExtentReports extent;

	public static ExtentReports getInstance() {
		DateFormator.dateFormetor();
		if (extent == null) {
			return createIntance(ResourcePathGenerator
					.getResorcePath("/src/test/TestResult/UA_MicroService/BFF_Sync_ExtentReports/extent_"
							+ DateFormator.dateFormetor() + ".html"));
		} else {
			return extent;
		}
	}

	// Extent report instance creation whic will be used in getInstance of report.
	public static ExtentReports createIntance(String fileName) {
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
		htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
		htmlReporter.config().setChartVisibilityOnOpen(true);
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setDocumentTitle(fileName);
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setReportName("UA Automation Report");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		log.info("extent returned");
		return extent;
	}
}
