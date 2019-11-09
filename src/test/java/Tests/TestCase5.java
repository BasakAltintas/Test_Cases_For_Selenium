package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class TestCase5 {
    /*Step 1. Go to https://practicecybertekschool.herokuapp.com
Step 2. Click on “Registration Form”
Step 3. Enter “123” into last name input box.
Step 4. Verify that warning message is displayed: “The last name can only consist of alphabetical letters and dash” */

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = BrowserFactory.getDriver("chrome");

        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[40]/a")).click();
        driver.findElement(By.name("lastname")).sendKeys("123");
        driver.findElement(By.name("lastname")).click();

        String warningMessage = "The last name can only consist of alphabetical letters and dash";
        String actualMessage = driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[2]/div/small[3]")).getText();

        if (warningMessage.equals(actualMessage)){
            System.out.println("test passed");
        }else{
            System.out.println("Test failed");
            }
        BrowserUtils.wait(2);
        driver.quit();


    }
}
