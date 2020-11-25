package AutomationTestStandard;

public class TestRunner {

	private static void runTestCase(TestCase testCase) throws Exception {
		System.out.println("Running " + testCase);
		try {
			testCase.runTest();
			System.out.println("OK");
		} catch (AssertionError e) {
			System.out.println("Failed");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) throws Exception {
		runTestCase(new CaseLoginUser());
		runTestCase(new CaseKeyPress());
		runTestCase(new CaseInfinityScroll());
	}
}
