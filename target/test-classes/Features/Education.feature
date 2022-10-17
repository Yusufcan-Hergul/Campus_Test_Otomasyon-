Feature:

  Background:
    Given User successfully logged in as Admin
    And Navigate to Grade Level page

    Scenario: User should be able to new Subject Categories
      When User should be able to add Subject Categories
      Then Subject Categories should appear in the list

      Scenario: Edit
        When User should be able to edit Subject Categories
        Then position category should have changed

        Scenario: delete
          When User should be able to delete Subject Categories
          Then Delete message should be able to displayed successfully