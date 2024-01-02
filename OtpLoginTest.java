import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class OtpLoginTest {
    public static void main(String[]args){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\saina\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("https://practice.expandtesting.com/otp-login");
        WebElement username=driver.findElement(By.id("email"));
        username.sendKeys("practice@expandtesting.com");
        WebElement button=driver.findElement(By.className("mb-3"));
        button.click();



        WebElement otp=driver.findElement(By.id("otp"));
        otp.sendKeys("214365");
        WebElement button1=driver.findElement(By.id("btn-send-verify"));
        button1.click();

        String expectUrl="https://practice.expandtesting.com/secure";
        WebDriverWait wait2=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait2.until(ExpectedConditions.urlToBe(expectUrl));

        String currentUrl=driver.getCurrentUrl();
        if (currentUrl.equals(expectUrl)){
            System.out.println("Logged in successfully");
        }else{
            System.out.println("Logged in failed");
        }


    }
}
