package controller;

public class NodeDupEncad {
	private char element; 
	private NodeDupEncad next, previous; 
	
	public NodeDupEncad(char c, NodeDupEncad n, NodeDupEncad p){
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
	
	public NodeDupEncad getNext(){ 
		return next; 
	}
	
	public NodeDupEncad getPrevious() {
		return previous;
	}
	
	public void setElement(char newElem){ 
		element = newElem; 
	}
	
	public void setNext(NodeDupEncad newNext){ 
		next = newNext; 
	}
	
	public void setPrevious(NodeDupEncad newPrevious) {
		previous = newPrevious;
	}
}
