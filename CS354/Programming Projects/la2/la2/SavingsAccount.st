"Notice that instead of Object, there is Account. This is how inheritance is shown in SmallTalk."

Account subclass: SavingsAccount [
     
     <comment:
      'This class contains the constructor and methods for opening a virtual savings account and the logic for accrue rate.'>
     
     |interest|
     
     
  SavingsAccount class [
      new [
	^super new 
    ]
  ]

  init:thisNumber Customer:thisCustomer Balance:thisBalance [
    number:= thisNumber.
    customer:= thisCustomer.
    balance:= thisBalance.
    interest:=0.
  ]

  accrue:rate [
    balance:= balance+(balance*rate).
    interest:= interest+(balance*rate).
  ]
  
]