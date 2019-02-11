Object subclass: Customer [
  <comment:
    'This class stores a name for a checking and/or savings account.'>
  
  
  |name|

  Customer class [
    new[
      ^super new 
    ]
  ]

  init: thisName [
    name:= thisName.
  ]

  toString [
    ^name
  ]
]

