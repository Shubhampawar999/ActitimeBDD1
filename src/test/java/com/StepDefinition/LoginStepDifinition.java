package com.StepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class LoginStepDifinition {
    WebDriver driver;

    @Given("I login to application with valid username and password")
    public void iLoginToApplicationWithValidUsernameAndPassword() {

        System.out.println("@given");
       // WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(setChromeOptions());
        driver.get("https://demo.actitime.com");

    }

    @When("I enter username {string} and password {string}")
    public void iEnterUsernameAndPasswordManager(String username, String password) throws Throwable {
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@name='pwd']")).sendKeys(password);
    }


    @Then("I verify user is logged in to application successfully")
    public void iVerifyUserIsLoggedInToApplicationSuccessfully() {
        System.out.println("@then");
        String tital=driver.getTitle();
        System.out.println(tital);
        if(tital.equals("actiTIME - Login")){
            System.out.println("Successfuly launched the login page");
        }else{
            System.out.println("Not logged in Successfuly application home page");
        }

       // driver.close();
    }

    @And("perform click operation")
    public void performClickOperation() {
        driver.findElement(By.xpath("//a[@id='loginButton']")).click();
    }

    public ChromeOptions setChromeOptions() {
        ChromeOptions option = new ChromeOptions();
        option.addArguments("start-maximized");
        option.addArguments("--remote-allow-origins=*");
        option.addArguments("incognito");
        option.setHeadless(false);
        option.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-clocking"));
        Map<String, String> prefs = new HashMap<>();
        prefs.put("download.default.directory", "C:/Users/shubham/Downloads/");
        option.setExperimentalOption("prefs", prefs);
        option.setAcceptInsecureCerts(true);
        return option;
    }

    @Given("I launched the {string} browser")
    public void iLaunchedTheBrowser(String browser) {
        System.out.println(browser);
        driver.get("browser");
    }


    @Then("I verify user is not logged in application")
    public void iVerifyUserIsNotLoggedInApplication() {
        System.out.println("click");
    }

    @Then("Verify employee")
    public void verifyEmployee() {
        System.out.println("verifyEmployee");
    }

    @When("Add the employee")
    public void addTheEmployee() {

    }

}
