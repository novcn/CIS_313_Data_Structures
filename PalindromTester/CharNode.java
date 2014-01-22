/* CharNode.java 
 *
 * a simple class, which holds the data and pointers
 * which will be used in the Stack and Queue Classes
 * Colin Gabrielson - October, 12th 2013
 */

public class CharNode
{
	
	public char data;//character data that the node holds
	public CharNode next;//pointer to the next node

	/*
	 *Constructor, which sets data
	 */
	public CharNode(char c)
	{
		this.data = c;//referencing data 
	}
}