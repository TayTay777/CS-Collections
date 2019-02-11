using System;
using System.Drawing;
using System.Windows.Forms;

class MForm : Form {


    public MForm() {
        Text = "Anchor";
        Size = new Size(210, 210);

        Button btn1 = new Button();
        btn1.Text = "Button";
        btn1.Parent = this;
        btn1.Location = new Point(30, 30);

        Button btn2 = new Button();
        btn2.Text = "Button2";
        btn2.Parent = this;
        btn2.Location = new Point(30, 80);
        btn2.Anchor = AnchorStyles.Left | AnchorStyles.Right;

        CenterToScreen();
    }
}


class MApplication {
    public static void Main() {
        MForm mf = new MForm();
        Application.Run(mf);
    }
}
