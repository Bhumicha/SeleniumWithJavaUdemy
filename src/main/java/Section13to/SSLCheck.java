package Section13to;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SSLCheck {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        ChromeOptions options=new ChromeOptions();
        options.setAcceptInsecureCerts(true);
        driver.get("https://expired.badssl.com/");
        System.out.println(driver.getTitle());
        driver.quit();
    }
}
