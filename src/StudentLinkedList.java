/*You should write a method for each of the above tasks (insertByLastName, 
removeStudent, sortByAverage, insertByAverage, and sortByLastName) in a class called 
StudentList. You may find it helpful to have private overloaded versions of some of these 
methods.*/
public class StudentLinkedList {
	private StudentNode head;
	private int size = 0;

	public void add(Student value) {
		StudentNode node = new StudentNode(value);
		if (size < 1)
			head = node;
		else {
			StudentNode tempNode = head;
			while (tempNode.next != null)
				tempNode = tempNode.next;
			tempNode.next = node;
			size++;
		}
	}

	public void add(int index, Student value) {
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException("" + index);
		StudentNode tempNode = head;
		StudentNode node = new StudentNode(value);
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

	public void add(StudentNode node) {
		if (size < 1)
			head = node;
		else {
			StudentNode tempNode = head;
			while (tempNode.next != null)
				tempNode = tempNode.next;
			tempNode.next = node;
			size++;
		}
	}

	public void add(int index, StudentNode node) {
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException("" + index);
		StudentNode tempNode = head;
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

	public Student remove(int index) {
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException("" + index);
		StudentNode tempNode = head;
		size--;
		for (int i = 0; i < index - 1; i++)
			tempNode = tempNode.next;
		if (index == size - 1) {
			tempNode.next = null;
			return null;
		} else {
			StudentNode tempNodeNext = tempNode.next;
			tempNode.next = tempNode.next.next;
			return tempNodeNext.value;
		}
	}

	public StudentNode removeNode(int index) {
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException("" + index);
		StudentNode tempNode = head;
		size--;
		for (int i = 0; i < index - 1; i++)
			tempNode = tempNode.next;
		if (index == size - 1) {
			tempNode.next = null;
			return null;
		} else {
			StudentNode tempNodeNext = tempNode.next;
			tempNode.next = tempNode.next.next;
			return tempNodeNext;
		}
	}

	public Student get(int index) {
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException("" + index);
		StudentNode tempNode = head;
		for (int i = 0; i < index; i++)
			tempNode = tempNode.next;
		return tempNode.value;
	}

	public void set(int index, Student value) {
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException("" + index);
		StudentNode tempNode = head;
		for (int i = 0; i < index; i++)
			tempNode = tempNode.next;
		tempNode.value = value;
	}

	public void insertByLastName(Student s) {
		StudentNode node = head;
		int i = 0;
		while (node != null) {
			if (s.getLastName().compareToIgnoreCase(node.value.getLastName()) < 0) {
				add(i, s);
				return;
			}
			i++;
			node = node.next;

		}
		add(s);
	}

	public void insertByLastName(StudentNode n) {
		StudentNode node = head;
		int i = 0;
		while (node != null) {
			if (n.value.getLastName().compareToIgnoreCase(
					node.value.getLastName()) < 0) {
				add(i, n);
				return;
			}
			node = node.next;
			i++;
		}
		add(n);
	}

	public void insertByAverage(Student s) {
		StudentNode node = head;
		int i = 0;
		while (node != null) {
			if (s.getGPA() < node.value.getGPA()) {
				add(i, s);
				return;
			}
			i++;
			node = node.next;

		}
		add(s);
	}

	public void insertByAverage(StudentNode n) {
		StudentNode node = head;
		int i = 0;
		while (node != null) {
			if (n.value.getGPA() < node.value.getGPA()) {
				add(i, n);
				return;
			}
			i++;
			node = node.next;

		}
		add(n);
	}

	public void sortByAverage() {
		StudentNode node = head;
		StudentNode next = head.next;
		StudentLinkedList newList = new StudentLinkedList();
		while (node != null) {
			newList.insertByAverage(node);
			node = next;
			next = node.next;
		}
	}

	public void sortByLastName() {
		StudentNode node = head;
		StudentNode next = head.next;
		StudentLinkedList newList = new StudentLinkedList();
		while (node != null) {
			newList.insertByLastName(node);
			node = next;
			next = node.next;
		}
	}

	public String toString() {
		StudentNode tempNode = head;
		String out = "";
		out += "Size:" + size;
		while (tempNode != null) {
			out += "\n" + (tempNode.value);
			tempNode = tempNode.next;
		}
		return out;
	}

	private class StudentNode {
		public StudentNode next;
		public Student value;

		public StudentNode(Student s, StudentNode next) {
			this.next = next;
			value = s;
		}

		public StudentNode(Student s) {
			this(s, null);
		}
	}
}
