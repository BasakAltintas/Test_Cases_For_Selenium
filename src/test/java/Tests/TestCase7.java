package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BrowserFactory;

public class TestCase7 {
    /*Step 1. Go to https://practice-cybertekschool.herokuapp.com
Step 2. Click on “Registration Form”
Step 3. Enter “testers@email” into email input box.
Step 4. Verify that warning message is displayed: “email address is not a valid
Email format is not correct” */
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = BrowserFactory.getDriver("chrome");

        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[40]/a")).click();
        driver.findElement(By.name("email")).sendKeys("testers@email");

        String actualWarningMessage = driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[4]/div/small[2]")).getText();
        String warningMessage = "email address is not a valid Email format is not correct";

        if(actualWarningMessage.equals(warningMessage)){
            System.out.println("Test passed");
        }else{
            System.out.println("Test failed");
        }
        driver.quit();
    }
}
