package POM;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderHistory {
	public WebDriver driver;
	public OrderHistory(WebDriver ldriver) {
		this.driver=ldriver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[text()='Booked Itinerary']")
	private WebElement bookedItinerary;
	@FindBy(id="order_id_text")
	private WebElement orderSearch;
	@FindBy(xpath="/html/body/table/tbody/tr/td/form/table/tbody/tr/td/table/tbody/tr/td/input")
	private List<WebElement> orderTable;
	@FindBy(id="search_hotel_id")
	private WebElement search;
	@FindBy(xpath="/html/body/table/tbody/tr/td/form/table/tbody/tr/td/table/tbody/tr/td/strong")
	private List<WebElement> orderHeader;
	public List<WebElement> getOrderHeader() {
		return orderHeader;
	}
	public WebElement getSearch() {
		return search;
	}
	public WebElement getBookedItinerary() {
		return bookedItinerary;
	}
	public WebElement getOrderSearch() {
		return orderSearch;
	}
	public List<WebElement> getOrderTable() {
		return orderTable;
	}
	
	
	
	
	
	
	
	
	
	
}
