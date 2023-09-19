
   Feature: Login functionality
  
    Scenario Outline: Login with valid credentials
    Given User navigates to login page
    When User enters email "<username>"  into field
    Then User enters password "<passw3ord>" into field
    And User clicks on login button
    
    Then User should get successfully loggedin
      
    Examples: 
      |    username             | passw3ord | 
      |  rafiqueltaj@yahoo.com  | Raita9660 | 
      
      
	   
    Scenario Outline: Login with invalid credentials
    Given User navigates to login page
    When User enters invalidemail "<username>"  into field
    Then User enters password "<passw3ord>" into field
    And User clicks on login button
     Then User should get a proper warning message about credentials mismatch
    
      
    Examples: 
      |    username               | passw3ord | 
      |  rafiqueltaj@yahoo.com9   | Raita8888 | 
      |  rafiqueltaj@yahoo.com10  |Raita9090|
      
      
       
       
       
         
	     
      
      
      
      
      
      