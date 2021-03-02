@myRatingChanging
Feature: Giving/Changing MyRating for games

  @myRating
  Scenario: User tries to give or change his rating for random game in collection
    Given User enters username qwerty1234zz and password qwerty1234zz
    Then User goes to collection and choose random game
    Then User give or change his rating for this game
    Then User goes to collection again, checks this game rating and go to the page of this game
    And User checks rating on Game Page and the count of stars