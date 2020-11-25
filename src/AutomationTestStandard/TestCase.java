package AutomationTestStandard;

import org.openqa.selenium.chrome.ChromeDriver;

public abstract class TestCase {

	private static final String SELENIUM_DRIVER_PATH = "/Users/mromanovsky/SELENIUM/Drivers/chromedriver";
	protected ChromeDriver driver;

	protected final void launchBrowser() throws Exception {
		System.setProperty("webdriver.chrome.driver", SELENIUM_DRIVER_PATH);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	protected final void closeBrowser() throws Exception {
		driver.quit();
	}

	public final void runTest() throws Exception {
		launchBrowser();
		executeTest();
		closeBrowser();
	}

	public void executeTest() throws AssertionError, Exception {
	}
}
