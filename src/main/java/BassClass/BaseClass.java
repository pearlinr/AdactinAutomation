
package BassClass;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {
	public static WebDriver driver;

	public static WebDriver browser(String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "\\resources\\Driver\\chromedriver.exe");
				driver = new ChromeDriver();
			} else if (browserName.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver",
						System.getProperty("user.dir")+ "\\resources\\Driver\\chromedriver.exe");
				driver = new FirefoxDriver();
			} else if (browserName.equalsIgnoreCase("internetexplorer")) {
				System.setProperty("webdriver.ie.driver",
						System.getProperty("usr.dir") + "\\resources\\Driver\\chromedriver.exe");
				driver = new InternetExplorerDriver();
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			return driver;
	}

	public static void getUrl(String url) {
		driver.get(url);
	}

	public static void navigateToPage(String navigatePage) {
		driver.navigate().to(navigatePage);
	}

	public static String getCurrentUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}

	public static String getTitle() {
		String title = driver.getTitle();
		return title;
	}

	public static void elementVisibility(WebElement element) {
		WebDriverWait wdw = new WebDriverWait(driver, 60);
		wdw.until(ExpectedConditions.visibilityOf(element));
	}

	public static boolean isDisplay(WebElement element) {
		boolean displayed = element.isDisplayed();
		return displayed;
	}

	public static boolean isEnabled(WebElement element) {
		boolean enabled = element.isEnabled();
		return enabled;
	}

	public static boolean isSelected(WebElement element) {
		boolean selected = element.isSelected();
		return selected;
	}

	public static void KeysToSend(String keys, WebElement element) {
		elementVisibility(element);
		if (isDisplay(element) && isEnabled(element)) {
			element.clear();
			element.sendKeys(keys);
		}
	}

	public static void singleClick(WebElement element) {
		element.click();
	}

	public static void mouseHover(WebElement element) {
		elementVisibility(element);
		Actions ac = new Actions(driver);
		ac.moveToElement(element).build().perform();
	}

	public static String getElementText(WebElement element) {
		String text = element.getText();
		return text;
	}

	public static Dimension getElementSize(WebElement element) {
		Dimension size = element.getSize();
		return size;
	}

	public static String getAttributeValue(WebElement element, String value) {
		String attributeVaue = element.getAttribute(value);
		return attributeVaue;
	}

	public static void doubleClick(WebElement element) {
		elementVisibility(element);
		Actions ac = new Actions(driver);
		ac.doubleClick(element).build().perform();
	}

	public static void rightClick(WebElement element) {
		elementVisibility(element);
		Actions ac = new Actions(driver);
		ac.contextClick(element).build().perform();
	}

	public static void dragAndDrop(WebElement sourceElement, WebElement targetElement) {
		elementVisibility(sourceElement);
		elementVisibility(targetElement);
		Actions ac = new Actions(driver);
		ac.dragAndDrop(sourceElement, targetElement).release(targetElement).perform();
	}

	public static void clickAndHold(WebElement element) {
		elementVisibility(element);
		Actions ac = new Actions(driver);
		ac.clickAndHold(element).release(element).perform();
	}

	public static void scrollIntoView(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scollIntoView()", element);
	}

	public static void scrollBy(WebElement element, int startingPixel, int endingPixel) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(" + startingPixel + "," + endingPixel + ")", element);
	}

	public static void scrollToPageDown(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)", element);
	}

	public static void scrollToPageUp(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTO(0,-document.body.scrollHeight)", element);
	}

	public static void takesScreenShot(String fileName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File sourceFile = ts.getScreenshotAs(OutputType.FILE);
		File descFile = new File(
				System.getProperty("User.dir") + "\\src\\test\\resoucres\\ScreenShots\\" + fileName + ".png");
		FileUtils.copyFile(sourceFile, descFile);
	}

	public static void singleDropDown(WebElement element, String options,String value) {
		Select sc = new Select(element);
		if (options.equalsIgnoreCase("index")) {
			sc.selectByIndex(Integer.parseInt(value));
		} else if (options.equalsIgnoreCase("value")) {
			sc.selectByValue(value);
		} else if (options.equalsIgnoreCase("text")) {
			sc.selectByVisibleText(value);
		}
	}
	public static String getOptionInDropDown(WebElement element) {
		Select sc = new Select(element);
		String optionData = sc.getFirstSelectedOption().getText();
		return optionData;
		
	}
	public static boolean multipleDropDown(WebElement element) {
		Select sc = new Select(element);
		boolean multiple = sc.isMultiple();
		return multiple;
	}

	public static void alertAccept(WebElement element) {
		elementVisibility(element);
		Alert alt = driver.switchTo().alert();
		alt.accept();
	}

	public static void alertDismiss(WebElement element) {
		elementVisibility(element);
		Alert alt = driver.switchTo().alert();
		alt.dismiss();
	}

	public static void alertSendKeys(WebElement element, String keysToSend) {
		elementVisibility(element);
		Alert alt = driver.switchTo().alert();
		alt.sendKeys(keysToSend);
	}

	public static int scannerNumbers() {
		Scanner scan = new Scanner(System.in);
		int nextInt = scan.nextInt();
		return nextInt;
	}

	public static String scannerStringWithOutSpace() {
		Scanner scan = new Scanner(System.in);
		String next = scan.next();
		return next;
	}

	public static String scannerStringWithSpace() {
		Scanner scan = new Scanner(System.in);
		String nextLine = scan.nextLine();
		return nextLine;
	}

	public static void updateToExcel() {
File f=new File(System.getProperty(""));
	}

	public static void driverClose() {
		driver.close();
	}

	public static void driverQuit() {
		driver.quit();
	}

}
