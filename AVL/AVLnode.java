/*BSTnode.java
 *Colin Gabrielson, November 29th 2013
 *Simple node class that contains pointers to left,
 *right and stores the data, which is the title of book
 */

public class BSTnode	
{
	String data;//to hold the book title
	int height = 1;//to hold height of each node
	BSTnode left;//points to the left child
	BSTnode right;//points to the right childe

	/*Constructor for the node
	 *that holds the book title
	 */
	public BSTnode(String data)
	{
		this.data = data;
	}

}