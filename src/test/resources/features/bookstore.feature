Feature: Online Bookstore Functionality
  As a user of Books to Scrape
  I want to browse and interact with books
  So that I can find and purchase books easily

  Scenario: CART-01 Add book to basket
    Given the homepage is loaded
    When I click "Add to basket" on the first available book
    Then the basket count should be 1

  Scenario: NAV-01 Navigate to Travel category
    Given the homepage is loaded
    When I click on "Travel" in the side menu
    Then the page header should be "Travel"
    And the URL should contain "/travel/"

  Scenario: PRICE-01 Catalog vs Detail price check
    Given the homepage is loaded
    When I note the price of the first book on the catalog
    And I click on the first book to open detail page
    Then the price on detail page should match the catalog price

  Scenario: SORT-01 Verify price range on category page
    Given I am on a category page with multiple books
    When I select "Price (high to low)" from the sort dropdown
    Then the first book should have the highest price

  Scenario: STOCK-01 Stock label validation
    Given I am on a product detail page
    Then the availability section should display "In stock"