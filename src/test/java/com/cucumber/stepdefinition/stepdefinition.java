package com.cucumber.stepdefinition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.cucumber.testrunner.testrunner;

import BassClass.BaseClass;
import Helper.ConfigReader;
import Helper.PageObjectHelper;
import POM.BookAHotel;
import POM.BookingConfirmation;
import POM.HomePage;
import POM.OrderHistory;
import POM.SearchHotel;
import POM.SelectHotel;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class stepdefinition extends BaseClass {
	public static WebDriver driver=testrunner.driver;
	public static PageObjectHelper poh= new PageObjectHelper(driver);
	
	@When("^Launch hotel reservation application using URL as in test data$")
	public void launch_hotel_reservation_application_using_URL_as_in_test_data() throws Throwable {
		ConfigReader cr=new ConfigReader();
		getUrl(cr.getUrl());
		isDisplay(poh.getHp().getLogo());
		
	}

	@Then("^Login to the application using username \"([^\"]*)\" and password \"([^\"]*)\" as in test data$")
	public void login_to_the_application_using_username_and_password_as_in_test_data(String username, String password)
			throws Throwable {
		HomePage hp = new HomePage(driver);
		KeysToSend(username, hp.getUserName());
		KeysToSend(password, hp.getPassword());
		isEnabled(hp.getLoginButton());
		singleClick(hp.getLoginButton());
		System.out.println("Logged in successfully");
	}

	@Then("^Select location \"([^\"]*)\" as in test data$")
	public void select_location_as_in_test_data(String location) throws Throwable {
		SearchHotel sh = new SearchHotel(driver);
		Assert.assertEquals(getAttributeValue(sh.getUsernameVerify(), "value"), "Hello Della2018!");
		singleDropDown(sh.getLocation(), "text", "Sydney");
	}

	@Then("^Select hotel \"([^\"]*)\" as in test data$")
	public void select_hotel_as_in_test_data(String hotelName) throws Throwable {
		SearchHotel sh = new SearchHotel(driver);
		singleDropDown(sh.getHotelName(), "value", hotelName);
	}

	@Then("^Select room type \"([^\"]*)\" as in test data$")
	public void select_room_type_as_in_test_data(String roomType) throws Throwable {
		SearchHotel sh = new SearchHotel(driver);
		singleDropDown(sh.getRoomType(), "value", roomType);
	}

	@Then("^Select no-of-rooms \"([^\"]*)\" as in test data$")
	public void select_no_of_rooms_as_in_test_data(String roomNum) throws Throwable {
		SearchHotel sh = new SearchHotel(driver);
		singleDropDown(sh.getRoomNum(), "value", roomNum);
	}

	@Then("^Enter check-in-date \"([^\"]*)\" later than the checkout-date \"([^\"]*)\" field as in test data$")
	public void enter_check_in_date_later_than_the_checkout_date_field_as_in_test_data(String inDate, String outDate)
			throws Throwable {
		SearchHotel sh = new SearchHotel(driver);
		KeysToSend(inDate, sh.getCheckInDate());
		KeysToSend(outDate, sh.getCheckOutDate());
	}

	@Then("^Verify that system gives an error saying ‘check-in-date should not be later than check-out-date’$")
	public void verify_that_system_gives_an_error_saying_check_in_date_should_not_be_later_than_check_out_date()
			throws Throwable {
		SearchHotel sh = new SearchHotel(driver);
		Assert.assertEquals("Check-Out Date shall be after than Check-In Date", getElementText(sh.getRegError()));
		System.out.println("Verified succesfully");
	}

	@Then("^Verify that application throws error message$")
	public void verify_that_application_throws_error_message() throws Throwable {
		throw new Exception("Enter Valid dates");
	}

	@Then("^Select No-of-adults as in test data \"([^\"]*)\"$")
	public void select_No_of_adults_as_in_test_data(String adult) throws Throwable {
		SearchHotel sh = new SearchHotel(driver);
		singleDropDown(sh.getAdultRoom(), "value", adult);

	}

	@Then("^Select No-of-children as in test data \"([^\"]*)\"$")
	public void select_No_of_children_as_in_test_data(String children) throws Throwable {
		SearchHotel sh = new SearchHotel(driver);
		singleDropDown(sh.getChildrenRoom(), "value", children);

	}

	@Then("^Click on Search button$")
	public void click_on_Search_button() throws Throwable {
		SearchHotel sh = new SearchHotel(driver);
		singleClick(sh.getSearchButton());

	}

	@Then("^Verify that hotel \"([^\"]*)\" displayed is the same as selected in search Hotel form$")
	public void verify_that_hotel_displayed_is_the_same_as_selected_in_search_Hotel_form(String hotelName)
			throws Throwable {
		SelectHotel sho = new SelectHotel(driver);
		isDisplay(sho.getPageText());
		for (WebElement x : sho.getTableData()) {
			String hotel = getAttributeValue(x, "value");
			// Assert.assertTrue(hotel.contains(hotelName));
			if (hotel.contains(hotelName)) {
				System.out.println("Hotel name: " + hotel);
			}
		}
	}

	@Then("^Location displayed in Select Hotel should be the same as location \"([^\"]*)\" selected in search hotel form$")
	public void location_displayed_in_Select_Hotel_should_be_the_same_as_location_selected_in_search_hotel_form(
			String hotelLocation) throws Throwable {
		SelectHotel sho = new SelectHotel(driver);
		for (WebElement y : sho.getTableData()) {
			String hotelLocate = getAttributeValue(y, "value");
			// Assert.assertTrue("Hotel location is: "+hotelLocation,
			// hotelLocate.contains(hotelLocation));
			if (hotelLocate.contains(hotelLocation)) {
				System.out.println("Hotel Location is: " + hotelLocation);
			}
		}
	}

	@Then("^Select the booking and click continue button$")
	public void continueBooking() {
		SelectHotel sho = new SelectHotel(driver);
		for (WebElement z : sho.getTableData()) {
			String select = getAttributeValue(z, "value");
			if (select.contains("0")) {
				singleClick(z);
			}
		}
		singleClick(sho.getContinueButton());
	}
	@Then("^Check whether all details are disabled$")
	public void check_whether_all_details_are_disabled() throws Throwable {
	    BookAHotel bah=new BookAHotel(driver);
	    Assert.assertFalse(isEnabled(bah.getHotelDis()));
	    Assert.assertFalse(isEnabled(bah.getLocationDis()));
	    Assert.assertFalse(isEnabled(bah.getRoomTypeDis()));
	    Assert.assertFalse(isEnabled(bah.getRoomNumDis()));
	    Assert.assertFalse(isEnabled(bah.getDaysDis()));
	    Assert.assertFalse(isEnabled(bah.getPrice1Dis()));
	    Assert.assertFalse(isEnabled(bah.getTotalPriceDis()));
	    Assert.assertFalse(isEnabled(bah.getGstDis()));
	    Assert.assertFalse(isEnabled(bah.getFinalPriceDis()));
	   
	}

	@Then("^Fill the form and click on Book now button$")
	public void fill_the_form_and_click_on_Book_now_button() throws Throwable {
		BookAHotel bah=new BookAHotel(driver);
		KeysToSend("Johanna", bah.getFirstName());
		KeysToSend("Della", bah.getLastname());
		KeysToSend("Mogappair West", bah.getAddress());
		KeysToSend("26598345265847315962", bah.getCardNum());
		singleDropDown(bah.getCardType(),"value", "VISA");
		singleDropDown(bah.getCardExpMonth(), "text", "February");
		singleDropDown(bah.getCardExpYear(), "text", "2022");
		KeysToSend("358", bah.getCardCVVNum());
		singleClick(bah.getBookNow());
	}

	@Then("^Click on My itinerary button$")
	public void click_on_My_itinerary_button() throws Throwable {
	  BookingConfirmation bc=new BookingConfirmation(driver);
	  Assert.assertFalse(isEnabled(bc.getHotelName()));
	  Assert.assertFalse(isEnabled(bc.getLocation()));
	  Assert.assertFalse(isEnabled(bc.getRoomType()));
	  Assert.assertFalse(isEnabled(bc.getArrivalDate()));
	  Assert.assertFalse(isEnabled(bc.getDepartureDate()));
	  Assert.assertFalse(isEnabled(bc.getTotalRoom()));
	  Assert.assertFalse(isEnabled(bc.getAdult()));	  
	  Assert.assertFalse(isEnabled(bc.getChildren()));
	  Assert.assertFalse(isEnabled(bc.getPrice()));
	  Assert.assertFalse(isEnabled(bc.getTotalPrice()));
	  Assert.assertFalse(isEnabled(bc.getGstPrice()));
	  Assert.assertFalse(isEnabled(bc.getFinalPrice()));
	  Assert.assertFalse(isEnabled(bc.getFirstname()));
	  Assert.assertFalse(isEnabled(bc.getLastname()));
	  Assert.assertFalse(isEnabled(bc.getAddress()));
	  Assert.assertFalse(isEnabled(bc.getOrderNumber()));
	  String orderNum = getAttributeValue(bc.getOrderNumber(), "value");
	  System.out.println(orderNum);
	  singleClick(bc.getMyItinerary());
	}
	@Then("^Click on booked itinerary button$")
	public void click_on_booked_itinerary_button() throws Throwable {
		OrderHistory oh=new OrderHistory(driver);
	   isEnabled(oh.getBookedItinerary());
	   singleClick(oh.getBookedItinerary());
	}

	@Then("^Enter the order id$")
	public void enter_the_order_id() throws Throwable {
		OrderHistory oh=new OrderHistory(driver);
		KeysToSend("I2K01I86AE", oh.getOrderSearch());
		singleClick(oh.getSearch());
	}

	@Then("^Verify that the relevant details are displayed$")
	public void verify_that_the_relevant_details_are_displayed() throws Throwable {
		OrderHistory oh=new OrderHistory(driver);
		String a[]= {", Go, 316604, I2K01I86AE, Cancel I2K01I86AE, Hotel Creek, Sydney, 2 Rooms, Johanna, Della, 20/11/2019, 21/11/2019, 1 Days, Standard, AUD $ 125, AUD $ 149"};
		Set<String> l=new LinkedHashSet<String>(Arrays.asList(a));
		Set<String> s=new LinkedHashSet<String>();
		for (WebElement d : oh.getOrderTable()) {
		String tableDetails = getAttributeValue(d, "value");
		s.add(tableDetails);
				}	
		/*for (WebElement w : oh.getOrderHeader()) {
			String headerText = getElementText(w);
		l.add(headerText);			
		}*/
		Assert.assertTrue(s.retainAll(l));
		System.out.println("Context are correct");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
