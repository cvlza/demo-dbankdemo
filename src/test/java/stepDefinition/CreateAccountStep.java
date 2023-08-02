package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CreateAccountStep {
   WebDriver driver;
    @Given("User has no Checking Account")
    public void user_has_no_checking_account(){
        driver.findElement(By.xpath("//*[@id='checking-menu']")).click();
        driver.findElement(By.xpath("//*[@id='view-checking-menu-item']")).click();
        String message = driver.findElement(By.xpath("//*[@id='largeModalLabel']")).getText();
        Assert.assertTrue(message.equals("No Accounts"));
    }

    @When("User creates new Checking Account")
    public void user_creates_new_checking_account(){
        boolean emptyAccounts = driver.findElement(By.xpath("//*[@id='emptyAccounts']/div/div/div[3]/a/button")).isDisplayed();
        if(emptyAccounts == true){
            driver.findElement(By.xpath("//*[@id='emptyAccounts']/div/div/div[3]/a/button")).click();
        }

        WebElement checkAccountType = driver.findElement(By.id("Standard Checking"));
        boolean selectedState = checkAccountType.isSelected();
        if(selectedState == false){
            checkAccountType.click();
        }

        WebElement AccountOwnership = driver.findElement(By.id("Individual"));
        selectedState = AccountOwnership.isSelected();
        if(selectedState == false){
            AccountOwnership.click();
        }

        driver.findElement(By.xpath("//*[@id='name']")).sendKeys("firstCheckingAcct");
        driver.findElement(By.xpath("//*[@id='openingBalance']")).sendKeys("25");

        //*[@id="new-account-error-msg"]  when initial deposit is less than 25
    }

    @Then("New Checking Account created")
    public void new_checking_account_created(){
        String newAccountMessage = driver.findElement(By.xpath("//*[@id='new-account-msg']")).getText();
        Assert.assertTrue(newAccountMessage.contains("Successfully created new Standard Checking account"));
    }

}
