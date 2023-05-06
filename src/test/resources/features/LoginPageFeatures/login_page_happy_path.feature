@e2e_tests
Feature: Happy path User login page validation

  @user_login_scenarios_happy_path
  Scenario Outline: Test the valid user name and passwords in the login page
    Given user navigates to Login Page
    And the user is able to see the title <PageName> in the Login page
    And user enters the <UserName> in the Username field
    And user enters the <Password> in the Password field
    When user clicks on the Submit button
    Then user is able to see the Home page with text <HomePageText>

    Examples:
      | PageName   | UserName | Password    | HomePageText           |
      | Test login | student  | Password123 | Logged In Successfully |

