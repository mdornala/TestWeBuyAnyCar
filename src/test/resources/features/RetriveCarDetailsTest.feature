Feature: Get my car valuation

  @smoke
  Scenario Outline: Verify users can get a car valuation
    Given Load the base url
    When User provides <input_file> as car details for search
    Then System verify the car valuations with <output_file>
    Examples:
    |input_file|output_file|
    | car_input_1.txt  |car_output_1.txt  |
