Feature: Login functionality of salesforce Application

Scenario: Login with positive credentials

Given Launch the browser 
Given load the url

When Enter Username
When Enter password
When click on login
And Click on toggle menu 
And Click view All
And click Sales from App Launcher
And Click on Accounts tab
And Click on New button
And Enter 'sai vasavi' as account name 
And Select Ownership 
And Click save
Then verify Account name   
    
