
/*
 * PalindromeDriver.java
 *
 * The main driver code for lab 1 (asst2).
 * Uses user-defined stack and queue class to determine if
 * input words are palindromes.
 * Colin Gabrielson - October 12th 2013
 */ 
import java.io.IOException;
import java.io.*;
import java.util.Scanner;

public class PalindromeDriver {

    public boolean even;//holds weather odd or even
    /*
     *Takes in any String and returns
     *a String with only lower case letters
     */
    public String trim(String drome)
    {
        String replaced = drome.replaceAll("\\W", ""); //reg expression to remove non A...Z/a...z
        replaced = replaced.toLowerCase(); //turns it all into lowercase
        return replaced; //return striped down string
    }

    /*
     *Takes in an int (length of the the string) and
     *returns true or false based on it being even or odd length
     */
    public void oddOrEven(int stringLength)
    {
        if(stringLength % 2 == 1)//if there is a remainder form div 2
                this.even = false;//then length is odd
            else
                this.even = true;//otherwise it's even
    }

    /*
     *Takes in a line and returns the first half
     *if the line is of odd length the middle character will
     *be ignored (it has no use in indentifying a palindrome )
     */
    public String getFirstHalf(String line)
    {
        if(this.even)
        {
            String first_half = line.substring(0, line.length() / 2);
            return first_half;
        }
        else
        {
            String first_half = line.substring(0, line.length() / 2);
            return first_half;
        }
    }

    /*
     *Takes in a line and returns the last half
     *if the line is of odd length the middle character will
     *be ignored (it has no use in identifying a palindrome)
     */
    public String getLastHalf(String line)
    {
        if(this.even)
        {
            String last_half = line.substring(line.length() / 2, line.length());
            return last_half;
        }
        else
        {
            String last_half = line.substring((line.length() / 2) + 1, line.length() );
            return last_half;
        }
    }

    /*
     *Takes in first half and last half of the line
     *returns false if it is not a palindrome (and defaults to false)
     *returns true if it is a palindrome
     */
    public static boolean is_palindrome(String first_half, String last_half)
    {   
        Queue queue = new Queue();//creating a new Queue
        Stack stack= new Stack();//creating a new Stack

        //push & enqueue, note:<INV> first_half.length() == last_half.length() (we can use either)
        for(int j = 0; j < first_half.length(); j++)
        {
            queue.enqueue(first_half.charAt(j));//enqueue first half of line
            stack.push(last_half.charAt(j));//push last half of line
        }

        //DQ and pop, note:<INV> first_half.length() == last_half.length() (we can use either)
        for(int k = 0; k < first_half.length(); k++)
        {
            if(queue.dairyqueen() != stack.pop())
            {
                return false;//not a palindrome
            }
            if(k + 1 == first_half.length())//Made it to the end without any non-equalities
            {
                return true;//is a palindrome
            }
        }
        return false;//default(should never be )
    }

    /* Main method: reads input and calls palindrome test, prints results */
    public static void main(String[] args) throws IOException
    {
        int num_phrases;//holds the number of phrases to check
        String first_half = "";//holds the first half of the line
        String last_half = "";//holds the second half of the line
        boolean even;//holds if a line is even (for splitting)
        String line;//holds inputted line

        PalindromeDriver dromeDriver = new PalindromeDriver();//instanciating self to call functions
        Queue queue = new Queue();//creating a new Queue
        Stack stack= new Stack();//creating a new Stack

        
        Scanner stdin = new Scanner(System.in);
        
        num_phrases = Integer.parseInt(stdin.nextLine());//reads user input of number of lines to test
    
        String pos_result = "Palindrome";//for the results
        String neg_result = "Not a palindrome";//for the results
        String[] results = new String[num_phrases];//array to hold the results
        int result_index = 0;//index for results


        for(int i = 0; i < num_phrases; i++)
        {
            line = stdin.nextLine();//reads the input line
            line = dromeDriver.trim(line);//trims the string into lowercase
          
            dromeDriver.oddOrEven(line.length());//check to see if odd or even
            first_half = dromeDriver.getFirstHalf(line);//get the first half (accounts for odd or even)
            last_half = dromeDriver.getLastHalf(line);//gets the last half ""

            //call function to test for palindrome, if true
            if(dromeDriver.is_palindrome(first_half, last_half))
            {
                results[result_index] = pos_result;//store the results
                result_index++;//incriment index
            }
            else//otherwise
            {
                results[result_index] = neg_result;//store the results
                result_index++;//increment index
            }
        }

        //Print the results
        for(int i = 0; i < result_index; i++)
        {
            System.out.println(results[i]);
        }
    }
}