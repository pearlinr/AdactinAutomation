package Helper;

import org.openqa.selenium.WebDriver;

import POM.BookAHotel;
import POM.BookingConfirmation;
import POM.HomePage;
import POM.OrderHistory;
import POM.SearchHotel;
import POM.SelectHotel;

public class PageObjectHelper {
public WebDriver driver;	

public PageObjectHelper(WebDriver xdriver) {
	this.driver=xdriver;
}
	
private BookAHotel bah;
private BookingConfirmation bc;
private HomePage hp;
private OrderHistory oh;
private SearchHotel sh;
private SelectHotel seh;

public BookAHotel getBah() {
	if (bah==null) {
		bah=new BookAHotel(driver);
	}
	return bah;
}
public BookingConfirmation getBc() {
	if (bc==null) {
		bc= new BookingConfirmation(driver);
	}
	return bc;
}
public HomePage getHp() {
	if (hp==null) {
		hp=new HomePage(driver);
	}
	return hp;
}
public OrderHistory getOh() {
	if (oh==null) {
		oh=new OrderHistory(driver);
	}
	return oh;
}
public SearchHotel getSh() {
	if (sh==null) {
		sh=new SearchHotel(driver);
	}
	return sh;
}
public SelectHotel getSeh() {
	if (seh==null) {
		seh=new SelectHotel(driver);
	}
	return seh;
}



}
