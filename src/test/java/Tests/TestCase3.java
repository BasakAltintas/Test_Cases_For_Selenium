package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class TestCase3 {
    /* 1. Go to https://practice-cybertekschool.herokuapp.com
 2. Click on “Multiple Buttons”
3. Click on “Button 1”
Verify that result message is displayed: “Clicked on button one!”  */

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = BrowserFactory.getDriver("chrome");

        driver.get("https://practice-cybertekschool.herokuapp.com/");

        driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[33]/a")).click();
        BrowserUtils.wait(2);
        driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/button[1]")).click();
        driver.findElement(By.id("result")).getText();
        BrowserUtils.wait(2);
        String expectedMessage = "Clicked on button one!";
        String actualMessage = driver.findElement(By.id("result")).getText();

        if (expectedMessage.equals(actualMessage)) {
            System.out.println("Test passed");
        }else{
            System.out.println("Test failed");
        }

    }
}
