

Object subclass: Bank [
  
  <comment: 
    'This is the class that stores checking and savings accounts'>
    
  |accounts|

  Bank class[
    new[
      ^super new init
    ]
  ]

  init [
    accounts:= Set new
  ]

  add: account [
    accounts add: account
  ]

  accrue: rate [
    accounts do: [:account| account accrue:rate]
  ]

  toString[
    |r| r:=''.
    accounts do:[:account|r:=r, (account toString), (Character nl asString)].
    ^r.
  ]
]

|bank| bank:= Bank new.

"COMMENT: add a name in the below line."
|customer| customer :=Customer new init: 'Taylor'.

"COMMENT: CHECKING: add account number, customer object (created above), and a balance."
|checking| checking :=CheckingAccount new init: '00001' Customer:customer Balance:1000000000.00.

"COMMENT: SAVINGS: add account number, customer object (created above), and a balance."
|savings| savings :=SavingsAccount new init: '00002' Customer:customer Balance:1000000000.00.
"adds checking and saving accounts to the bank class."
bank add: checking.
bank add: savings.

"COMMENT: set the accrue rate for the savings account."
bank accrue: 0.05.


"COMMENT: values to withdraw and deposit below. Uncomment to allow code to run."
"checking deposit: 100000000"
checking withdraw: 200.
"savings withdraw: 0"
savings deposit: 200.
(bank toString) display