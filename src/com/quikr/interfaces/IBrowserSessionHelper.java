package com.quikr.interfaces;

/**
 * 
 * @author napendra
 * 
 */
public interface IBrowserSessionHelper {

	public void open(String url) throws Exception;

	public void findElement(String xpath, String key);

	public void findDropDownElement(String xpath, String key);

	public void findElementAndClick(String xpath);

	public String getPageSource();

	public void close();

}
