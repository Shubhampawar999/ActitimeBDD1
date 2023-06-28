package com.StepDefinition;

import io.cucumber.java.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class HooksApplyInScenario {

WebDriver driver;

   /* @Before
    public void before() throws InterruptedException {
        System.out.println("Navigate to the actiTime application ");
        driver=new ChromeDriver(setChromeOptions());
        driver.get("https://demo.actitime.com");
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("admin");
        driver.findElement(By.xpath("//input[@name='pwd']")).sendKeys("manager");
        driver.findElement(By.xpath("//a[@id='loginButton']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//div[@id='container_tt']")).click();
    }

    @After
    public void after(){
        System.out.println("Close the browser");
        //driver.close();
    }

    @BeforeStep
    public void beforestep(){
        System.out.println("Navigate to the task module");


    }
    @AfterStep
    public void afterStep(){
        System.out.println("Navigate to the step successfully");
    }*/

    @Given("I lauch  browser in using actitime url")
    public void iLauchBrowserInUsingActitimeUrl() throws InterruptedException {
        System.out.println("creat the new task");
//click on the new task button
        driver.findElement(By.xpath("//div[@id='container_tasks']/parent::*")).click();
        //click on add new task button
        driver.findElement(By.xpath("//div[contains(text(),'Add New')]/parent::*")).click();
  //click addnew customer
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@id='taskManagementPage']/following-sibling::div[1]/div[1]")).click();
        Thread.sleep(2000);
       WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
      WebElement nameofcust=  wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[@id='customerLightBox_content']/descendant::input[1]"))));
        nameofcust.sendKeys("HDFC BANK");
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[contains(text(),'Create Customer')]/parent::*")))).click();

    //click on add new button using java Script perform click operation
      WebElement ele= driver.findElement(By.xpath("//div[contains(text(),'Add New')]/parent::*"));
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",ele);
        //click on new project button
        driver.findElement(By.xpath("//div[@id='taskManagementPage']/following-sibling::div[1]/div[2]")).click();
        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[@id='createProjectPopup_content']/descendant::input[1]")))).sendKeys("Employee Operation");
wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[contains(text(),'Create Project.json')]/parent::*")))).click();

   //click on add new button using java script
        WebElement ele1= driver.findElement(By.xpath("//div[contains(text(),'Add New')]/parent::*"));
        js.executeScript("arguments[0].click();",ele);
        Thread.sleep(2000);
        //click on new task
        driver.findElement(By.xpath("//div[@id='taskManagementPage']/following-sibling::div[1]/div[3]")).click();
        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[@id='createTasksPopup_content']/descendant::div[@class='tablePlaceholder']/descendant::td[contains(@class,'nameCell first')][1]/input")))).sendKeys("Adding empolye");
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[contains(text(),'Create Tasks')]")))).click();


    }

    @When("Navigate to the AddTask module and creat task")
    public void navigateToTheAddTaskModuleAndCreatTask() {
        System.out.println("Add new task in task module");
    }

    @Then("Verify the added new task in task module")
    public void verifyTheAddedNewTaskInTaskModule() {
        System.out.println("Verify successfully added new task in add task module");
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
}
