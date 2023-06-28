package com.StepDefinition;

import com.github.javafaker.Faker;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pojo.UsersPayload;
import pojo.Usertype;

import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class AddNewUser extends BaseClass {
    WebDriver driver;
    String str;

    String str1;
    int  userId;
  public  Usertype payloadpogo11;

    @Given("I lauch browser")
    public void i_lauch_browser() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(setChromeOptions());
        driver.get("https://demo.actitime.com");

        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("admin");
        driver.findElement(By.xpath("//input[@name='pwd']")).sendKeys("manager");
        driver.findElement(By.xpath("//a[@id='loginButton']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//div[@id='container_users']/parent::a")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//div[contains(text(),'New User')]")).click();
    }

    @When("I add the new user")
    public void i_add_the_new_user(DataTable userDetails) throws InterruptedException {
        System.out.println("add new user");
        List<Map<String, String>> list = userDetails.asMaps();
        Map<String, String> map = list.get(0);
        Object o = map.get("firstName");

        String str = (String) o;
        System.out.println(str);


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//input[@id='createUserPanel_firstNameField']")))).sendKeys(str);
        Object o1 = map.get("LastName");
        String str1 = (String) o1;
        System.out.println(str1);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//input[@id='createUserPanel_lastNameField']")))).sendKeys(str1);

        Object o2 = map.get("emailId");
        String str2 = (String) o2;
        System.out.println(str2);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='createUserPanel_emailField']"))).sendKeys(str2);

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'Save & Send Invitation')]"))).click();
        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Close']"))).click();
//close this window


    }


    @And("Verify added value")
    public void verifyAddedValue() {
        System.out.println("Verify added new employee");
    }

    @Then("Added new employee deleted")
    public void addedNewEmployeeDeleted() {

        System.out.println("Veerify added new user is successfully deleted");
        driver.findElement(By.xpath("//thead[@id='userListTableHeader']/descendant::tr[2]/descendant::div[@class='userList_wordsFilter']/div[1]")).click();
//driver.findElement(By.xpath("//tr[@id='pageHeader']/following-sibling::tr[2]/descendant::input[2]")).sendKeys(str);
        System.out.println(str);

    }

    @When("I pass the data in form of dataTable class")
    public void iPassTheDataInFormOfDataTableClass(DataTable userDt) {
        System.out.println("Pass the multiple data in the foorm of data table");
        List<Map<String, String>> list = userDt.asMaps();
        for (Map<String, String> map : list) {
            for (Map.Entry map1 : map.entrySet()) {
                System.out.println("kay:" + map1.getKey() + " , " + "value:" + map1.getValue());
            }
        }
    }

    @And("I removing the added new user")
    public void iRemovingTheAddedNewUser() {
        System.out.println(" removing the added new user successfully");
    }

    @Then("Verify added new user successfully delet")
    public void verifyAddedNewUserSuccessfullyDelet() {
        System.out.println("verify added new user successfully deleted");
    }



        @When("I add the user")
        public void iAddTheUser (DataTable datatable){
            System.out.println("add new user");
            List<Map<String, String>> list = datatable.asMaps();

            for (Map<String, String> map : list) {
                for (Map.Entry map1 : map.entrySet()) {
                    System.out.println("kay:" + map1.getKey() + " , " + "value:" + map1.getValue());
                }
            }

        }
        public ChromeOptions setChromeOptions () {
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




    @Given("Add new user {int} timee")
    public void addNewUserTimee(int arg,DataTable userdata) throws InterruptedException {
        for(int i=0; i<arg;i++){
        List<Map<String,String>> list = userdata.asMaps();
        Map<String,String>  map=list.get(0);
       String str=  map.get("firstName");
      // System.out.println(str);
       WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
       wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//input[@id='createUserPanel_firstNameField']")))).sendKeys(str);
         str1=map.get("lastName");
       // System.out.println(str1);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//input[@id='createUserPanel_lastNameField']")))).sendKeys(str1);
            String str2=map.get("emailId");
        //System.out.println(str2);
            wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//input[@id='createUserPanel_emailField']")))).sendKeys(str2);
wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[contains(text(),'Save & Send Invitation')]")))).click();

wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//span[contains(text(),'Invite one more user')]")))).click();
            Thread.sleep(3000);
        }
   }

    @Then("I verify added new three user")
    public void iVerifyAddedNewThreeUser() {
        driver.findElement(By.xpath("//div[contains(@class,'closeButton hideButton_panelContainer')]")).click();
        driver.findElement(By.xpath("//table[@class='userNameSelectorsTable']/descendant::div[@class='icon']")).click();
        driver.findElement(By.xpath("//thead[@id='userListTableHeader']/descendant::input[contains(@placeholder,\"Start typing name...\")]")).sendKeys(str1);
       WebElement element= driver.findElement(By.xpath("//span[text()='pawar']"));
      String lastname= element.getText();
        if(lastname.equals("pawar")){
            System.out.println("Add employee successfuly");
        }else{
            System.out.println("Not added employee ");
        }
    }


    @Given("I set the request structure and create user")
    public void iSetTheRequestStructureAndCreateUser(Map<String,String> map) {
        RestAssured.useRelaxedHTTPSValidation();
       String username= map.get("name");
        requestSpecification = given();
        requestSpecification.baseUri("https://gorest.co.in/")
                .basePath("/public/v2")
                .header("Authorization", "Basic QmVhcmVyOjdlYzkxNWQzMzY3MjZiMWVmM2MxMjMzMzViOTg5MjZkNzI5M2FiMTk0NmY0Yjg3OGNkOTA1NWU4M2E4ZGJjMWM=")
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .body(username)
                .log()
                .all();

    }

    @Given("I set up the request structuree")
    public void iSetUpTheRequestStructuree(DataTable table) {
    Map<String,String> dataTable=table.asMaps().get(0);
         payloadpogo11=new Usertype();
        String name=(dataTable.get("firstName").equals("random")?new Faker().name().firstName():dataTable.get("firstName"));
        payloadpogo11.setfirstName(name);
        String email=(dataTable.get("email").equals("random")?name+"@gmail.com":dataTable.get("email"));
        payloadpogo11.setEmail(email);
        String username=(dataTable.get("username").equals("random")?new Faker().name().lastName():dataTable.get("username"));
        payloadpogo11.setUsername(username);
        payloadpogo11.setLastName(name);
        payloadpogo11.setPassword(dataTable.get("password"));
        String fullName=(dataTable.get("fullName").equals("random")?new Faker().name().title():dataTable.get("fullName"));
        payloadpogo11.setFullName(fullName);
        System.out.println(payloadpogo11);

requestSpecification=given();
        requestSpecification.baseUri("https://demo.actitime.com/")
                .basePath("/api/v1/")
                .header("Authorization", "Basic YWRtaW46bWFuYWdlcg==")
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .body(payloadpogo11)
                .log()
                .all();


    }




    @Then("I get the apii")
    public void iGetTheApii() {
        requestSpecification=given();
        requestSpecification.baseUri("https://demo.actitime.com/")
                .basePath("/api/v1/")
                .header("Authorization", "Basic YWRtaW46bWFuYWdlcg==")
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .log()
                .all();

    }
    @Then("I verify the name and")
    public void iVerifyTheNameAnd() {
        Assert.assertEquals(200, responce.getStatusCode());
        UsersPayload usersPayload = new UsersPayload();
        UsersPayload[] list = responce.jsonPath().getObject("items", UsersPayload[].class);
        boolean flag = false;
        for (UsersPayload uspay : list) {
          System.out.println( uspay.getfirstName());
        }
    }}