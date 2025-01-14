package Section15;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Relativelocators {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        WebElement nameEditBox = driver.findElement(org.openqa.selenium.By.cssSelector("input[name='name']"));
        driver.findElement(with(By.tagName("label")).aboce(nameEditBox)).getText();

    }
        
    
}
