"Notice that instead of Object, there is Account when initializing the subclass CheckingAccount, because CheckingAccount is a subclass of Account. This is how inheritance is shown in SmallTalk instead of extends like in java."

Account subclass: CheckingAccount[
  <comment: 
    'This class contains the constructor and methods for opening a virtual checking account. No accrue rate for a checking account.'>
  
  
  
  CheckingAccount class[
    new[
      ^super new 
    ]
  ]

  init:thisNumber Customer:thisCustomer Balance:thisBalance [
    number:= thisNumber.
    customer:= thisCustomer.
    balance:= thisBalance.
  ]

  accrue:rate[]

 ]