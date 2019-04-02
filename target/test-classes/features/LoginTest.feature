Feature: Login Test
As a test automation developer 
I try to login with valid credentials and
I try to login with invalid credentials

@validLogin
Scenario: Valid Login
		Given I am a user of amazon.com
		When I log in using valid credentials
		| userName   |   baris.gul@outlook.com.tr   | 
    | password |   DummyPassword025   | 
		Then I should be logged in
		Then I close browser			

@invalidLogin
Scenario: Invalid Login
		Given I am a user of amazon.com
		When I log in using invalid credentials
		| userName   |   baris.gul@outlook.com.tr   | 
    | password |   DummyPassword025123123   | 
		Then I should not be logged in
		Then I close browser		 