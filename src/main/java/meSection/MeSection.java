/**
 * Created by Shahar Sheinfeld on 18/08/2020.
 **/
package meSection;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;
import tests.TestHelpers;


public class MeSection extends TestHelpers
{
	
	public MeSection(AppiumDriver driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(accessibility = "meAvatar")
	@iOSXCUITFindBy(accessibility = "meAvatar")
	MobileElement meButton;
	
	@AndroidFindBy(accessibility = "expand_questions_group")
	@iOSXCUITFindBy(accessibility = "expand_questions_group")
	MobileElement userInfo;
	
	
	public void clickOnMeButton()
	{
		meButton.click();
	}
	
	public void checkUserInfo(String text)
	{
		checkIfTextEqualsToTextOnScreen(userInfo, text);
	}
}
