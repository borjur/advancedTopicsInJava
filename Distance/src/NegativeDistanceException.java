/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author wade
 */
public class NegativeDistanceException extends Exception
{
    public NegativeDistanceException()
    {
    }

    public NegativeDistanceException(String message)
    {
        super(message);
    }

    public NegativeDistanceException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public NegativeDistanceException(Throwable cause)
    {
        super(cause);
    }

}
