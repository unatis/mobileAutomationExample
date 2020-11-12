package tests;

import meSection.MeSection;
import org.testng.annotations.Test;
import tests.onBoarding.OnBoarding;

/**
 * Created by Shahar Sheinfeld on 18/08/2020.
 **/

public class MeSectionTests extends TestSetup
{
	
	@Test(groups = {"Sanity"})
	public void OnboardingInformationDisplayCorrectly()
	{
		String name = "OnboardingInformationDisplayCorrectly";
		String gender = "Male";
		String year = "1980";
		String email = "Automation@test.com";
		
		OnBoarding onBoarding = new OnBoarding(driver);
		
		onBoarding.onBoard(name, gender, year, email);
		onBoarding.clickSymptomSearch();
		onBoarding.cancelSymptomSearch();
		
		MeSection meSection = new MeSection(driver);
		meSection.clickOnMeButton();
		meSection.checkUserInfo(name);
		meSection.checkUserInfo(gender + ", Born " + year);
	}
}
