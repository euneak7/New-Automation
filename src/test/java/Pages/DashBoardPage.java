package Pages;

import Base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class DashBoardPage extends BaseClass {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By dashboard = By.xpath("//*[contains(@class, 'sidebar_links__') and normalize-space()='Dashboard']");

    public DashBoardPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void clickDashboard() {
        wait.until(ExpectedConditions.elementToBeClickable(dashboard)).click();
        wait.until(ExpectedConditions.attributeContains(dashboard, "class", "sidebar_active__"));
    }
}