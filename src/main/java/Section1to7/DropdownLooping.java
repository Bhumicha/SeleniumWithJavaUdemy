package Section1to7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DropdownLooping {
    public static void main(String [] args) throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.get("https://spicejet.com");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector(".css-1dbjc4n:nth-child(2) > .css-1dbjc4n:nth-child(5) > .css-1dbjc4n > div > .css-1dbjc4n:nth-child(1) > .css-1dbjc4n")).click();
        Thread.sleep(3000);
        //while loop
     //   int i=1;
//        while(i<5)
//        {
       // driver.findElement(By.cssSelector(".css-1dbjc4n:nth-child(1) > .css-1dbjc4n:nth-child(1) > .css-1dbjc4n:nth-child(2) > .r-1awozwy:nth-child(3)")).click();
//            i++;
//        }

        //for loop
        for(int i=1; i<5; i++)
        {
            driver.findElement(By.cssSelector(".css-1dbjc4n:nth-child(1) > .css-1dbjc4n:nth-child(1) > .css-1dbjc4n:nth-child(2) > .r-1awozwy:nth-child(3)")).click();
            //4 times
        }
        System.out.println(driver.findElement(By.cssSelector(".css-1dbjc4n:nth-child(2) > .css-1dbjc4n:nth-child(5) > .css-1dbjc4n > div > .css-1dbjc4n:nth-child(1) > .css-1dbjc4n")).getText());
        driver.quit();
    }
}
