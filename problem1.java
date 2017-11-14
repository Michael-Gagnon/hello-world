package problems;

import java.util.Hashtable;

public class problem1 {

	public static void main(String[] args) {
		
		LinkedList<Integer> m = new LinkedList<Integer>();
		m.add(7);
		m.add(6);
		m.add(7);
		m.add(4);
		System.out.println(m);
		m.delete(0);
		System.out.println(m);
		m.addToStart(34);
		System.out.println(m);
		System.out.println(m.size());
		m.addAt(2, 50);
		System.out.println(m);
		System.out.println(m.size());
		m.reverse();
		System.out.println(m);
		m.add(7);
		m.add(7);
		m.removeDup();
		System.out.println(m);
		
		BinaryTree<Integer> s = new BinaryTree<Integer>();
		s.add(40);
		s.add(20);
		s.add(10);
		s.add(30);
		s.add(60);
		s.add(50);
		s.add(70);
		System.out.println("Inorder");
		s.inOrder(s.getRoot());
		System.out.println("Preorder");
		s.preOrder(s.getRoot());
		System.out.println("Postorder");
		s.postOrder(s.getRoot());

	}

}
