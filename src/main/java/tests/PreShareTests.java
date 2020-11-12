/**
 * Created by Shahar Sheinfeld on 05/07/2020.
 **/
package tests;

import org.testng.annotations.Test;
import tests.healthDialog.HealthDialog;
import tests.irr.Irr;
import tests.onBoarding.OnBoarding;
import tests.preShare.PreShare;
import tests.ptt.Ptt;
import tests.welcomeScreen.WelcomeScreen;

public class PreShareTests extends TestSetup
{
	/* https://kanghealthio.atlassian.net/browse/KE-6732 */
	@Test (groups = { "Sanity" })
	public void chooseStateWithUnavailableDoctors()
	{
		OnBoarding onBoarding = new OnBoarding(driver);
		HealthDialog healthDialog = new HealthDialog(driver);
		PreShare preShare = new PreShare(driver);
		
		String name = "Check_K_CTA_Disclaimer_and_choose_a_state_with_unavailable_doctors";
		String gender = "Male";
		String year = "1990";
		String email = "Automation@test.com";
		String symptom = "Goiter";

		String doctorUnavailableMessage = "Sorry, we don't have Doctors available in Florida right now, but we're expanding quickly. As soon as we get there, we'll let you know.";
		
		onBoarding.onBoard(name, gender, year, email);
		onBoarding.clickSymptomSearch();
		healthDialog.searchAndSelectSymptom(symptom);
		
		healthDialog.clickOnFooterButton("No", 13);
		healthDialog.clickOnFooterButton("None of the above", 5);
		healthDialog.clickOnFooterButton("I just wanted to try K out");
		healthDialog.clickOnFooterButton("Skip");
		healthDialog.notificationPopup();
		healthDialog.clickOnFooterButton("Ok, show me");
		
		Irr irr = new Irr(driver);
		irr.clickOnCTAButton("Chat with a Doctor now");
		preShare.checkTextFoundOnCTADisclaimer("Important!");
		preShare.checkTextFoundOnCTADisclaimer(TextHelpers.ctaDisclaimerTextEnglish);
		
		preShare.clickOnPreShareDisclaimerAcceptButton();
		preShare.isWheelPickerDisplayed();
		
		preShare.changeState("Florida");
		preShare.checkIfDoctorUnavailableMessageFoundOnScreen(doctorUnavailableMessage);
		preShare.clickOnGotItButton();
		preShare.checkStatePickerVisible();
	}
	
	
	/* https://kanghealthio.atlassian.net/browse/KE-6671 */
	@Test (groups = { "Sanity" })
	public void completePreShare()
	{
		OnBoarding onBoarding = new OnBoarding(driver);
		HealthDialog healthDialog = new HealthDialog(driver);
		
		String name = "completePreShare";
		String gender = "Male";
		String year = "1990";
		String email = isIos ? "AutomationIOS@test.com" : "AutomationAndroid@test.com";
		String symptom = "Goiter";
		String phoneCode = isIos ? "000151" : "000152";
		String phoneNumber = "+972540" + phoneCode;
		
		onBoarding.onBoard(name, gender, year, email);
		onBoarding.clickSymptomSearch();
		healthDialog.searchAndSelectSymptom(symptom);
		
		healthDialog.runUntilTextIsDisplayedInFooterContainer("I just wanted to try K out");
		healthDialog.clickOnFooterButton("I just wanted to try K out");
//		healthDialog.clickOnFooterButton("No", 13);
//		healthDialog.clickOnFooterButton("None of the above", 5);
//		healthDialog.clickOnFooterButton("I just wanted to try K out");
		healthDialog.clickOnFooterButton("Skip");
//		healthDialog.notificationPopup();
		healthDialog.clickOnFooterButton("Ok, show me");
		
		Irr irr = new Irr(driver);
		Ptt ptt = new Ptt(driver);
		irr.clickOnIrrButton(1);
		ptt.checkTextFoundOnPttScreen("What can you do next?");
		ptt.clickBackErow();
		irr.clickOnCTAButton("Chat with a Doctor now");
		
		PreShare preShare = new PreShare(driver);
		preShare.checkTextFoundOnCTADisclaimer("Important!");
		preShare.checkTextFoundOnCTADisclaimer(TextHelpers.ctaDisclaimerTextEnglish);
		preShare.clickOnPreShareDisclaimerAcceptButton();
		preShare.changeState("Alabama");
		preShare.clickOnFooterButton("Register");
		preShare.clickOnOpenCameraButton();
		preShare.allowTakePicture();
		preShare.closeCameraWithX();
		preShare.userDetails("Lorem", "ipsum");
		preShare.insertPhoneNumberUS(phoneNumber);
		preShare.insertCode(phoneCode);
		preShare.takeAPicture();
		preShare.isButtonWithTextDisplayed("Prior surgeries|Taking medications regularly|Chronic medical conditions|Allergies to medications|Chronic medical conditions in your family");
		preShare.clickOnFooterButton("None of the above");
		preShare.clickByTextInGeneralInformationWindow("I confirm this information");
		preShare.clickOnFooterButton("No");
		preShare.clickOnFooterButton("No thanks");
		preShare.clickOnFooterButton("See options");
		
		preShare.clickOnTextFoundOnPreShareOptionPlan("Learn more");
		preShare.clickBackErow();
		
		preShare.clickOnContinueButtonOnOptionPlanScreen();
		preShare.addNewCardAndPay();
		preShare.clickOnFooterButton("Submit");
		preShare.checkTextContainedInHealthDialog("Great, you’re checked in!");
	}
	
	/* https://kanghealthio.atlassian.net/browse/KE-7847 */
	@Test (groups = { "Sanity" })
	public void K_IL_Create_K_AccountAtBeginningOfPreShare()
	{
		String name = "K_IL_Create_K_AccountAtBeginningOfPreShare";
		String gender = "Male";
		String year = "1990";
		String email = "Automation@test.com";
		String symptom = "חוסר מוטיבציה";
		String phoneCode = isIos ? "000153" : "000154";
		String phoneNumber = "+972540" + phoneCode;
		resetAppiumDriverOnFailureIfIos = true;
		
		WelcomeScreen welcomeScreen = new WelcomeScreen(driver);
		driver = welcomeScreen.newIOSDriverWithCapabilityNoResetTrue();
		
		OnBoarding onBoarding = new OnBoarding(driver);
		HealthDialog healthDialog = new HealthDialog(driver);
		Irr irr = new Irr(driver);
		PreShare preShare = new PreShare(driver);
		
		welcomeScreen = new WelcomeScreen(driver);
		
		welcomeScreen.changeCountryOnDebugScreen("IL");
		welcomeScreen.changeLanguage("עברית");
		onBoarding.clickOnStartButton();
		onBoarding.clickOnAcceptButton();
		onBoarding.setName(name);
		onBoarding.selectMaleOrFemale(gender);
		onBoarding.setYear(year);
		onBoarding.clickSymptomSearch();
		healthDialog.searchAndSelectSymptom(symptom);
		healthDialog.runUntilTextIsDisplayedInFooterContainer("רק בדקתי את האפליקציה");
		healthDialog.clickOnFooterButton("רק בדקתי את האפליקציה");
		healthDialog.clickOnFooterButton("דלג");
		healthDialog.notificationPopup();
		healthDialog.clickOnFooterButton("אוקיי, הראי לי");
		irr.clickOnCTAButton("לצ'אט רפואי חינם");
		preShare.checkTextFoundOnCTADisclaimer("חשוב!");
		preShare.checkTextFoundOnCTADisclaimer(TextHelpers.ctaDisclaimerTextHebrew);
		preShare.clickOnPreShareDisclaimerAcceptButton();
		preShare.checkTextContainedInHealthDialogBubble("ראשית, נאמת את מספר הטלפון שלך לשם זיהוי במערכת מכבי ושמירה על פרטיותך.");
		preShare.clickOnFooterButton("לאימות טלפון");
 		preShare.insertPhoneNumberIL(phoneNumber);
		preShare.insertCode(phoneCode);
		preShare.checkTextContainedInHealthDialogBubble("נהדר, מספר הטלפון שלך אומת בהצלחה. עוד קצת וסיימנו.");
		
//		driver = welcomeScreen.defaultIOSDriverCapabilities();
	}
	
}
