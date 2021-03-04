@languageDependenceComparing
Feature: Comparing language dependence of random chose game

  @languageDependence
  Scenario: User tries to chose random game to compare language dependence with information in Xml API
    Given User enters credentials and log into application
    Then User goes to ALl Boardgames page
    Then User chooses random game
    And User compares language dependencies between game page and XmlApi