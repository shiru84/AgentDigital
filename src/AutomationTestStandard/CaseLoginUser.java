package AutomationTestStandard;

import org.openqa.selenium.By;
import org.junit.Assert;

public class CaseLoginUser extends TestCase {

	private static final String CORRECT_USERNAME = "tomsmith";
	private static final String INCORRECT_USERNAME = "tomsmithA";
	private static final String CORRECT_PASSWORD = "SuperSecretPassword!";
	private static final String INCORRECT_PASSWORD = "SuperSecretPassword!A";

	private boolean loginUser(String uname, String pass) {
		driver.get("http://the-internet.herokuapp.com");
		driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[21]/a")).click();
		driver.findElement(By.id("username")).sendKeys(uname);
		driver.findElement(By.id("password")).sendKeys(pass);
		driver.findElement(By.xpath("//*[@id=\"login\"]/button/i")).click();

		boolean isLoggedin = driver.getPageSource().contains("Logout");
		if (isLoggedin) {
			driver.findElement(By.xpath("/html/body/div[2]/div/div/a")).click();
		}

		return isLoggedin;
	}

	public void executeTest() throws AssertionError {
		Assert.assertFalse(loginUser(CORRECT_USERNAME, INCORRECT_PASSWORD));
		Assert.assertFalse(loginUser(INCORRECT_USERNAME, CORRECT_PASSWORD));
		Assert.assertTrue(loginUser(CORRECT_USERNAME, CORRECT_PASSWORD));
	}
}
