package com.automation.ux.qa.pageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.hamcrest.MatcherAssert.assertThat;


public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "name")
    private WebElement nameField;

    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "address")
    private WebElement addressField;


    @FindBy(xpath = "//*[contains(@data-testid,'FINISHED')]/following-sibling::div[1]/h1")
    private WebElement registrationSuccessMessage;

    @FindBy(xpath = "//*[contains(@data-testid,'FINISHED')]/following-sibling::div/*[contains(text(),'C1')]")
    private WebElement cardC1EligibilityMessage;

    @FindBy(xpath = "//*[contains(@data-testid,'FINISHED')]/following-sibling::div/*[contains(text(),'C2')]")
    private WebElement cardC2EligibilityMessage;

    @FindBy(xpath = "//*[@data-testid='ERROR']/form/h3")
    private WebElement errorMessage;

    @FindBy(xpath = "//h2")
    private WebElement loginPageHeader;

    @FindBy(xpath = "//*[contains(@name,'username')]")
    private WebElement userNameField;
    @FindBy(xpath = "//*[contains(@name,'password')]")
    private WebElement passwordField;
    @FindBy(xpath = "//*[contains(@id,'submit')]")
    private WebElement submitButton;

    @FindBy(xpath = "//*[contains(@id,'error')]")
    private WebElement errorMessages;

    public void navigateToLoginPage() {
        driver.get("https://practicetestautomation.com/practice-test-login/");
    }

    public void validateLoginPage(String title) {
        Assert.assertEquals(title, loginPageHeader.getText());
    }

    public void enterUserName(final String value) {
        assertThat("User name field is not displayed", userNameField.isDisplayed());

        userNameField.clear();
        userNameField.sendKeys(value);
    }

    public void enterPassword(final String name) {
        assertThat("Password field is not displayed", passwordField.isDisplayed());

        passwordField.clear();
        passwordField.sendKeys(name);
    }


    public void clickSubmit() {
        assertThat("Submit button is not displayed", submitButton.isDisplayed());

        submitButton.click();
    }

    public String getRegistrationSuccessMessage() {
        return registrationSuccessMessage.getText();
    }

    public boolean assertEligibleCard(final int cardDisplayPosition) throws Exception {
        boolean isDisplayed = false;
        switch (cardDisplayPosition) {
            case 1:
                isDisplayed = cardC1EligibilityMessage.isDisplayed();
                break;
            case 2:
                isDisplayed = cardC2EligibilityMessage.isDisplayed();
                break;
            default:
                throw new Exception("Invalid Card");
        }
        return isDisplayed;
    }

    public String getErrorMessage() {
        return errorMessage.getText().trim();
    }


    public void validateErrorMessage(String errorMessage) {
        assertThat("Error text is not available", errorMessages.isDisplayed());
        assertThat("Error Text  is wrong", errorMessages.getText().equalsIgnoreCase(errorMessage));

    }
}

