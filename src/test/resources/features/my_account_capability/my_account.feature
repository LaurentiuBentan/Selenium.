Feature: my account feature
  #se ruleaza inainte de fiecare test
  Background:
    Given sign in: I am a user on sign in page
    When sign in: I log in with my valid credentials
    When my account: i get in my account

  @laurentiu
  Scenario Outline: open my account and verify error message for invalid credentials
    When my account: i provide first name <first name>
    When my account: i provide last name <last name>
    When my account: i provide phone number <phone number>
    Then my account: i verify all invalid messages

    Examples:
    |first name|last name|phone number|
    |!@#$.     | %^$#12  |  abcd@     |
    |Lau!      | bentan#$| 0751233213!|

  @laurentiu
  Scenario: verify valid account information and if they are updated
  When my account: i try with valid information
  When my account: i close my account page
  Then my account: i open again my account page and verify if the credentials are updated