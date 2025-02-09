package Testing;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import javax.mail.*;
import java.time.Duration;
import java.util.Properties;

public class EmailVerifier {
    private WebDriver driver;
    private WebDriverWait wait;
    private final String EMAIL;
    private final String PASSWORD;

    public EmailVerifier(WebDriver driver, String email, String password) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        this.EMAIL = email;
        this.PASSWORD = password;
    }

    private Store connectToEmail() throws MessagingException {
        Properties props = new Properties();
        props.put("mail.store.protocol", "imaps");
        props.put("mail.imaps.host", "imap.gmail.com");
        props.put("mail.imaps.port", "993");
        props.put("mail.imaps.ssl.enable", "true");

        Session session = Session.getInstance(props);
        Store store = session.getStore("imaps");
        store.connect("imap.gmail.com", EMAIL, PASSWORD);
        return store;
    }

    public String getOTP() {
        try {
            Store store = connectToEmail();
            Folder inbox = store.getFolder("INBOX");
            inbox.open(Folder.READ_ONLY);

            // Get latest message
            Message[] messages = inbox.getMessages();
            Message latestMessage = messages[messages.length - 1];

            // Wait for 5 seconds for new email if needed
            if (System.currentTimeMillis() - latestMessage.getReceivedDate().getTime() > 30000) {
                Thread.sleep(5000);
                messages = inbox.getMessages();
                latestMessage = messages[messages.length - 1];
            }

            // Extract OTP from email content
            String content = latestMessage.getContent().toString();

            // Modify this pattern based on your email format
            String otp = content.replaceAll("\\D+","").trim().substring(0, 6);

            inbox.close(false);
            store.close();
            return otp;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void verifyOTP(String otpInputId) {
        try {
            String otp = getOTP();
            WebElement otpInput = wait.until(
                    ExpectedConditions.presenceOfElementLocated(By.id(otpInputId))
            );
            otpInput.sendKeys(otp);

            // Find and click verify button (modify selector as needed)
            WebElement verifyButton = driver.findElement(By.xpath("//button[contains(text(),'Verify')]"));
            verifyButton.click();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clickVerificationLink() {
        try {
            Store store = connectToEmail();
            Folder inbox = store.getFolder("INBOX");
            inbox.open(Folder.READ_ONLY);

            Message latestMessage = inbox.getMessages()[inbox.getMessageCount() - 1];
            String content = latestMessage.getContent().toString();

            // Extract link - modify based on your email format
            String verificationLink = content.substring(
                    content.indexOf("http"),
                    content.indexOf("http") + content.substring(content.indexOf("http")).indexOf("\n")
            ).trim();

            driver.get(verificationLink);

            inbox.close(false);
            store.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}