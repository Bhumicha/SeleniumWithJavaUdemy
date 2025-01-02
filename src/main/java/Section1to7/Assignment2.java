package Section1to7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;

public class Assignment2 {
    public static void main(String[] args)
    {

    WebDriver    driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        driver.manage().window().maximize();
        driver.findElement(By.name("name")).sendKeys("Bhumika Shrestha");
        driver.findElement(By.name("email")).sendKeys("bhumikaashrestha@gmail.com");
        driver.findElement(By.id("exampleInputPassword1")).click();
        driver.findElement(By.id("exampleInputPassword1")).sendKeys("Kcm1234");
        driver.findElement(By.id("exampleCheck1")).click();
        driver.findElement(By.id("exampleFormControlSelect1")).click();
        {
            WebElement dropdown = driver.findElement(By.id("exampleFormControlSelect1"));
            dropdown.findElement(By.xpath("//option[. = 'Female']")).click();
        }
        driver.findElement(By.id("inlineRadio1")).click();
        driver.findElement(By.name("bday")).click();
        driver.findElement(By.name("bday")).sendKeys("2025-01-03");
        driver.findElement(By.cssSelector(".btn")).click();
        driver.quit();
    }

}
