
/*************************************** PURPOSE **********************************

 - This class implements the WebDriverListener, which is included under events.
 The purpose of implementing this interface is to override all the methods and define certain useful  Log statements 
 which would be displayed/logged as the application under test is being run.

 Do not call any of these methods, instead these methods will be invoked automatically
 as an when the action done (click, findBy etc). 

 */

package utils;


import base.BaseTest;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.events.WebDriverListener;

public class WebEventListener extends BaseTest implements WebDriverListener {

	// Navigation

	@Override
	public void beforeGet(WebDriver driver, String url) {
		System.out.println("Navigating to: " + url);
	}

	@Override
	public void afterGet(WebDriver driver, String url) {
		System.out.println("Navigated to: " + url);
	}

	// Find element

	@Override
	public void beforeFindElement(WebDriver driver, By locator) {
		System.out.println("Trying to find element by: " + locator);
	}

	@Override
	public void afterFindElement(WebDriver driver, By locator, WebElement result) {
		System.out.println("Found element by: " + locator);
	}

	// Click

	@Override
	public void beforeClick(WebElement element) {
		System.out.println("Trying to click on: " + element);
	}

	@Override
	public void afterClick(WebElement element) {
		System.out.println("Clicked on: " + element);
	}

	// Send keys

	@Override
	public void beforeSendKeys(WebElement element, CharSequence... keysToSend) {
		System.out.println("Typing value into element: " + element);
	}

	@Override
	public void afterSendKeys(WebElement element, CharSequence... keysToSend) {
		System.out.println("Finished typing into element: " + element);
	}

	// Errors

	@Override
	public void onError(Object target, Method method, Object[] args, InvocationTargetException e) {

		System.out.println("Exception occurred in method: " + method.getName());
		System.out.println("Error details: " + e.getCause());
		try {
			TestUtils.takeScreenshotAtEndOfTest();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	// Browser close

	@Override
	public void beforeQuit(WebDriver driver) {
		System.out.println("Closing browser");
	}

	@Override
	public void afterQuit(WebDriver driver) {
		System.out.println("Browser closed");
	}
}

/*
 * public class WebEventListener extends BaseTest implements WebDriverListener {
 * 
 * public void beforeNavigateTo(String url, WebDriver driver) {
 * System.out.println("Before navigating to: '" + url + "'"); }
 * 
 * public void afterNavigateTo(String url, WebDriver driver) {
 * System.out.println("Navigated to:'" + url + "'"); }
 * 
 * public void beforeChangeValueOf(WebElement element, WebDriver driver) {
 * System.out.println("Value of the:" + element.toString() +
 * " before any changes made"); }
 * 
 * public void afterChangeValueOf(WebElement element, WebDriver driver) {
 * System.out.println("Element value changed to: " + element.toString()); }
 * 
 * public void beforeClickOn(WebElement element, WebDriver driver) {
 * System.out.println("Trying to click on: " + element.toString()); }
 * 
 * public void afterClickOn(WebElement element, WebDriver driver) {
 * System.out.println("Clicked on: " + element.toString()); }
 * 
 * public void beforeNavigateBack(WebDriver driver) {
 * System.out.println("Navigating back to previous page"); }
 * 
 * public void afterNavigateBack(WebDriver driver) {
 * System.out.println("Navigated back to previous page"); }
 * 
 * public void beforeNavigateForward(WebDriver driver) {
 * System.out.println("Navigating forward to next page"); }
 * 
 * public void afterNavigateForward(WebDriver driver) {
 * System.out.println("Navigated forward to next page"); }
 * 
 * public void onException(Throwable error, WebDriver driver) throws IOException
 * { System.out.println("Exception occured: " + error);
 * TestUtils.takeScreenshotAtEndOfTest(); }
 * 
 * public void beforeFindBy(By by, WebElement element, WebDriver driver) {
 * System.out.println("Trying to find Element By : " + by.toString()); }
 * 
 * public void afterFindBy(By by, WebElement element, WebDriver driver) {
 * System.out.println("Found Element By : " + by.toString()); }
 * 
 * 
 * non overridden methods of WebListener class
 * 
 * public void beforeScript(String script, WebDriver driver) { }
 * 
 * public void afterScript(String script, WebDriver driver) { }
 * 
 * public void beforeAlertAccept(WebDriver driver) { // TODO Auto-generated
 * method stub
 * 
 * }
 * 
 * public void afterAlertAccept(WebDriver driver) { // TODO Auto-generated
 * method stub
 * 
 * }
 * 
 * public void afterAlertDismiss(WebDriver driver) { // TODO Auto-generated
 * method stub
 * 
 * }
 * 
 * public void beforeAlertDismiss(WebDriver driver) { // TODO Auto-generated
 * method stub
 * 
 * }
 * 
 * public void beforeNavigateRefresh(WebDriver driver) { // TODO Auto-generated
 * method stub
 * 
 * }
 * 
 * public void afterNavigateRefresh(WebDriver driver) { // TODO Auto-generated
 * method stub
 * 
 * }
 * 
 * public void beforeChangeValueOf(WebElement element, WebDriver driver,
 * CharSequence[] keysToSend) { // TODO Auto-generated method stub
 * 
 * }
 * 
 * public void afterChangeValueOf(WebElement element, WebDriver driver,
 * CharSequence[] keysToSend) { // TODO Auto-generated method stub
 * 
 * }
 * 
 * public <X> void afterGetScreenshotAs(OutputType<X> arg0, X arg1) { // TODO
 * Auto-generated method stub
 * 
 * }
 * 
 * public void afterGetText(WebElement arg0, WebDriver arg1, String arg2) { //
 * TODO Auto-generated method stub
 * 
 * }
 * 
 * public void afterSwitchToWindow(String arg0, WebDriver arg1) { // TODO
 * Auto-generated method stub
 * 
 * }
 * 
 * public <X> void beforeGetScreenshotAs(OutputType<X> arg0) { // TODO
 * Auto-generated method stub
 * 
 * }
 * 
 * public void beforeGetText(WebElement arg0, WebDriver arg1) { // TODO
 * Auto-generated method stub
 * 
 * }
 * 
 * public void beforeSwitchToWindow(String arg0, WebDriver arg1) { // TODO
 * Auto-generated method stub
 * 
 * }
 * 
 * }
 * 
 * 
 */