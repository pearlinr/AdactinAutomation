package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookAHotel {
public WebDriver driver;
public BookAHotel(WebDriver ldriver) {
	this.driver=ldriver;
	PageFactory.initElements(driver, this);
}
@FindBy(id="hotel_name_dis")
private WebElement hotelDis;
@FindBy(id="location_dis")
private WebElement locationDis;
@FindBy(id="room_type_dis")
private WebElement roomTypeDis;
@FindBy(id="room_num_dis")
private WebElement roomNumDis;
@FindBy(id="total_days_dis")
private WebElement daysDis;
@FindBy(id="price_night_dis")
private WebElement price1Dis;
@FindBy(id="total_price_dis")
private WebElement totalPriceDis;
@FindBy(id="gst_dis")
private WebElement gstDis;
@FindBy(id="final_price_dis")
private WebElement finalPriceDis;
@FindBy(id="first_name")
private WebElement firstName;
@FindBy(id="last_name")
private WebElement lastname;
@FindBy(id="address")
private WebElement address;
@FindBy(id="cc_num")
private WebElement cardNum;
@FindBy(id="cc_type")
private WebElement cardType;
@FindBy(id="cc_exp_month")
private WebElement cardExpMonth;
@FindBy(id="cc_exp_year")
private WebElement cardExpYear;
@FindBy(id="cc_cvv")
private WebElement cardCVVNum;
@FindBy(id="book_now")
private WebElement bookNow;
public WebElement getHotelDis() {
	return hotelDis;
}
public WebElement getLocationDis() {
	return locationDis;
}
public WebElement getRoomTypeDis() {
	return roomTypeDis;
}
public WebElement getRoomNumDis() {
	return roomNumDis;
}
public WebElement getDaysDis() {
	return daysDis;
}
public WebElement getPrice1Dis() {
	return price1Dis;
}
public WebElement getTotalPriceDis() {
	return totalPriceDis;
}
public WebElement getGstDis() {
	return gstDis;
}
public WebElement getFinalPriceDis() {
	return finalPriceDis;
}
public WebElement getFirstName() {
	return firstName;
}
public WebElement getLastname() {
	return lastname;
}
public WebElement getAddress() {
	return address;
}
public WebElement getCardNum() {
	return cardNum;
}
public WebElement getCardType() {
	return cardType;
}
public WebElement getCardExpMonth() {
	return cardExpMonth;
}
public WebElement getCardExpYear() {
	return cardExpYear;
}
public WebElement getCardCVVNum() {
	return cardCVVNum;
}
public WebElement getBookNow() {
	return bookNow;
}






























}
