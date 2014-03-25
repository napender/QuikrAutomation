package com.quikr.logic.helper;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.support.ui.Select;

import com.quikr.interfaces.IBrowserSessionHelper;

/**
 * 
 * @author napendra
 * 
 */

public class BrowserSessionHelper implements IBrowserSessionHelper {

	private WebDriver driver;
	private Select dropDown;

	public BrowserSessionHelper() {

		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	@Override
	public void open(String url) throws Exception {
		driver.get(url);
	}

	@Override
	public void findElement(String xpath, String key) {
		driver.findElement(By.id(xpath)).sendKeys(key);

	}

	@Override
	public void findDropDownElement(String xpath, String key) {
		dropDown = new Select(driver.findElement(By.id(xpath)));
		dropDown.selectByVisibleText(key);

	}

	@Override
	public void findElementAndClick(String xpath) {
		driver.findElement(By.id(xpath)).click();

	}

	@Override
	public String getPageSource() {
		return driver.getPageSource();
	}

	@Override
	public void close() {
		driver.close();

	}

}
