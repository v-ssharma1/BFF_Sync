Feature: Validatin of status code for BFF and sync services. 
@Sanity @Regression @API @Test
Scenario: 
	validate the status code on successfully invoking  BFF and sync services. 

	Given the endpoint of BFF services 
	And  the endpoint of Sync services 
	When user invokes the BFF endPoint successfully 
	And user invokes the sync endPoint successfully 
	Then User should get status code as 200 for Sync service 
	And User should get status code as 200 for BFF service