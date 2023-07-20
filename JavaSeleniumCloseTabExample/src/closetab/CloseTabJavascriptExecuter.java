package closetab;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

// How to close Tab in Selenium Java Example
public class CloseTabJavascriptExecuter {
	public static void main(String[] args) {

		// No need for setProperty as ChromeDriver() will auto install 
		// required browser driver for Chrome using Selenium Manager
		WebDriver driver = new ChromeDriver();
				
		// Open the "https://ecommerce-playground.lambdatest.io/" web page on the browser
		driver.get("https://ecommerce-playground.lambdatest.io/");
			
		// Print the tile of the current tab
		System.out.println(driver.getTitle());
		
		// Creating a JavascriptExecutor reference
        JavascriptExecutor js = (JavascriptExecutor) driver;
		
		// Open a new tab using the JavascriptExecutor
		js.executeScript("popup_window = window.open('https://www.google.com')");
		
		// Print the tile of new tab
		System.out.println(driver.getTitle());
				
		// Add time Delay for page to load 
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// Catch block to handle exception
			e.printStackTrace();
		}

        // Selenium close tab using JavascriptExecutor
        js.executeScript("popup_window.close()");
	}
}
