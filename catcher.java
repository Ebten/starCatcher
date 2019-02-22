package star;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
class catcher extends JComponent implements Runnable, KeyListener{
            // This class handles the movements of the catcher along with the movement of the star
            Thread t;
            int threadTime = 64;
            boolean hold = true;
            int x = 400, y = 600, sisp = 10;
            boolean moveLeft = false, moveRight = false;
            Rectangle2D.Float r = new Rectangle2D.Float();
            int starsCaught = 0;
            JLabel score = new JLabel("" + starsCaught);
            Font f = new Font("Verdana",Font.BOLD,16);
            star s = new star();
            catcher(){
                        // Setting its size here so we don't have to do so in the main class
                        setSize(m.dx,m.dy);
                        addKeyListener(this);
                        setFocusable(true);
                        scoreSetup();
                        add(s);
                        start();
            }
            void scoreSetup(){
                        // Setting up the score display, adding it in, changing its color, 
                        // setting where it's to be and setting the font
                        score.setSize(m.dx,m.dy);
                        score.setFont(f);
                        score.setForeground(Color.WHITE);
                        score.setVerticalAlignment(JLabel.TOP);
                        add(score);
            }
            public void paintComponent(Graphics co){
                        Graphics2D g = (Graphics2D) co;
                        r.setFrame(x,y,sisp,sisp);
                        g.setColor(Color.WHITE);
                        g.fill(r);
            }
            public void keyPressed(KeyEvent k){
                        if(k.getKeyChar() == 'a'){
                                    moveLeft = true;
                        }
                        if(k.getKeyChar() == 'd'){
                                    moveRight = true;
                        }
                        if(k.getKeyChar() == KeyEvent.VK_ENTER){
                                    catcher newCatcher = new catcher();
                                    m.jf.add(newCatcher);
                                    m.jf.remove(this);
                        }
            }
            public void keyTyped(KeyEvent k){}
            public void keyReleased(KeyEvent k){
                        if(k.getKeyChar() == 'a'){
                                    moveLeft = false;
                        }
                        if(k.getKeyChar() == 'd'){
                                    moveRight = false;
                        }
            }
            void start(){if(t == null){t = new Thread(this);t.start();}}
            public void run(){
                        while(hold == true){
                                    if(moveLeft == true && x > m.jfi.left){
                                                x-=sisp;
                                    }
                                    if(moveRight == true && (x + sisp) < m.jfi.right){
                                                x+=sisp;
                                    }
                                    s.fall();
                                    if(x == s.x && y == s.y){
                                                s.backToSky();
                                                starsCaught++;
                                                score.setText("" + starsCaught);
                                                y-=sisp;
                                                threadTime-=2;
                                    }
                                    if(s.y == (y + sisp)){
                                                hold = false;
                                                score.setText("Your final score was " + score.getText() + ". Press ENTER to start again.");
                                    }
                                    repaint();
                                    try{t.sleep(threadTime);}catch(Exception e){}
                        }
            }
}