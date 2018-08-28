Cucumber is just tool.

Test: Check the login page with an invalid username and
password. Using this URL: http://intranet.sutrix.com/
 

Gherkin

The primary keywords are:

Feature
Example (Scenario and Scenario Outline are synonyms)
Given, When, Then, And, But (steps)
Background

Feature
The purpose of the Feature keyword is to provide a high-level
 description of a software feature, and to group related 
 scenarios.

Given
Given steps are used to describe the initial context of the 
system - the scene of the scenario. It is typically 
something that happened in the past.

When
When steps are used to describe an event, or an action. 
This can be a person interacting with the system, or it can
 be an event triggered by another system.

Then
Then steps are used to describe an expected outcome, or result.

And, But
If you have several Given’s, When’s, or Thens, you could 
write:
Example: Multiple Givens
  Given one thing
  Given another thing
  Given yet another thing
  When I open my eyes
  Then I should see something
  Then I shouldn't see something else
  
  
  
  
Or, you could make it read more fluidly by writing:

Example: Multiple Givens
  Given one thing
  And another thing
  And yet another thing
  When I open my eyes
  Then I should see something
  But I shouldn't see something else
  
Background
Occasionally you’ll find yourself repeating the same Given 
steps in all of the scenarios in a feature.









Data Tables
Data Tables are handy for passing a list of values to a 
step definition:

Given the following users exist:
  | name   | email              | twitter         |
  | Aslak  | aslak@cucumber.io  | @aslak_hellesoy |
  | Julien | julien@cucumber.io | @jbpros         |
  | Matt   | matt@cucumber.io   | @mattwynne      |
  
  
  
  
  
  
  
  
  
  
Scenario Outline
The Scenario Outline keyword can be used to run the same 
Scenario multiple times, with different combinations of values.
Scenario Outline: eating
  Given there are <start> cucumbers
  When I eat <eat> cucumbers
  Then I should have <left> cucumbers

  Examples:
    | start | eat | left |
    |    12 |   5 |    7 |
    |    20 |   5 |   15 |