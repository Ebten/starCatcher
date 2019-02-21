package star;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.util.*;
class star extends JComponent{
            // This class is simply a rectangle that is handled by the catcher class, all it does is
            // display at the points its told to display at
            int x, y, sisp = 10;
            Random rm = new Random();
            Rectangle2D.Float r = new Rectangle2D.Float();
            star(){
                        setSize(m.dx,m.dy);
                        backToSky();
            }
            public void paintComponent(Graphics co){
                        Graphics2D g = (Graphics2D) co;
                        r.setFrame(x,y,sisp,sisp);
                        g.setColor(Color.YELLOW);
                        g.fill(r);
            }
            void backToSky(){
                        // Sending the star back into the sky,
                        // or putting the star at a y above the border and
                        // at a new random x location
                        y = (sisp * -4);
                        newRandomLocation();
            }
            void fall(){
                        // Method that's called by the catcher's thread to have
                        // the star "fall"
                        y+=sisp;
                        repaint();
            }
            void newRandomLocation(){
                        // Getting a new random x location for the star
                        int newx = rm.nextInt(m.jfi.right);
                        // Getting the new x location to a power of 10 
                        while(newx % sisp != 0){
                                    newx--;
                        }
                        x = newx;
            }
}