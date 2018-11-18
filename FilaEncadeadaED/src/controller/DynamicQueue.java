package controller;

public class DynamicQueue {
	protected Node pri; 
	protected Node ult; 
	
	public DynamicQueue() {
		pri = null;
		ult = null;
	}
	
	public boolean isEmpty() {
		return pri == null;
	}
	
	public int getSize() {
		int size = 0;
		if (pri == null) {
		return size;
		}
		Node current = pri;
		while (current != null) {
		size++;
		current = current.getNext();
		}
		return size;
	}
	
	public char showFront() throws EmptyQueueException {
		if (isEmpty()) {
			throw new EmptyQueueException();
		}
		return pri.getElement();
	}
	
	public void enqueue(char element) {
		if (ult == null) {
			Node novo = new Node(element);
			pri = novo;
			ult = novo;
		} else {
			Node novo = new Node(element);
			ult.setNext(novo);
			ult = novo;
		}
	}
	
	public char dequeue() throws EmptyQueueException {
		if (isEmpty()) {
			throw new EmptyQueueException();
		}
		if (pri == ult) {
			char temp = pri.getElement();
			pri = null;
			ult = null;
			return temp;
		} else {
			char temp = pri.getElement();
			pri = pri.getNext();
			return temp;
		}
	}
}
