Feature: As a zeus user
  I need to have a login functionality to be able to access all the operations of the application

  Background:
    Given user is in apps zeus

  @UserStory=2800901
  Scenario Outline: Create successful login app zeus
    When the user fills out the registration form name  <name>  mail <mail>  pass  <pass>
    Then should see zeus logo
    Examples:
      |name  |mail                 |pass        |
      |ANDRES|ANDRO11ANTO@GMAIL.COM|121212121212|

  @UserStory=2800901
  Scenario: Create starter app with incomplete fields
    When the user logs in without filling in fields
    Then should see a message "Debe llenar todos los campos."

  @UserStory=2800901
  Scenario Outline: Create a launcher application with a password field of less than 10 characters
    When the user fills out the registration form name  <name>  mail <mail>  pass  <pass>
    Then should see a message "El password debe tener minimo 10 caracteres."
    Examples:
      |name  |mail                 |pass|
      |ANDRES|ANDRO11ANTO@GMAIL.COM|121 |

  @UserStory=2800901
  Scenario Outline: Create an app launcher with an incorrect mail field
    When the user fills out the registration form name  <name>  mail <mail>  pass  <pass>
    Then should see a message "Email no valido."
    Examples:
      |name  |mail       |pass|
      |ANDRES|ANDRO11ANTO|121 |

