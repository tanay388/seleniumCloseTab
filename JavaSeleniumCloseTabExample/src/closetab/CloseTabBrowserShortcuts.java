package closetab;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

// How to close Tab in Selenium Java Example
public class CloseTabBrowserShortcuts {

	public static void main(String[] args) {

		// No need for setProperty as ChromeDriver() will auto install 
		// required browser driver for Chrome using Selenium Manager
		WebDriver driver = new ChromeDriver();
				
		// Open the "https://ecommerce-playground.lambdatest.io/" web page on the browser
		driver.get("https://ecommerce-playground.lambdatest.io/");
			
		// Print the tile of the current tab
		System.out.println(driver.getTitle());
				
		// Add time Delay for page to load 
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// Catch block to handle exception
			e.printStackTrace();
		}
		
				
		// Selenium Close tab Java using browser shortcuts
		Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL).sendKeys("w").keyUp(Keys.CONTROL).perform();
        
        // Other method
        String shortcut = Keys.chord(Keys.CONTROL, "w");
        driver.findElement(By.tagName("body")).sendKeys(shortcut);
        
        driver.quit();
	}

}
