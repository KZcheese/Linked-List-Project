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
		}
		size++;
	}

	public void add(int index, Student value) {
		if (index < 0 || index > size)
			throw new IndexOutOfBoundsException("" + index);
		StudentNode node = new StudentNode(value);
		if (index == 0) {
			node.next = head;
			head = node;
			return;
		} else {
			StudentNode tempNode = head;
			for (int i = 0; i < index - 1; i++)
				tempNode = tempNode.next;
			node.next = tempNode.next;
			tempNode.next = node;
		}
		size++;
	}

	private void add(StudentNode node) {
		node.next = null;
		if (size < 1)
			head = node;
		else {
			StudentNode tempNode = head;
			while (tempNode.next != null)
				tempNode = tempNode.next;
			tempNode.next = node;
		}
		size++;
	}

	private void add(int index, StudentNode node) {
		if (index < 0 || index > size)
			throw new IndexOutOfBoundsException("" + index + " " + size + " "
					+ node.value.getLastName());
		if (index == 0) {
			node.next = head;
			head = node;
			return;
		} else {
			StudentNode tempNode = head;
			for (int i = 0; i < index - 1; i++)
				tempNode = tempNode.next;
			node.next = tempNode.next;
			tempNode.next = node;
		}
		size++;
	}

	public Student removeStudent(int index) {
		return removeNode(index).value;
	}

	private StudentNode removeNode(int index) {
		if (index < 0 || index > size)
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
			if (s.getLastName().compareToIgnoreCase(node.value.getLastName()) <= 0) {
				add(i, s);
				return;
			}
			i++;
			node = node.next;
		}
		add(s);
	}

	private void insertByLastName(StudentNode n) {
		StudentNode node = head;
		int i = 0;
		while (node != null) {
			if (n.value.getLastName().compareToIgnoreCase(
					node.value.getLastName()) <= 0) {
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
			if (s.getGPA() <= node.value.getGPA()) {
				add(i, s);
				return;
			}
			i++;
			node = node.next;
		}
		add(s);
	}

	private void insertByAverage(StudentNode n) {
		StudentNode node = head;
		int i = 0;
		while (node != null) {
			if (n.value.getGPA() <= node.value.getGPA()) {
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
		StudentNode next;
		StudentLinkedList newList = new StudentLinkedList();
		while (node != null) {
			next = node.next;
			newList.insertByAverage(node);
			node = next;
		}
		this.head = newList.head;
	}

	public void sortByLastName() {
		StudentNode node = head;
		StudentNode next;
		StudentLinkedList newList = new StudentLinkedList();
		while (node != null) {
			next = node.next;
			newList.insertByLastName(node);
			node = next;
		}
		this.head = newList.head;
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

	public static void main(String[] args) {
		StudentLinkedList list = new StudentLinkedList();
		list.add(new Student("Thomas", "Edgars", 89));
		list.add(new Student("Jennifer", "Smith", 86));
		list.add(new Student("Harold", "Umberton", 78));
		list.add(new Student("Frank", "Martin", 60));
		list.add(new Student("Jeremy", "Andrews", 83));
		list.add(new Student("Laura", "Roberts", 93));
		list.add(new Student("Adele", "Lincoln", 85));
		list.add(new Student("Peter", "Smith", 85));
		list.add(new Student("Peterson", "Larry", 85));

		System.out.println(list);
		System.out.println();
//		System.out.println("LastName");
//		list.sortByLastName();
//		System.out.println(list);
//		System.out.println("Average");
//		list.sortByAverage();
//		System.out.println(list);
		System.out.println(list.removeStudent(3));
		System.out.println();
		System.out.println(list);
	}
}
