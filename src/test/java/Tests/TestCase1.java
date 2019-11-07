package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.http.util.Asserts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.BrowserFactory;
import utils.BrowserUtils;
import utils.VerifyStringEquality;

public class TestCase1 {
    /*Test case #1
    Step 1. Go to https://practice-cybertekschool.herokuapp.comStep
    2. Click on “Sign Up For Mailing List”Step
    3. Enter any valid nameStep
    4. Enter any valid emailStep
    5. Click on “Sign Up” buttonExpected result:
    Following message should be displayed:
    “Thank you for signing up.
    Click the button below to return to the home page.”
    Home button should be displayed */

    public static void main(String[] args) {
        //WebDriverManager.chromedriver().setup();
        WebDriver driver = BrowserFactory.getDriver("chrome");

        driver.get("https://practice-cybertekschool.herokuapp.com");

        BrowserUtils.wait(2);

        driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[43]/a")).click();
        BrowserUtils.wait(2);
        driver.findElement(By.name("full_name")).sendKeys("Hello");

        driver.findElement(By.name("email")).sendKeys("kukuleta@gmail.com");

        driver.findElement(By.name("wooden_spoon")).click();
        BrowserUtils.wait(2);

       String expectedMessage = "Thank you for signing up. Click the button below to return to the home page.";
        BrowserUtils.wait(2);
       String actualMessage = driver.findElement(By.name("signup_message")).getText();


        boolean homeButton = driver.findElement(By.xpath("//*[@id=\"wooden_spoon\"]/i")).isDisplayed();

        VerifyStringEquality.verifyStrings(expectedMessage,actualMessage,homeButton);
        BrowserUtils.wait(2);

        driver.findElement(By.xpath("//*[@id=\"wooden_spoon\"]/i")).click();
        BrowserUtils.wait(4);
        driver.close();





    }
}
