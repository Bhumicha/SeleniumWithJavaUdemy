package Section14to;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class WebTableSorting 
{
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        //click on the column
        driver.findElement(By.xpath("//tr/th[1]")).click();
        //capture all webelements into list
        List<WebElement> elementList = driver.findElements(By.xpath("//tr/td[1]"));

        //capture all webelements into list
        List<String> originalList = elementList.stream().map(s->s.getText()).collect(Collectors.toList());
        
        //sort on the original list
        List<String>sortedList = originalList.stream().sorted().collect(Collectors.toList());
        Assert.assertTrue(originalList.equals(sortedList));
    
}
}
