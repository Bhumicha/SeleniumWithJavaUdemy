import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class test {
    private WebDriver driver;

@Before
    public void setUp() {

    WebDriver driver = new ChromeDriver();
}
    @Test
    public void kCMRespondentsRespondentExclusionCRUD() throws InterruptedException {
        driver.get("https://d.kcmg.nl/login");
        driver.manage().window().setSize(new Dimension(1308,907));
        {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
        }
        driver.findElement(By.id("username")).sendKeys("testautomation.donotdelete@procit.com");
        driver.findElement(By.id("password")).sendKeys("KCM2020!#");
        driver.findElement(By.id("password")).sendKeys(Keys.ENTER);

        Thread.sleep(7000);

        driver.navigate().to("https://d.kcmg.nl/respondents/respondent/74d71729-84a1-4a9a-9cac-9a6fb4567844");
        Thread.sleep(7000);
        driver.findElement(By.xpath("//ion-segment-button[@value=\'exclusion\']")).click();
        Thread.sleep(7000);


        driver.findElement(By.xpath("//ion-row[2]/ion-col[2]/ion-buttons/ion-button[2]")).click();
        Thread.sleep(7000);


        // Wait for the table rows to be present
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//datatable-body-row")));

// Get all table rows
        List<WebElement> rows = driver.findElements(By.xpath("//datatable-body-row"));

// Iterate through rows to find the one containing
        for (WebElement row : rows) {
            if (row.getText().contains("Bereik")) {
                WebElement clickOnScope = row.findElement(By.xpath(".//mat-select[@name='scope']"));
                Thread.sleep(7000);
                clickOnScope.click();
                Thread.sleep(7000);
                //Click on Organisation from dropdown
                WebElement addOrganisation = row.findElement(By.xpath("//span[@class='mdc-list-item__primary-text'][normalize-space()='Organisatie']"));
                addOrganisation.click();
                Thread.sleep(7000);
                WebElement addExclusionPeriod = row.findElement(By.xpath(".//input[@placeholder='Aantal dagen']"));
                Thread.sleep(7000);
                addExclusionPeriod.sendKeys("6");
                Thread.sleep(7000);
                WebElement clickCalender = row.findElement(By.xpath(".//input[@placeholder='Startdatum']"));
                Thread.sleep(7000);
                clickCalender.click();
                Thread.sleep(7000);
                WebElement addDate = row.findElement(By.xpath("//span[@class='owl-dt-calendar-cell-content owl-dt-calendar-cell-today']"));
                Thread.sleep(7000);
                addDate.click();
                Thread.sleep(7000);
                WebElement applyCheckbox = row.findElement(By.xpath(".//ion-checkbox"));
                Thread.sleep(7000);
                applyCheckbox.click();
                Thread.sleep(7000);
                //Click on save icon
                driver.findElement(By.xpath(".//ion-button[@helpcode='label-SaveDetailsInExclusion']")).click();
                break; // Exit loop once found and clicked
            }
            Thread.sleep(7000);

        }
        Thread.sleep(7000);
        driver.findElement(By.xpath("//ion-row[2]/ion-col[2]/ion-buttons/ion-button[2]")).click();
        Thread.sleep(8000);

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//datatable-body-row")));
        List<WebElement> rows1 = driver.findElements(By.xpath("//datatable-body-row"));

        //add survey level exclusion


        for (WebElement row1 : rows1) {
            if (row1.getText().contains("Bereik")) {
                WebElement clickOnScope = row1.findElement(By.xpath(".//mat-select[@name='scope']"));
                Thread.sleep(7000);
                clickOnScope.click();
                Thread.sleep(7000);
                //Click on Organisation from dropdown
                WebElement addOrganisation = row1.findElement(By.xpath("//span[@class='mdc-list-item__primary-text'][normalize-space()='Onderzoek']"));
                addOrganisation.click();
                Thread.sleep(7000);
                WebElement addExclusionPeriod = row1.findElement(By.xpath(".//input[@placeholder='Aantal dagen']"));
                Thread.sleep(7000);
                addExclusionPeriod.sendKeys("6");
                Thread.sleep(7000);
                WebElement addSurvey = row1.findElement(By.xpath(".//mat-select[@name='Survey']"));
                addSurvey.click();
                Thread.sleep(7000);
                WebElement selectSurvey= row1.findElement(By.xpath("//span[normalize-space()='Sample Survey']"));
                selectSurvey.click();
                Thread.sleep(7000);
                WebElement clickCalender = row1.findElement(By.xpath(".//input[@placeholder='Startdatum']"));
                Thread.sleep(7000);
                clickCalender.click();
                Thread.sleep(7000);
                WebElement addDate = row1.findElement(By.xpath("//span[@class='owl-dt-calendar-cell-content owl-dt-calendar-cell-today']"));
                addDate.click();
                Thread.sleep(7000);
                WebElement applyCheckbox = row1.findElement(By.xpath(".//ion-checkbox"));
                applyCheckbox.click();
                Thread.sleep(7000);
                //Click on save icon
                driver.findElement(By.xpath(".//ion-button[@helpcode='label-SaveDetailsInExclusion']")).click();
            }
            Thread.sleep(7000);

        }
        Thread.sleep(7000);
        driver.findElement(By.xpath("//ion-row[2]/ion-col[2]/ion-buttons/ion-button[2]")).click();
        Thread.sleep(8000);

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//datatable-body-row")));
        List<WebElement> rows2 = driver.findElements(By.xpath("//datatable-body-row"));

        //add survey group level exclusion

        for (WebElement row2 : rows2) {
            if (row2.getText().contains("Bereik")) {
                WebElement clickOnScope = row2.findElement(By.xpath(".//mat-select[@name='scope']"));
                Thread.sleep(7000);
                clickOnScope.click();
                Thread.sleep(7000);
                //Click on Organisation from dropdown
                WebElement addOrganisation = row2.findElement(By.xpath("//span[@class='mdc-list-item__primary-text'][contains(text(),'Onderzoeksgroep') or contains(text(), 'Survey group')]"));
                addOrganisation.click();
                Thread.sleep(7000);
                WebElement addExclusionPeriod = row2.findElement(By.xpath(".//input[@placeholder='Aantal dagen']"));
                Thread.sleep(7000);
                addExclusionPeriod.sendKeys("6");
                Thread.sleep(7000);
                WebElement addSurveyGroup = row2.findElement(By.xpath(".//mat-select[@name='SurveyGroup']"));
                addSurveyGroup.click();
                Thread.sleep(7000);
                WebElement selectSurveyGroup=row2.findElement(By.xpath("//span[@class='mdc-list-item__primary-text'][normalize-space()='Bhumikagroup']"));
                selectSurveyGroup.click();
                Thread.sleep(7000);
                WebElement clickCalender = row2.findElement(By.xpath(".//input[@placeholder='Startdatum']"));
                Thread.sleep(7000);
                clickCalender.click();
                Thread.sleep(7000);
                WebElement addDate = row2.findElement(By.xpath("//span[@class='owl-dt-calendar-cell-content owl-dt-calendar-cell-today']"));
                addDate.click();
                Thread.sleep(7000);
                WebElement applyCheckbox = row2.findElement(By.xpath(".//ion-checkbox"));
                applyCheckbox.click();
                Thread.sleep(7000);
                //Click on save icon
                driver.findElement(By.xpath(".//ion-button[@helpcode='label-SaveDetailsInExclusion']")).click();

                break; // Exit loop once found and clicked
            }
            Thread.sleep(7000);

        }
        Thread.sleep(7000);
        driver.findElement(By.xpath("//ion-row[2]/ion-col[2]/ion-buttons/ion-button[2]")).click();
        Thread.sleep(8000);

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//datatable-body-row")));
        List<WebElement> rows3 = driver.findElements(By.xpath("//datatable-body-row"));

// Iterate through rows to find the one containing "Bhumika"
        for (WebElement row3 : rows3) {
            if (row3.getText().contains("Bhumika")) {
                // Find the checkbox within this specific row
                WebElement checkbox = row3.findElement(By.xpath(".//input[@type='checkbox']"));

                // Wait for the checkbox to be clickable
                wait.until(ExpectedConditions.elementToBeClickable(checkbox));

                // Click the checkbox
                checkbox.click();
                driver.findElement(By.xpath("//ion-button[@helpcode=\"label-DeleteDetailsInExclusion\"]")).click();
                Thread.sleep(7000);
                driver.findElement(By.xpath("//span[contains(.,\'Ja\')]")).click();
                Thread.sleep(7000);
                break; // Exit loop once found and clicked
            }
        }


    }
}
