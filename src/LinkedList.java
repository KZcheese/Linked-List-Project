public class LinkedList<E> {
	private Node<E> head;
	private int size = 0;

	public void add(E value) {
		Node<E> node = new Node<E>(value);
		if (size < 1)
			head = node;
		else {
			Node<E> tempNode = head;
			while (tempNode.getNext() != null)
				tempNode = tempNode.getNext();
			tempNode.setNext(node);
			size++;
		}
	}

	public E get(int index) {
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException("" + index);
		Node<E> tempNode = head;
		for (int i = 0; i < index; i++)
			tempNode = tempNode.getNext();
		return tempNode.getValue();
	}

	public void set(int index, E value) {
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException("" + index);
		Node<E> tempNode = head;
		for (int i = 0; i < index; i++)
			tempNode = tempNode.getNext();
		tempNode.setValue(value);
	}

	public String toString() {
		Node<E> tempNode = head;
		String out = "";
		out += "Size:" + size;
		while (tempNode.getNext() != null) {
			out += "\n" + (tempNode.getValue());
			tempNode = tempNode.getNext();
		}
		return out;
	}

	private class Node<E> {
		public Node<E> next;
		E value;

		public Node(E value) {
			this(value, null);
		}

		public Node(E value, Node<E> next) {
			this.value = value;
			this.next = next;
		}

		public Node<E> getNext() {
			return next;
		}

		public void setNext(Node<E> next) {
			this.next = next;
		}

		public E getValue() {
			return value;
		}

		public void setValue(E value) {
			this.value = value;
		}
	}
}
