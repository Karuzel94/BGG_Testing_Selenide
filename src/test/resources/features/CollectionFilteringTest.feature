@filteringTest
Feature: Filtering Collection in application

  @myRatingFiltering
  Scenario: User filters the collection using the ratings given to the games
    Given User enters username qwerty1234zz and password qwerty1234zz
    Then User goes to Collection, enters minimum and maximum rating to filters section
    And User checks if the filtered games ratings are between minimum and maximum rating