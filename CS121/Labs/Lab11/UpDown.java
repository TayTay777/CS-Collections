import javax.swing.JFrame;

/**
 * By adding the same listener object to both buttons is how 
 * the two components can share the same listener.
 * 
 * @author taylorpaulroberts
 */
public class UpDown
{
   /**
    * Creates and displays the main program frame.
    * @param args
    */
   public static void main(String[] args)
   {
      JFrame frame = new JFrame("Up Down");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      frame.getContentPane().add(new UpDownPanel());

      frame.pack();
      frame.setVisible(true);
   }
}

