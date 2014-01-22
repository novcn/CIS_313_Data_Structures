/*BST.java
 *Colin Gabrielson, November 4th 2013
 *Binary search tree which has insert, find and remove functions
 */

public class BST
{
	BSTnode root;//holds the root value
	BSTnode parent;//initialize of parent node
	BSTnode temp;//initialize of temp node

	/*
	 *public function for insert
	 */
	public void insert(String title)
	{
		insert(title, this.root);
	}

	/*
	 *Private function for insert, conforms to BST 
	 *specifications (node with smaller value goes to the left of current)
	 */
	private void insert(String title, BSTnode current)
	{
		BSTnode node = new BSTnode(title);//new node that holds new title
		if(this.root == null)//if the tree is empty
		{
			this.root = node;//set root to node
		}
		else if(title.compareToIgnoreCase(current.data) < 0)//go left
		{
			if(current.left != null)//still something there
				insert(title, current.left);//continue down...
			else
				current.left = node;//new leaf
		}
		else
		{
			if(current.right != null)//still something there
				insert(title, current.right);//continue down...
			else
				current.right = node;//new leaf
		}
	}

	/*
	 *public function to find book
	 */
	public boolean find(String title)
	{
		return find(title, this.root);
	}

	/*
	 *private function, attempts to find a book based on the title
	 *returns true if found, false otherwise
	 */
	private boolean find(String title, BSTnode current)
	{
		if(current == null)//if we have reached the end
		{
			return false;//not found
		}
		if(current.data.equals(title))//if we have found 
			return true;//found
		else if(title.compareToIgnoreCase(current.data) < 0)//go left
			return find(title, current.left);
		else//go right
			return find(title, current.right);
	}

	/*
	 *public function to remove
	 */
	public boolean remove(String title)
	{
		return remove(title, this.root);
	}

	/*private function, which removes the node if in the tree
	 *and maintains links with BST properties
	 */
	private boolean remove(String title, BSTnode current)
	{
		if(current == null)//if tree is empty
			return false;//
		if(current.data.equals(title))//if current node contains title
		{
			if(this.root == current)//if we are at root
			{
				if(current.right != null)//and right isn't null
				{
					parent = current;//make root parent
					current = current.right;//go right
					if(current.left != null)//if left isn't null
					{	
						while(current.left != null)//go left until null
						{
							parent = current;//keep a pointer to the parent
							current = current.left;//continue right
						}
						parent.left = null;//set parent.left to null
					}
					else
						parent.right = null;//otherwise parent.right to null
					this.root.data = current.data;//set the root to what was found at bottom
					current = null;//set current to null
				}
				else if(current.left != null)//if right isn't null
				{
					parent = current;//keep a pointer to the parent
					current = current.left;//continue right
					if(current.right != null)//if right isn't null
					{
						while(current.right != null)//go right untill null
						{
							parent = current;//keep a poiner to the parent
							current = current.right;//continue right
						}
						parent.right = null;//set parent.right to null
					}
					else
						parent.left = null;//set parent.right to null
					this.root.data = current.data;//set the root to what was found at the bottom
					current = null;//current is null
				}
				else
					current = null;//if root is the only node
			}
			else if(current.right == null && current.left == null)//if we have a leaf
				current = null;//set it to null, simply
			//if current has only left child
			else if(current.right != null && current.left == null)
			{	//
				if(current.right.data.compareToIgnoreCase(parent.data) < 0)//node to the right of current is less than parent
					parent.left = current.right;//point the left pointer of parent to the node right of current
				else
					parent.right = current.right;//point the right pointer of the parent to the node right of current	
			}
			//if current only has a right child
			else if(current.right == null && current.left != null)
			{
				if(current.left.data.compareToIgnoreCase(parent.data) < 0)//node to the right of current is less than parent
					parent.left = current.left;//point the left pointer of parent to the night left of current
				else
					parent.right = current.left;//point the right pointer of the parent to the node left of current
			}
			//current has both children
			else
			{
				temp = current;//store current @ temp
				current = current.right;//go right
				while(current != null)
					current = current.left;//continue left until right before null
				temp.data = current.data;//store initial node's data @temp with data found at bottom
				if(current.right != null)//if right points to something not null
					parent.left = current.right;//pointer from left of parent is current.right
				else
					current = null;//otherwise current is null				
			}
			return true;//return true (since we successfully found & delted a node)
		}
		//if title is greater than the current nodes data
		else if(title.compareToIgnoreCase(current.data) > 0)
		{
			if(current.right == null)//check right
			{
				return false;//if null, reached end
			}
			else
			{
				parent = current;//store parent
				return remove(title, current.right);//continue down right
			}
		}
		//title is less than the current nodes data
		else
		{
			if(current.left == null)//check left
				return false;//if null, reached end
			else
			{
				parent = current;//store parent
				return remove(title, current.left);//continue down left
			}
		}
	}
}