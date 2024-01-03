package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.testng.Assert;

import java.util.Set;

public class Login_Steps {
    private WebDriver driver;

    @Before("@login")
    public void setup(){
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/java/drivers/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
    }

    @After("@login")
    public void tearDown(){
        driver.quit();
    }

    @Given("I access the WebDriver University login page")
    public void i_access_the_web_driver_university_login_page() {
        driver.get("https://webdriveruniversity.com/Login-Portal/index.html");
    }
    @When("I enter a specific username {word}")
    public void i_enter_a_specific_username(String username) {
        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(username);
    }
    @And("I enter a specific password {word}")
    public void i_enter_a_specific_password(String password) {
        driver.findElement(By.id("password")).sendKeys(password);
    }
    @And("I click on the login button")
    public void i_click_on_the_login_button() {
        driver.findElement(By.id("login-button")).click();
    }
    @Then("I should be presented with a successful login message")
    public void i_should_be_presented_with_a_successful_login_message() throws InterruptedException {
        String login_Message = driver.switchTo().alert().getText();
        Assert.assertEquals(login_Message,"validation succeeded");
    }

    @Then("I should be presented with a unsuccessful login message")
    public void i_should_be_presented_with_a_unsuccessful_login_message() {
        String login_Message = driver.switchTo().alert().getText();
        Assert.assertEquals(login_Message,"validation failed");
    }

}