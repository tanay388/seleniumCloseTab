from selenium import webdriver
from selenium.webdriver.chrome.service import Service
from selenium.webdriver.chrome.service import Service as ChromeService
from webdriver_manager.chrome import ChromeDriverManager
import time

# Create Chrome Service using the WebDriver Manager
ChromeService = ChromeService(ChromeDriverManager().install())

# Create the Chrome WebDriver
chromeDriver = webdriver.Chrome(service=ChromeService)

# Open "https://ecommerce-playground.lambdatest.io/" web page on the browser
chromeDriver.get("https://ecommerce-playground.lambdatest.io/")

# Print the title of tab in focus
print(chromeDriver.title)

# Open a new tab using the JavascriptExecutor
chromeDriver.execute_script(
    "popup_window = window.open('https://www.google.com')")


# Add time Delay for clear visibility and observability
time.sleep(2)

# Selenium Close tab Python using javascrit executer
chromeDriver.execute_script("popup_window.close()")

# Try to get alert from the web app
alert = driver.switch_to.alert
