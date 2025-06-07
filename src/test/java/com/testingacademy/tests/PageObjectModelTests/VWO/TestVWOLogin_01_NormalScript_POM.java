package com.testingacademy.tests.PageObjectModelTests.VWO;

import com.thetestingacademy.base.CommonToAllTest;
import com.thetestingacademy.pages.pageObjectModel.normal_POM.normal_POM.vwo.DashBoardPage;
import com.thetestingacademy.pages.pageObjectModel.normal_POM.normal_POM.vwo.LoginPage;
import com.thetestingacademy.utils.PropertiesReader;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.annotations.Test;

import static com.testingacademy.Driver.DriverManager.PropertiesReader;
import static com.testingacademy.Driver.DriverManager.driver;

import static org.assertj.core.api.Assertions.*;
import org.testng.Assert;

public class TestVWOLogin_01_NormalScript_POM<DashBoardPage> extends CommonToAllTest {

    @Description("Verify that with invalid email, pass, error message is shown on the app.vwo.com")
    @Test
    public void test_negative_vwo_login(){

        // Driver Manager Code - 1
        // Page Class Code (POM Code) - 2

        LoginPage loginPage;
        loginPage = new LoginPage(driver);
        String error_msg = loginPage.loginToVWOLoginInvalidCred(PropertiesReader.readKey("invalid_username"), PropertiesReader.readKey("invalid_password"));

        // Assertions - 3
        assertThat(error_msg).isNotNull().isNotBlank().isNotEmpty();
        Assert.assertEquals(error_msg,PropertiesReader.readKey("error_message"));

    }

    @Owner("Sai")
    @Description("TC#2-Verify that valid creds dashboard page is loaded")
    @Test
    public void testLoginPositiveVWO() {

        LoginPage loginPage_VWO = new LoginPage(driver);
        loginPage_VWO.loginToVWOLoginValidCreds(PropertiesReader.readKey("username"),PropertiesReader.readKey("password"));

        DashBoardPage dashBoardPage  = new DashBoardPage(driver);
        String usernameLoggedIn = dashBoardPage.loggedInUserName();


        assertThat(usernameLoggedIn).isNotBlank().isNotNull().isNotEmpty();
        Assert.assertEquals(usernameLoggedIn,PropertiesReader.readKey("expected_username"));


    }
}