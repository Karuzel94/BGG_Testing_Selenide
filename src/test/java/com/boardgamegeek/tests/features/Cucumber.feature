Feature: Login to Application


  Scenario: Default login on Homepage
    Given User is on Homepage
    When User log in with username and password
    Then Homepage will reload to logged version
    And User Button is displayed