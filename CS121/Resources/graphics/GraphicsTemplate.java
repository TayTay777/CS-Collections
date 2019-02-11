
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Color;

/**
 * A starting point for creating a new graphical program
 * @author mvail, amit, marissa
 */
public class GraphicsTemplate extends JPanel
{
	/**
	 * Draws the picture in the panel. This is where all of your
	 * code will go.
	 * @param page Our graphics canvas.
	 */
   public void paintComponent (Graphics page)
   {
	   
   }

  
   /**
    * Constructor (panel initialization)
    */
   public GraphicsTemplate() {
      this.setBackground(Color.white);
      this.setPreferredSize(new Dimension(450,175));
   }
   
   
   /**
    * Sets up a JFrame and the GraphicsTemplate panel.
    * @param args unused
    */
   public static void main(String[] args) {
      JFrame frame = new JFrame("GraphicsTemplate");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(new GraphicsTemplate());
      frame.pack();
      frame.setVisible(true);
   }
}
