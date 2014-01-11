/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package screensaver;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author wade
 */
public class ScreenSaver extends JPanel implements ActionListener
{
    Random random;
    Timer timer;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        JFrame screen = new JFrame();
        ScreenSaver screensaver = new ScreenSaver();
        screen.add(screensaver);
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        screen.setSize(500, 500);
        screen.setVisible(true);
    }
    
    public ScreenSaver()
    {
        random = new Random();
        timer = new Timer(1000, this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        
        for(int x = 0; x < 100; ++x)
        {
            g.drawLine(random.nextInt(this.getWidth()), random.nextInt(this.getHeight()), random.nextInt(this.getWidth()), random.nextInt(this.getHeight()));
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent event)
    {
        repaint();
    }
}
