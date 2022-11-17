package sof306.ph18485.demo1;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import sof306.ph18485.beans.Student;

public class Lambda {
	
	private static List<Student> students = Arrays.asList(
			new Student("Nguyễn Văn A", true, 7.0),
			new Student("Nguyễn Văn B", true, 9.0),
			new Student("Nguyễn Văn C", true, 7.5),
			new Student("Nguyễn Văn D", true, 8.0)
		);

	public static void main(String[] args) {
		demo4();
	}

	private static void demo4() {
		Demo4Inter o = new Demo4Inter() {
			
			@Override
			public void m1(int x) {
				System.out.println(x);
			}
		};
		o.m1(2022);
		
		Demo4Inter o2 = x -> System.out.println(x);
		o2.m1(2023);
	}

	private static void demo3() {
		Collections.sort(students, (sv1, sv2) -> sv1.getMarks().compareTo(sv2.getMarks()));
		students.forEach(sv -> {
			System.out.println("Name: " + sv.getName());
			System.out.println("Marks: " + sv.getMarks());
			System.out.println("------------------------");
		});
	}

	private static void demo2() {
		students.forEach(sv -> {
			System.out.println("Name: " + sv.getName());
			System.out.println("Marks: " + sv.getMarks());
			System.out.println("------------------------");
		});
	}

	private static void demo1() {
		List<Integer> list = Arrays.asList(1, 4, 7, 10);
		list.forEach(n -> System.out.println(n));
	}
}

@FunctionalInterface
interface Demo4Inter {
	
	void m1(int x);
	
	default void m2() {
	}
	
	public static void m3() {
	}
}
