package Base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;

public class BaseClass {
    public static WebDriver driver;
    private ExtentReports extentReports;
    private final ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    @BeforeSuite
    public void launchBrowser() {
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter("target/ALOHub-ExtentReport.html");
        extentReports = new ExtentReports();
        extentReports.attachReporter(htmlReporter);

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://alo-hub-stage-admin.vercel.app");
    }

    @BeforeMethod
    public void startExtentTest(Method method) {
        extentTest.set(extentReports.createTest(
                method.getDeclaringClass().getSimpleName() + "." + method.getName()));
    }

    protected void logStep(String message) {
        extentTest.get().info(message);
    }

    @AfterMethod
    public void recordTestResult(ITestResult result) {
        ExtentTest test = extentTest.get();
        if (result.getStatus() == ITestResult.SUCCESS) {
            test.pass("Test passed");
        } else if (result.getStatus() == ITestResult.FAILURE) {
            test.fail(result.getThrowable());
        } else if (result.getStatus() == ITestResult.SKIP) {
            test.skip(result.getThrowable());
        }
        extentTest.remove();
    }

    @AfterSuite
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
        if (extentReports != null) {
            extentReports.flush();
        }
    }
}
