package java_collections_uses;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class AgeComparator implements Comparator<Student> {
	public int compare(Student s1, Student s2) {
		if (s1.age == s2.age)
			return 0;
		else if (s1.age > s2.age)
			return 1;
		else
			return -1;
	}
}

class NameComparator implements Comparator<Student> {
	public int compare(Student s1, Student s2) {
		return s1.name.compareTo(s2.name);
	}
}
/*
 * 
Difference between Comparable and Comparator in Java. 
Comparable and comparator both are an interface that can be used to sort the elements of the collection. ... 
Comparator interface sort collection using two objects provided to it,
whereas comparable interface compares" this" refers to the one objects provided to it

*/

public class TestComparator {
	public static void main(String[] args) {
		// Creating a list of students
		ArrayList<Student> al = new ArrayList<Student>();
		al.add(new Student(101, "Vijay", 23));
		al.add(new Student(106, "Ajay", 27));
		al.add(new Student(105, "Jai", 21));

		System.out.println("Sorting by Name");
		// Using NameComparator to sort the elements
		Collections.sort(al, new NameComparator());
		// Traversing the elements of list
		for (Student st : al) {
			System.out.println(st.rollno + " " + st.name + " " + st.age);
		}

		System.out.println("sorting by Age");
		// Using AgeComparator to sort the elements
		Collections.sort(al, new AgeComparator());
		// Traversing the list again
		for (Student st : al) {
			System.out.println(st.rollno + " " + st.name + " " + st.age);
		}

	}
}
