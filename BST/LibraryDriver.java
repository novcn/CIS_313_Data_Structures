/*LibraryDriver.java
 *Colin Gabrielson, November, 4th
 *Driver for BST, takes in user input for 
 *insert, find, and remove and prints out result
 */

import java.io.IOException;
import java.io.*;
import java.util.Scanner;

public class LibraryDriver
{
	public static void main(String[] args)
	{
		BST tree = new BST();

		String command;//command to use
		String insert = "insert";//string for insert
		String find = "find";//string for find
		String remove = "remove";//string for remove
		String book = "";//to hold the book title
		String result = "";//to hold result
		
		int numComds = 0;//number of cammands

        Scanner stdin = new Scanner(System.in);//new scanner to get user input
        
        numComds = Integer.parseInt(stdin.nextLine());//reads user input of number of lines to test

        String[] results = new String[numComds];//array to hold the results

        //iterates for each command
        for(int i = 0; i < numComds; i++)
        {
        	command = stdin.nextLine();//read the command in
        	if(command.equals(insert))//if its insert
        	{
        		book = stdin.nextLine();//book is next line
        		tree.insert(book);//insert it into the tree
        		results[i] = "Inserted " + book + " into the catalog.";//store result
        	}
        	else if(command.equals(find))//if it's find
        	{
        		book = stdin.nextLine();//book is next line
        		if(tree.find(book))
        			results[i] = book + " is in the catalog.";//store that it was found
        		else
        			results[i] = book + " is not in the catalog.";//store that it wasn't found
        	}
        	else if(command.equals(remove))//if it's remove
        	{
        		book = stdin.nextLine();//book is next line
        		if(tree.remove(book))
        			results[i] = book + " was removed from the catalog.";//store that it was removed
        		else
        			results[i] = book + " is not in the catalog.";//store that it wasn't
        	}
        	else
        		System.out.println("Command not recognized");//if command isn't valid
        }

        for(int j = 0; j < numComds; j++)
        	System.out.println(results[j]);//print the results
	}
	
}