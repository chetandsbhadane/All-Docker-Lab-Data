package CDACDemo;

import java.time.Duration;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MaxAndTriangleTypeTest {
    public static void main(String[] args) {
        // Get user inputs
        String num1 = JOptionPane.showInputDialog("Enter first number:");
        String num2 = JOptionPane.showInputDialog("Enter second number:");
        String num3 = JOptionPane.showInputDialog("Enter third number:");

        // Initialize the WebDriver
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\dac\\Desktop\\Batch_1_lab\\Software_Testing\\chromedriver-126\\chromedriver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        WebDriver driver = new ChromeDriver(options);

        try {
            // Open the HTML file
            driver.get("C:\\Users\\dac\\Desktop\\Batch_1_lab\\Software_Testing\\index.html"); // Update the path to your HTML file

            // Find input elements by their IDs
            WebElement num1Input = driver.findElement(By.id("num1"));
            WebElement num2Input = driver.findElement(By.id("num2"));
            WebElement num3Input = driver.findElement(By.id("num3"));
            WebElement button = driver.findElement(By.tagName("button"));

            // Enter test data
            num1Input.sendKeys(num1);
            num2Input.sendKeys(num2);
            num3Input.sendKeys(num3);

            // Click the button to execute the JavaScript function
            button.click();

            // Wait for the alert to be displayed and store it in a variable
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10000));

            wait.until(ExpectedConditions.alertIsPresent());
            String alertMessage = driver.switchTo().alert().getText();

            // Print alert message to the console
            System.out.println("Alert message: " + alertMessage);

            // Calculate the expected max value
            double number1 = Double.parseDouble(num1);
            double number2 = Double.parseDouble(num2);
            double number3 = Double.parseDouble(num3);
            double max = Math.max(number1, Math.max(number2, number3));
            String expectedMessage = "Max: " + max;

            // Validate the alert message
            if (alertMessage.equals(expectedMessage)) {
                System.out.println("Test case passed");
            } else {
                System.out.println("Test case failed");
            }

            // Accept the alert
            driver.switchTo().alert().accept();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
