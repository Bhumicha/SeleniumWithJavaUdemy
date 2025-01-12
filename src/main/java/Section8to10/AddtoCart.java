package Section8to10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class AddtoCart {
        public static void main(String[] args) {
            WebDriver driver = new ChromeDriver();
            driver.get("https://rahulshettyacademy.com/seleniumPractise");
            String names="Cucumber";

            List<WebElement> products=driver.findElements(By.cssSelector("h4.product-name"));
            for (int i=0;  i<products.size(); i++)
            {
                String name=products.get(i).getText();
                if(name.contains(names))
                {
                    driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();                    break;
                }
            }
        }
}
