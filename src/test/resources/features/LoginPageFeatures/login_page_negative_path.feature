@e2e_tests
Feature: Negative path User login page validation

  @user_login_scenarios_negative
  Scenario Outline: Test the valid user name and passwords in the login page
    Given user navigates to Login Page
    And the user is able to see the title <PageName> in the Login page
    And user enters the <UserName> in the Username field
    And user enters the <Password> in the Password field
    When user clicks on the Submit button
    Then user is able to see the error message <Error_Message>

    Examples:
      | PageName   | UserName  | Password    | Error_Message             |
      | Test login | students  | Password123 | Your username is invalid! |
      | Test login | student££ | Password123 | Your username is invalid! |
      | Test login |           | Password123 | Your username is invalid! |
      | Test login | student   | Password12  | Your password is invalid! |
      | Test login | student   | Password12£ | Your password is invalid! |
      | Test login | student   |             | Your password is invalid! |
      | Test login |           |             | Your username is invalid! |


