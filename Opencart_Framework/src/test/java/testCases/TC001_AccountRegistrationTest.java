package testCases;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass{
	
	
	
	@Test(groups= {"Regression", "Master"})
	public void verify_account_registration() throws InterruptedException
	{
		try 
		{
		logger.info("****Starting TC001_AccountRegistrationTest***** ");
		HomePage hp = new HomePage(driver);
		
		hp.clickMyAccount();
		logger.info("Clicked My account link");
		
		hp.clickRegister();
		logger.info("Clicked My Register link");
		
		AccountRegistrationPage register = new AccountRegistrationPage(driver);
		
		
		logger.info("Providing Customer details");
		register.setFirstName(randomAlbhabetic().toUpperCase());
		register.setLastName(randomAlbhabetic().toUpperCase());
		
		String email = randomAlbhabetic();
		register.setEmail(email+ "@gmail.com");
		
		register.setTelephone(randomNumber());
		
		 String password = randomAlbhaNumberic();
		register.setPassword(password);
		register.setConfirmPassword(password);
		
		register.setPrivacyPolicy();
		register.clickContinue();
		
		logger.info("Validating expected output");
		String confirmation_msg=register.getConfirmationMsg();
		if(confirmation_msg.equals("Your Account Has Been Created!"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
			logger.error("Test Failed");
			logger.debug("Debug logs");
		}
		//Assert.assertEquals(confirmation_msg, "Your Account Has Been Created!??");
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info("****Finished TC001_AccountRegistrationTest***** ");
		
		/*
		register.clickreg_Continue();
		

		HomePage hp1 = new HomePage(driver);
		hp.clickMyAccount();
		
		register.clickLogout();
		
		AccountLoginPage ac = new AccountLoginPage(driver);
		
		ac.clickMyAccount();
		ac.clickLogin();
		ac.email(email);
		ac.pwd(password);
		
		Thread.sleep(5000);
	*/
	}
	
	

}
