using System;
using System.Drawing;
using System.Windows.Forms;

/*
*Class that adds features to the Windows.Forms.Button class
*/



// ':' character represents the extends option
// simularly java uses "extends" for inheriting methods
class ToggleButton : Button {

  string togOne;
  string togTwo;

  
  
public ToggleButton ( string toggleOne, string toggleTwo){

  //base.ToggleButton(togOne);
  togOne = toggleOne;
  togTwo = toggleTwo;
  //Text is a Button class variable
  Text = togOne;
  togOne = toggleOne;
  togTwo = toggleTwo;
  //Button button = new Button();
  //button.Text = togOne;

}


public void toggleOnOff(){
  
  string s = togOne;
  togOne = togTwo;
  togTwo = s;
  //Text is a Button class variable
  Text = togOne;


}

}




