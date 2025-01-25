#language: en

  @Login @BugBank @Web
  Feature: Access login page
    Scenario: Access successful
      Given I access the Home Page
      When click in Register
      And enter the email "teste01@teste.com.br"
      And enter the name "Teste Da Silva"
      And enter the password "12345678"
      And confirm the password "12345678"
      And enable the account balance
      And create account
      Then I back to the login page