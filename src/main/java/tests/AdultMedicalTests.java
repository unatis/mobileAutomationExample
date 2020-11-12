/**
 * Created by Shahar Sheinfeld on 22/03/2020.
 **/
package tests;


import org.testng.annotations.Test;
import tests.healthDialog.HealthDialog;
import tests.medical.AdultMedical;
import tests.onBoarding.OnBoarding;

public class AdultMedicalTests extends TestSetup
{
	
	//1 Female Age Test
	@Test
	public void female_AgeTest()
	{
		OnBoarding onBoarding = new OnBoarding(driver);
		String name = "FemaleAgeTest";
		String gender = "Female";
		String year = "1990";
		String email = "Automation@test.com";
		onBoarding.clickOnStartButton();
		onBoarding.clickOnAcceptButton();
		onBoarding.selectOnBoardigButtonSelection("option_0"); // I want to know what i have
		onBoarding.clickOnSureLetsStart(); // Sure, lets start
		onBoarding.setName(name);
		onBoarding.isTextFoundOnOnBoardingScreen(name, 2);
		onBoarding.selectMaleOrFemale(gender);
		onBoarding.isTextFoundOnOnBoardingScreen(gender, 3);
		onBoarding.setYear(year);
		onBoarding.isTextFoundOnOnBoardingScreen(String.valueOf(year));
		onBoarding.setEmail(email);
		onBoarding.closePopUp();
		onBoarding.clickSymptomSearch();
		
		
		HealthDialog healthDialog = new HealthDialog(driver);
		AdultMedical adultMedical = new AdultMedical(driver);

//		chat.searchSymptom("b");
//		adultMedical.checkIfTextFoundOnSymptomSearchScreen("Cough,Runny nose");
//		chat.searchSymptom("r");
//		adultMedical.checkIfTextFoundOnSymptomSearchScreen("Vomiting blood,Shortness of breath");
//		chat.searchSymptom("e");
//		adultMedical.checkIfTextFoundOnSymptomSearchScreen("Shortness of breath", 2);
//		adultMedical.checkIfTextFoundOnSymptomSearchScreen("Anxiety");
//		chat.searchSymptom("a");
//		adultMedical.checkIfTextFoundOnSymptomSearchScreen("Shortness of breath", 2);
//		adultMedical.checkIfTextFoundOnSymptomSearchScreen("Anxiety");
//		chat.searchSymptom("s");
//		adultMedical.checkIfTextFoundOnSymptomSearchScreen("Breast pain,Breast redness");
//
//		chat.clearSymptomSearchField();
		healthDialog.searchAndSelectSymptom("breast pain");
		adultMedical.checkIfTextFoundOnHealthDialogScreen("When did it start?");
		adultMedical.buttonSelect("option_1");  // in the last week
		
		adultMedical.checkIfTextFoundOnHealthDialogScreen("Which side is bothering you?");
		adultMedical.buttonSelect("option_0"); // one side
		
		adultMedical.checkIfTextFoundOnHealthDialogScreen("Is the pain worsened by touching?");
		adultMedical.buttonSelect("option_0"); // yes
		
		adultMedical.checkIfTextFoundOnHealthDialogScreen("Did either of these trigger your breast pain?");
		adultMedical.buttonSelect("chat_screen.tapToRespond"); // none of the above
		
		adultMedical.checkIfTextFoundOnHealthDialogScreen("How severe is your pain?");
		adultMedical.buttonSelect("option_0"); // mild
		
		adultMedical.checkIfTextFoundOnHealthDialogScreen("another related symptom?");
		adultMedical.buttonSelect("chat_screen.tapToRespond"); //no
		
		adultMedical.checkIfTextFoundOnHealthDialogScreen("Is your breast red?");
		adultMedical.buttonSelect("option_0"); // yes
		
		adultMedical.checkIfTextFoundOnHealthDialogScreen("Which breast is red?");
		adultMedical.buttonSelect("option_0"); //one breast
		
		adultMedical.checkIfTextFoundOnHealthDialogScreen("How severe would you say it is?");
		adultMedical.buttonSelect("option_0"); // mild
		
		adultMedical.checkIfTextFoundOnHealthDialogScreen("Did you recently give birth?");
		adultMedical.buttonSelect("option_0"); // Yes
		
		adultMedical.checkIfTextFoundOnHealthDialogScreen("Are you breastfeeding?");
		adultMedical.buttonSelect("option_0"); // Yes
		
		adultMedical.checkIfTextInFooterContainer("Recent childbirth,Fever");
		
		adultMedical.clickOnImageNumberInFooterContainer(1, "Recent childbirth"); // Recent childbirth
		adultMedical.buttonSelect("chat_screen.tapToRespond"); // done
		adultMedical.checkIfTextFoundOnHealthDialogScreen("Recent childbirth", "chat_screen.tapToRespond");
		
		adultMedical.checkIfTextInFooterContainer("Warm skin over breast,Chills,General discomfort");
		adultMedical.buttonSelect("chat_screen.tapToRespond"); // none of the above
		
		adultMedical.checkIfTextInFooterContainer("Lymph node swelling,Lack of menstruation,Unprotected sex");
		adultMedical.buttonSelect("chat_screen.tapToRespond"); // none of the above
		
		adultMedical.checkIfTextInFooterContainer("Irritable,Depressed mood,Restlessness");
		adultMedical.buttonSelect("chat_screen.tapToRespond"); // none of the above
		
		adultMedical.checkIfTextInFooterContainer("Fatigue,Abdominal pain,Anxiety");
		adultMedical.buttonSelect("chat_screen.tapToRespond"); // none of the above
		
		adultMedical.checkIfTextInFooterContainer("Crying,Insomnia,Abdominal swelling");
		adultMedical.buttonSelect("chat_screen.tapToRespond"); // none of the above
		
		adultMedical.checkIfTextInFooterContainer("Heart palpitations,Nausea,Dizziness");
		adultMedical.buttonSelect("chat_screen.tapToRespond"); // none of the above
		
		adultMedical.checkIfTextInFooterContainer("Emotional stress,Sweating,Weight gain");
		adultMedical.buttonSelect("chat_screen.tapToRespond"); // none of the above
		
		adultMedical.checkIfTextFoundOnHealthDialogScreen("about these symptoms?");
		adultMedical.buttonSelect("option_2"); // I just wanted to try K out
		
		adultMedical.allowIosNotification();
		adultMedical.buttonSelect("chat_screen.tapToRespond"); // OK, show me
		
		adultMedical.checkResultScreen("88,Mastitis", 0);
		adultMedical.checkResultScreen("12,Local Benign Breast Condition", 1);
		
		adultMedical.checkResultScreenAlpha("Breast Abscess", 0);
		adultMedical.buttonSelect("resultItem-0"); //Mastitis
//		adultMedical.checkIfTextFoundOnPttScreen("Watch out for symptoms like Fever.");
	}
	
	//2 Male Gender Test
	@Test
	public void male_GenderTest()
	{
		OnBoarding onBoarding = new OnBoarding(driver);
		String name = "LowSexDrive";
		String gender = "Male";
		String year = "1990";
		String email = "Automation@test.com";
		onBoarding.clickOnStartButton();
		onBoarding.clickOnAcceptButton();
		onBoarding.selectOnBoardigButtonSelection("option_0"); // I want to know what i have
		onBoarding.clickOnSureLetsStart(); // Sure, lets start
		onBoarding.setName(name);
		onBoarding.isTextFoundOnOnBoardingScreen(name, 2);
		onBoarding.selectMaleOrFemale(gender);
		onBoarding.isTextFoundOnOnBoardingScreen(gender);
		onBoarding.setYear(year);
		onBoarding.isTextFoundOnOnBoardingScreen(String.valueOf(year));
		onBoarding.setEmail(email);
		onBoarding.closePopUp();
		onBoarding.clickSymptomSearch();
		
		HealthDialog healthDialog = new HealthDialog(driver);
		AdultMedical adultMedical = new AdultMedical(driver);
		
		healthDialog.searchSymptom("l");
		adultMedical.checkIfTextFoundOnSymptomSearchScreen("Cough,Runny nose");
		healthDialog.searchSymptom("i");
		adultMedical.checkIfTextFoundOnSymptomSearchScreen("Diarrhea,Nausea");
		healthDialog.searchSymptom("b");
		adultMedical.checkIfTextFoundOnSymptomSearchScreen("Low sex drive,Diarrhea");
		
		healthDialog.clearSymptomSearchField();
		healthDialog.searchAndSelectSymptom("low sex drive");
		
		adultMedical.checkIfTextFoundOnHealthDialogScreen("How long has this been a problem?");
		adultMedical.buttonSelect("option_0");  // In the last month
//		adultMedical.verifyButtonSelectedOnBubbleNumber("In the last month", 2);
		
		adultMedical.checkIfTextFoundOnHealthDialogScreen("another related symptom?");
		adultMedical.buttonSelect("chat_screen.tapToRespond"); // no
//		adultMedical.verifyButtonSelected("No");
		
		adultMedical.checkIfTextFoundOnHealthDialogScreen("difficulty getting or maintaining an erection?");
		adultMedical.buttonSelect("option_0"); // yes
//		adultMedical.verifyButtonSelected("Erectile dysfunction");
		
		adultMedical.checkIfTextFoundOnHealthDialogScreen("Do you currently feel down/depressed?");
		adultMedical.buttonSelect("chat_screen.tapToRespond"); // no
//		adultMedical.verifyButtonSelected("No");
		
		adultMedical.checkIfTextFoundOnHealthDialogScreen("High Blood Pressure by a doctor?");
		adultMedical.buttonSelect("chat_screen.tapToRespond"); // no
//		adultMedical.verifyButtonSelected("No", 2);
		
		adultMedical.checkIfTextFoundOnHealthDialogScreen("Do you smoke?");
		adultMedical.buttonSelect("option_0"); // No, I don't smoke
//		adultMedical.verifyButtonSelected("No, I don’t smoke");
		
		adultMedical.checkIfTextInFooterContainer("Urinary hesitancy / difficulties,Lack of motivation,Alcohol use");
		adultMedical.buttonSelect("chat_screen.tapToRespond"); // none of the above
//		adultMedical.verifyButtonSelected("No");
		
		adultMedical.checkIfTextInFooterContainer("Social dysfunction,Urination at night,Unprotected sex");
		adultMedical.buttonSelect("chat_screen.tapToRespond"); // none of the above
//		adultMedical.verifyButtonSelected("No");
		
		adultMedical.checkIfTextInFooterContainer("Blood in urine,Scrotal pain,Anxiety");
		adultMedical.buttonSelect("chat_screen.tapToRespond"); // none of the above
//		adultMedical.verifyButtonSelected("No");
		
		adultMedical.checkIfTextFoundOnHealthDialogScreen("about these symptoms?");
		adultMedical.buttonSelect("option_2"); // I just wanted to try K out
//		adultMedical.verifyButtonSelected("I just wanted to try K out");
		
		adultMedical.allowIosNotification();
		adultMedical.buttonSelect("chat_screen.tapToRespond"); // OK, show me
		
		adultMedical.checkResultScreen("90,Erectile Dysfunction", 0);
		adultMedical.checkResultScreenAlpha("Hypogonadism - Male", 0);
		adultMedical.buttonSelect("alphaResultItem-0"); //Hypogonadism - Male
//		adultMedical.checkIfTextFoundOnPttScreen("Lab tests");
	}
	
	
	//3 Male Severe Test
	@Test
	public void male_SevereTest()
	{
		OnBoarding onBoarding = new OnBoarding(driver);
		String name = "MaleSevereTest";
		String gender = "Male";
		String year = "1990";
		String email = "Automation@test.com";
		onBoarding.clickOnStartButton();
		onBoarding.clickOnAcceptButton();
		onBoarding.selectOnBoardigButtonSelection("option_0"); // I want to know what i have
		onBoarding.clickOnSureLetsStart(); // Sure, lets start
		onBoarding.setName(name);
		onBoarding.isTextFoundOnOnBoardingScreen(name, 2);
		onBoarding.selectMaleOrFemale(gender);
		onBoarding.isTextFoundOnOnBoardingScreen(gender, 3);
		onBoarding.setYear(year);
		onBoarding.isTextFoundOnOnBoardingScreen(String.valueOf(year));
		onBoarding.setEmail(email);
		onBoarding.closePopUp();
		onBoarding.clickSymptomSearch();
		
		
		HealthDialog healthDialog = new HealthDialog(driver);
		AdultMedical adultMedical = new AdultMedical(driver);
		
		
		healthDialog.searchSymptom("g");
		adultMedical.checkIfTextFoundOnSymptomSearchScreen("Cough,Runny nose");
		healthDialog.searchSymptom("r");
		adultMedical.checkIfTextFoundOnSymptomSearchScreen("Vomiting blood,Hoarseness");
		healthDialog.searchSymptom("o");
		adultMedical.checkIfTextFoundOnSymptomSearchScreen("Vomiting blood,Groin pain");
		healthDialog.searchSymptom("i");
		adultMedical.checkIfTextFoundOnSymptomSearchScreen("Groin pain,Groin swelling");
		healthDialog.clearSymptomSearchField();
		healthDialog.searchAndSelectSymptom("groin swelling");
		
		adultMedical.checkIfTextFoundOnHealthDialogScreen("When did it start");
		adultMedical.buttonSelect("option_0");  // Today
//		adultMedical.verifyButtonSelectedOnBubbleNumber("Today", 2);
		
		adultMedical.checkIfTextFoundOnHealthDialogScreen("groin swelling on one side or both?");
		adultMedical.buttonSelect("option_0");  // One side
//		adultMedical.verifyButtonSelected("One side");
		
		adultMedical.checkIfTextFoundOnHealthDialogScreen("another related symptom?");
		adultMedical.buttonSelect("chat_screen.tapToRespond");  // No
//		adultMedical.verifyButtonSelected("No");
		
		
		adultMedical.checkIfTextFoundOnHealthDialogScreen("Do you have pain in your abdomen/stomach?");
		adultMedical.buttonSelect("option_0");  // Yes
//		adultMedical.verifyButtonSelected("Abdominal pain");
		
		adultMedical.buttonSelect("chat_screen.tapToRespond");  // See diagram
		
		adultMedical.selectAbdomAreaInDiagram("Lower abdom");
		adultMedical.buttonSelect("next.dontknow"); //Next
		
		adultMedical.checkIfTextFoundOnHealthDialogScreen("Which side is bothering you?");
		adultMedical.buttonSelect("option_0");  // Right
//		adultMedical.verifyButtonSelected("Right");
		
		adultMedical.checkIfTextFoundOnHealthDialogScreen("How uncomfortable do you feel?");
		adultMedical.buttonSelect("option_1");  // It's intense
//		adultMedical.verifyButtonSelected("It’s intense");
		
		adultMedical.buttonSelect("chat_screen.tapToRespond");  // See list
		adultMedical.buttonSelect("chat_screen.tapToRespond"); // none of the above
//		adultMedical.verifyButtonSelected("None of the above");
		adultMedical.buttonSelect("chat_screen.tapToRespond");  // See list
		adultMedical.buttonSelect("chat_screen.tapToRespond"); // none of the above
//		adultMedical.verifyButtonSelected("None of the above");
		
		adultMedical.checkIfTextFoundOnHealthDialogScreen("Do you have diarrhea?");
		adultMedical.buttonSelect("chat_screen.tapToRespond");  // No
//		adultMedical.verifyButtonSelected("No");
		
		adultMedical.checkIfTextFoundOnHealthDialogScreen("constipated or have difficulty moving your bowels?");
		adultMedical.buttonSelect("chat_screen.tapToRespond");  // No
//		adultMedical.verifyButtonSelectedOnBubbleNumber("No", 2);
		
		adultMedical.checkIfTextFoundOnHealthDialogScreen("Does it burn when you urinate?");
		adultMedical.buttonSelect("chat_screen.tapToRespond");  // No
//		adultMedical.verifyButtonSelected("No");
		
		adultMedical.checkIfTextFoundOnHealthDialogScreen("Did you have abdominal surgery in the past?");
		adultMedical.buttonSelect("chat_screen.tapToRespond");  // No
//		adultMedical.verifyButtonSelected("No");
		
		adultMedical.checkIfTextFoundOnHealthDialogScreen("Do you have swelling of your testicles?");
		adultMedical.buttonSelect("option_0");  // Yes
//		adultMedical.verifyButtonSelected("Scrotal swelling");
		
		adultMedical.checkIfTextFoundOnHealthDialogScreen("How severe would you say it is?");
		adultMedical.buttonSelect("option_1");  // Severe
//		adultMedical.verifyButtonSelected("Severe");
		
		adultMedical.checkIfTextFoundOnHealthDialogScreen("Did it start after an injury?");
		adultMedical.buttonSelect("chat_screen.tapToRespond");  // No
//		adultMedical.verifyButtonSelected("No");
		
		adultMedical.checkIfTextInFooterContainer("Groin pain,Abdominal swelling,Vomiting");
		adultMedical.clickOnImageNumberInFooterContainer(1, "Groin pain"); // Recent childbirth
		adultMedical.buttonSelect("chat_screen.tapToRespond"); // done
		adultMedical.checkIfTextFoundOnHealthDialogScreen("Groin pain", "chat_screen.tapToRespond");
		
		adultMedical.checkIfTextFoundOnHealthDialogScreen("nausea or feel sick to your stomach?");
		adultMedical.buttonSelect("chat_screen.tapToRespond"); // No
//		adultMedical.verifyButtonSelected("No");
		
		adultMedical.checkIfTextFoundOnHealthDialogScreen("diagnosed with High Blood Pressure by a doctor?");
		adultMedical.buttonSelect("chat_screen.tapToRespond"); // No
//		adultMedical.verifyButtonSelected("No");
		
		adultMedical.checkIfTextFoundOnHealthDialogScreen("diagnosed with Diabetes (Type 2) by a doctor?");
		adultMedical.buttonSelect("chat_screen.tapToRespond"); // No
//		adultMedical.verifyButtonSelected("No");
		
		adultMedical.checkIfTextInFooterContainer("Scrotal pain,Urination at night,Lymph node swelling");
		adultMedical.buttonSelect("chat_screen.tapToRespond"); // None of the above
//		adultMedical.verifyButtonSelected("No");
		
		adultMedical.checkIfTextInFooterContainer("Leg redness,Skin lesion,Foot swelling");
		adultMedical.buttonSelect("chat_screen.tapToRespond"); // None of the above
//		adultMedical.verifyButtonSelected("No");
		
		adultMedical.checkIfTextInFooterContainer("Warm skin in the leg,Insect bite,Calf swelling");
		adultMedical.buttonSelect("chat_screen.tapToRespond"); // None of the above
//		adultMedical.verifyButtonSelected("No");
		
		adultMedical.checkIfTextInFooterContainer("Hand swelling,Leg swelling,Warm skin in the arm");
		adultMedical.buttonSelect("chat_screen.tapToRespond"); // None of the above
//		adultMedical.verifyButtonSelected("No");
		
		adultMedical.checkIfTextInFooterContainer("Foot redness,Calf pain,Leg pain");
		adultMedical.buttonSelect("chat_screen.tapToRespond"); // None of the above
//		adultMedical.verifyButtonSelected("No");
		
		adultMedical.checkIfTextFoundOnHealthDialogScreen("about these symptoms?");
		adultMedical.buttonSelect("option_2"); // I just wanted to try K out
//		adultMedical.verifyButtonSelected("I just wanted to try K out");
		adultMedical.allowIosNotification();
		adultMedical.buttonSelect("chat_screen.tapToRespond"); // OK, show me
		
		adultMedical.checkResultScreen("62,Hernia", 0);
		adultMedical.checkResultScreen("38", 1);
		adultMedical.checkResultScreen("Incarcerated Hernia", 1,2);
		adultMedical.checkResultScreenAlpha("Orchitis", 0);
		
		adultMedical.buttonSelect("resultItem-1"); //Incarcerated Hernia
//		adultMedical.checkIfTextFoundOnPttScreen("Verifying Incarcerated Hernia");
	}
	
	
	//4 OBGYN
	@Test
	public void obgyn()
	{
		OnBoarding onBoarding = new OnBoarding(driver);
		String name = "OBGYN";
		String gender = "Female";
		String year = "1970";
		String email = "Automation@test.com";
		onBoarding.clickOnStartButton();
		onBoarding.clickOnAcceptButton();
		onBoarding.selectOnBoardigButtonSelection("option_0"); // I want to know what i have
		onBoarding.clickOnSureLetsStart(); // Sure, lets start
		onBoarding.setName(name);
		onBoarding.isTextFoundOnOnBoardingScreen(name, 2);
		onBoarding.selectMaleOrFemale(gender);
		onBoarding.isTextFoundOnOnBoardingScreen(gender);
		onBoarding.setYear(year);
		onBoarding.isTextFoundOnOnBoardingScreen(String.valueOf(year));
		onBoarding.setEmail(email);
		onBoarding.closePopUp();
		onBoarding.clickSymptomSearch();
		
		
		HealthDialog healthDialog = new HealthDialog(driver);
		AdultMedical adultMedical = new AdultMedical(driver);


		healthDialog.searchSymptom("v");
		adultMedical.checkIfTextFoundOnSymptomSearchScreen("Cough,Runny nose");
		healthDialog.searchSymptom("o");
		adultMedical.checkIfTextFoundOnSymptomSearchScreen("Nausea");
		adultMedical.checkIfTextFoundOnSymptomSearchScreen("Vomiting", 2);
		healthDialog.clearSymptomSearchField();
		healthDialog.searchAndSelectSymptom("vomiting");
		
		adultMedical.checkIfTextFoundOnHealthDialogScreen("When did you start vomiting?");
		adultMedical.buttonSelect("option_1");  // In the last week
		
		adultMedical.checkIfTextFoundOnHealthDialogScreen("Did any of these trigger your vomiting?");
		adultMedical.buttonSelect("chat_screen.tapToRespond");  // See list
		adultMedical.buttonSelect("chat_screen.tapToRespond"); // none of the above
		
		adultMedical.checkIfTextFoundOnHealthDialogScreen("How often are you vomiting?");
		adultMedical.buttonSelect("option_2");  // Couple of times a day

		adultMedical.checkIfTextFoundOnHealthDialogScreen("vomit worse at a particular time of day?");
		adultMedical.buttonSelect("chat_screen.tapToRespond");  // None of the above
		
		adultMedical.checkIfTextFoundOnHealthDialogScreen("make you vomit more?");
		adultMedical.buttonSelect("chat_screen.tapToRespond");  // None of the above
		
		adultMedical.checkIfTextFoundOnHealthDialogScreen("blood in your vomit?");
		adultMedical.buttonSelect("chat_screen.tapToRespond");  // No
		
		adultMedical.checkIfTextFoundOnHealthDialogScreen("Does rest make it better?");
		adultMedical.buttonSelect("chat_screen.tapToRespond");  // No
		
		adultMedical.checkIfTextFoundOnHealthDialogScreen("Did it start gradually or suddenly?");
		adultMedical.buttonSelect("chat_screen.tapToRespond");  // I'm not sure
		
		adultMedical.checkIfTextFoundOnHealthDialogScreen("Is your vomiting getting worse?");
		adultMedical.buttonSelect("chat_screen.tapToRespond");  // I'm not sure
		
		adultMedical.checkIfTextFoundOnHealthDialogScreen("another related symptom?");
		adultMedical.buttonSelect("option_0");  // Yes
		
		
		healthDialog.searchSymptom("s");
		adultMedical.checkIfTextFoundOnSymptomSearchScreen("Cough,Runny nose");
		healthDialog.searchSymptom("e");
		adultMedical.checkIfTextFoundOnSymptomSearchScreen("Nausea,Painful urination (burning)");
		healthDialog.searchSymptom("x");
		adultMedical.checkIfTextFoundOnSymptomSearchScreen("Low sex drive,Painful intercourse");
		healthDialog.clearSymptomSearchField();
		healthDialog.searchAndSelectSymptom("painful intercourse");
		
		adultMedical.checkIfTextFoundOnHealthDialogScreen("Any other symptoms you’d like to tell me about?");
		adultMedical.buttonSelect("chat_screen.tapToRespond");  // No
		
		adultMedical.checkIfTextFoundOnHealthDialogScreen("skin seem noticeably yellower than your normal skin tone?");
		adultMedical.buttonSelect("chat_screen.tapToRespond");  // No
		
		adultMedical.checkIfTextFoundOnHealthDialogScreen("pain in your abdomen/stomach?");
		adultMedical.buttonSelect("chat_screen.tapToRespond");  // No
		
		adultMedical.checkIfTextFoundOnHealthDialogScreen("your mouth dry?");
		adultMedical.buttonSelect("chat_screen.tapToRespond");  // No
		
		adultMedical.checkIfTextFoundOnHealthDialogScreen("Does your groin hurt?");
		adultMedical.buttonSelect("chat_screen.tapToRespond");  // No
		
		adultMedical.checkIfTextFoundOnHealthDialogScreen("Do you have vaginal itching?");
		adultMedical.buttonSelect("chat_screen.tapToRespond");  // No
		
		adultMedical.checkIfTextFoundOnHealthDialogScreen("Do you have diarrhea?");
		adultMedical.buttonSelect("chat_screen.tapToRespond");  // No
		
		adultMedical.checkIfTextFoundOnHealthDialogScreen("Do you have facial drooping?");
		adultMedical.buttonSelect("chat_screen.tapToRespond");  // No
		
		adultMedical.checkIfTextFoundOnHealthDialogScreen("pain in your flank/sides?");
		adultMedical.buttonSelect("chat_screen.tapToRespond");  // No
		
		adultMedical.checkIfTextFoundOnHealthDialogScreen("noticed swelling in your groin area?");
		adultMedical.buttonSelect("chat_screen.tapToRespond");  // No
		
		adultMedical.checkIfTextFoundOnHealthDialogScreen("Is your skin itchy?");
		adultMedical.buttonSelect("chat_screen.tapToRespond");  // No
		
		adultMedical.checkIfTextFoundOnHealthDialogScreen("noticed a change in how your urine looks or smells?");
		adultMedical.buttonSelect("chat_screen.tapToRespond");  // No
		
		adultMedical.checkIfTextFoundOnHealthDialogScreen("Do you have pain in your chest?");
		adultMedical.buttonSelect("chat_screen.tapToRespond");  // No
		
		adultMedical.checkIfTextFoundOnHealthDialogScreen("Is your speech thick or slurred?");
		adultMedical.buttonSelect("chat_screen.tapToRespond");  // No
		
		adultMedical.checkIfTextFoundOnHealthDialogScreen("Are you currently more tired than usual?");
		adultMedical.buttonSelect("chat_screen.tapToRespond");  // No
		
		adultMedical.checkIfTextFoundOnHealthDialogScreen("Are you having any vaginal discharge?");
		adultMedical.buttonSelect("chat_screen.tapToRespond");  // No
		
		adultMedical.checkIfTextFoundOnHealthDialogScreen("Do you have nausea or feel sick to your stomach?");
		adultMedical.buttonSelect("option_0");  // Yes
		
		adultMedical.checkIfTextFoundOnHealthDialogScreen("Did any of these trigger your nausea?");
		adultMedical.buttonSelect("chat_screen.tapToRespond"); // none of the above
		
		adultMedical.checkIfTextFoundOnHealthDialogScreen("How nauseous are you?");
		adultMedical.buttonSelect("chat_screen.tapToRespond"); // I'm not sure
		
		adultMedical.checkIfTextInFooterContainer("Dizziness,Fatigue,Smelly urine");
		adultMedical.buttonSelect("chat_screen.tapToRespond"); // None of the above
		
		
	}
	}
