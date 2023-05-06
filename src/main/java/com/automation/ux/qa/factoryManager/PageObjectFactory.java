package com.automation.ux.qa.factoryManager;

import com.automation.ux.qa.pageObjects.HomePage;
import com.automation.ux.qa.pageObjects.LoginPage;
import org.openqa.selenium.WebDriver;


public class PageObjectFactory {

    private final WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;

    public PageObjectFactory(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage getCardsHomePage() {
        return (homePage == null) ? homePage = new HomePage(driver) : homePage;
    }

    public LoginPage getLoginPage() {
        return (loginPage == null) ? loginPage = new LoginPage(driver) : loginPage;
    }
}