/* Stack.java 
 *
 * a class which implements a stack on a singly linked list
 * Colin Gabrielson - October, 12th 2013
 */

public class Stack
{
	private CharNode top; //a Node pointing to the top of the stack
	
	/*
	 *push function, which adds a new Node and makes it the top of the stack
	 */
	public void push(char data)
	{
		CharNode newNode = new CharNode(data);//newNode with the functions inputed data
		if(!isEmpty())//if the stack isn't empty...
			newNode.next = top;//points the newNode to the top...
		top = newNode;//and then makes top the newNode
	}

	/*
	 *pop function, which takes the top nod off of the stack, makes the next
	 *one down the top and returns the element within the previous top
	 */
	public char pop()
	{
		if(isEmpty())//if stack is empty when we try to remove
		{
			System.out.print("The stack is empty");//throw an error sign
			return '!';//return something invalid
		}
		char data = top.data;//extracts data from the top
		top = top.next;//the node below top is the new top
		return data;//return data extracted from previous top
	}

	/*
	 *function which returns a boolean "true" if the stack is empty
	 */
	public boolean isEmpty()
	{
		return(top == null);
	}
}