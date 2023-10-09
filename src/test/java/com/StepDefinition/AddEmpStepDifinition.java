package com.StepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;


public class AddEmpStepDifinition {
    WebDriver driver;

    @Given("I navigate to pim module in orangehrm")
    public void navigateToActitime() throws Throwable {
       // WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver(setChromeOptions());
        driver.get("https://demo.actitime.com");
    }
    @When("I entering username {string} and password {string}")
    public void iEnteringUsernameAndPassword(String username, String password) throws Throwable {
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@name='pwd']")).sendKeys(password);
    }
    @And("I click the login button")
    public void iClickTheLoginButton() throws InterruptedException {
        driver.findElement(By.xpath("//a[@id='loginButton']")).click();
        Thread.sleep(5000);
    }
    @Given("Navigate to the pim module")
    public void navigateToTheUserModule() {

        driver.findElement(By.xpath("//div[@id='container_users']/parent::a")).click();
        String tital = driver.getTitle();
        if (tital.equals("actiTIME - User List")) {
            System.out.println("Navigate successfuly in user module from actitime");
        } else {
            System.out.println("Not navigated from user module");}
    }
    @And("Click on the addemployee and add button")
    public void clickOnTheAddemployeeAndAddButton() throws InterruptedException {
        System.out.println("click on the add employee");
        driver.findElement(By.xpath("//div[contains(text(),'New User')]")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
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


    @When("I add the new user in actitimee firstname {string} and lastname {string} and emailid {string}")
    public void iAddTheNewUserInActitimeeFirstnameAndLastnameAndEmailid(String firstname, String lastname, String emailid) {
        System.out.println(firstname);
        // driver.switchTo().window().
        // WebElement firstnam= driver.findElement(By.xpath("//input[@id=\"createUserPanel_firstNameField\"]"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//input[@id='createUserPanel_firstNameField']")))).sendKeys(firstname);


        System.out.println(lastname);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//input[@id='createUserPanel_lastNameField']")))).sendKeys(lastname);
        System.out.println(emailid);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='createUserPanel_emailField']"))).sendKeys(emailid);

        driver.findElement(By.xpath("//div[contains(text(),'Save & Send Invitation')]")).click();


    }


    @Given("Navigate to the user modulee in actitime")
    public void navigateToTheUserModuleeInActitime() throws InterruptedException {
        System.out.println("logged to successfully in actitime application");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@id='container_users']/parent::a")).click();


    }


    @When("Search user for userlist")
    public void searchUserForUserlist() {
        String name = driver.getTitle();
        System.out.println(name);
        if (name.equals("actiTIME - User List")) {
            System.out.println("Navigate successfuly in user module from actitime");
        } else {
            System.out.println("Not navigated from user module");

        }
    }

    @Then("Verify user add successfully in userlist")
    public void verifyUserAddSuccessfullyInUserlist() {
        System.out.println("verify the user added successfuly in usermodule");

        // driver.findElement(By.xpath("//thead[@id='userListTableHeader']/descendant::tr[2]/descendant::div[@class='userList_wordsFilter']/div[1]")).click();
        // AddEmpStepDifinition addEmpStepDifinition=new AddEmpStepDifinition();
        // String firstname= addEmpStepDifinition.iAddTheNewUserInActitimeeFirstnameAndLastnameAndEmailid("firstname","lastname","emailid");
        // System.out.println(firstname);
        //driver.findElement(By.xpath("//thead[@id='userListTableHeader']/descendant::tr[2]/descendant::input")).sendKeys(firstname);


    }


}
