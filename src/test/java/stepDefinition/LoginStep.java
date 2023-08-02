package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LoginStep {
    WebDriver driver;

    @Given("User is in Login Page")
    public void user_is_in_login_page(){
        System.setProperty("webdriver.chrome.driver", "/IdeaProjects/Google Chrome V.104 webdriver/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("http://dbankdemo.com/bank/login");
    }

    @When("User enters {string} and {string}") //In Feature file User enters "username" and "password"
    public void user_enters_and(String username, String password){
        driver.findElement(By.xpath("//*[@id='username']")).sendKeys(username);
        driver.findElement(By.xpath("//*[@id='password']")).sendKeys(password);
        driver.findElement(By.xpath("//*[@id='submit']")).click();
    }

    @Then("User is login successfully")
    public void user_is_login_successfully(){
        String title = driver.findElement(By.xpath("//*[@id='page-title']")).getText();
        Assert.assertEquals("Dashboard", title);
        String url = driver.getCurrentUrl();
        Assert.assertEquals("http://dbankdemo.com/bank/home", url);
        boolean isTitleDisplayed = driver.findElement(By.xpath("//*[@id='left-panel']/nav/div[1]/a[1]/img")).isDisplayed();
        Assert.assertTrue(isTitleDisplayed);
        System.out.println("Login Successful");
    }

    @Then("User login unsuccessful")
    public void user_login_unsuccessful(){
        String errorMessage = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div")).getText();
        Assert.assertTrue(errorMessage.contains("Invalid credentials"));
        System.out.println("Login Unsuccessful");
    }

    @Then("User closes browser")
    public void user_closes_browser(){
        driver.quit();
    }

}
