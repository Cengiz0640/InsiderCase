package com.insider.pages;

import com.insider.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CareersPage {

    public CareersPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//h3[normalize-space()= 'Our Locations' ]")
    public WebElement locationsElement;

    @FindBy(xpath = "//div[@class= 'job-title mt-0 mt-lg-2 mt-xl-5']")
    public List<WebElement> listOfTeamsOnCareersPageByDefault;

    @FindBy(xpath = "//h2[.= 'Life at Insider' ]")
    public WebElement lifeAtİnsiderElement;

    @FindBy(xpath = "//a[.= 'See all teams' ]")
    public WebElement seeAllTeamsButton;

    @FindBy(xpath = "//h3[.='Quality Assurance']")
    public WebElement qualityAssuranceTeamElement;

}
