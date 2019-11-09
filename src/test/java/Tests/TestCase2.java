package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;

import java.util.List;

public class TestCase2 {
    /*Step 1. Go to https://practicecybertekschool.herokuapp.com
Step 2. Verify that number of listed examples is equals to 48.
Hint: use findElemnts() and size() methods */
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        WebElement list = driver.findElement(By.className("list-group"));
        List<WebElement> links = list.findElements(By.tagName("li"));
        if(links.size() == 48){
            System.out.println("Number of listed examples is 48... \nTEST PASSED");
        }else {
            System.out.println("Number of listed examples is not 48... \nTEST FAILED");
        }
        driver.close();
    }


}
