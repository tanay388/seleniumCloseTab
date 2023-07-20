from selenium import webdriver
from selenium.webdriver.chrome.service import Service
from selenium.webdriver.chrome.service import Service as ChromeService
from webdriver_manager.chrome import ChromeDriverManager
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
import time

# Create Chrome Service using the WebDriver Manager
ChromeService = ChromeService(ChromeDriverManager().install())

# Create the Chrome WebDriver
chromeDriver = webdriver.Chrome(service=ChromeService)

# Open "https://ecommerce-playground.lambdatest.io/" web page on the browser
chromeDriver.get("https://ecommerce-playground.lambdatest.io/")

# Print the title of tab in focus
print(chromeDriver.title)

# Add time Delay for clear visibility and observability
time.sleep(2)

# Get body of browser
body = chromeDriver.find_element(By.TAG_NAME, "body")

# Selenium Close tab using browser shortcuts
body.send_keys(Keys.CONTROL, 'w')
