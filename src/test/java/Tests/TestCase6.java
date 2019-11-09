package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BrowserFactory;

public class TestCase6 {
    /*Step 1. Go to https://practicecybertekschool.herokuapp.com
Step 2. Click on “Registration Form”
Step 3. Enter “user” into username input box.
Step 4. Verify that warning message is displayed: “The username must be more than 6 and less than 30 characters long” */
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = BrowserFactory.getDriver("chrome");

        driver.get(" https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[40]/a")).click();
        driver.findElement(By.name("username")).sendKeys("user");

        String warningMessage = "The username must be more than 6 and less than 30 characters long";
        String actualErrorMessage = driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[3]/div/small[2]")).getText();

        if(actualErrorMessage.equals(warningMessage)){
            System.out.println("Test passed");
        }else{
            System.out.println("Test failed");
        }
        driver.quit();
    }
}
