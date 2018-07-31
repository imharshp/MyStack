

public class Stack<T> {

	private int size;
	private Node<T> top;
	private Node<T> temp;

	public Stack() {
		this.size = 0;
	}

	public boolean isEmpty() {
		return (size == 0);
	}

	public T peek() {
		if (!isEmpty())
			return top.getData();

		return null;
	}

	public void push(T value) {
		// O(1)
		if (isEmpty())
			top = new Node<T>(value);
		else {
			temp = new Node<T>(value);
			temp.setNext(top);
			top = temp;
		}
		size++;
		return;
	}

	public T pop() {
		// pop from the top
		// remove and return the stack top
		// return null for empty stack
		// O(1)
		if (!isEmpty()) {
			T ans = top.getData();
			size--;
			top = top.getNext();
			return ans;
		}

		return null;
	}

	private class Node<T> {

		private Node<T> next;
		private T data;

		private Node(T data) {
			this.data = data;
			this.next = null;
		}

		private T getData() {
			return this.data;
		}

		private Node<T> getNext() {
			return next;
		}

		private void setNext(Node<T> n) {
			next = n;
			return;
		}
	}

	
