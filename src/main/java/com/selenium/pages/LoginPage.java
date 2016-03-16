package com.selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Maksym Kharchenko on 04.02.2016.
 */
public class LoginPage {

    @FindBy(id = "open_login_form")
    WebElement loginLink;

    @FindBy(id = "username")
    WebElement emailField;

    @FindBy(id = "password")
    WebElement passwordField;

    @FindBy(id = "bt_signin")
    WebElement loginBtn;

    @FindBy(id = "open-password")
    WebElement forgotPassLink;

    @FindBy(id = "username_forgot")
    WebElement forgotEmailField;

    @FindBy(id = "back-login")
    WebElement backToLoginLink;

    @FindBy(className = "login-error")
    WebElement errorMessage;

    @FindBy(id = "message_forgot")
    WebElement messForgotPass;

    @FindBy(className = "login")
    WebElement loginForm;

    public void openLoginForm() {
        loginLink.click();
        System.out.println("Click on the Login link");
    }

    public void setEmailField(String email) {
        emailField.sendKeys(email);
        System.out.println("Set email in to the Email field");
    }

    public void setPasswordField(String pass) {
        passwordField.sendKeys(pass);
        System.out.println("Set password in to the Password field");
    }

    public void setForgotEmailField(String email) {
        forgotEmailField.sendKeys(email);
        System.out.println("Set email in to the Forgot email field");
    }

    public void clickLoginBtn() {
        loginBtn.click();
        System.out.println("Click on the Login button");
    }

    public void backToLoginForm() {
        backToLoginLink.click();
    }

    public String getErrorLoginMessage() {
        System.out.println("Error message is:" + errorMessage.getText());
        return errorMessage.getText();
    }

    public boolean ifLoginFormOpened() {
        System.out.println("Check if Login form is opened" + loginForm.isDisplayed());
        return loginForm.isDisplayed();
    }

    public void clickOnForgotPassLink() {
        forgotPassLink.click();
        System.out.println("Click on the Forgot password link");
    }

    public boolean ifBackToLoginLinkDisplayed() {

        return backToLoginLink.isDisplayed();
    }

    public String getForgotPassMess() {
        return messForgotPass.getText();
    }
}
