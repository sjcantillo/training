# language: en

Feature: LAMP Security CTF4
  From site root-me
  From CTF All the day category
  With my username jaguir11

  Background:
    Given the fact that I am registered in site root-me
    And I have Windows 7 Operating System
    And I have a kali VM

  Scenario: First failed attempt
    Given a host name
    When I run nmap
    And I see port 80 open
    And I find robots.txt
    And I see a /restricted/ which looks really interesting
    And I try to access it
    But I get a 401 and a prompt for HTTP Basic Authentication
    Then I decide to try and bypass it

  Scenario: Second failed attempt
    Given a link with HTTP Basic Auth
    And dictionary with maximum 5 letter words created with crunch
    When I try a brute force attack
    And I get nothing
    Then I decide to try something else

  Scenario: Third failed attempt
    Given a host name
    And the output to the nikto command
    When I see an interesting url to admin/login.php
    And I try a basic sql injection
    And log in successfully
    And I see a function to post a blog entry
    And I post a js script
    And I see the xss I injected
	And I try to then inject some php so that the server can execute it
    But I do not succeed
    Then I decide to see what else that injection can give me

  Scenario: Fourth failed attempt
    Given a host name
    And an sql injection which was found at the admin/login.php
    When I sqlmap on the target
    And I am able to obtain the current db
    And all the tables with their columns
    And a complete list of users with their passwords hashes
    And I run sqlmap once again to brute force the password hashes
    And I get a complete list of users and passwords in plain text
    And I get the current user of the db which is root
    When I try to get a shell with sqlmap --os-shell
    But I notice the current user does not have write privileges
    Then I decide to try something else

  Scenario: Fifth failed attempt
    Given a host name
    And an sql injection which gave me a list of users and their passwords
    And the nmap output which tells me port 22 is open
    When I try to connect to the server though ssh
    And I used the webmasters account to log in
    And I log in successfully
    And I try to get the passwd flag file at /root
    And I get permission denied with the current user
    But I see the users has a new email waiting
    And I decide to quickly read through them
    And I see an email from the sys admin
    And I realize I have his credentials in the list obtained from sqlmap
    Then I decide to log in with that account

  Scenario: Successful solution
    Given a host name
    And an sql injection which gave me a list of users and their passwords
    And an email which allowed me to know who the sys admin is
    When I log in with the sys admin account
    And I try to cat the passwd file
    And I see the flag
    Then I solve challenge
