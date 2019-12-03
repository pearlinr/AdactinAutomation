Feature: Sample Test Cases for Automation for AdactIn Hotel Application

  @TC_101
  Scenario: To verify valid login details
    Given Launch hotel reservation application using URL as in test data
    When Login to the application using username "Della2018" and password "emmu@26" as in test data

  @TC_102
  Scenario: To verify whether the check-out date field accepts a later date than checkin date.
    Given Launch hotel reservation application using URL as in test data
    When Login to the application using username "Della2018" and password "emmu@26" as in test data
    And Select location "Sydney" as in test data
    And Select hotel "Hotel Creek" as in test data
    And Select room type "Standard" as in test data
    And Select no-of-rooms "2" as in test data
    And Enter check-in-date "26/11/2019" later than the checkout-date "21/11/2019" field as in test data
    And Click on Search button
    Then Verify that system gives an error saying ‘check-in-date should not be later than check-out-date’

  @TC_103
  Scenario: To check if error is reported if check-out date field is in the past
    Given Launch hotel reservation application using URL as in test data
    When Login to the application using username "Della2018" and password "emmu@26" as in test data
    And Select location "Sydney" as in test data
    And Select hotel "Hotel Creek" as in test data
    And Select room type "Standard" as in test data
    And Select no-of-rooms "2" as in test data
    And Enter check-in-date "14/11/2019" later than the checkout-date "16/11/2019" field as in test data
    And Click on Search button
    Then Verify that application throws error message

  @TC_104
  Scenario: To verify whether locations in Select Hotel page are displayed according to the location selected in Search Hotel
    Given Launch hotel reservation application using URL as in test data
    When Login to the application using username "Della2018" and password "emmu@26" as in test data
    And Select location "Sydney" as in test data
    And Select hotel "Hotel Creek" as in test data
    And Select room type "Standard" as in test data
    And Select no-of-rooms "2" as in test data
    And Enter check-in-date "20/11/2019" later than the checkout-date "21/11/2019" field as in test data
    And Select No-of-adults as in test data "1"
    ##And  Select No-of-children as in test data "- Select Children per Room -"
    And Click on Search button
    Then Verify that hotel "Hotel Creek" displayed is the same as selected in search Hotel form
    And Location displayed in Select Hotel should be the same as location "Sydney" selected in search hotel form
    And Select the booking and click continue button

  @TC_115
  Scenario: To verify whether locations in Select Hotel page are displayed according to the location selected in Search Hotel
    Given Launch hotel reservation application using URL as in test data
    When Login to the application using username "Della2018" and password "emmu@26" as in test data
    And Select location "Sydney" as in test data
    And Select hotel "Hotel Creek" as in test data
    And Select room type "Standard" as in test data
    And Select no-of-rooms "2" as in test data
    And Enter check-in-date "20/11/2019" later than the checkout-date "21/11/2019" field as in test data
    And Select No-of-adults as in test data "1"
    And Click on Search button
    And Select the booking and click continue button
    Then Check whether all details are disabled
    And Fill the form and click on Book now button
    And Click on My itinerary button

  @TC_117
  Scenario: To verify whether locations in Select Hotel page are displayed according to the location selected in Search Hotel
    Given Launch hotel reservation application using URL as in test data
    When Login to the application using username "Della2018" and password "emmu@26" as in test data
    And Click on booked itinerary button
    And Enter the order id
    Then Verify that the relevant details are displayed
