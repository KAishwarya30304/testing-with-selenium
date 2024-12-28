import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;
import java.time.Duration;
import java.util.List;
public class ECommerceTest {
 WebDriver driver;
 WebDriverWait wait;
 @BeforeClass
 public void setUp() {
 // Set up ChromeDriver
 System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
 driver = new ChromeDriver();
 wait = new WebDriverWait(driver, Duration.ofSeconds(20));
 // Open the Amazon India website
 driver.get("https://www.amazon.in");
 // Wait for the page to load completely
 wait.until(d -> ((JavascriptExecutor) d).executeScript("return document.readyState").equals("complete"));
 }
 @Test
 public void searchProductTest1() {
 // Locate the search box and search for "Selenium WebDriver"
 WebElement searchBox = 
wait.until(ExpectedConditions.presenceOfElementLocated(By.id("twotabsearchtextbox")));
 searchBox.sendKeys("Selenium WebDriver");
 searchBox.submit();
 // Verify the search results
 List<WebElement> searchResults = 
wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(".s-main-slot .s-result-item")));
 Assert.assertTrue(searchResults.size() > 0, "No search results found.");
 System.out.println("Test 1 passed: Search results found.");
 }
 @Test
 public void searchProductTest2() {
 // Locate the search box and search for "Java Programming"
 WebElement searchBox = 
wait.until(ExpectedConditions.presenceOfElementLocated(By.id("twotabsearchtextbox")));
 searchBox.sendKeys("Java Programming");
 searchBox.submit();
 // Verify the search results
 List<WebElement> searchResults = 
wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(".s-main-slot .s-result-item")));
 Assert.assertTrue(searchResults.size() > 0, "No search results found.");
 System.out.println("Test 2 passed: Search results found.");
 }
 @AfterClass
 public void tearDown() {
 // Close the browser
 if (driver != null) {
 driver.quit();
 }
 }
}