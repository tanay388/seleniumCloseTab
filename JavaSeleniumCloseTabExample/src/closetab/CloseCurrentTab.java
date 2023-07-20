package closetab;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CloseCurrentTab {

	public static void main(String[] args) {
		// No need for setProperty as ChromeDriver() will auto install 
		// required browser driver for Chrome using Selenium Manager
		WebDriver driver = new ChromeDriver();
		
		// Open the "https://ecommerce-playground.lambdatest.io/" web page on the browser
		driver.get("https://ecommerce-playground.lambdatest.io/");
		
		// Print the tile of the current tab
		System.out.println(driver.getTitle());
		
		// Add time Delay for clear visibility and observability
		try {
			Thread.sleep(2);
		} catch (InterruptedException e) {
			// Catch block to handle exception
			e.printStackTrace();
		}
		
		// Close the current tab
		driver.close();

	}

}
