public class LinkedList<E extends Comparable<E>> {
	private Node head;
	private int size = 0;

	public void add(E value) {
		Node node = new Node(value);
		if (size < 1)
			head = node;
		else {
			Node tempNode = head;
			while (tempNode.next != null)
				tempNode = tempNode.next;
			tempNode.next = node;
			size++;
		}
	}

	public void add(int index, E value) {
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException("" + index);
		Node tempNode = head;
		Node node = new Node(value);
		size++;
		for (int i = 0; i < index - 1; i++)
			tempNode = tempNode.next;
		if (index == size) {
			tempNode.next = node;
		} else {
			node.next = tempNode.next;
			tempNode.next = node;
		}
	}

	public void add(Node node) {
		if (size < 1)
			head = node;
		else {
			Node tempNode = head;
			while (tempNode.next != null)
				tempNode = tempNode.next;
			tempNode.next = node;
			size++;
		}
	}

	public void add(int index, Node node) {
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException("" + index);
		Node tempNode = head;
		size++;
		for (int i = 0; i < index - 1; i++)
			tempNode = tempNode.next;
		if (index == size) {
			tempNode.next = node;
		} else {
			node.next = tempNode.next;
			tempNode.next = node;
		}
	}

	public E remove(int index) {
		if (index < 0 || index >= size)
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
			return tempNodeNext.value;
		}
	}

	public Node removeNode(int index) {
		if (index < 0 || index >= size)
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

	public String toString() {
		Node tempNode = head;
		String out = "";
		out += "Size:" + size;
		while (tempNode.next != null) {
			out += "\n" + (tempNode.value);
			tempNode = tempNode.next;
		}
		return out;
	}

	public void sort() {
		LinkedList<E> newList = new LinkedList<E>();
		Node n = head;
		while (n.next != null) {
			boolean isSet = false;
			for (int i = 0; i < newList.size(); i++) {
				E value = newList.get(i);
				if (value.compareTo(n.value) < 0) {
					newList.add(i, n);
					isSet = true;
					break;
				}
			}
			if (!isSet)
				newList.add(n);
			n = head.next;
		}
		this.head = newList.head;
	}

	public int size() {
		return size;
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
