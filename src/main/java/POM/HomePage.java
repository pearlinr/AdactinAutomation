package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public static WebDriver driver;
public HomePage(WebDriver ldriver) {
	this.driver=ldriver;
	PageFactory.initElements(driver, this);
}
@FindBy(xpath="//img[@class='logo']")
private WebElement logo;
@FindBy(id="username")
private WebElement userName;
@FindBy(id="password")
private WebElement password;
@FindBy(xpath="//input[@type='Submit']")
private WebElement loginButton;

public WebElement getLogo() {
	return logo;
}
public WebElement getUserName() {
	return userName;
}
public WebElement getPassword() {
	return password;
}
public WebElement getLoginButton() {
	return loginButton;
}











}
