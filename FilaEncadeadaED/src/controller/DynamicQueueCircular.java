package controller;

public class DynamicQueueCircular {
	protected NodeDupEncad pri; 
	protected NodeDupEncad ult; 
	
	public DynamicQueueCircular() {
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
		NodeDupEncad current = pri;
		while (current != ult) {
			size++;
			current = current.getNext();
		}
		return (size + 1);
	}
	
	public char showFront() throws EmptyQueueException {
		if (isEmpty()) {
			throw new EmptyQueueException();
		}
		return pri.getElement();
	}
	
	public void enqueue(char element) {
		if (ult == null) {
			NodeDupEncad novo = new NodeDupEncad(element);
			pri = novo;
			ult = novo;
			pri.setNext(ult);
			ult.setNext(pri);
			pri.setPrevious(ult);
			ult.setPrevious(pri);
		} else {
			NodeDupEncad novo = new NodeDupEncad(element);
			NodeDupEncad temp = ult;
			ult.setNext(novo);
			ult = novo;
			ult.setNext(pri);
			ult.setPrevious(temp);
			pri.setPrevious(ult);
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
			ult.setNext(pri.getNext());
			pri = pri.getNext();
			pri.setPrevious(ult);
			if(pri == ult) {
				ult.setPrevious(pri);
			}
			return temp;
		}
	}
}
