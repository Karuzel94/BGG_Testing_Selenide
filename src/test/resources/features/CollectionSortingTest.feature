@sortingTest
Feature: Sorting Games Collection in application

  @myRatingSorting
  Scenario: User tries to check the correctness of sorting in the application
    Given User enters credentials and log into application
    Then User goes to Collection
    Then User sort collection by Titles in ascending order
    And User checks correctness of sorting