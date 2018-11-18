package controller;

public class DynamicQueueDeque {
	protected Node pri, pri1; 
	protected Node ult, ult1; 
	
	public DynamicQueueDeque() {
		pri = null;
		ult = null;
		pri1 = null;
		ult1 = null;
	}
	
	public boolean isEmpty(int fila) {//Checa se uma das listas esta vazia
		return (fila == 1) ? pri == null : pri1 == null;
	}
	
	public int getSize(int fila) {
		int size = 0;
		if(fila == 1) {
			if (pri == null) {
				return size;
			}
			Node current = pri;
			while (current != ult.getNext()) {
				size++;
				current = current.getNext();
			}
		}else {
			if (pri1 == null) {
				return size;
			}
			Node current = pri1;
			while (current != ult1.getNext()) {
				size++;
				current = current.getNext();
			}
		}
		return size;
	}
	
	public char showFront(int fila) throws EmptyQueueException {
		if (isEmpty(fila)) {
			throw new EmptyQueueException();
		}
		return (fila == 1) ? pri.getElement() : pri1.getElement();
	}
	
	public void enqueue(char element, int fila) {
		if(fila == 1) {
			if (ult == null) {
				Node novo = new Node(element);
				pri = novo;
				ult = novo;
				ult.setNext(pri1);
			} else {
				Node novo = new Node(element);
				ult.setNext(novo);
				ult = novo;
				ult.setNext(pri1);
			}
		}else {
			if (ult1 == null) {
				Node novo = new Node(element);
				pri1 = novo;
				ult1 = novo;
			} else {
				Node novo = new Node(element);
				ult1.setNext(novo);
				ult1 = novo;
			}
		}
	}
	
	public char dequeue(int fila) throws EmptyQueueException {
		if (isEmpty(fila)) {
			throw new EmptyQueueException();
		}
		if(fila == 1) {
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
		}else {
			if (pri1 == ult1) {
				char temp = pri1.getElement();
				pri1 = null;
				ult1 = null;
				return temp;
			} else {
				char temp = pri1.getElement();
				pri1 = pri1.getNext();
				return temp;
			}
		}
	}
}
