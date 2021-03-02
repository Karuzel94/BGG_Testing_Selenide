@sortingTest
Feature: Sorting Games Collection in application

  @myRatingSorting
  Scenario: User tries to check the correctness of sorting in the application
    Given User enters username qwerty1234zz and password qwerty1234zz
    Then User goes to Collection and sort it by Names
    And User checks correctness of sorting