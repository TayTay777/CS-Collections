import javax.swing.JFrame;

/**
 * Demonstrates the use of one listener for multiple buttons.
 * 
 * @author Java Foundations
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
