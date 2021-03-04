@myRatingChanging
Feature: Giving/Changing MyRating for games

  @myRating
  Scenario: User tries to give or change his rating for random game in collection
    Given User enters credentials and log into application
    Then User goes to Collection
    Then User chooses random game from Collection
    Then User set his new rating for this game
    Then User goes to Collection
    Then User checks this game rating and go to the page of this game
    And User checks rating on Game Page and the count of stars