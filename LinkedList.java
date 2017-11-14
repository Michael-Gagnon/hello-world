package problems;

import java.util.Hashtable;

public class LinkedList<E> {
	
	public class Node {
		
		private Node next;
		private Node prev;
		private E data;
		public Node(E data){
			this.data = data;
		}

	}
	private Node head;
	private int size;
	
	public LinkedList() {
		head = null;
		size = 0;
	}
	
	public void add(E data)
	{
		if (head == null)
		{
			head = new Node(data);
			head.prev = head;
			size++;
			return;
		}
		Node T = head;
		while(T.next != null)
		{
			T=T.next;
		}
		T.next = new Node(data);
		T.next.prev = T;
		T = null;
		size++;
	}
	public String toString() {
		if (head == null)
			return "--> X";
		StringBuffer m = new StringBuffer(" --> ");
		Node T = head;
		while(T != null)
		{
			if(T.next==null)
				m.append(T.data + " --> ");
			else m.append(T.data + " <--> ");
			T= T.next;
		}
		T=null;
		m.append("X");
		return m.toString();
	}
	public int size() 
	{
		return size;
	}
	public void delete(int i)
	{
		if(i>size-1)
			throw new ArrayIndexOutOfBoundsException();
		if(size == 1)
		{
			head = null;
			size--;
			return;
		}
		Node T = head;
		int count = 0;
		if(i == 0)
		{
			head = head.next;
			head.prev = null;
			size--;
			return;
		}
		while(count<i-1)
		{
			T=T.next;
			count++;
		}
		T.next = T.next.next;
		T.next.prev = T;
		T = null;
		size--;
	}
	public void addToStart(E data)
	{
		if(head==null)
		{
			head = new Node(data);
			size++;
			return;
		}
		Node T = new Node(data);
		head.prev = T;
		T.next = head;
		head = T;
		T = null;
		size++;
	}
	public void addAt(int i, E data)
	{
		if(i>size)
			throw new ArrayIndexOutOfBoundsException();
		if(i==0)
		{
			addToStart(data);
			return;
		}
		if(i == size)
		{
			add(data);
			return;
		}
		Node T = head;
		int count = 0;
		while(count < i-1)
		{
			T = T.next;
			count++;
		}
		T.next.prev = new Node(data);
		T.next.prev.prev = T;
		T.next.prev.next = T.next;
		T.next = T.next.prev;
		T = null;
		size++;
	}
	public void reverse()
	{
		Node T = head;
		while(T.next != null)
		{
			T= T.next;
		}
		head = T;
		T = head.prev;
		head.prev = head.next;
		head.next = T;
		T = head;
		while(T.next != null)
		{
			T = T.next;
			Node Q = T.prev;
			T.prev = T.next;
			T.next = Q;
		}
		T = null;
	}
	public void removeDup()
	{
		Hashtable<E, Integer> m = new Hashtable<E, Integer>();
		Node T = head;
		while(T.next != null)
		{
			if(m.containsKey(T.data))
			{
				T.prev.next = T.next;
				T.next.prev = T.prev;
			}
			else m.put(T.data, 1);
			T = T.next;
		}
		if(m.containsKey(T.data))
			T.prev.next = null;
		T = null;
	}
}
