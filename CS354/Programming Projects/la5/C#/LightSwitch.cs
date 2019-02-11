using System;
using System.Drawing;
using System.Windows.Forms;

/*
*
*Class that extends Windows.Forms.Form class
*
*
*/




class LightSwitch : Form {


  BinaryCounter biCount;
  ToggleButton togButton;


  public LightSwitch() {
    //Things like "Text" and "Size" below are refering to the Form class 
    //itself. In other words Form class variables
    Text = "Button";
    Size = new Size(250,200);
    
    biCount = new BinaryCounter(0);
    togButton = new ToggleButton("off", "on");
    
    int PANEL_HEIGHT = togButton.Height + 8;
    
    //panel is for the square that the two objects,
    //togButton and biCount, will lay on.
    Panel panel = new Panel();
    panel.Height = PANEL_HEIGHT;
    panel.Dock = DockStyle.Top;
    //"this" is refering to the Form
    panel.Parent = this;
    
    int x = togButton.Width * 2 + 15;
    int y = (PANEL_HEIGHT - togButton.Height) / 2;
    
    //".Parent" tells togButton where to lay
    togButton.Parent = panel;
    togButton.Location = new Point(Width - x - (togButton.Width/2), y);
    //".Anchor" allows several places for the object to be. 
    //for example Top, Bottom, Right, etc.
    //you can even combine them. 
    togButton.Anchor = AnchorStyles.Top;
    
      
    biCount.Parent = panel;
    biCount.Location = new Point(x - 5 - (togButton.Width/2), y);
    biCount.Anchor = AnchorStyles.Top;
  
    //every time a "click" happens, the methods within
    //OnClick are enacted
    togButton.Click += new EventHandler(OnClick);
  
    //centers the window to the center of the console
    CenterToScreen();
    
    }
    
    //mentioned in README after ## Running the tests header  
    //method for calling Button and TextBox methods upon a click
    void OnClick(object sender, EventArgs e) {
      biCount.plusOne();
      togButton.toggleOnOff();
    }
  }


//main class for running the program
class MApplication {
    public static void Main() {
        Application.Run(new LightSwitch());
    }
}



