package practice;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriver;

public class login {
    public static void main(String[] args) {
        WebDriver driver;
        System.setProperty("webdriver.chrome.driver", "/IdeaProjects/Google Chrome V.104 webdriver/chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.get("http://dbankdemo.com/bank/login");

        driver.findElement(By.xpath("//*[@id='username']")).sendKeys("alexsmith@gmail.com");
        driver.findElement(By.xpath("//*[@id='password']")).sendKeys("Password_1");
        driver.findElement(By.xpath("//*[@id='submit']")).click();

        String title = driver.findElement(By.xpath("//*[@id='page-title']")).getText();
        Assert.assertEquals("Dashboard", title);
        String url = driver.getCurrentUrl();
        Assert.assertEquals("http://dbankdemo.com/bank/home", url);
        boolean isTitleDisplayed = driver.findElement(By.xpath("//*[@id='left-panel']/nav/div[1]/a[1]/img")).isDisplayed();
        Assert.assertTrue(isTitleDisplayed);

        System.out.println("Login Successful");
        driver.quit();
    }
}
