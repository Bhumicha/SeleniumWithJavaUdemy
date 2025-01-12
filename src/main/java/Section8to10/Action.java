package Section8to10;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Action {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.amazon.in/stores/page/FB61ADA2-F77A-413C-97C9-BB74C754829D");
        driver.manage().window().maximize();
        Actions a =new Actions(driver);

        WebElement move=driver.findElement(By.cssSelector("a[id='nav-link-accountList']"));
        a.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("laptop").doubleClick().build().perform();
        //moves to specific element
        a.moveToElement(move).build().perform();

        a.moveToElement(move).contextClick().perform();

    }
}
