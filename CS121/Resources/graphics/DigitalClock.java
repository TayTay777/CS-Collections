import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import javax.swing.Timer;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
    An animated digital clock.
    @author  amit
*/

public class DigitalClock extends JPanel
{
    private final int delay = 1000; //milliseconds
  
    /**
        Display the digital time. 
        @param g Graphics context
        @return none
    */
    public void paintComponent(Graphics g)
    {
        g.setColor(Color.black);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(Color.green);
       
        Calendar rightNow = Calendar.getInstance();
        int hour = rightNow.get(Calendar.HOUR_OF_DAY);
        int minute = rightNow.get(Calendar.MINUTE);
        int second = rightNow.get(Calendar.SECOND);
        
        g.setFont (new Font("Arial", Font.BOLD, 64));
        g.drawString(hour + ":" + minute + ":" + second, 60, 60);
    }


    /**
        Set background color and preferred size and start animation.
        @param none
        @return void
    */
    public DigitalClock()
    {
        setBackground(Color.white);
        setPreferredSize(new Dimension(370,100));
        startAnimation();
    }
    
    
    /**
     * Create an animation thread that runs once per second
     */
    private void startAnimation() 
    {
        ActionListener taskPerformer = new ActionListener() {
            public void actionPerformed(ActionEvent evt) 
            {
                repaint();
            }
        };
        new Timer(delay, taskPerformer).start();
    }
    
    
    /**
     * sets up a JFrame and the DigitalClock panel
     * @param args unused
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame("Digital Clock");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new DigitalClock());
        frame.pack();
        frame.setVisible(true);
    }
}
