@feature:searchProduct
Feature: Search for the product

  @positive
  Scenario Outline: Search test with available product
    When I call the get search test product endpoint <product>
    Then verify the search results of product should be displayed
    Examples:
      | product |
      | orange  |
      | apple   |
      | pasta   |
      | cola    |

  @negative
  Scenario: Search test with unavailable product car
    When I call the get search test product endpoint car
    Then verify not found error should be displayed in search results

  @negative
  Scenario: Search test without product
    When I call the get search test endpoint
    Then verify unauthorized error should be displayed in search result

