@languageDependenceComparing
Feature: Comparing language dependence of random chose game

  @languageDependence
  Scenario: User tries to chose random game to compare language dependence with information in Xml API
    Given User enters username qwerty1234zz and password qwerty1234zz
    Then User goes to ALl Boardgames page
    Then User choose random game and compare dependencies from XmlApi and Game Page