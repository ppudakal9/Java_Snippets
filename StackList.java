package com.snippets;

class StackNode {
	public int data;
	public StackNode next;
	StackNode(int data) {
		this.data = data;	
	}
}
public class StackList {
	public static StackNode root;
	StackList() {
		this.root = null;
	}
	
	public static boolean isEmpty() {
		if(root == null) {
			return true;
		}
		return false;
	}
	
	public void push(int data) {
		StackNode newNode = new StackNode(data);
		newNode.next = root;
		root = newNode;
		System.out.println("%d pushed to stack" +data);
	}
	
	public int pop() {
		if(isEmpty()) {
			return 0;
		}
		StackNode temp = root;
		root = root.next;
		int popped = temp.data;
		return popped;
	}
	
	public int peek() {
		if(isEmpty()) {
			return 0;
		}
		return root.data;
	}
	
	
}

