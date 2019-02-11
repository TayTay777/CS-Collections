using System;
using System.Drawing;
using System.Windows.Forms;

class MForm : Form {


    public MForm() {
        Text = "Player";
        Size = new Size(350, 280);

        MainMenu mainMenu = new MainMenu();
        //MenuItem file = mainMenu.MenuItems.Add("&File");
        //MenuItem playm = mainMenu.MenuItems.Add("&Play");
        //MenuItem view = mainMenu.MenuItems.Add("&View");

        //MenuItem tools = mainMenu.MenuItems.Add("&Tools");
        //MenuItem favourites = mainMenu.MenuItems.Add("&Favourites");
        //MenuItem help = mainMenu.MenuItems.Add("&Help");
        //file.MenuItems.Add(new MenuItem("E&xit",
                 //new EventHandler(this.OnExit), Shortcut.CtrlX));

        Menu = mainMenu;

        Panel panel = new Panel();
        panel.Parent = this;
        panel.BackColor = Color.Black;
        panel.Dock = DockStyle.Fill;
        
        Panel buttonPanel = new Panel();
        buttonPanel.Parent = this;
        buttonPanel.Height = 40;
        buttonPanel.Dock = DockStyle.Bottom;

        Button pause = new Button();
        pause.FlatStyle = FlatStyle.Popup;
        pause.Parent = buttonPanel;
        pause.Location = new Point(5, 10);
        pause.Size = new Size(25, 25);
        //pause.Image = new Bitmap("pause.png");

        Button play = new Button();
        play.FlatStyle = FlatStyle.Popup;
        play.Parent = buttonPanel;
        play.Location = new Point(35, 10);
        play.Size = new Size(25, 25);
        //play.Image = new Bitmap("play.png");

        Button forward  = new Button();
        forward.FlatStyle = FlatStyle.Popup;
        forward.Parent = buttonPanel;
        forward.Location = new Point(80, 10);
        forward.Size = new Size(25, 25);
        //forward.Image = new Bitmap("forward.png");

        Button backward  = new Button();
        backward.FlatStyle = FlatStyle.Popup;
        backward.Parent = buttonPanel;
        backward.Location = new Point(110, 10);
        backward.Size = new Size(25, 25);
        //backward.Image = new Bitmap("backward.png");

        TrackBar tb = new TrackBar();
        tb.Parent = buttonPanel;
        tb.TickStyle = TickStyle.None;
        tb.Size = new Size(150, 25);
        tb.Location = new Point(200, 10);
        tb.Anchor = AnchorStyles.Right;

        Button audio = new Button();
        audio.FlatStyle = FlatStyle.Popup;
        audio.Parent = buttonPanel;
        audio.Size = new Size(25, 25);
        //audio.Image = new Bitmap("audio.png");
        audio.Location = new Point(170, 10);
        audio.Anchor = AnchorStyles.Right;

        StatusBar sb = new StatusBar();
        sb.Parent = this;
        sb.Text = "Ready";

        CenterToScreen();
    }

    void OnExit(object sender, EventArgs e) {
        Close();
    }
}


class MApplication {
    public static void Main() {
        Application.Run(new MForm());
    }
}