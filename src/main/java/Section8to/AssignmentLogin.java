package Section8to;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class AssignmentLogin {
    public static void main(String[] args)
    {
        WebDriver driver= new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
        driver.findElement(By.id("password")).sendKeys("learning");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(7000));

        WebElement staticDropdown = driver.findElement(By.cssSelector("select[class='form-control']"));
        Select dropdown=new Select(staticDropdown);
        dropdown.selectByIndex(2);

        driver.findElement(By.id("terms")).click();
        driver.findElement(By.id("signInBtn")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Checkout")));
        List<WebElement> products = driver.findElements(By.cssSelector(".card-footer .btn-info"));
        for(int i =0;i<products.size();i++)
        {
            products.get(i).click();
        }
        driver.findElement(By.partialLinkText("Checkout")).click();}
}
