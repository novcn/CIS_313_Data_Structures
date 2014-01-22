/*BST.java
 *Colin Gabrielson, November, 29th
 *Binary Search Tree with methods to have AVL
 *height balanced functionality
 */

public class BST
{
	BSTnode root;//holds the root value
	BSTnode parent;//initialize of parent node
	boolean status;//flag for remove
	String str;//string for traversal

	/*insert public function sets the root
	 *and calls the recursive insert function
	 */
	public void insert(String title)
	{
		root = insert(title, root);
	}


	/*insert recursive function, takes in a book title and
	 *the current BSTNode and inserts title within
	 *tree, while conforming to BST properties
	 */
	private BSTnode insert(String title, BSTnode current)
	{
		if(current == null)//if we're at a leaf
		{
			BSTnode node = new BSTnode(title);//make a new node with title
			return node;//return it
		}
		else if(current.data.equals(title))//if it already exists in the tree
			return current;//return current
		else
		{
			if(title.compareToIgnoreCase(current.data) < 0)//if it is less than current
			{
				current.left = insert(title, current.left);//we go left
			}
			else
				current.right = insert(title, current.right);//go right
			return balance(current);//call and return balanced node
		}
	}


	/*find helper function, takes in a book
	 *title and starts at the root
	 *
	 */
	public boolean find(String title)
	{
		return find(title, root);
	}


	/*
	 *find function, to search for a title
	 *in our tree - catelog
	 */
	private boolean find(String title, BSTnode current)
	{
		if(current == null)
			return false;//not found
		else if(current.data.equals(title))
			return true;//found
		else
		{
			if(title.compareToIgnoreCase(current.data) < 0)//less than
				return find(title, current.left);//go left
			else
				return find(title, current.right);//go right
		}
	}


	/*remove helper function
	 *returns a boolean flag
	 *if book was found or not
	 */
	public boolean remove(String title)
	{
		status = true;//initiate flag to true, will be set to false if not found
		root = remove(title, root);
		return status;
	}

	/*remove function
	 *searches for a title in the catelog recursivly
	 *and removes it from our BST
	 */
	private BSTnode remove(String title, BSTnode current)
	{
		if(current == null)
		{
			status = false;//set flag to false
			return null;//wasn't found
		}
		else if(current.data.equals(title))//title was found
		{
			if(current.left == null && current.right == null)//at a leaf
				return null;
			else if(current.left != null && current.right == null)//only a left child
				return current.left;
			else if(current.right != null && current.left == null)//only a right child
				return current.right;
			else
			{
				BSTnode temp = current;//new temp node at current node
				temp = temp.right;//go right
				temp = goBottom(temp);//go all the way left
				if(temp.right != null)//if there is still a right child
				{
					current.right.left = temp.right;
					current.data = temp.data;
					return current;	
				}
				else
				{
					current.data = temp.data;//get data from temp, overwrite current
					current.right = null;//disconnect right of current
					return balance(current);//return balanced node
				}
			}
		}
		else
		{
			if(title.compareToIgnoreCase(current.data) < 0)
				current.left = remove(title, current.left);//continue searching left
			else
				current.right = remove(title, current.right);//continue searching right
			return balance(current);//return balanced node
		}
	}

	/*Simple recursive function to go all the way to the bottom
	 *left of a subtree, used in remove function
	 */
	private BSTnode goBottom(BSTnode current)
	{
		if(current == null)
			return goBottom(current.left);
		else
			return current;
	}

	/*balance function which determines
	 *which kind of balance is needed in order 
	 *to maintain AVL height balanced properties
	 */
	private BSTnode balance(BSTnode current)
	{
		if(heightBalance(current) == 0)//tree is already balanced
			current = current;//do nothing
		else if(heightBalance(current) < -1)//subtree is heavy on the right
		{
			if(heightBalance(current.right) == -1)//right.right situation
				current = rotateLeft(current);
			else
				current = doubleRotateLeft(current);//right.left situation
		}
		else if(heightBalance(current) > 1)
		{
			if(heightBalance(current.left) == 1 || heightBalance(current.left) == 0)//left.left situation
				current = rotateRight(current);
			else
				current = doubleRotateRight(current);//left.right situation
		}
		heightFix(current);//fix the height
		return current;//return balanced node
	} 

	/*heightBalance function which returns
	 *an int based on the type of balancing we need
	 *to do to restore height-balanced property
	 *returns a negative number if we are right heavy, positive otherwise
	 */
	private int heightBalance(BSTnode current)
	{
		if(current.left == null && current.right == null)//we are at a leaf
			return 0;//no balance needed
		else if(current.left == null)//just left is null
			return 0 - current.right.height;//return a negative number
		else if(current.right == null)//just right is null
			return current.left.height;//return the height of right
		else
			return current.left.height - current.right.height;//find the difference
	}


	/*
	 *Rotateleft function to restore a right-heavy subtree
	 *
	 */
	private BSTnode rotateLeft(BSTnode current)
	{
		BSTnode temp = current;//temp = a
		current = current.right;//current = b
		temp.right = current.left;//a.right = t1
		current.left = temp;//b.left = a
		heightFix(current.left);//fix the height
		return current;//return balanced node
	}

	/*
	 *Rotateright function to restore a left-heavy subtree
	 *
	 */
	private BSTnode rotateRight(BSTnode current)
	{
		BSTnode temp = current;//temp = c
		current = current.left;//current = b
		temp.left = current.right;//a.left = t1
		current.right = temp;//b.left = a
		heightFix(current.right);//fix the height
		return current;//return balanced node
	}

	/*
	 *DoubleRotateRight to fix left-heavy subtree
	 *
	 */
	private BSTnode doubleRotateRight(BSTnode current)
	{
		current.left = rotateLeft(current.left);//single rotateleft on current.left
		return rotateRight(current);//single rotateright on current
	}

	/*
	 *DoubleRotateLeft to fix right-heavy subtree
	 *
	 */
	private BSTnode doubleRotateLeft(BSTnode current)
	{
		current.right = rotateRight(current.right);//single rotateright on current.right
		return rotateLeft(current);//single rotateleft on current
	}

	/*
	 *heightFix function to get accurate heights for each
	 *node
	 */
	private void heightFix(BSTnode current)
	{
		if(current.left == null && current.right == null)//if at a leaf
			current.height = 1;//leaf is set to 1
		if(current.left != null && current.right == null)//just right null
			current.height = current.left.height + 1;//left height plus 1
		if(current.right != null && current.left == null)//just left null
			current.height = current.right.height + 1;//right height plus 1
		if(current.right != null && current.left != null)//both aren't null
			current.height = getMax(current) + 1;//get the highest of the two + 1
	}


	/*
	 *Simpe function to get the max height of
	 *two childtren of a node
	 */
	private int getMax(BSTnode current)
	{
		if(current.left.height > current.right.height)
			return current.left.height;
		else
			return current.right.height;
	}

	/*
	 *Helper function for a preorder traversal
	 *
	 */
	public String preOrder()
	{
		str = "";//empty string
		return preOrder(root);//call it on root
	}

	/*
	 *preorder traversal, returns a string containing
	 *every title in tree
	 */
	private String preOrder(BSTnode current)
	{
		if(current != null)
		{
			str += current.data;//append to string
			preOrder(current.left);//call on left child
			preOrder(current.right);//call on right child
		}
		return str;//return the string
	}


}