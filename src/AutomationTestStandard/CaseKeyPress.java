package AutomationTestStandard;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.junit.Assert;

public class CaseKeyPress extends TestCase {

	private void openPage() {
		driver.get("http://the-internet.herokuapp.com");
		driver.findElement(By.xpath("/html/body/div[2]/div/ul/li[31]/a")).click();
	}

	private boolean typeKeys(Keys keyboardKeys, String yourkey) {
		driver.findElement(By.id("target")).sendKeys(keyboardKeys);

		return driver.getPageSource().contains(yourkey);
	}

	public void executeTest() throws AssertionError {
		openPage();
		Assert.assertTrue(typeKeys(Keys.BACK_SPACE, "You entered: BACK_SPACE"));
		Assert.assertTrue(typeKeys(Keys.SHIFT, "You entered: SHIFT"));
		Assert.assertTrue(typeKeys(Keys.TAB, "You entered: TAB"));
		Assert.assertTrue(typeKeys(Keys.ARROW_UP, "You entered: UP"));
	}
}
