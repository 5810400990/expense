
Feature: Manage account
    As a user, I can add and view income and expense
    so that I know how much money I have.

Scenario: Spend money from pocket correct and Show my money pocket
    Given a user with 100 money in pocket
    When a user spend money with 50
    Then account will show money in pocket is 50 , expense money is 50 and income money is 0.

Scenario: Spend money from pocket incorrect
    Given a user with 100 money in pocket
    When a user spend money with 150
    Then account will show money in pocket is 100 , expense money is 0 and income money is 0.


Scenario: Receive money and Show money pocket
    Given a user with 100 money in pocket
    When a user receive money with 20
    Then account will show money in pocket is 120 , expense money is 0 and income money is 20.
