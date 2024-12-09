Feature:To validate the account creation of fb application

Scenario:To create new account
Given To launch the browser and maximise the window
When To launch url of fb application
And To click the create new account button
#one dimensional map data
And  To pass firstname in firstname text box
 #key       value
|firstname1|Monisha|
|firstname2|Sharva|
|firstnama3|Sivani|
|firstname4|keertiga|
| 
 
 
  
And To pass secondname in secondname text box
#Two dimensional map data
And To pass mobileno or email in email text 
|password1|password2|password3|
|9095909354|bhfkjj5|bhbhbhb@mk|
|265655|jnjhnhhn|@!hjh25252|
|256565|jhfddddf|$@14,jbhhn|
|478+65|kgreddf|@$jh145445|

And To create new password using new password text box
Then To close the chrome browser
