package com.tests.dsites.login.tests;

import com.selenium.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


/**
 * Created by Maksym Kharchenko on 08.02.2016.
 */
public class LoginTests {

    WebDriver driver;
    LoginPage loginPage;

    @BeforeClass(alwaysRun = true)
    public void runBrowser() {
        this.driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        driver.manage().window().maximize();
        loginPage = PageFactory.initElements(this.driver, LoginPage.class);
    }

    @AfterClass
    public void closeBrowser() {
        this.driver.quit();
    }

    @Test(priority = 1)
    public void loadHomePage() {
        driver.get("");
        Assert.assertEquals(driver.getTitle(), "title");
    }

    @Test(priority = 1, dependsOnMethods = "loadHomePage")
    public void openLoginFormTest() throws Exception {
        loginPage.openLoginForm();
        Assert.assertEquals(loginPage.ifLoginFormOpened(), true);
    }

    @Test(priority = 2)
    public void wrongUserDataTest() {
        loginPage.setEmailField("qwerty@qwerty.com");
        loginPage.setPasswordField("qwerty");
        loginPage.clickLoginBtn();
        Assert.assertEquals(loginPage.getErrorLoginMessage(), "Invalid username or password.");
    }

    @Test(priority = 3, dependsOnMethods = "wrongUserDataTest")
    public void clickOnTheForgotPasswordTest() {
        loginPage.clickOnForgotPassLink();
        Assert.assertEquals(true, loginPage.ifBackToLoginLinkDisplayed());
    }

    @Test (priority = 3, dependsOnMethods = "clickOnTheForgotPasswordTest")
    public void setWrongEmailToRestorePassTest(){
        loginPage.setForgotEmailField("qwerty@qwerty.com");
        loginPage.clickLoginBtn();
        Assert.assertEquals(loginPage.getForgotPassMess(),"Invalid email");
    }
    @Test(priority = 3)
    public void loginTest(){
        loginPage.setEmailField("merchant@merchant.com");
        loginPage.setPasswordField("merchant");
        loginPage.clickLoginBtn();
        Assert.assertEquals(this.driver.getTitle(),"title");
    }

}
