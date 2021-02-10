Feature: Farerule Validation. 
@Regression @API @Test
Scenario: validate the value of farerule of /BFF API from /sync API 
	Given the endpoint of BFF services 
	And  the endpoint of Sync services 
	When user invokes the BFF endPoint successfully 
	And user invokes the sync endPoint successfully 
	Then User should get the farerule string from /Sync service 
	And User should get the farerule string from /BFF service 
	And User should get the same value of string returned by /BFF and /Sync APIs