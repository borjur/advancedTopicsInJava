/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package temperatureConversion;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author wade
 */
public class TemperatureConverter extends JFrame
{
    private JTextField temp;
    private JComboBox scale1;
    private JComboBox scale2;
    private JButton convert;
    private JLabel result;
    private static final String[] scales = {"Cº", "Fº", "Kº"};
    
    public TemperatureConverter()
    {
        super("Temparature Converter");
        setLayout(new FlowLayout());
        
        temp = new JTextField("0", 10);
        add(temp);
        scale1 = new JComboBox(scales);
        add(scale1);
        
        result = new JLabel("= 0");
        add(result);
        scale2 = new JComboBox(scales);
        add(scale2);
        
        convert = new JButton("Convert");
        convert.addActionListener(
                new ActionListener() 
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        double newTemp = 0;
                        double oldTemp = Double.parseDouble(temp.getText());
                        
                        switch(scale1.getSelectedIndex())
                        {
                            case 0:
                                if(scale2.getSelectedIndex() == 0) newTemp = oldTemp;
                                else if(scale2.getSelectedIndex() == 1) newTemp = CelsiusToFahrenheit(oldTemp);
                                else newTemp = CelsiusToKelvin(oldTemp);
                                break;
                            case 1:
                                if(scale2.getSelectedIndex() == 0) newTemp = FahrenheitToCelsius(oldTemp);
                                else if(scale2.getSelectedIndex() == 1) newTemp = oldTemp;
                                else newTemp = FahrenheitToKelvin(oldTemp);
                                break;
                            case 2:
                                if(scale2.getSelectedIndex() == 0) newTemp = KelvinToCelsius(oldTemp);
                                else if(scale2.getSelectedIndex() == 1) newTemp = KelvinToFahrenheit(oldTemp);
                                else newTemp = oldTemp;
                                break;
                        }
                        
                        result.setText(String.format("= %.2f", newTemp));
                    }
                });
        add(convert);        
    }
    
    private double FahrenheitToCelsius(double f)
    {
        return (f-32.0)*5.0/9.0;
    }
    
    private double FahrenheitToKelvin(double f)
    {
        return CelsiusToKelvin(FahrenheitToCelsius(f));
    }
    
    private double CelsiusToFahrenheit(double c)
    {
        return (c*9.0/5.0) + 32.0;
    }
    
    private double CelsiusToKelvin(double c)
    {
        return c + 273.15;
    }
    
    private double KelvinToCelsius(double k)
    {
        return k - 273.15;
    }
    
    private double KelvinToFahrenheit(double k)
    {
        return CelsiusToFahrenheit(KelvinToCelsius(k));
    }
}
