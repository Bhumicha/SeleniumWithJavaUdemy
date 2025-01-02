package Section1to7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CheckboxAssignment {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        WebElement check = driver.findElement(By.id("checkBoxOption1"));


        //check checkboxes
        check.click();
        Assert.assertTrue(driver.findElement(By.id("checkBoxOption1")).isSelected());//validated checkbox selection
        if (check.isSelected()) {
            check.click();
        Assert.assertFalse(driver.findElement(By.id("checkBoxOption1")).isSelected());//validated checkbox deselection
        } else {
            System.out.println("Checkbox is already deselected");
        }

        //count the checkboxes
        System.out.println("The checkbox count is "+ driver.findElements(By.cssSelector("input[type='checkbox']")).size());//select checkbox 1

        driver.quit();
    }
}
