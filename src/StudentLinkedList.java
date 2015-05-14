public class StudentLinkedList {
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
