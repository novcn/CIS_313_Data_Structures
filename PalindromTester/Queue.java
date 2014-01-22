 /* Queue.java 
  *
  * a class which implements a queue using a singly linked list
  * Colin Gabrielson - October, 12th 2013
  */

public class Queue
{
	private CharNode head;//Node which points to the head or beginning of the Queue
	private CharNode tail;//Node which points to the tail or end of the Queue
	
	/*
	 *Function to add a character to the head of the Queue
	 */
	public void enqueue(char data)
	{
		CharNode newNode = new CharNode(data);//Creating a newNode with function input
		if(isEmpty())//if queue is empty
			tail = newNode;//newNode is tail(along with assumed head)
		else
			head.next = newNode;//head points to newNode
		head = newNode;//newNode is now the head
	}

	/*
	 *Function to remove & return (DQ) the element at the tail of the Queue
	 */
	public char dairyqueen()
	{
		if(isEmpty())//if it is empty
		{
			System.out.print("Queue is empty");//throw an error
			return '!';//return something invalid
		}
		char data = tail.data;//extract the data from the tail
		if(head == tail)//if there was only one element
		{
			head = null;//the queue will
			tail = null;//now be empty
		}
		if(head != tail)//if not
			tail = tail.next;//point the tail to the next node
		return data;//return extracted data from previous tail
	}

	/*
	 *Function return a boolean in regaurds to the Queue being empty or not
	 */
	public boolean isEmpty()
	{
		return(head == null && tail == null);
	}
	
}