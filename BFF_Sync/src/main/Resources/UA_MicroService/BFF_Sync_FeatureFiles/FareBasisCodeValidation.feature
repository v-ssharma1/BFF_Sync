Feature: Validation of fare bsic code in the given Farerule string. 
@Regression @API @Test 
Scenario: Validate the number of farebasis codes in /BFF API from /sync API 
	Given the endpoint of BFF services 
	And  the endpoint of Sync services 
	When user invokes the BFF endPoint successfully 
	And user invokes the sync endPoint successfully 
	Then User should get the farerule string from /Sync service 
	And User should get same number of farebasis code in /BFF as provided by /Sync service 
	
@Regression @API @Test 
Scenario: Validate the value of farebasis codes of /BFF API from /sync API 
	Given the endpoint of BFF services 
	And  the endpoint of Sync services 
	When user invokes the BFF endPoint successfully 
	And user invokes the sync endPoint successfully 
	Then User should get the farerule string from /Sync service 
	And User should get same farebasis code in /BFF as provided by /Sync service