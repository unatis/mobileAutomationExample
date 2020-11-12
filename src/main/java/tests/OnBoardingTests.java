package tests;

import org.testng.annotations.Test;
import tests.onBoarding.OnBoarding;
/**
 * Created by Shahar Sheinfeld on 19/11/2019.
 **/

public class OnBoardingTests extends TestSetup
{
	
	/* https://kanghealthio.atlassian.net/browse/KE-7354 */
	@Test (groups = { "Sanity" })
	public void GoingBackTakesToHomePage()
	{
		String name = "GoingBackTakesToHomePage";
		String gender = "Male";
		String year = "1990";
		String email = "Automation@test.com";
		
		OnBoarding onBoarding = new OnBoarding(driver);
		onBoarding.onBoard(name, gender, year, email);
		onBoarding.navigateBackErow();
		onBoarding.checkMenuButtonDisplayed();
	}
	
	/* https://kanghealthio.atlassian.net/browse/KE-7370 */
	@Test (groups = { "Sanity" })
	public void CheckYoungestYearOfBirth()
	{
		String name = "CheckYoungestYearOfBirth";
		String gender = "Male";
		
		OnBoarding onBoarding = new OnBoarding(driver);
		onBoarding.clickOnStartButton();
		onBoarding.clickOnAcceptButton();
		onBoarding.setName(name);
		onBoarding.selectMaleOrFemale(gender);
		onBoarding.checkCurrentYearMinus18Exists();
	}

	/* https://kanghealthio.atlassian.net/browse/KE-7851 */
	@Test (groups = { "Functional" })
	public void CheckEmailValidationErrorMessage() {
		String name = "Test";
		String gender = "Male";
		String year = "1990";
		String invalidEmail = "EmailValidationTest@";

		OnBoarding onBoarding = new OnBoarding(driver);
		onBoarding.clickOnStartButton();
		onBoarding.clickOnAcceptButton();
		onBoarding.setName(name);
		onBoarding.selectMaleOrFemale(gender);
		onBoarding.setYear(year);
		onBoarding.setEmail(invalidEmail);
		onBoarding.isTextFoundInFooterContainer("This is not a valid email");
	}
}
