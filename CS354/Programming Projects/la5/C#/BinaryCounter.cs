using System;
using System.Drawing;
using System.Windows.Forms;

/*
*Class that adds features to the Windows.Forms.TextBox class
*/

// ':' character represents the extends option
// simularly java uses "extends" for inheriting methods
class BinaryCounter : TextBox {

  int counter;
  
  public BinaryCounter(int count){
    counter = count;
    //Text is a TextBox class variable
    Text = Convert.ToString(counter, 2);
  }


  public void plusOne(){
    counter = ++counter;
    //Text is a TextBox class variable
    Text = Convert.ToString(counter, 2);
  } 
}