package sof306.ph18485.demo1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import sof306.ph18485.beans.Student;

public class StreamAPI {
	
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
		Double double1 = students.stream().mapToDouble(sv -> sv.getMarks()).average().getAsDouble();
		System.out.println("average " + double1);

		double sum = students.stream().mapToDouble(sv -> sv.getMarks()).sum();
		System.out.println("sum " + sum);

		double min_marks = students.stream().mapToDouble(sv -> sv.getMarks()).min().getAsDouble();
		System.out.println("min " + min_marks);

		boolean all_passed = students.stream().allMatch(sv -> sv.getMarks() >= 5);
		System.out.println("all_passed " + all_passed);

		Student min_sv = students.stream().reduce(students.get(0),
				(min, sv) -> sv.getMarks() < min.getMarks() ? sv : min);
		System.out.println("Name " + min_sv.getName());
	}

	private static void demo3() {
		List<Student> list = students.stream().filter(t -> t.getMarks() > 5)
				.peek(t -> t.setName(t.getName().toUpperCase())).collect(Collectors.toList());
		list.forEach(n -> System.out.println(n));

	}

	private static void demo2() {
		List<Integer> list = Arrays.asList(1, 4, 6, 10, 11, 15);
		List<Double> list2 = list.stream().filter(t -> t % 2 == 0).map(s -> Math.sqrt(s))
				.peek(t -> System.out.println(t)).collect(Collectors.toList());

	}

	private static void demo1() {
		Stream<Integer> stream1 = Stream.of(1, 2, 4, 6);
		stream1.forEach(n -> System.out.println(n));

		List<Integer> list = Arrays.asList(1, 6, 8, 9);
		list.stream().forEach(n -> System.out.println(n));
	}
}
