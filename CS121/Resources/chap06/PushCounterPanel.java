import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Demonstrates a graphical user interface and an event listener.
 * 
 * @author Java Foundations
 */
@SuppressWarnings("serial")
public class PushCounterPanel extends JPanel
{
   private static final Color LIGHT_GREEN = new Color(206, 255, 199);
	 
   private int count;
   private JButton push;
   private JLabel label;

   /**
    * Constructor: Sets up the GUI panel
    */
   public PushCounterPanel()
   {
	  // initialize the components
      count = 0;
      push = new JButton("Push Me!");
      label = new JLabel("Pushes: " + count);
      
      // add the action listener (aka. event handler) to the button.
      push.addActionListener(new ButtonListener());

      // add the button and label to this panel
      add(push);
      add(label);

      // set the background color and preferred size of this panel.
      setBackground(LIGHT_GREEN);
      setPreferredSize(new Dimension(300, 40));
   }

   /**
    * Represents a listener for button push (action) events.
    */
   private class ButtonListener implements ActionListener
   {
      /**
       * Updates the counter and label when the button is pushed.
       */
      public void actionPerformed(ActionEvent event)
      {
         count++;
         
         // replace the text of the existing label with the new text.
         label.setText("Pushes: " + count);
      }
   }
}
