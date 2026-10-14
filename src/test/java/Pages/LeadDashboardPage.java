package Pages;

import Base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LeadDashboardPage extends BaseClass {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final By leadDashboard = By.xpath("//a[@href='/lead-dashboard']");

    public LeadDashboardPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void open() {
        wait.until(ExpectedConditions.elementToBeClickable(leadDashboard)).click();
        wait.until(ExpectedConditions.urlContains("/lead-dashboard"));
    }
}
