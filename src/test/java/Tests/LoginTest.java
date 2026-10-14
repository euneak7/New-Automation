package Tests;

import Base.BaseClass;
import Pages.DashBoardPage;
import Pages.LeadDashboardPage;
import Pages.LeadsPage;
import Pages.LoginPage;
import Pages.RegistrationListPage;
import Pages.RzrPayTransactionsPage;
import Pages.StudentListPage;
import org.testng.annotations.Test;

public class LoginTest extends BaseClass {
    @Test
    public void loginTest() throws InterruptedException {
        logStep("Log in to the admin website");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("alohubadmin@gmail.com", "Password@1");

        logStep("Open Dashboard");
        DashBoardPage dashBoardPage = new DashBoardPage(driver);
        dashBoardPage.clickDashboard();
        Thread.sleep(1500);

        logStep("Open Lead Dashboard");
        LeadDashboardPage leadDashboardPage = new LeadDashboardPage(driver);
        leadDashboardPage.open();
        Thread.sleep(1500);

        logStep("Open Leads");
        LeadsPage leadsPage = new LeadsPage(driver);
        leadsPage.open();
        Thread.sleep(1500);

        logStep("Open Registration List");
        RegistrationListPage registrationListPage = new RegistrationListPage(driver);
        registrationListPage.open();
        Thread.sleep(1500);

        logStep("Open RzrPay Transactions");
        RzrPayTransactionsPage rzrPayTransactionsPage = new RzrPayTransactionsPage(driver);
        rzrPayTransactionsPage.open();
        Thread.sleep(1500);

        logStep("Open student List");
        StudentListPage studentListPage = new StudentListPage(driver);
        studentListPage.open();
    }
}
