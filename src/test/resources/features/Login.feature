Feature: Login to the application

  @credentialsLogIn
  Scenario: Log in with credentials
    Given Log with defined credentials
    And User check if the correct user was logged in

  @regexLogIn
  Scenario: Log in with credentials "qwerty1234zz" and password "qwerty1234zz"
    Given Log in with credentials "qwerty1234zz" and "qwerty1234zz"
    Then Check if the user "qwerty1234zz" was logged in

  @negativeLogIn
  Scenario Outline: Log in with example credentials
    Given Log in with example <login> and <password>
    Then Check if there is an error

    Examples:
      | login        | password     |
      | qwerty1234za | qwerty1234za |
      | qwerty1234zi | qwerty1234zi |
      | qwerty1234zq | qwerty1234zq |
