package closetab;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;

public class CloseAllExceptCurrentTab {
	// Global declaration for chrome driver
	private static WebDriver driver;
	
	// Function to open multiple tab
	private static void openMultipleTabs(String[] urls) throws InterruptedException {
		// Finding no. of urls
		int listLength = urls.length;
		
		// Creating a JavascriptExecutor reference.
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		
		// LAst open tab name
		String last = driver.getWindowHandle();
		// Iterating over all url to open new tab
		for(int i=0; i<listLength ; i++) {
			// Javascript command to open url in new tab
			String link = "window.open('" + urls[i] + "', '_blank')";
			js.executeScript(link);
			
			// Get all open tabs
			Set<String> allTabs = driver.getWindowHandles();
			// find Last open tab in allTabs
	        Iterator<String> iterator = allTabs.iterator();
	        while(iterator.hasNext()){
	            last = iterator.next();
	        }  
	        
	        // Switch to new tab
			driver.switchTo().window(last);
			
			// Print page title
			System.out.println("New Tab = " + driver.getTitle());
			
			// Add time delay for proper loading
			Thread.sleep(1000);
		}		
	}
	
	// Function to close all tab except the Current tab
	private static void closeMultipleTabs() throws InterruptedException {
		// Get all open tabs
		Set<String> allTabs = driver.getWindowHandles();
		
		// Get Current tab
		String currentTab = driver.getWindowHandle();
		
		Iterator<String> iterator = allTabs.iterator();
		
		while(iterator.hasNext()) {
			// Condition to check if the selected tab is not current tab
			String selectedTab = iterator.next();
			if(!selectedTab.equals(currentTab)) {
				// Switch to new tab
				driver.switchTo().window(selectedTab);
				
				// Print title of tabs to be closed
				System.out.println("Closing Tab = "+driver.getTitle());
				
				// Close the selected tab
				driver.close();
				
				// Time delay
				Thread.sleep(1000);
			}
		}	
	}

	public static void main(String[] args) {
		// No need for setProperty as ChromeDriver() will auto install 
		// required browser driver for Chrome using Selenium Manager
		driver = new ChromeDriver();
				
		// Initializing urls to open in new tab
		String[] urlList = new String[3];
		urlList[0] = "https://ecommerce-playground.lambdatest.io/";
		urlList[1] = "https://ecommerce-playground.lambdatest.io/index.php?route=product/special";
		urlList[2] = "https://ecommerce-playground.lambdatest.io/index.php?route=extension/maza/blog/home";
				
		// Surround with try catch block to handle exception
		try {

			// Calling function to open new tab
			openMultipleTabs(urlList);
			
			// Print Current Tab name
			System.out.println("Current Tab = "+driver.getTitle());
			Thread.sleep(2000);
			
			// Calling function to close all tab except current
			closeMultipleTabs();
			
		} catch (InterruptedException e) {
			// Catch block to handle exception
			e.printStackTrace();
		}
			
		// Quit the current browser session
		driver.quit();
	}
}

