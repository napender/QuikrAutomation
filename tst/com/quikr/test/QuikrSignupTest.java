package com.quikr.test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.quikr.constant.QuikrSignUpXpaths;
import com.quikr.logic.helper.BrowserSessionHelper;

/**
 * 
 * @author napendra
 * 
 */

public class QuikrSignupTest {

	private String textVariable = "Thank You for registering on Quikr";

	@SuppressWarnings("deprecation")
	@Test(dataProvider = "testDataFirst")
	public void testQuikrSignupForInvalidData(String firstName,String userName,String passWord,String eMail,String city) throws Exception {

		BrowserSessionHelper browserHelper = new BrowserSessionHelper();
		browserHelper.open("http://www.quikr.com/Register");
		browserHelper.findElement(QuikrSignUpXpaths.FIRST_NAME, firstName);
		browserHelper.findElement(QuikrSignUpXpaths.USER_NAME, userName);
		browserHelper.findElement(QuikrSignUpXpaths.PASSWORD, passWord);
		browserHelper.findElement(QuikrSignUpXpaths.EMAIL, eMail);
		browserHelper.findDropDownElement(QuikrSignUpXpaths.CITY, city);
		browserHelper.findElementAndClick(QuikrSignUpXpaths.AGE_CONF);
		browserHelper.findElementAndClick(QuikrSignUpXpaths.SUBMIT);
		Assert.assertFalse(browserHelper.getPageSource().contains(textVariable));
		browserHelper.close();

	}

	@DataProvider(name = "testDataFirst")
	public Object[][] createData1() {
		return new Object[][] { { "123","123","123","123","Agra" },
				                { "","","","","Bangalore" }, };
	}
}
