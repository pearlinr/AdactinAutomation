package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchHotel {
	public WebDriver driver;
public SearchHotel(WebDriver ldriver) {
	this.driver=ldriver;
	PageFactory.initElements(driver, this);
}
@FindBy(id="location")
private WebElement location;
@FindBy(id="hotels")
private WebElement hotelName;
@FindBy(id="room_type")
private WebElement roomType;
@FindBy(id="room_nos")
private WebElement roomNum;
@FindBy(xpath="(//input[@class='date_pick'])[1]")
private WebElement checkInDate;
@FindBy(xpath="(//input[@class='date_pick'])[2]")
private WebElement checkOutDate;
@FindBy(id="adult_room")
private WebElement adultRoom;
@FindBy(id="child_room")
private WebElement childrenRoom;
@FindBy(name="Submit")
private WebElement searchButton;
@FindBy(id="checkout_span")
private WebElement regError;
@FindBy(id="username_show")
private WebElement usernameVerify;
public WebElement getUsernameVerify() {
	return usernameVerify;
}
public WebElement getChildrenRoom() {
	return childrenRoom;
}
public WebElement getRegError() {
	return regError;
}
public WebElement getSearchButton() {
	return searchButton;
}
public WebElement getLocation() {
	return location;
}
public WebElement getHotelName() {
	return hotelName;
}
public WebElement getRoomType() {
	return roomType;
}
public WebElement getRoomNum() {
	return roomNum;
}
public WebElement getCheckInDate() {
	return checkInDate;
}
public WebElement getCheckOutDate() {
	return checkOutDate;
}
public WebElement getAdultRoom() {
	return adultRoom;
}

}
