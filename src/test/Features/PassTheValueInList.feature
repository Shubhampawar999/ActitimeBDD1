    Feature: Pass the value in list
      Scenario: pass the value in list format
        Given Connectiing the url
          | firstName |
          | lastname  |
          | empId     |
          | City      |
      Scenario Outline: Pass the value in object form
        Given Pass value in object form
          | firstname   | lastname   | emp   |
          | <firstname> | <lastname> | <emp> |
        Examples:
          | firstname                      | lastname              | emp |
          | cyber ,success,technology      | success,cyber,shubham | 01  |
          | cyber ,success,technology,pune | success,cyber,shubham |     |
          | cyber  ,success ,tech          |                       | 03  |
          |                                | success,cyber,shubham | 04  |
          |                                |                       |     |