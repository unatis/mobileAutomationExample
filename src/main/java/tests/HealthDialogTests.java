/**
 * Created by Shahar Sheinfeld on 01/01/2020.
 **/
package tests;

import org.testng.annotations.Test;
import tests.healthDialog.HealthDialog;
import tests.homeScreen.HomeScreen;
import tests.onBoarding.OnBoarding;

public class HealthDialogTests extends TestSetup
{
	
	/* https://kanghealthio.atlassian.net/browse/KE-5705 */
	@Test (groups = { "Sanity" })
	public void ContinueFromHealthDialogToCoronaAssessment()
	{
		OnBoarding onBoarding = new OnBoarding(driver);
		HealthDialog healthDialog = new HealthDialog(driver);
		
		String name = "continueFromHealthDialogToCoronaAssessment";
		String gender = "Male";
		String year = "1990";
		String email = "Automation@test.com";
		String symptom = "Cough";
		String temperature = "100";
		
		onBoarding.onBoard(name, gender, year, email);
		onBoarding.clickSymptomSearch();
		healthDialog.searchAndSelectSymptom(symptom);
		healthDialog.checkHealthDialogHeaderTitle(symptom);

		healthDialog.clickOnFooterButton("Today");
		healthDialog.clickOnFooterButton("See list");
		healthDialog.selectFromRadioButtonContainer("None of the above");
		healthDialog.clickOnFooterButton("I'm not sure");
		healthDialog.clickOnFooterButton("None of the above");
		healthDialog.clickOnFooterButton("See list");
		healthDialog.selectFromRadioButtonContainer("None of the above");
		
		healthDialog.clickOnFooterButton("No", 2);
		healthDialog.clickOnFooterButton("No, I don’t smoke");
		healthDialog.checkTextContainedInHealthDialogBubble("Do you have a fever?");
		healthDialog.clickOnFooterButton("Yes");
		healthDialog.checkTextContainedInHealthDialogBubble("How high was your fever?");
		healthDialog.setTemperature(temperature);
		healthDialog.checkUsersLastAnswer("100°F");
		healthDialog.checkTextContainedInHealthDialogBubble("Did any of these trigger your fever?");
		healthDialog.clickOnFooterButton("Recent travel");
		healthDialog.clickOnFooterButton("Done", true); // This is really "Done" button since the button changes the text during the selection before, the driver still holds the old text
		healthDialog.clickOnFooterButton("No", 13);
		healthDialog.clickOnFooterButton("None of the above", 4);
		healthDialog.clickOnFooterButton("I just wanted to try K out");
		healthDialog.clickOnFooterButton("Skip");
		healthDialog.notificationPopup();
		healthDialog.clickOnFooterButton("Ok, show me");
		healthDialog.clickOnAssessmentCard();
		healthDialog.covidDisclaimerApprove();
		healthDialog.checkUsersLastAnswer("Start assessment");
	}
	
	/* https://kanghealthio.atlassian.net/browse/KE-5706 */
	@Test(groups = { "Sanity" })
	public void CoronaAssessmentContinueToHealthDialog()
	{
		OnBoarding onBoarding = new OnBoarding(driver);
		String name = "CoronaAssessmentContinueToHealthDialog";
		String gender = "Female";
		String year = "1990";
		String email = "Automation@test.com";
		
		onBoarding.onBoard(name, gender, year, email);
		onBoarding.clickSymptomSearch();
		onBoarding.cancelSymptomSearch();
		
		HomeScreen homeScreen = new HomeScreen(driver);
		HealthDialog healthDialog = new HealthDialog(driver);
		
		healthDialog.clickOnMenuButton();
		homeScreen.clickOnMenuCovidAssessment();
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
	
	/* https://kanghealthio.atlassian.net/browse/KE-6889 */
	@Test (groups = { "Sanity" })
	public void FreeTextQuestion()
	{
		String name = "FreeTextQuestion";
		String gender = "Male";
		String year = "1990";
		String email = "Automation@test.com";
		String symptom = "Lack of motivation";
		
		OnBoarding onBoarding = new OnBoarding(driver);
		HealthDialog healthDialog = new HealthDialog(driver);
		
		onBoarding.onBoard(name, gender, year, email);
		onBoarding.clickSymptomSearch();
		
		healthDialog.searchAndSelectSymptom(symptom);
		healthDialog.checkHealthDialogHeaderTitle(symptom);
		
		healthDialog.clickOnFooterButton("No", 11);
		healthDialog.clickOnFooterButton("No, I don’t smoke");
		healthDialog.clickOnFooterButton("No");
		healthDialog.clickOnFooterButton("None of the above", 5);
		healthDialog.clickOnFooterButton("I just wanted to try K out");
		healthDialog.checkTextContainedInHealthDialogBubble("Is there anything else you can share? (Like any changes in feelings, senses, or bodily sensations, for instance)?");
		healthDialog.insertTextIntoTextField("Abc123!@#");
		healthDialog.notificationPopup();
		healthDialog.checkUsersLastAnswer("Abc123!@#");
	}
	
	
	/* https://kanghealthio.atlassian.net/browse/KE-7689 */
	@Test (groups = { "Functional" })
	public void SevereSymptomWarning()
	{
		String name = "SevereSymptomWarning";
		String gender = "Male";
		String year = "1990";
		String email = "Automation@test.com";
		String symptom1 = "Shortness of breath";
		String symptom2 = "Chest pain";
		String symptom3 = "Cough";
		String serious_health_complaint = "Serious Health Complaint";
		
		OnBoarding onBoarding = new OnBoarding(driver);
		HealthDialog healthDialog = new HealthDialog(driver);
		
		onBoarding.onBoard(name, gender, year, email);
		onBoarding.clickSymptomSearch();
		
		healthDialog.searchAndSelectSymptom(symptom1);
		healthDialog.checkHealthDialogHeaderTitle(symptom1);
		healthDialog.checkIfHealthWarningMessageIsDisplayed(serious_health_complaint);
		healthDialog.runUntilBubbleWithTextIsDisplayed("I have more questions but before we get to that, can you think of another related symptom?");
		healthDialog.clickOnFooterButton("Yes");
		healthDialog.searchAndSelectSymptom(symptom2);
		healthDialog.checkHealthDialogHeaderTitle(symptom1);
//		healthDialog.checkIfTextFoundOnHealthDialogScreen(serious_health_complaint, 2);
		healthDialog.checkIfHealthWarningMessageIsDisplayed(serious_health_complaint);
		healthDialog.clickBackButton();
		
		HomeScreen homeScreen = new HomeScreen(driver);
		homeScreen.clickOnHomeScreenButton_CheckMySymptoms();
		
		healthDialog.searchAndSelectSymptom(symptom3);
		healthDialog.checkHealthDialogHeaderTitle(symptom3);
		healthDialog.runUntilTextIsDisplayedInFooterContainer(symptom1);
		healthDialog.clickOnFooterButton("Yes");
		healthDialog.checkIfHealthWarningMessageIsDisplayed(serious_health_complaint);
		healthDialog.clickBackButton();
		
		homeScreen.clickOnHomeScreenButton_CoronavirusTracking();
		homeScreen.coronaVirusAcceptDisclaimer();
		
		healthDialog.runUntilTextIsDisplayedInFooterContainer(symptom1);
		healthDialog.clickOnFooterButton(symptom1);
		healthDialog.checkIfHealthWarningMessageIsDisplayed(serious_health_complaint);
	}
		
	
	
	
	@Test
	public void RunUntilButtonWithTextIsShown()
	{
		OnBoarding onBoarding = new OnBoarding(driver);
		HealthDialog healthDialog = new HealthDialog(driver);
		
		String name = "runUntilButtonWithTextIsDisplayed";
		String gender = "Male";
		String year = "1990";
		String email = "Automation@test.com";
		String symptom = "Lack of motivation";
		
		onBoarding.onBoard(name, gender, year, email);
		onBoarding.clickSymptomSearch();
		healthDialog.searchAndSelectSymptom(symptom);
		healthDialog.checkHealthDialogHeaderTitle(symptom);
		
		healthDialog.runUntilTextIsDisplayedInFooterContainer("I just wanted to try K out");
		healthDialog.clickOnFooterButton("I just wanted to try K out");
	}
}
