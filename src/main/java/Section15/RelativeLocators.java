package Section15;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class RelativeLocators {
    public static void main(String[] args) throws InterruptedException, IOException {
        WebDriver driver = new ChromeDriver();


        driver.get("https://rahulshettyacademy.com/angularpractice/");


        WebElement nameEditBox = driver.findElement(By.cssSelector("[name='name']"));
        System.out.println(driver.findElement(with(By.tagName("label")).above(nameEditBox)).getText());


        WebElement dateOfBirth= driver.findElement(By.cssSelector("input[name='bday']"));
        driver.findElement(with(By.tagName("input")).below(dateOfBirth)).click();

        WebElement iceCreamLabel= driver.findElement(By.xpath("//label[text()='Check me out if you Love IceCreams!']"));
        driver.findElement(with(By.tagName("input")).toLeftOf(iceCreamLabel)).click();

        WebElement radioButton= driver.findElement(By.id("inlineRadio1"));
        driver.findElement(with(By.tagName("input")).toRightOf(radioButton)).click();

        Select genderSelect= new Select(driver.findElement(By.id("exampleFormControlSelect1")));
        genderSelect.selectByVisibleText("Female");




    }
        
    
}
