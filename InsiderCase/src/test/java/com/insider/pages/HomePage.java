package com.insider.pages;

import com.insider.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    public HomePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//a[@id='mega-menu-1']")
    public WebElement moreOnMenuBar;

    @FindBy(xpath = "//h5[.='Careers']")
    public WebElement careersOption;

    @FindBy(xpath = "//a[.='Accept All']")
    public WebElement acceptAllCookies;

}
