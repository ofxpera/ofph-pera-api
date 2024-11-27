Feature: Customer Details Retrieval
  As a PERA Administrator or Financial Institution
  I want to retrieve detailed customer information
  So that I can provide PERA-related services

  Background:
    Given a valid access token with "customer_details" scope
    And a valid mTLS certificate for secure communication
    And customer consent has been granted

  Scenario: Successfully Retrieve Complete Customer Details
    Given a customer with ID "cust_123" exists in the system
    When a GET request is sent to "/common/customer/cust_123/detail"
    Then the response status code should be 200
    And the response should contain complete customer information:
      | Field               | Value                  |
      | customerId          | cust_123               |
      | firstName           | Juan                   |
      | lastName            | Dela Cruz              |
      | dateOfBirth         | 1990-01-15             |
      | nationality         | Filipino               |
      | residencyStatus     | Resident               |
      | taxStatus           | Regular                |
      | employmentStatus    | Employed               |
      | occupation          | Software Engineer      |
      | tin                 | 123-456-789-000        |

  Scenario: Retrieve Customer Details with Multiple PERA Accounts
    Given a customer with ID "cust_456" has multiple PERA accounts
    When a GET request is sent to "/common/customer/cust_456/detail"
    Then the response status code should be 200
    And the response should contain customer information
    And the response should include a list of PERA accounts:
      | Account Number | Institution    | Status  | Balance  | Opening Date |
      | PERA-001      | Sample Bank    | Active  | 100000   | 2023-01-15  |
      | PERA-002      | Another Bank   | Active  | 250000   | 2023-06-30  |

  Scenario: Retrieve Customer Details with Contact Information
    Given a customer with ID "cust_789" exists
    When a GET request is sent to "/common/customer/cust_789/detail"
    Then the response status code should be 200
    And the response should contain contact details:
      | Field           | Value                    |
      | emailAddress    | juan.cruz@email.com      |
      | mobileNumber    | +63-912-345-6789         |
      | address         | 123 Sample St, Manila    |
      | postalCode      | 1234                     |
      | country         | Philippines              |

  Scenario: Retrieve Customer Details with Investment Profile
    Given a customer with ID "cust_101" has investment profile
    When a GET request is sent to "/common/customer/cust_101/detail"
    Then the response status code should be 200
    And the response should contain investment profile:
      | Field                  | Value            |
      | riskTolerance          | Moderate         |
      | investmentHorizon      | Long Term        |
      | investmentObjective    | Retirement       |
      | sourceOfFunds          | Employment       |
      | monthlyIncome          | 50000-100000     |

  Scenario: Retrieve Customer Details with Beneficiary Information
    Given a customer with ID "cust_202" has registered beneficiaries
    When a GET request is sent to "/common/customer/cust_202/detail"
    Then the response status code should be 200
    And the response should contain beneficiary information:
      | Name          | Relationship | Share | Contact Number  |
      | Maria Cruz    | Spouse       | 60%   | +63912345678    |
      | Juan Cruz Jr  | Child        | 40%   | +63923456789    |

  Scenario: Customer Not Found
    Given a customer with ID "invalid_cust" does not exist
    When a GET request is sent to "/common/customer/invalid_cust/detail"
    Then the response status code should be 404
    And the response should contain error details:
      | Field     | Value                        |
      | code      | CUSTOMER_NOT_FOUND           |
      | message   | Customer details not found   |

  Scenario: Retrieve Customer Details with Insufficient Scope
    Given an access token without "customer_details" scope
    When a GET request is sent to "/common/customer/cust_123/detail"
    Then the response status code should be 403
    And the response should contain error details:
      | Field     | Value                           |
      | code      | INSUFFICIENT_SCOPE              |
      | message   | Missing required scope          |

  Scenario: Retrieve Customer Details without Consent
    Given customer consent has been revoked for ID "cust_303"
    When a GET request is sent to "/common/customer/cust_303/detail"
    Then the response status code should be 403
    And the response should contain error details:
      | Field     | Value                           |
      | code      | CONSENT_NOT_GRANTED             |
      | message   | Customer consent not available  |

  Scenario: Retrieve Customer Details with Specific Fields
    Given a customer with ID "cust_404" exists
    When a GET request is sent to "/common/customer/cust_404/detail?fields=personalInfo,contactInfo"
    Then the response status code should be 200
    And the response should only contain requested fields:
      | Category      | Fields                          |
      | personalInfo  | firstName,lastName,dateOfBirth  |
      | contactInfo   | emailAddress,mobileNumber       |
