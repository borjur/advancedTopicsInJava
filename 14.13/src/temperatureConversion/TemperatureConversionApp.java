/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package temperatureConversion;

import javax.swing.JFrame;

/**
 *
 * @author wade
 */
public class TemperatureConversionApp 
{
    public static void main(String[] args)
    {
        TemperatureConverter converter = new TemperatureConverter();
        converter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        converter.setSize(600,100);
        converter.setVisible(true);
    }
}
