from selenium import webdriver
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.common.by import By
from webdriver_manager.chrome import ChromeDriverManager
from selenium.webdriver.chrome.service import Service as ChromeService
import time

# Create the Chrome WebDriver.
chrome_driver = webdriver.Chrome(
    service=ChromeService(ChromeDriverManager().install()))

# Function to open multiple tabs.


def open_multiple_tabs_from_urls(urls):
    # Open new tabs for all the URLs.
    for url in urls:
        # This javascript command is executed to open new tab.
        chrome_driver.execute_script(f"window.open('{url}', '_blank');")
        # Switch to the new tab.
        chrome_driver.switch_to.window(chrome_driver.window_handles[-1])
        # Print title of new tab.
        print("Opened Tab = " + chrome_driver.title)
        time.sleep(1)

# Function to close all tabs except the current tab


def close_all_except_current_tab():
    # Get all tab list and current tab using the
    # window_handles and current_window_handle method.
    all_tab_list = chrome_driver.window_handles
    current_tab = chrome_driver.current_window_handle

    # Print Current Tab name.
    print("Current Tab = " + chrome_driver.title)

    # Iterating over the open tabs.
    for window in all_tab_list:
        # Condition to make sure current tab is not closed.
        if window != current_tab:
            chrome_driver.switch_to.window(window)
            print("Closing Tab = " + chrome_driver.title)
            # close() method is used to close the selected tab.
            chrome_driver.close()

    # Switch back to the current tab
    chrome_driver.switch_to.window(current_tab)


# URL list to open in tabs
urls = [
    "https://ecommerce-playground.lambdatest.io/",
    "https://ecommerce-playground.lambdatest.io/index.php?route=product/special",
    "https://ecommerce-playground.lambdatest.io/index.php?route=extension/maza/blog/home"
]

# Open multiple tabs
open_multiple_tabs_from_urls(urls)

# Close all tabs except the current tab
close_all_except_current_tab()

# Close the browser session
chrome_driver.quit()
