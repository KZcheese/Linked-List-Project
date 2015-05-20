public class LinkedList<E extends Comparable<E>> {
	private Node head;
	private int size = 0;

	public void add(E value) {
		add(new Node(value));
	}

	public void add(int index, E value) {
		add(index, new Node(value));
	}

	private void add(Node node) {
		node.next = null;
		if (size < 1)
			head = node;
		else {
			Node tempNode = head;
			while (tempNode.next != null)
				tempNode = tempNode.next;
			tempNode.next = node;
		}
		size++;
	}

	private void add(int index, Node node) {
		if (index < 0 || index > size)
			throw new IndexOutOfBoundsException("" + index);
		if (index == 0) {
			node.next = head;
			head = node;
			return;
		} else {
			Node tempNode = head;
			for (int i = 0; i < index - 1; i++)
				tempNode = tempNode.next;
			node.next = tempNode.next;
			tempNode.next = node;
		}
		size++;
	}

	public E removeStudent(int index) {
		return removeNode(index).value;
	}

	private Node removeNode(int index) {
		if (index < 0 || index > size)
			throw new IndexOutOfBoundsException("" + index);
		Node tempNode = head;
		size--;
		for (int i = 0; i < index - 1; i++)
			tempNode = tempNode.next;
		if (index == size - 1) {
			tempNode.next = null;
			return null;
		} else {
			Node tempNodeNext = tempNode.next;
			tempNode.next = tempNode.next.next;
			return tempNodeNext;
		}
	}

	public E get(int index) {
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException("" + index);
		Node tempNode = head;
		for (int i = 0; i < index; i++)
			tempNode = tempNode.next;
		return tempNode.value;
	}

	public void set(int index, E value) {
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException("" + index);
		Node tempNode = head;
		for (int i = 0; i < index; i++)
			tempNode = tempNode.next;
		tempNode.value = value;
	}

	public void Sort() {
		LinkedList<E> newList = new LinkedList<E>();
		Node node = head;
		while (node != null)
			newList.insertSorted(node);
		this.head = newList.head;
	}

	public void insertSorted(E value) {
		insertSorted(new Node(value));
	}

	private void insertSorted(Node node) {
		Node node2 = head;
		int i = 0;
		while (node2 != null) {
			if (node.value.compareTo(node2.value) <= 0) {
				add(i, node);
				return;
			}
			i++;
		}
	}

	public String toString() {
		Node tempNode = head;
		String out = "";
		out += "Size:" + size;
		while (tempNode != null) {
			out += "\n" + (tempNode.value);
			tempNode = tempNode.next;
		}
		return out;
	}

	private class Node {
		public Node next;
		public E value;

		public Node(E value) {
			this(value, null);
		}

		public Node(E value, Node next) {
			this.value = value;
			this.next = next;
		}
	}

}
