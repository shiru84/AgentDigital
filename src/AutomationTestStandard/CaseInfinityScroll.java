package AutomationTestStandard;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.junit.Assert;

public class CaseInfinityScroll extends TestCase {

	private void openPage() throws Exception {
		driver.get("http://the-internet.herokuapp.com");
		driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[26]/a")).click();
		Thread.sleep(500);
	}

	private void scroll(boolean down) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		if (down) {
			jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		} else {
			jse.executeScript("window.scrollTo(0, -document.body.scrollHeight)");
		}
	}

	private boolean hasInfinityScroll() {
		return driver.getPageSource().contains("Infinite Scroll");
	}

	public final void executeTest() throws AssertionError, Exception {
		openPage();
		scroll(true);
		scroll(true);
		scroll(false);
		Assert.assertTrue(hasInfinityScroll());
	}
}
