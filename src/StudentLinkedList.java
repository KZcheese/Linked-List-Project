/**
 * A linked list of Student type objects that can insert and sort by last name
 * and GPA.
 * 
 * @author Kevin Zhan
 * 
 */
public class StudentLinkedList {
	private StudentNode head;
	private int size = 0;

	/**
	 * Creates a new StudentNode using value and delegates to add(StudentNode
	 * node).
	 * 
	 * @param value
	 */
	public void add(Student value) {
		add(new StudentNode(value));
	}

	/**
	 * Creates a new StudentNode using value and delegates to add(int index,
	 * StudentNode node).
	 * 
	 * @param index
	 * @param value
	 */
	public void add(int index, Student value) {
		add(index, new StudentNode(value));
	}

	/**
	 * Adds a StudentNode to the end of the list.
	 * 
	 * @param node
	 */
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

	/**
	 * Adds a StudentNode to a position in the linked list specified by index.
	 * Throws IndexOutOfBoundsException when index is not a valid position in
	 * the list.
	 * 
	 * @param index
	 * @param node
	 * @throws IndexOutOfBoundsException
	 */
	private void add(int index, StudentNode node)
			throws IndexOutOfBoundsException {
		if (index < 0 || index > size)
			throw new IndexOutOfBoundsException("" + index + " " + size + " "
					+ node.value.getLastName());
		if (index == 0) {
			node.next = head;
			head = node;
		} else {
			StudentNode tempNode = head;
			for (int i = 0; i < index - 1; i++)
				tempNode = tempNode.next;
			node.next = tempNode.next;
			tempNode.next = node;
		}
		size++;
	}

	/**
	 * Gets the Student object of the node returned by removeNode(index);
	 * 
	 * @param value
	 */
	public Student removeStudent(int index) {
		return removeNode(index).value;
	}

	/**
	 * Removes the first student with a firstname, lastname, and GPA matching
	 * the given parameters.
	 * 
	 * @param firstName
	 * @param lastName
	 * @param GPA
	 * @return The node removed.
	 */
	public Student removeStudent(String firstName, String lastName, int GPA) {
		StudentNode node = head;
		int i = 0;
		while (node != null) {
			Student s = node.value;
			if (s.getFirstName().equals(firstName)
					&& s.getLastName().equals(lastName) && s.getGPA() == GPA)
				return removeStudent(i);
			i++;
			node = node.next;
		}
		return null;
	}

	/**
	 * Removes the s from the list if it exists in the list. Returns true if s
	 * exists in the list, and false if it doesn't.
	 * 
	 * @param s
	 * @return If s exists in the list.
	 */
	public boolean removeStudent(Student s) {
		StudentNode node = head;
		int i = 0;
		while (node != null) {
			Student st = node.value;
			if (st.equals(s)) {
				removeStudent(i);
				return true;
			}
			i++;
			node = node.next;
		}
		return false;
	}

	/**
	 * Gets the first student with a firstname, lastname, and GPA matching the
	 * given parameters.
	 * 
	 * @param firstName
	 * @param lastName
	 * @param GPA
	 * @return The first Student object with the matching firstname, lastname,
	 *         and GPA.
	 */
	public Student getStudent(String firstName, String lastName, int GPA) {
		StudentNode node = head;
		while (node != null) {
			Student s = node.value;
			if (s.getFirstName().equals(firstName)
					&& s.getLastName().equals(lastName) && s.getGPA() == GPA)
				return s;
			node = node.next;
		}
		return null;
	}

	/**
	 * Removes the StudentNode at the given index of the list. Throws
	 * IndexOutOfBoundsException if index is not a valid value of the list.
	 * 
	 * @param index
	 * @return The node removed.
	 * @throws IndexOutOfBoundsException
	 */
	private StudentNode removeNode(int index) throws IndexOutOfBoundsException {
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

	/**
	 * Gets the Student object at the given index of the list. Throws
	 * IndexOutOfBoundsException if list is not a valid value of list.
	 * 
	 * @param index
	 * @return The node at index.
	 * @throws IndexOutOfBoundsException
	 */
	public Student get(int index) throws IndexOutOfBoundsException {
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException("" + index);
		StudentNode tempNode = head;
		for (int i = 0; i < index; i++)
			tempNode = tempNode.next;
		return tempNode.value;
	}

	/**
	 * Sets the Student object at the given index of the list to Value. Throws
	 * IndexOutOfBoundsException if list is not a valid value of list.
	 * 
	 * @param index
	 * @throws IndexOutOfBoundsException
	 */
	/**
	 */
	public void set(int index, Student value) throws IndexOutOfBoundsException {
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException("" + index);
		StudentNode tempNode = head;
		for (int i = 0; i < index; i++)
			tempNode = tempNode.next;
		tempNode.value = value;
	}

	/**
	 * Creates a new Node using s and delegates to insertByLastName(StudentNode
	 * n).
	 * 
	 * @param s
	 */
	public void insertByLastName(Student s) {
		insertByLastName(new StudentNode(s));
	}

	/**
	 * Adds n to the proper position in list based on it's last name.
	 * 
	 * @param s
	 */
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

	/**
	 * Creates a new Node using s and delegates to insertByAverage(StudentNode
	 * n).
	 * 
	 * @param s
	 */
	public void insertByAverage(Student s) {
		insertByAverage(new StudentNode(s));
	}

	/**
	 * Adds n to the proper position in list based on it's GPA.
	 * 
	 * @param s
	 */
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

	/**
	 * Sorts the Student objects in list based on their GPA from least to
	 * greates.
	 */
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

	/**
	 * Sorts the Student objects in list based on their last names in
	 * alphabetical order.
	 */
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

	/**
	 * Returns a String of the size of the list followed by the String forms of
	 * the stored Students in the order they are stored in the list.
	 * 
	 * @return A string represenation of StudentLinkedList
	 */
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

	/**
	 * A node used in StudentLinkedList that stores a Student object and a next
	 * StudentNode.
	 * 
	 * @author 16zhank
	 * 
	 */
	private class StudentNode {
		public StudentNode next;
		public Student value;

		/**
		 * S is stored as the node's value, next is stored as the next node in
		 * the list.
		 * 
		 * @param s
		 * @param next
		 */
		public StudentNode(Student s, StudentNode next) {
			this.next = next;
			value = s;
		}

		/**
		 * Delegates to StudentNode(Student s, StudentNode next) with next as
		 * null;
		 * 
		 * @param s
		 */
		public StudentNode(Student s) {
			this(s, null);
		}
	}

	/**
	 * Test code following the assignment directions given.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		StudentLinkedList list = new StudentLinkedList();
		list.insertByLastName(new Student("Thomas", "Edgars", 89));
		list.insertByLastName(new Student("Jennifer", "Smith", 86));
		list.insertByLastName(new Student("Harold", "Umberton", 78));
		list.insertByLastName(new Student("Frank", "Martin", 60));
		list.insertByLastName(new Student("Jeremy", "Andrews", 83));
		list.insertByLastName(new Student("Laura", "Roberts", 93));
		list.insertByLastName(new Student("Adele", "Lincoln", 85));
		list.insertByLastName(new Student("Peter", "Smith", 91));
		list.insertByLastName(new Student("Peterson", "Larry", 72));
		System.out.println(list);
		System.out.println();

		System.out.println("Removing Frank");
		System.out.println(list.removeStudent("Frank", "Martin", 60));
		// System.out.println(list.removeStudent(list.getStudent("Frank",
		// "Martin", 60)));
		System.out.println(list);
		System.out.println();

		System.out.println("Sorting by Average");
		list.sortByAverage();
		System.out.println(list);
		System.out.println();

		System.out.println("Adding Alice Henderson");
		list.insertByAverage(new Student("Alice", "Henderson", 90));
		System.out.println(list);
		System.out.println();

		System.out.println("Sorting by Last Name");
		list.sortByLastName();
		System.out.println(list);
	}
}
