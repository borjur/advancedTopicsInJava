/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package screensaver;

import java.awt.Graphics;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author wade
 */
public class ScreenSaver extends JPanel
{
    Random random;
    
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
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        
        for(int x = 0; x < 100; ++x)
        {
            g.drawLine(random.nextInt(this.getWidth()), random.nextInt(this.getHeight()), random.nextInt(this.getWidth()), random.nextInt(this.getHeight()));
        }
        
        repaint();
    }
}
