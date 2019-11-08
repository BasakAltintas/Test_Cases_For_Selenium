package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BrowserFactory;
import utils.VerifyStringEquality;

public class TestCase4 {
    /*Step 1. Go to https://practicecybertekschool.herokuapp.com
Step 2. Click on “Registration Form”
Step 3. Enter “123” into ﬁrst name input box.
Step 4. Verify that warning message is displayed: “ﬁrst name can only consist of alphabetical letters”*/

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = BrowserFactory.getDriver("chrome");

        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[40]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[1]/label")).sendKeys("123");
        String expectedErrorMessage = "first name can only consist of alphabetical letters";
        String actualErrorMessage = driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[1]/div/small[3]")).getText();
        VerifyStringEquality.verifyStrings(expectedErrorMessage, actualErrorMessage);
        driver.close();
    }
}
