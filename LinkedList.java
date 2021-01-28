/*
LinkedList.java
* An implementation of Linked List Data structure.
* This linkedlist will be used during execution.
* When a 'User' buys a product, the details of product along with quantity willl be stored inside a single node of linked list.
* The details of product are fetched from database by other APIs

@author: AKASH A. MAHAJAN <akashmahajan025@gmail.com>

created under: INVENTORY MANAGEMENT SYSTEM project

*/

public class LinkedList
{
	// Every node is a item bought
	private class Node
	{
		int product_id;
		String product_name;
		float price;
		int amount;
		Node next;
	}
	private Node head;
	public LinkedList()
	{
		head = null;
	}
	public void display()
	{
		// This method directly displays the items in linkedlist with their name, price and amount bought only
		Node temp = new Node();
	        temp = head;
		while (temp != null)
		{
			System.out.println(temp.product_name + " Rs." + temp.price + " x " + temp.amount);
 			temp = temp.next;
		}
	}
	public void insert(int product_id, String product_name, float price, int amount)
	{
		// Insert a new node at end of list
		Node item = new Node();
		item.product_id = product_id;
		item.product_name = product_name;
		item.price = price;
		item.amount = amount;
	
		if (head == null)
			head = item;
		else
		{
			Node temp = new Node();
			temp = head;
			while (temp.next != null)
				temp = temp.next;
			temp.next = item;
		}
	}
        public int[][] getCart()
        {
        	// The users has a choice to view their cart. This method builds up a two dimensional int array where each index at array
        	// stores the product_id and amout of each item bought.
		Node temp = new Node();
	        temp = head;
                int[][] cart;
                cart = new int[10][2];
                int i = 0;
		while (temp != null)
		{
                        cart[i][0] = temp.product_id;
                        cart[i][1] = temp.amount;
                        i++;
                        temp = temp.next;
		}
                return cart;
        }
	public float getTotal()
	{
		// Returns the total price of items bought
		Node temp = new Node();
		temp = head;
		float total = 0.0f;
		while (temp != null)
		{
			total += temp.price * temp.amount;	// The amount of product bought * the original price of product
			temp = temp.next;
		}
		return total;
	}
	public void empty()
	{
		head = null;
	}
	public static void main(String[] args)
	{
		// For testing purpose only
		LinkedList product = new LinkedList();
	}
}
