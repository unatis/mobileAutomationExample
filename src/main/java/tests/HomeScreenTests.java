/**
 * Created by Shahar Sheinfeld on 09/06/2020.
 **/
package tests;

import org.testng.annotations.Test;
import tests.healthDialog.HealthDialog;
import tests.homeScreen.HomeScreen;
import tests.onBoarding.OnBoarding;

public class HomeScreenTests extends TestSetup
{
	
	/* https://kanghealthio.atlassian.net/browse/KE-5609 */
	@Test (groups = { "Sanity" })
	public void USA_intent_questions()
	{
		OnBoarding onBoarding = new OnBoarding(driver);
		String name = "USA_intent_questions";
		String gender = "Female";
		String year = "1990";
		String email = "Automation@test.com";
		String symptom = "Cough";
		
		onBoarding.onBoard(name, gender, year, email);
		onBoarding.clickSymptomSearch();
		onBoarding.cancelSymptomSearch();
		
		HomeScreen homeScreen = new HomeScreen(driver);
		HealthDialog healthDialog = new HealthDialog(driver);
		
		homeScreen.clickOnHomeScreenButton_CheckMySymptoms();
		healthDialog.searchAndSelectSymptom(symptom);
		healthDialog.checkHealthDialogHeaderTitle(symptom);
		healthDialog.clickBackButton();
		homeScreen.clickOnHomeScreenButton_CoronavirusTracking();
		homeScreen.coronaVirusAcceptDisclaimer();
		healthDialog.checkUsersLastAnswer("Coronavirus tracking");
		
		
		healthDialog.clickOnFooterButton("No");
		healthDialog.clickOnFooterButton("None of the above", 4);
		healthDialog.clickOnFooterButton("No", 3);
		healthDialog.clickOnFooterButton("No, I wasn't tested");
		healthDialog.clickOnFooterButton("No", 9);
		healthDialog.checkTextContainedInHealthDialogBubble("Do you have any of the following symptoms? (If you have more than one, pick the one you’d like to talk about first).");
		healthDialog.isTextFoundInFooterContainer("Cough|Fever|Shortness of breath|Sore throat ");
		healthDialog.clickOnFooterButton("None of the above");
		healthDialog.checkTextContainedInHealthDialogBubble("Great, what about one of these (again, if there’s more than one, pick the one you’d like to start with)?");
		healthDialog.isTextFoundInFooterContainer("Fatigue|Muscle pain (myalgia)|Chills|Another symptom|I don't have any symptoms");
	}
	
	/* https://kanghealthio.atlassian.net/browse/KE-6526 */
	@Test (groups = { "Sanity" })
	public void NavigateToCoronaAssessmentViaLabsBanner()
	{
		String name = "NavigateToCoronaAssessmentViaLabsBanner";
		String gender = "Female";
		String year = "1990";
		String email = "Automation@test.com";
		
		OnBoarding onBoarding = new OnBoarding(driver);
		
		onBoarding.onBoard(name, gender, year, email);
		onBoarding.clickSymptomSearch();
		onBoarding.cancelSymptomSearch();
		
		HomeScreen homeScreen = new HomeScreen(driver);
		HealthDialog healthDialog = new HealthDialog(driver);
		
		healthDialog.clickOnSeeLiveMapsBanner();
		healthDialog.popup();
		homeScreen.clickOnCoronaScreenButtonByTextContained("Testing Locations Near You");
		homeScreen.clickOnFirstTestingLocation();
		homeScreen.clickOnCoronaScreenButtonByText("Coronavirus screening");
		homeScreen.coronaVirusAcceptDisclaimer();
		homeScreen.verifyTitleText("Coronavirus tracking");
		healthDialog.checkUsersLastAnswer("Coronavirus tracking");
	}
	
	
	/* https://kanghealthio.atlassian.net/browse/KE-6530 */
	@Test (groups = { "Sanity" })
	public void NavigateToCoronaAssessmentViaLabsInformationCTA()
	{
		String name = "NavigateToCoronaAssessmentViaLabsInformationCTA";
		String gender = "Female";
		String year = "1990";
		String email = "Automation@test.com";
		
		OnBoarding onBoarding = new OnBoarding(driver);
		
		onBoarding.onBoard(name, gender, year, email);
		onBoarding.clickSymptomSearch();
		onBoarding.cancelSymptomSearch();
		
		HomeScreen homeScreen = new HomeScreen(driver);
		HealthDialog healthDialog = new HealthDialog(driver);
		
		healthDialog.clickOnSeeLiveMapsBanner();
		healthDialog.popup();
		homeScreen.clickOnCoronaScreenButtonByTextContained("Testing Locations Near You");
		homeScreen.searchForLabLocation("new york");
		homeScreen.clickOnCoronaScreenButtonByText("NY, USA");
		homeScreen.clickOnCoronaScreenButtonByText("West 57th Urgent Care");
		homeScreen.clickOnCoronaScreenButtonByText("Just show me the testing location");
		homeScreen.isTextDisplayedOnWebView("Need a referral?");
		homeScreen.clickOnCoronaScreenButtonByText("Chat with a doctor");
		homeScreen.coronaVirusAcceptDisclaimer();
		homeScreen.verifyTitleText("Coronavirus tracking");
		healthDialog.checkUsersLastAnswer("Coronavirus tracking");
	}
	
}
