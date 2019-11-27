package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookingConfirmation {
	public WebDriver driver;
	public BookingConfirmation(WebDriver ldriver) {
		this.driver=ldriver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="(//input[@class='disable_text'])[1]")
	private WebElement hotelName;
	@FindBy(xpath="(//input[@class='disable_text'])[2]")
	private WebElement location;
	@FindBy(xpath="(//input[@class='disable_text'])[3]")
	private WebElement roomType;
	@FindBy(xpath="(//input[@class='disable_text'])[4]")
	private WebElement arrivalDate ;
	@FindBy(xpath="(//input[@class='disable_text'])[5]")
	private WebElement departureDate;
	@FindBy(xpath="(//input[@class='disable_text'])[6]")
	private WebElement totalRoom;
	@FindBy(xpath="(//input[@class='disable_text'])[7]")
	private WebElement adult;
	@FindBy(xpath="(//input[@class='disable_text'])[8]")
	private WebElement children;
	@FindBy(xpath="(//input[@class='disable_text'])[9]")
	private WebElement price;
	@FindBy(xpath="(//input[@class='disable_text'])[10]")
	private WebElement totalPrice;
	@FindBy(xpath="(//input[@class='disable_text'])[11]")
	private WebElement gstPrice;
	@FindBy(xpath="(//input[@class='disable_text'])[12]")
	private WebElement finalPrice;
	@FindBy(xpath="(//input[@class='disable_text'])[13]")
	private WebElement firstname;
	@FindBy(xpath="(//input[@class='disable_text'])[14]")
	private WebElement lastname;	
	@FindBy(id="address")
	private WebElement address;
	@FindBy(xpath="(//input[@class='disable_text'])[15]")
	private WebElement orderNumber;
	@FindBy(id="my_itinerary")
	private WebElement myItinerary;
	
	public WebElement getRoomType() {
		return roomType;
	}
	public WebElement getHotelName() {
		return hotelName;
	}
	public WebElement getLocation() {
		return location;
	}
	public WebElement getArrivalDate() {
		return arrivalDate;
	}
	public WebElement getDepartureDate() {
		return departureDate;
	}
	public WebElement getTotalRoom() {
		return totalRoom;
	}
	public WebElement getAdult() {
		return adult;
	}
	public WebElement getChildren() {
		return children;
	}
	public WebElement getPrice() {
		return price;
	}
	public WebElement getTotalPrice() {
		return totalPrice;
	}
	public WebElement getGstPrice() {
		return gstPrice;
	}
	public WebElement getFinalPrice() {
		return finalPrice;
	}
	public WebElement getFirstname() {
		return firstname;
	}
	public WebElement getLastname() {
		return lastname;
	}
	public WebElement getAddress() {
		return address;
	}
	public WebElement getOrderNumber() {
		return orderNumber;
	}
	public WebElement getMyItinerary() {
		return myItinerary;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
