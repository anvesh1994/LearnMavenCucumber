Feature: Red bus ticket reservation

  Scenario: Verify the landing page of redbus home page
  	Given i am on Redbus Site
  	When i am on "RedBusTickets" page
  	When i enter "Bangalore" in "Source" field
  	And i select "Bangalore (All Locations)" from the dropdown
  	When i enter "Hyderabad" in "Destination" field
  	And i select "Hyderabad (All Locations)" from the dropdown
  	And i enter "14-Jun-2021" in "OnWardDate" field
  	And i click "SearchBuses" button on "RedBusHome" page
  	And i click "ViewSeats" button on "ViewSeats" page