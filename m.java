package star;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class m{
            static int scx = 1920, scy = 1080, dx = 800, dy = 800;
            // Jframe
            static JFrame jf = new JFrame("Star Catcher!");
            static Insets jfi = new Insets(0,0,0,780);
            // Our Layered Pane, soon to be our Content Pane
            static JLayeredPane jl = new JLayeredPane();
            // Component being added
            static catcher catcher = new catcher();
            public static void main(String[] arguments){
                        jf.setSize(dx,dy);
                        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        jf.setBackground(Color.BLACK);
                        jf.setContentPane(jl);
                        jf.add(catcher);
                        jf.setVisible(true);
            }
}