using System;
using System.Drawing;
using System.Windows.Forms;

class MForm : Form {

    private int WIDTH = 250;
    private int HEIGHT = 150;
    private int BUTTONS_SPACE = 15;
    private int PANEL_SPACE = 8;
    private int CLOSE_SPACE = 10;

    public MForm() {
        Text = "Anchor";
        Size = new Size(WIDTH, HEIGHT);

        Button ok = new Button();

        int PANEL_HEIGHT = ok.Height + PANEL_SPACE;

        Panel panel = new Panel();
        panel.Height = PANEL_HEIGHT;
        panel.Dock = DockStyle.Bottom;
        panel.Parent = this;     

        int x = ok.Width * 2 + BUTTONS_SPACE;
        int y = (PANEL_HEIGHT - ok.Height) / 2;

        ok.Text = "Ok";
        ok.Parent = panel;
        ok.Location = new Point(WIDTH-x, y);
        ok.Anchor = AnchorStyles.Right;

        Button close = new Button();
  
        x = close.Width;

        close.Text = "Close";
        close.Parent = panel;
        close.Location = new Point(WIDTH-x-CLOSE_SPACE, y);
        close.Anchor = AnchorStyles.Right;

        CenterToScreen();
    }
}


class MApplication {
    public static void Main() {
        Application.Run(new MForm());
    }
}