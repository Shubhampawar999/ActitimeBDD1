package com.StepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;



public class VerifyTextFilled {
    WebDriver driver;
    @Given("Navigate to   actitime applicatione")
    public void navigate_to_actitime_applicatione() throws InterruptedException {
      //  WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(setChromeOptions());
        driver.get("https://demo.actitime.com");
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("admin");
        driver.findElement(By.xpath("//input[@name='pwd']")).sendKeys("manager");
        driver.findElement(By.xpath("//a[@id='loginButton']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//div[@id='container_users']/parent::a")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[contains(text(),'New User')]")).click();
    }
    @When("Add the multiple inputee")
    public void add_the_multiple_inputee(Map<String,String> userData) {
        driver.findElement(By.xpath("//div[contains(text(),'New User')]")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
       String firstname= userData.get("firstName");
      System.out.println(firstname);
       String lastname= userData.get("lastName");
       System.out.println(lastname);
       String emailId= userData.get("emailId");
       System.out.println(emailId);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//input[@id='createUserPanel_firstNameField']")))).sendKeys(userData.get(firstname));


        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//input[@id='createUserPanel_lastNameField']")))).sendKeys(userData.get(lastname));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='createUserPanel_emailField']"))).sendKeys(userData.get(emailId));

        driver.findElement(By.xpath("//div[contains(text(),'Save & Send Invitation')]")).click();


    }
    @Then("Verify error msgee")
    public void verify_error_msgee() {
        System.out.print("given");
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


    @Given("Connectiing the url")
    public void connectiingTheUrl(List<String> list) {
        for(String string:list){
            System.out.println(string);
        }

    }


}