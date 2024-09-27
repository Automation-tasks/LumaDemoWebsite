package util;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporter {
	
	public static ExtentReports getExtentReport() {
		
		ExtentReports extentReport = new ExtentReports();
		String extentReportFilePath = System.getProperty("user.dir")+"\\reports\\extentReport-Luma.html";
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extentReportFilePath);
		sparkReporter.config().setReportName("DDF - Extent Report for Luma");
		sparkReporter.config().setDocumentTitle("DDF - Extent Report for LoginTest of Luma");
		
		extentReport.attachReporter(sparkReporter);
		extentReport.setSystemInfo("Operating System",System.getProperty("os.name"));
		extentReport.setSystemInfo("Java Version",System.getProperty("java.version"));
		extentReport.setSystemInfo("Exectued By",System.getProperty("user.name"));
		
		return extentReport;
		
	}
}