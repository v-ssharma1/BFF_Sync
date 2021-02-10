Feature: Customer information validation 
@Regression @API @Test 
Scenario: Validate the customer information associated with the searched PNR 
	Given the endpoint of BFF services 
	And  the endpoint of Sync services 
	When user invokes the BFF endPoint successfully 
	And user invokes the sync endPoint successfully 
	Then User should be able to validate the BFF value of Customer's FirstName against sync 
	And User should be able to validate the BFF value of Customer's LastName against sync 
	
@Regression @API @Test 
Scenario: Validate the customer information associated with the searched PNR 
	Given the endpoint of BFF services 
	And  the endpoint of Sync services 
	When user invokes the BFF endPoint successfully 
	And user invokes the sync endPoint successfully 
	Then User should be able to validate the BFF value of Customer's DOB against sync 
	
@Regression @API @Test 
Scenario: Validate the customer information associated with the searched PNR 
	Given the endpoint of BFF services 
	And  the endpoint of Sync services 
	When user invokes the BFF endPoint successfully 
	And user invokes the sync endPoint successfully 
	Then User should be able to validate the BFF value of Customer's Type against sync 