@Web @Amazon
Feature: Create an Amazon account using gmail account
  As a user
  I want to create an Amazon account
  Using gmail account
  So, I can purchase goods

  Scenario: Login Using Gmail
    Given Amazon web site is opened
    When I click register on amazon
    And I input the required information
    Then Amazon ask me to enter OTP password
    When I access my gmail account
    And I enter the OTP from my gmail inbox
    Then I am successfully create new account using temporary email
