Feature: Hear Shout

  These features are about the listeners perspective.

  Shawn is the shouter.
  Linda is the listener.

  Scenario: Sounds of Silence
    When Shawn is quiet
    Then Linda should hear nothing

  Scenario: Too far away
    Given Linda is too far from Shawn
    When Shawn shouts "Hello"
    Then Linda should hear nothing

  Scenario: Close enough
    Given Linda is close enough from Shawn
    When Shawn shouts "Hello"
    Then Linda should hear "Hello"

