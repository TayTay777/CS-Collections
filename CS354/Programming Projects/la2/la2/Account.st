Object subclass: Account [

  <comment: 
    'This class is the parent class for the Checking and Savings accounts. All the methods here are inherited by the Checking and Savings account.'>

  |number customer balance|

  accrue: rate [
    ^self subclassResponsibility
  ]

  balance [
    ^balance
  ]

  deposit: amount [
    balance:= balance+amount.
  ]

  withdraw: amount [
    balance:= balance-amount.
  ]

  toString [
    ^number,':',(customer toString),':',(balance asString).
  ]

]