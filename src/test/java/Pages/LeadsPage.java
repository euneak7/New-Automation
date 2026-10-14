package Pages;

import Base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LeadsPage extends BaseClass {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final By leads = By.xpath("//a[@href='/leads']");

    public LeadsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void open() {
        wait.until(ExpectedConditions.elementToBeClickable(leads)).click();
        wait.until(ExpectedConditions.urlContains("/leads"));
    }
}
