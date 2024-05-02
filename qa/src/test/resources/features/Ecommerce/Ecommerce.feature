#language: en

	@EcommerceTest
	Feature: Log in to Swag Labs and run all the test scenarios
		
		#standard_user#
		@Scenario01
		Scenario: Logging in to the Marketplace and completing some purchases
			Given I log in to the website
			|UserLogin		|Password			|
			|standard_user|secret_sauce	|
			When I add the products to the cart
			|Sauce Labs Backpack			|29.99|
			|Sauce Labs Fleece Jacket	|49.99|
			|Sauce Labs Onesie				|7.99|
			And fill in the address correctly
			|Nome	|UltNome|Cep			|
			|Alex |Ramos	|65026010	|
			Then my purchases should be made
		
		#locked_out_user#	
		@Scenario02
		Scenario: Validate locked user
			Given I enter the incorrect user
			|UserLogin			|Password			|
			|locked_out_user|secret_sauce	|
			Then the system should show me a alert message
			|Epic sadface: Sorry, this user has been locked out.|
			
		#problem_user#	
		@Scenario03
		Scenario: Validate existing problems on the Marketplace
			Given I enter the problem user
			|UserLogin		|Password			|
			|problem_user|secret_sauce	|
			Then I validate the problema on the list
			
		#problem_user#	
		@Scenario03_1
		Scenario: validate whether the purchase its correct
			Given I enter using a problem user
			|UserLogin		|Password			|
			|problem_user|secret_sauce	|
			Then I must validate which button Add to cart is working
			|Sauce Labs Backpack							|
			|Sauce Labs Bike Light						|
			|Sauce Labs Bolt T-Shirt					| 
			|Sauce Labs Fleece Jacket					|
			|Sauce Labs Onesie								|
			|Test.allTheThings() T-Shirt (Red)|
			
		#problem_user#	
		@Scenario03_2
		Scenario: validate whether the purchase its correct
			Given I do login using a problem user
			|UserLogin		|Password			|
			|problem_user|secret_sauce	|			
			When I add some products to the cart
			|Sauce Labs Backpack		|29.99|
			|Sauce Labs Bike Light	|9.99	|			
			Then in my list of products click on my purchase and validate my purchase whether its correct or not
			
		#problem_user#	
		@Scenario03_3
		Scenario: Validate to fill my infos on checkout
			Given I work using a problem user
			|UserLogin		|Password			|
			|problem_user|secret_sauce	|
			When I add a product to the cart
			|Sauce Labs Backpack		|29.99|			
			Then at the checkout the system doesnt allow I fill my infos			
			|Nome	|UltNome|Cep			|
			|Alex |Ramos	|65026010	|			
			
			
		#performance_glitch_user#	
		@Scenario04
		Scenario: Validate how long it takes to log in to the Marketplace
			Given I enter using performance_glitch_user
			|UserLogin							|Password			|
			|performance_glitch_user|secret_sauce	|
			Then I have to validate how long it took to login
			
		#performance_glitch_user#	
		@Scenario04_1
		Scenario: Validate how long it takes to cancel a purchase
			Given I make a purchase using performance_glitch_user
			|UserLogin							|Password			|
			|performance_glitch_user|secret_sauce	|
			When I choose some products to the cart
			|Sauce Labs Backpack			|29.99|
			|Sauce Labs Fleece Jacket	|49.99|
			|Sauce Labs Onesie				|7.99|
			And fill my infos correctly
			|Nome	|UltNome|Cep			|
			|Alex |Ramos	|65026010	|
			Then I click on button Cancel and validate how long time it took
			
			
		#performance_glitch_user#	
		@Scenario04_2
		Scenario: Validate how long it takes after click Continue to Shopping
			Given I going to use performance_glitch_user
			|UserLogin							|Password			|
			|performance_glitch_user|secret_sauce	|
			When I add my wish products to the cart
			|Sauce Labs Backpack			|29.99|
			|Sauce Labs Fleece Jacket	|49.99|
			|Sauce Labs Onesie				|7.99|
			Then I click on button Continue to Shopping and validate how long time it took			
			
			
		#performance_glitch_user#	
		@Scenario04_3
		Scenario: Validate how long it takes to back Home after a purchase
			Given I want to make a purchase using performance_glitch_user
			|UserLogin							|Password			|
			|performance_glitch_user|secret_sauce	|
			When I add products to the cart
			|Sauce Labs Backpack			|29.99|
			|Sauce Labs Fleece Jacket	|49.99|
			|Sauce Labs Onesie				|7.99|
			And fill my the infos correctly
			|Nome	|UltNome|Cep			|
			|Alex |Ramos	|65026010	|
			Then I click on button Back Home and validate how long time it took	
			
			
		#error_user#
		@Scenario05
		Scenario: Validate the button Finish
			Given I want to make a purchase using error_user 
			|UserLogin	|Password			|
			|error_user	|secret_sauce	|
			When I put my products to the cart
			|Sauce Labs Backpack	|29.99|
			|Sauce Labs Bike Light|9.99	|
			And fill in the address
			|Nome	|UltNome|Cep			|
			|Alex |Ramos	|65026010	|
			

		#error_user#
		@Scenario05_01
		Scenario: Validate inputs checkout
			Given I make a purchase using error_user 
			|UserLogin	|Password			|
			|error_user	|secret_sauce	|
			When I choose products to the cart
			|Sauce Labs Backpack	|29.99|
			|Sauce Labs Bike Light|9.99	|
			And try to fill in the address
			|Nome	|UltNome|Cep			|
			|Alex |Ramos	|65026010	|
			Then the system should allow me fill all inputs	
			
			
		#visual_user#
		@Scenario06
		Scenario: Validate the elements in their correct coordinates
			Given I make a log in using visual_user
			|UserLogin	|Password			|
			|visual_user|secret_sauce	|
			Then I should validate that the images are correct
			|Sauce Labs Backpack							|/static/media/sauce-backpack-1200x1500.0a0b85a3.jpg| 
			|Sauce Labs Bike Light						|/static/media/bike-light-1200x1500.37c843b0.jpg		|
			|Sauce Labs Bolt T-Shirt					|/static/media/bolt-shirt-1200x1500.c2599ac5.jpg		| 
			|Sauce Labs Fleece Jacket					|/static/media/sauce-pullover-1200x1500.51d7ffaf.jpg|
			|Sauce Labs Onesie								|/static/media/red-onesie-1200x1500.2ec615b2.jpg		|
			|Test.allTheThings() T-Shirt (Red)|/static/media/red-tatt-1200x1500.30dadef4.jpg			|
			
		
		#visual_user#
		@Scenario06_1
		Scenario: Validate that cart its correct position
			Given I log in using visual_user
			|UserLogin	|Password			|
			|visual_user|secret_sauce	|
			Then I should validate that the cart are correct position

		
		#visual_user#
		@Scenario06_2
		Scenario: Validate that checkout button its in correct position
			Given I login using visual_user
			|UserLogin	|Password			|
			|visual_user|secret_sauce	|
			When I put a product to the cart
			|Sauce Labs Backpack			|29.99|
			Then I should validate that the checkout button are in correct position		