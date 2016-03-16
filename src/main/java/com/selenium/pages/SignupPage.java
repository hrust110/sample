package com.selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Maksym Kharchenko on 04.02.2016.
 */
public class SignupPage {
    @FindBy(xpath = "//*[@id=\"main-nav\"]/ul/li[2]/a")
    WebElement signupBtn;

    @FindBy(id = "username")
    WebElement emailField;

    @FindBy(id = "password")
    WebElement passwordFiled;

    @FindBy(id = "c-password")
    WebElement confirmPassField;

    @FindBy(className = "btn")
    WebElement submintBtn;

    @FindBy(id = "731")
    WebElement premiumMembership;

    @FindBy(id = "4")
    WebElement threeMonthMembership;

    @FindBy(id = "5")
    WebElement fiveMonthMembership;

    @FindBy(id = "first-name")
    WebElement firstNameField;

    @FindBy(id = "last-name")
    WebElement lastNameField;

    @FindBy(id = "zip_code")
    WebElement zipCodeField;

    @FindBy(id = "ccn")
    WebElement cardNumberField;

    @FindBy(id = "cvv2_code")
    WebElement cvvCodeField;

    //There is always January selects. If we need another month, we need to change xpath of the month element
    @FindBy(id = "month")
    WebElement monthDropdown;

    @FindBy(xpath = "//*[@id=\"month-styler\"]/div[2]/ul/li[3]")
    WebElement month;

    ////There is always 2018 selects. If we need another year, we need to change xpath of the year element
    @FindBy(id = "year")
    WebElement yearDropdown;

    @FindBy(xpath = "//*[@id=\"year-styler\"]/div[2]/ul/li[4]")
    WebElement year;

    @FindBy(id = "continue3")
    WebElement createAccountBtn;

    @FindBy(id = "unicef-button-2")
    WebElement continueBtnUnicefPage;

    @FindBy(id = "unicef-button")
    WebElement donateBtn;

    @FindBy(id = "continue-receipt")
    WebElement continueBtnThankyouPage;

    @FindBy(id = "change_email")
    WebElement changeEmailBtn;

    /*methods of the current page object*/

    public void setEmailField(String email) {
        emailField.clear();
        emailField.sendKeys(email);
    }

    public String getEmail() {
        return emailField.getText();
    }

    public void setPasswordFiled(String pass) {
        passwordFiled.clear();
        passwordFiled.sendKeys(pass);
    }

    public String getPassword() {
        return passwordFiled.getText();
    }

    public void setConfirmPassField(String pass) {
        confirmPassField.clear();
        confirmPassField.sendKeys(pass);
    }

    public String getConfirmationPass() {
        return confirmPassField.getText();
    }

    public void selectPremiummembership() {
        premiumMembership.click();
    }

    public void selectThreemonthMembership() {
        threeMonthMembership.click();
    }


}
