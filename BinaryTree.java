package problems;

public class BinaryTree<E extends Comparable<E>>{
	
	public class Node {
		
		private Node left;
		private Node right;
		private E data;
		public Node(E data){
			this.data = data;
		}
	}
	
	private Node head;
	
	public BinaryTree()
	{
		head = null;
	}
	
	public Node getRoot()
	{
		return head;
	}
	
	public void add(E data)
	{
		if(head == null)
		{
			head = new Node(data);
			return;
		}
		Node T = head;
		while(true)
		{
			if(data.compareTo(T.data) == -1)
			{
				System.out.println(data + " is less than " + T.data);
				if(T.left == null)
				{
					T.left = new Node(data);
					return;
				}
				T = T.left;
			}
			if(data.compareTo(T.data) == 1)
			{
				System.out.println(data + " is greater than " + T.data);
				if(T.right == null)
				{
					T.right = new Node(data);
					return;
				}
				T = T.right;
			}
		}
	}
	public void inOrder(Node T)
	{
		if(T.left != null)
			inOrder(T.left);
		System.out.println(T.data);
		if(T.right != null)
			inOrder(T.right);
	}
	
	public void preOrder(Node T)
	{
		if(T == null)
			return;
		System.out.println(T.data); 
		preOrder(T.left);
		preOrder(T.right);
	}
	public void postOrder(Node T)
	{
		if(T.left != null)
			preOrder(T.left);
		if(T.right != null)
			preOrder(T.right);
		System.out.println(T.data);
		
			
	}
	
	public String toString()
	{
		if(head == null)
			return "Empty";
		StringBuffer m = new StringBuffer("");
		Node T = head;
		m.append("Root: "+T.data);
		return "";
	}

}
