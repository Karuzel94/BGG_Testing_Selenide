@logIn
Feature: Login to the application

  @credentialsLogIn
  Scenario: User tries to log in to the application
    Given User enters username qwerty1234zz and password qwerty1234zz
    And User checks if he is currently logged in

  @regexLogIn
  Scenario: User tries to log in to the application
    Given User enters username "qwerty1234zz" and password "qwerty1234zz"
    Then User checks if he, "qwerty1234zz", is currently logged in

  @negativeLogIn
  Scenario Outline: User tries to log in to the application
    Given User enters an invalid username <login> and password <password>
    Then User checks if he receives an error

    Examples:
      | login        | password     |
      | qwerty1234za | qwerty1234za |
      | qwerty1234zi | qwerty1234zi |
      | qwerty1234zq | qwerty1234zq |
