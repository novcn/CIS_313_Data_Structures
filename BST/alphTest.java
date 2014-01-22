/*alphaTest.java
 *Colin Gabrielson, November 4th 2013
 *Tests the running time of BST with an average case
 *vs a worst case
 */

import java.io.IOException;
import java.io.*;
import java.util.Scanner;

public class alphTest
{
	public static void main(String[] args)
	{
		BST treeWorst = new BST();//tree for worst case
		BST treeAvgEx = new BST();//tree for avg case

		double end = 0;//end of nano timer
		double beg = 0;//beginning of nano timer
		double tot = 0;//total time
		int alphLength = 26;//length of alphabet

		//alphabet array in order
		String[] inOrder = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", 
		"m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
		//alphabet array in random order
		String[] random = {"o", "f", "n", "m", "d", "k", "u", "e", "j", "y", "p", "k", 
		"u", "z", "b", "c", "v", "l", "i", "q", "a", "g", "r", "h", "x", "t"};
		
		System.out.println("Beginning of worst case insert: " + System.nanoTime());
		beg = System.nanoTime();
		//adding elements in monotonically increasing order
		for(int i = 0; i < alphLength; i++)
			treeWorst.insert(inOrder[i]);
		System.out.println("End of worst case insert: " + System.nanoTime());
		end = System.nanoTime();
		tot = end - beg;
		System.out.println("Total time for worst case: " + tot);
		tot = tot / alphLength;
		System.out.println("Time per node: " + tot);

		tot = 0;

		System.out.println("Beginning of avgEx case insert: " + System.nanoTime());
		beg = System.nanoTime();
		//adding elements in random order
		for(int i = 0; i < alphLength; i++)
			treeWorst.insert(inOrder[i]);
		System.out.println("End of avgEx case insert: " + System.nanoTime());
		end = System.nanoTime();
		tot = end - beg;
		System.out.println("Total time for avgEx case: " + tot);
		tot = tot / alphLength;
		System.out.println("Time per node: " + tot);

	}	
}