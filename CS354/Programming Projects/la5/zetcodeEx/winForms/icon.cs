using System.Windows.Forms;
using System.Drawing;
using System;

public class MForm : Form
{
    public MForm()
    {
       Text = "Icon";
       Size = new Size(250, 200);

       try {
           Icon = new Icon("web.ico");
       } catch (Exception e) {
           Console.WriteLine(e.Message);
           Environment.Exit(1);
       }

       CenterToScreen();
    }

    static public void Main()
    {
       Application.Run(new MForm());
    }
}