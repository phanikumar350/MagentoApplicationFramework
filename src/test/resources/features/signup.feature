Feature: Magento Account Creation

  As a new user
  I want to create an account on Magento
  So that I can log in and use the site features

  Scenario: User signs up with valid details
    When User lands in homepage
    When User provides the following details
      | First Name | Last Name | Email                         | Password     |
      | John       | Doe       | johndoe+<timestamp>@gmail.com | Password@123 |
    And submits the registration form
    Then A success message should be displayed indicating registration is complete "Thank you for registering with Main Website Store."
    Then Sign out
    When Signing using credentials
    Then user should be successfully logged in
