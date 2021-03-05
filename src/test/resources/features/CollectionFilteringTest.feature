@filteringTest
Feature: Filtering Collection in application

  @myRatingFiltering
  Scenario: User filters the collection using the ratings given to the games
    Given User enters credentials and log into application
    Then User goes to Collection
    Then User enters minimum and maximum rating to filters section and checks if the filtered games ratings are between minimum and maximum rating