package com.insider.pages;

import com.insider.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class QualityAssurancePage {

    public QualityAssurancePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//a[.='See all QA jobs']")
    public WebElement seeAllQAJobsButton;

    @FindBy(xpath = "//div[@class='position-location text-large']")
    public List<WebElement> locationsOnFilteredItems;

    @FindBy(xpath = "//span[@class='position-department text-large font-weight-600 text-primary']")
    public List<WebElement> departmentsOnFilteredItems;

    @FindBy(xpath = "//a[.='Apply Now']")
    public List<WebElement> applyNowButtonsOnFilteredItems;

    @FindBy(xpath = "(//a[.='Apply for this job'])[1]")
    public WebElement applyForThisJobButton;

    @FindBy(xpath = "(//button)[1]")
    public WebElement filterButton;

    @FindBy(xpath = "(//span[@data-select2-id='1'])[1]")
    public WebElement clearSelectionElementOnLocation;

    @FindBy(xpath = "//li[.='Istanbul, Turkey']")
    public WebElement ıstanbulTurkeyOption;

    @FindBy(xpath = "//div[@class='position-list-item-wrapper bg-light']")
    public List<WebElement> listOfFilteredJobs;

}

