package Section13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class CheckHTTPStatusCode {
    public static void main(String[] args) throws InterruptedException, IOException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://d.kcmg.nl/");

        List<WebElement> links=   driver.findElements(By.cssSelector("li[class='gf-li'] a"));
        for(WebElement link : links)
        {
            String url = link.getAttribute("href");

            HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
            conn.setRequestMethod("HEAD");
            conn.connect();
            int resCode = conn.getResponseCode();
            System.out.println(resCode);
            Assert.assertTrue(resCode<400,"The links with text"+link.getText()+"is broken with code"+resCode);
            if (resCode > 400) {
                System.out.println("The link with Test.test" + link.getText()+"is broken with code"+resCode);
            }
        }
    }
}
