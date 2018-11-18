package controller;

public class NodeDupEncad {
	private char element; 
	private Node next, previous; 
	
	public NodeDupEncad(char c, Node n, Node p){
		element = c;
		next = n;
		previous = p;
	}
	
	public NodeDupEncad(char element) { 
		this(element, null, null); 
	}
	
	public char getElement(){ 
		return element; 
	}
	
	public Node getNext(){ 
		return next; 
	}
	
	public Node getPrevious() {
		return previous;
	}
	
	public void setElement(char newElem){ 
		element = newElem; 
	}
	
	public void setNext(Node newNext){ 
		next = newNext; 
	}
	
	public void setPrevious(Node newPrevious) {
		previous = newPrevious;
	}
}
