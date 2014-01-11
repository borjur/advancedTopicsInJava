
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

/**
 *
 * @author wade
 */
public class Main 
{
    public static char[][] letters = {{0,0,0}
                        , {0,0,0}
                        , {'A', 'B', 'C'}
                        , {'D', 'E', 'F'}
                        , {'G', 'H', 'I'}
                        , {'J', 'K', 'L'}
                        , {'M', 'N', 'O'}
                        , {'P', 'R', 'S'}
                        , {'T', 'U', 'V'}
                        , {'W', 'X', 'Y'}};
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        boolean validInput = false;
        int phoneNum = 0;
        String strNum = "";
        
        while(!validInput)
        {
            System.out.println("Enter a 7 digit number that does not contain 0 or 1: ");
            strNum = scanner.nextLine();
            if(strNum.length() != 7)
            {
                System.out.println("You must input a number with 7 digits");
            }
            else if(strNum.contains("0") || strNum.contains("1"))
            {
                System.out.println("The number cannot contain 0 or 1");
            }
            else
            {
                try
                {
                    phoneNum = Integer.parseInt(strNum);
                    validInput = true;
                }
                catch(NumberFormatException nfe)
                {
                    System.out.println("You must input a valid 7 digit number");                    
                }
            }
        }
        
        try
        {
            PrintStream stream = new PrintStream("phone_numbers.txt"); 
        
            char[] charNums = strNum.toCharArray();
            int[] nums = new int[charNums.length];

            for(int x = 0; x < charNums.length; ++x)
            {
                nums[x] = Character.digit(charNums[x], 10);
            }
            int count = 0;
            for(int one = 0; one < 3; ++one)
            {
                for(int two = 0; two < 3; ++two)
                {
                    for(int three = 0; three < 3; ++three)
                    {
                        for(int four = 0; four < 3; ++four)
                        {
                            for(int five = 0; five < 3; ++five)
                            {
                                for(int six = 0; six < 3; ++six)
                                {
                                    for(int seven = 0; seven < 3; ++seven)
                                    {
                                        stream.print(letters[nums[0]][one]);
                                        stream.print(letters[nums[1]][two]);
                                        stream.print(letters[nums[2]][three]);
                                        stream.print(letters[nums[3]][four]);
                                        stream.print(letters[nums[4]][five]);
                                        stream.print(letters[nums[5]][six]);
                                        stream.println(letters[nums[6]][seven]);
                                        ++count;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            stream.println("There are " + count + " numbers");
        }
        catch(FileNotFoundException fnfe)
        {
            fnfe.printStackTrace();
        }
    }
}