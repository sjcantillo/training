Feature: Solve the challenge Warchall: Live RFI
  From www.wechall.net
  With my username SYLAR

  Scenario: Try Failed
    Given a URL
    When I see the page I clicked on bottons to change the language
      And I see the same URL whith params
      And I inject to lang param solution.php
      And I see the next message <<Nothing Here ???>>
      And I check the html code
    Then I use php%3A%2F%2Ffilter%2Fread%3Dconvert.base64-encode%2Fresource
        And I use solution.php for resource
        And I decode the message
        But I don't solve the challenge

    Scenario: Succesful Solution
    Given a URL
    When I see the page I clicked on bottons to change the language
      And I see the same URL whith params
      And I research about data protocol
      And I make a simple php %3C%3Fphp%20system(%22ifconfig%22)%3F%3E
      And I use lang%3Ddata%3A%2F%2Ftext%2Fplain%2C
    Then  I see execution of ifconfig
        And I change Ifconfig for <<cat solution.php>>
        But check the html code
        Then I solve de challenge
