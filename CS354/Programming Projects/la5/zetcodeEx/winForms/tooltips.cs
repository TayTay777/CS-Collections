using System;
using System.Drawing;
using System.Windows.Forms;

class MForm : Form {

    public MForm() {
        Text = "Tooltips";
        Size = new Size(250, 200);

        ToolTip btnTlp = new ToolTip();

        btnTlp.SetToolTip(this, "This is a Form");

        Button button = new Button();
        btnTlp.SetToolTip(button, "This is a Button Control");
        button.Text = "Button";
        button.Location = new Point(30, 70);
        button.Parent = this;

        CenterToScreen();
    }
}

class MApplication {
    static void Main() {
        Application.Run(new MForm());
    }
}