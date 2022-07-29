package com.insider.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.insider.pages.CareersPage;
import com.insider.pages.HomePage;
import com.insider.pages.QualityAssurancePage;
import com.insider.utilities.BrowserUtils;
import com.insider.utilities.Driver;
import com.insider.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DemoTest extends TestBase {

    HomePage homePage = new HomePage();
    CareersPage careersPage = new CareersPage();
    QualityAssurancePage qualityAssurancePage = new QualityAssurancePage();

    @Test
    public void test1() {

        extentLogger= report.createTest("test1");

        extentLogger.info("Login Home Page");
        driver.get("https://useinsider.com/");
        //assert page title to verify insider home page opened
        extentLogger.info("Verify Page Url");
        Assert.assertEquals(driver.getTitle(), "Insider personalization engine for seamless customer experiences");

        extentLogger.pass("Insider home page is opened");
    }

    @Test
    public void test2() {
        extentLogger= report.createTest("test2");

        extentLogger.info("Login Home Page");
        driver.get("https://useinsider.com/");

        extentLogger.info("Accept All Cookies");
        homePage.acceptAllCookies.click();

        extentLogger.info("Click on More Menu Bar");
        BrowserUtils.clickWithJS(homePage.moreOnMenuBar);

        extentLogger.info("Select Careers");
        BrowserUtils.clickWithJS(homePage.careersOption);

        extentLogger.info("Check Careers Page");
        Assert.assertTrue(driver.getCurrentUrl().contains("careers/"));

        extentLogger.info("Locations are displayed");
        Assert.assertTrue(careersPage.locationsElement.isDisplayed());
        extentLogger.info("See All Teams Button");
        Assert.assertTrue(careersPage.seeAllTeamsButton.isDisplayed());

        extentLogger.info("See Life At Insider");
        Assert.assertTrue(careersPage.lifeAtİnsiderElement.isDisplayed());

        for (WebElement element : careersPage.listOfTeamsOnCareersPageByDefault) {
            Assert.assertTrue(element.isDisplayed());
        }
        extentLogger.pass("Locations, Teams and Life at Insider blocks are opened");
    }

    @Test
    public void test3() {
        extentLogger= report.createTest("test3");

        extentLogger.info("Login Home Page");
        driver.get("https://useinsider.com/");

        extentLogger.info("Accept All Cookies");
        homePage.acceptAllCookies.click();

        extentLogger.info("Click on More Menu Bar");
        BrowserUtils.clickWithJS(homePage.moreOnMenuBar);

        extentLogger.info("Select Careers");
        BrowserUtils.clickWithJS(homePage.careersOption);

        extentLogger.info("See All Teams Button and click");
        BrowserUtils.clickWithJS(careersPage.seeAllTeamsButton);

        extentLogger.info("See Quality Assurance and click");
        BrowserUtils.clickWithJS(careersPage.qualityAssuranceTeamElement);

        extentLogger.info("See see all QA jobs button and click");
        BrowserUtils.clickWithJS(qualityAssurancePage.seeAllQAJobsButton);

        extentLogger.info("Click the filter button");
        BrowserUtils.clickWithJS(qualityAssurancePage.filterButton);

        Actions actions = new Actions(driver);
        BrowserUtils.waitFor(5);

        extentLogger.info("Clear Selection Element On Location");
        actions.moveToElement((qualityAssurancePage.clearSelectionElementOnLocation)).pause(2000).click().perform();
        BrowserUtils.waitFor(3);

        extentLogger.info("Select Istanbul, Turkey");
        actions.moveToElement((qualityAssurancePage.ıstanbulTurkeyOption)).pause(2000).click().perform();
        BrowserUtils.waitFor(2);
        BrowserUtils.scrollDown(400);
        BrowserUtils.waitFor(2);

        extentLogger.info("Check presence of jobs list");
        Assert.assertTrue(qualityAssurancePage.listOfFilteredJobs.get(0).isDisplayed());
        Assert.assertTrue(qualityAssurancePage.listOfFilteredJobs.get(1).isDisplayed());
        Assert.assertTrue(qualityAssurancePage.listOfFilteredJobs.get(2).isDisplayed());

        extentLogger.pass("All the QA Positions in İstanbul are displayed");
    }

    @Test
    public void test4() {
        extentLogger= report.createTest("test4");

        extentLogger.info("Login Home Page");
        driver.get("https://useinsider.com/");

        extentLogger.info("Accept All Cookies");
        homePage.acceptAllCookies.click();

        extentLogger.info("Click on More Menu Bar");
        BrowserUtils.clickWithJS(homePage.moreOnMenuBar);

        extentLogger.info("Select Careers");
        BrowserUtils.clickWithJS(homePage.careersOption);

        extentLogger.info("See All Teams Button and click");
        BrowserUtils.clickWithJS(careersPage.seeAllTeamsButton);

        extentLogger.info("See Quality Assurance and click");
        BrowserUtils.clickWithJS(careersPage.qualityAssuranceTeamElement);

        extentLogger.info("See see all QA jobs button and click");
        BrowserUtils.clickWithJS(qualityAssurancePage.seeAllQAJobsButton);

        extentLogger.info("Click the filter button");
        BrowserUtils.clickWithJS(qualityAssurancePage.filterButton);

        Actions actions = new Actions(driver);
        BrowserUtils.waitFor(5);

        extentLogger.info("Clear Selection Element On Location");
        actions.moveToElement((qualityAssurancePage.clearSelectionElementOnLocation)).pause(2000).click().perform();
        BrowserUtils.waitFor(3);

        extentLogger.info("Select Istanbul, Turkey");
        actions.moveToElement((qualityAssurancePage.ıstanbulTurkeyOption)).pause(2000).click().perform();
        BrowserUtils.waitFor(2);
        BrowserUtils.scrollDown(550);
        BrowserUtils.waitFor(2);

        extentLogger.info("Check presence of QA jobs list in İstanbul and See Apply Now Buttons ");
        for (WebElement element : qualityAssurancePage.locationsOnFilteredItems) {
            Assert.assertTrue(element.isDisplayed());
            Assert.assertEquals(element.getText(), "Istanbul, Turkey");

        }

        for (WebElement element : qualityAssurancePage.departmentsOnFilteredItems) {
            Assert.assertTrue(element.isDisplayed());
            Assert.assertEquals(element.getText(), "Quality Assurance");
        }

        for (WebElement element : qualityAssurancePage.applyNowButtonsOnFilteredItems) {
            actions.moveToElement(element).pause(1000).perform();
            Assert.assertEquals(element.getText(), "Apply Now");
        }

        extentLogger.pass("Apply Now buttons are displayed");
    }

    @Test
    public void test5() {

        extentLogger= report.createTest("test5");

        extentLogger.info("Login Home Page");
        driver.get("https://useinsider.com/");

        extentLogger.info("Accept All Cookies");
        homePage.acceptAllCookies.click();

        extentLogger.info("Click on More Menu Bar");
        BrowserUtils.clickWithJS(homePage.moreOnMenuBar);

        extentLogger.info("Select Careers");
        BrowserUtils.clickWithJS(homePage.careersOption);

        extentLogger.info("See All Teams Button and click");
        BrowserUtils.clickWithJS(careersPage.seeAllTeamsButton);

        extentLogger.info("See Quality Assurance and click");
        BrowserUtils.clickWithJS(careersPage.qualityAssuranceTeamElement);

        extentLogger.info("See see all QA jobs button and click");
        BrowserUtils.clickWithJS(qualityAssurancePage.seeAllQAJobsButton);

        extentLogger.info("Click the filter button");
        BrowserUtils.clickWithJS(qualityAssurancePage.filterButton);

        Actions actions = new Actions(driver);
        BrowserUtils.waitFor(5);

        extentLogger.info("Clear Selection Element On Location");
        actions.moveToElement((qualityAssurancePage.clearSelectionElementOnLocation)).pause(2000).click().perform();
        BrowserUtils.waitFor(3);

        extentLogger.info("Select Istanbul, Turkey");
        actions.moveToElement((qualityAssurancePage.ıstanbulTurkeyOption)).pause(2000).click().perform();
        BrowserUtils.waitFor(5);
        BrowserUtils.scrollDown(600);
        BrowserUtils.waitFor(1);

        extentLogger.info("Click Apply Now button");
        actions.moveToElement(qualityAssurancePage.applyNowButtonsOnFilteredItems.get(0)).pause(1000).click().perform();

        BrowserUtils.switchToWindow();
        BrowserUtils.waitFor(1);

        extentLogger.info("Apply For This Job Button is Displayed");
        Assert.assertTrue(qualityAssurancePage.applyForThisJobButton.isDisplayed());

        extentLogger.pass("This action redirects us to Lever Application form page");
    }


}