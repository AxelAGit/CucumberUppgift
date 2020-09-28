Feature: UserCreation 
	As a User
I want to be able to create an account with valid information
and get error messages when my information is invalid
So that I can log in and use the site

Background: Open website and accept cookies 
	Given I have navigated to the create user page 
	And I have accepted the cookies 
	
@validUser 
Scenario Outline: Create a user with valid and invalid credentials 
	Given I have entered a email <email> 
	And I have entered a username <username> 
	And I have entered a password <password> 
	And I have entered a password in the repeat password box <repeatPassword> 
	When I press register user 
	Then The result should be <login>   


	Examples: 
		|email								|username	|password	|repeatPassword				|login							|
		|"@sharklasers.com"					|"16"		|"password"	|"password"					|"https://forumet.vimla.se/"	|
		|"@sharklasers.com"					|"17"		|"password"	|"password"					|"longUsernameError"			|
		|"@sharklasers.com"					|"16"		|"password"	|"passwordMismatch"			|"passwordMismatchError"		|
		|"thisEmailIsInUse@sharklasers.com"	|"16"		|"password"	|"password"					|"emailInUseError"				|
		
		
