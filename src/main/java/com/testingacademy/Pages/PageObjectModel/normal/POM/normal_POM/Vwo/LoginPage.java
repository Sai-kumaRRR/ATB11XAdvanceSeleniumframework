package com.testingacademy.Pages.PageObjectModel.normal.POM.normal_POM.Vwo;



import com.testingacademy.Utils.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.testingacademy.Driver.DriverManager.PropertiesReader;

// Page Class
    public class LoginPage {

        WebDriver driver;
        private WaitHelpers WaitHelpers;

        public LoginPage(WebDriver driver) {
            this.driver = driver;
        }

        // Step 1- Page Locators
        private By username = By.id("login-username");
        private By password = By.id("login-password");
        private By signButton = By.id("js-login-btn");
        private By error_message = By.id("js-notification-box-msg");

        // If you are not using it , don't keep.
        //private By signBySSO = By.xpath("//button[normalize-space()='Sign in using SSO']");


        // Step 2 - Page Actions
        public String loginToVWOLoginInvalidCreds(String user, String pwd) {

            driver.get(PropertiesReader.readKey("url"));
            driver.findElement(username).sendKeys(user);
            driver.findElement(password).sendKeys(pwd);
            driver.findElement(signButton).click();

            // Wait - Thread sleep
//        WaitHelpers.waitJVM(5000);

            WaitHelpers.checkVisibility(driver, error_message, 3);

            String error_message_text = driver.findElement(error_message).getText();
            return error_message_text;
        }

        // Step 2 - Page Actions
        public void loginToVWOLoginValidCred(String user, String pwd) {

            driver.get(PropertiesReader.readKey("url"));
            driver.findElement(username).sendKeys(user);
            driver.findElement(password).sendKeys(pwd);
            driver.findElement(signButton).click();

            // Wait - Thread sleep
            WaitHelpers.waitJVM(5000);

        }
    }

