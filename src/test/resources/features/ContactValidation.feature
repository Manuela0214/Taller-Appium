# Created by ManuelaAC at 14/04/2025

Feature: Contact validation in mobile app
#
#  Scenario: Alphabetical listing of contacts
#    Given A user is on the main screen of the application
#    When user filter by Phone contacts
#    Then the list of contact appears ordenered by A-Z

  Scenario Outline: Create new contact
    Given A user is on the main screen of the application
    When user create a contact with name "<name>" and last name "<last_name>" and phone number "<phone_number>"
    Then the new contact appears in the contact list
    Examples:
      | name | last_name | phone_number |
      | Juan | Jose      | 55667788     |

  Scenario Outline:
    Given A user is on the main screen of the application
    When user select a contact and update last name to "<new_last_name>"
    Then the contact has the last name updated in the contact list
    Examples:
      | new_last_name |
      | David         |

  Scenario: Delete an existing contact
    Given A user is on the main screen of the application
    When user select a contact and select the delete option
    Then the contact is not present in the contact list