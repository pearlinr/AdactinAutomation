package POM;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectHotel {
public WebDriver driver;
public SelectHotel(WebDriver ldriver) {
	this.driver=ldriver;
	PageFactory.initElements(driver, this);
}

@FindBy(xpath="//td[@class='login_title']")
private WebElement pageText;
@FindBy(xpath="/html/body/table/tbody/tr/td/form/table/tbody/tr/td/table/tbody/tr[2]//td//input")
private List<WebElement> tableData;
@FindBy(id="continue")
private WebElement continueButton;




public WebElement getContinueButton() {
	return continueButton;
}
public WebElement getPageText() {
	return pageText;
}
public List<WebElement> getTableData() {
	return tableData;
}










}
