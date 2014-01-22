/*TestDriver.java
 *Colin Gabrielson, November, 29th
 *Test driver to insure BST has AVL properties
 *
 */

public class TestDriver
{
	public static void main(String[] args)
	{
		//#1
		System.out.println("Test #1: ");
		BST t0 = new BST();
		t0.insert("cat");
		System.out.println(t0.preOrder().equals("cat"));

		//#2
		System.out.println("\nTest #2: ");
		t0.insert("bat");
		System.out.println(t0.preOrder().equals("catbat"));

		//#3
		System.out.println("\nTest #3: ");
		BST t1 = new BST();
		t1.insert("bat");
		t1.insert("cat");
		System.out.println(t1.preOrder().equals("batcat"));

		//#4.1
		System.out.println("\nTest #4.1: ");
		t0.insert("ant");
		System.out.println(t0.preOrder().equals("batantcat"));

		//#4.2
		System.out.println("\nTest #4.2: ");
		BST t2 = new BST();
		t2.insert("cat");
		t2.insert("ant");
		t2.insert("bat");
		System.out.println(t2.preOrder().equals("batantcat"));

		//#4.3
		System.out.println("\nTest #4.3: ");
		BST t3 = new BST();
		t3.insert("bob");
		t3.insert("art");
		t3.insert("car");
		System.out.println(t3.preOrder().equals("bobartcar"));

		//#5.1
		System.out.println("\nTest #5.1: ");
		t1.insert("duh");
		System.out.println(t1.preOrder().equals("catbatduh"));

		//#5.2
		System.out.println("\nTest #5.2: ");
		BST t4 = new BST();
		t4.insert("cow");
		t4.insert("owe");
		t4.insert("fff");
		System.out.println(t4.preOrder().equals("fffcowowe"));

		//#5.3
		System.out.println("\nTest #5.3: ");
		BST t5 = new BST();
		t5.insert("bob");
		t5.insert("cab");
		t5.insert("age");
		System.out.println(t5.preOrder().equals("bobagecab"));

		//#6.1
		System.out.println("\nTest #6.1: ");
		t5.insert("aid");
		System.out.println(t5.preOrder().equals("bobageaidcab"));

		//#6.2
		System.out.println("\nTest #6.2: ");
		t4.insert("dog");
		System.out.println(t4.preOrder().equals("fffcowdogowe"));
		t4.preOrder();

		//#6.3
		System.out.println("\nTest #6.3: ");
		t3.insert("bzb");
		System.out.println(t3.preOrder().equals("bobartcarbzb"));

		//#6.4
		System.out.println("\nTest #6.4: ");
		t2.insert("vat");
		System.out.println(t2.preOrder().equals("batantcatvat"));

		//#7
		System.out.println("\nTest #7: ");
		t2.insert("vat");
		System.out.println(t2.preOrder().equals("batantcatvat"));

		//#8
		System.out.println("\nTest #8: ");
		BST t6 = new BST();
		System.out.println(t6.remove("frog"));
		System.out.println(t6.preOrder().equals(""));

		//#9
		System.out.println("\nTest #9: ");
		System.out.println(t2.remove("toad"));
		System.out.println(t2.preOrder().equals("batantcatvat"));

		//#10
		System.out.println("\nTest #10: ");
		BST t7 = new BST();
		t7.insert("one");
		System.out.println(t7.remove("one"));
		System.out.println(t7.preOrder().equals(""));

		//#11
		System.out.println("\nTest #11: ");
		BST t8 = new BST();
		t8.insert("car");
		t8.insert("arc");
		System.out.println(t8.remove("arc"));
		System.out.println(t8.preOrder().equals("car"));

		//#12
		System.out.println("\nTest #12: ");
		t8.insert("arc");
		System.out.println(t8.remove("car"));
		System.out.println(t8.preOrder().equals("arc"));

		//#13
		System.out.println("\nTest #13: ");
		t8.insert("drc");
		System.out.println(t8.remove("drc"));
		System.out.println(t8.preOrder().equals("arc"));
		
		//#14
		System.out.println("\nTest #14: ");
		t8.insert("drc");
		System.out.println(t8.remove("arc"));
		System.out.println(t8.preOrder().equals("drc"));

		t3.remove("bzb");
		t4.remove("owe");
		t5.remove("aid");

		//#15.1
		System.out.println("\nTest #15.1: ");
		System.out.println(t3.preOrder());
		System.out.println(t3.remove("art"));
		System.out.println(t3.preOrder().equals("bobcar"));

		//#15.2
		System.out.println("\nTest #15.2: ");
		System.out.println(t4.preOrder());
		System.out.println(t4.remove("fff"));
		System.out.println(t4.preOrder().equals("dogcow"));

		//#15.3
		System.out.println("\nTest #15.3: ");
		System.out.println(t5.preOrder());
		System.out.println(t5.remove("bob"));
		System.out.println(t5.preOrder().equals("cabage"));

		t1.insert("ant");

		//#16
		System.out.println("\nTest #16: ");
		System.out.println(t1.preOrder());
		System.out.println(t1.remove("duh"));
		System.out.println(t1.preOrder().equals("batantcat"));

	}
}