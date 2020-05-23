package com.zy.cloud.mc.test.java8;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.Test;

public class StreamTest {

	List<String> list = Arrays.asList("ddd2", "aaa2", "bbb1", "aaa1", "bbb3", "ccc1", "bbb2", "ddd1");

	int max = 1000000;

	@Test
	public void test1() {
		list.stream().filter(s -> s.startsWith("a")).forEach(System.out::println);

		System.err.println("-------------------");
		list.stream().sorted().filter(s -> s.startsWith("a")).forEach(System.out::println);

		System.err.println("-------------------");
		list.stream().map(String::toUpperCase).sorted((x, y) -> y.compareTo(x)).forEach(System.out::println);

		System.err.println("-------------------");
		boolean m = list.stream().anyMatch(s -> s.startsWith("a"));
		System.out.println(m);

		System.err.println("-------------------");
		boolean a = list.stream().allMatch(s -> s.startsWith("a"));
		System.out.println(a);

		System.err.println("-------------------");
		boolean n = list.stream().noneMatch(s -> s.startsWith("z"));
		System.out.println(n);

		System.err.println("-------------------");
		long c = list.stream().filter(s -> s.startsWith("b")).count();
		System.out.println(c);

		Optional<String> r = list.stream().sorted().reduce((s1, s2) -> s1 + "," + s2);
		r.ifPresent(System.out::println);
	}

	@Test
	public void test2() {
		list.stream().sorted().forEach(System.out::println);
	}

	@Test
	public void test3() {
		List<String> vl = new ArrayList<>(max);
		for (int i = 0; i < max; i++) {
			vl.add(UUID.randomUUID().toString());
		}
		long t0 = System.nanoTime();
		System.out.println(t0);
		long count = vl.stream().sorted().count();
		System.out.println(count);
		long t1 = System.nanoTime();
		System.out.println(t1);
		long sub = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
		System.out.println(sub);
	}

	@Test
	public void test4() {
		List<String> vl = new ArrayList<>(max);
		for (int i = 0; i < max; i++) {
			vl.add(UUID.randomUUID().toString());
		}
		long t0 = System.nanoTime();
		System.out.println(t0);
		long count = vl.parallelStream().sorted().count();
		System.out.println(count);
		long t1 = System.nanoTime();
		System.out.println(t1);
		long sub = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
		System.out.println(sub);
	}

	@Test
	public void test5() {
		IntStream.range(0, 10).forEach(i -> {
			if (i % 2 == 1) {
				System.out.println(i);
			}
		});

		System.err.println("-------------------");
		IntStream.range(0, 10).filter(i -> i % 2 == 1).forEach(System.out::println);

		System.err.println("-------------------");
		OptionalInt r = IntStream.range(0, 10).reduce((x, y) -> x + y);
		System.out.println(r.getAsInt());

		System.err.println("-------------------");
		int i = IntStream.range(0, 100).reduce(100, (x, y) -> x + y);
		System.out.println(i);
	}

	@Test
	public void test6() {
		list.stream().filter(s -> {
			System.out.println("filter:" + s);
			return true;
		}).forEach(s -> System.err.println("forEach:" + s));
	}

	@Test
	public void test7() {
		list.stream().map(s -> {
			System.out.println("map:" + s);
			return s.toUpperCase();
		}).filter(s -> {
			System.out.println("filter:" + s);
			return s.startsWith("A");
		}).forEach(s -> System.err.println("forEach:" + s));
	}

	@Test
	public void test8() {
		list.stream().filter(s -> {
			System.out.println("filter:" + s);
			return s.startsWith("a");
		}).map(s -> {
			System.out.println("map:" + s);
			return s.toUpperCase();
		}).forEach(s -> System.err.println("forEach:" + s));
	}

	@Test
	public void test9() {
		list.stream().sorted((s1, s2) -> {
			System.out.printf("sort: %s - %s", s1, s2);
			return s1.compareTo(s2);
		}).filter(s -> {
			System.out.println("filter:" + s);
			return s.toLowerCase().startsWith("a");
		}).map(s -> {
			System.out.println("map:" + s);
			return s.toUpperCase();
		}).forEach(s -> System.err.println("forEach:" + s));
	}

	@Test
	public void test10() {
		list.stream().filter(s -> {
			System.out.println("filter:" + s);
			return s.toLowerCase().startsWith("a");
		}).sorted((s1, s2) -> {
			System.out.printf("sort: %s - %s", s1, s2);
			return s1.compareTo(s2);
		}).map(s -> {
			System.out.println("map:" + s);
			return s.toUpperCase();
		}).forEach(s -> System.err.println("forEach:" + s));
	}

	@Test
	public void test11() {
		boolean b = list.stream().map(s -> {
			System.out.println("map:" + s);
			return s.toUpperCase();
		}).anyMatch(s -> {
			System.out.println("anyMatch:" + s);
			return s.startsWith("A");
		});
		System.out.println(b);
	}

	@Test
	public void test12() {
		Stream<String> stm = list.stream().filter(s -> s.startsWith("a"));
		System.out.println(stm.anyMatch(s -> true));
		System.out.println(stm.noneMatch(s -> true));
	}

	@Test
	public void test13() {
		Supplier<Stream<String>> sp = () -> list.stream().filter(s -> s.startsWith("a"));
		System.out.println(sp.get().anyMatch(s -> true));
		System.out.println(sp.get().noneMatch(s -> true));
	}

	@Test
	public void test14() {
		int[] nums = { 1, 3, 5, 6, 8, 9 };
		Arrays.stream(nums).average().ifPresent(System.out::println);
	}

	@Test
	public void test15() {
		IntStream.builder().add(1).add(3).add(5).add(6).add(8).add(9).build().average().ifPresent(System.out::println);
	}

	@Test
	public void test16() {
		IntStream.range(0, 10).average().ifPresent(System.out::println);
	}

	@Test
	public void test17() {
		Stream.of(new BigDecimal(1.2), new BigDecimal(3.7)).mapToDouble(BigDecimal::doubleValue).average()
				.ifPresent(System.out::println);
	}

	static class Foo {
		String name;
		List<Bar> bars = new ArrayList<>();

		public Foo(String name) {
			this.name = name;
		}
	}

	static class Bar {
		String name;

		public Bar(String name) {
			this.name = name;
		}
	}
	
	@Test
	public void test18() {
		List<Foo> foos = new ArrayList<>();

		IntStream.range(1, 4).forEach(i -> foos.add(new Foo("Foo" + i)));
		foos.forEach(f -> IntStream.range(1, 4).forEach(i -> f.bars.add(new Bar("Bar" + i + "-->" + f.name))));

		foos.stream().flatMap(f -> f.bars.stream()).forEach(b -> System.out.println(b.name));
	}
	
	@Test
	public void test19() {
		IntStream.range(1, 4).mapToObj(i -> new Foo("Foo" + i)).peek(
				f -> IntStream.range(1, 4).mapToObj(j -> new Bar("Bar" + j + "-->" + f.name)).forEach(f.bars::add))
				.flatMap(f -> f.bars.stream()).forEach(b -> System.out.println(b.name));
	}

	@Test
	public void test20() {
		Arrays.asList("a1", "a2", "a3").stream().findFirst().ifPresent(System.out::println);
		Arrays.asList("a1", "a2", "a3").stream().map(s -> s.substring(1)).mapToInt(Integer::parseInt).max()
				.ifPresent(System.out::println);
		IntStream.range(1, 4).mapToObj(i -> "a" + i).forEach(System.out::println);
		Arrays.stream(new int[] { 1, 2, 3 }).map(n -> n * 2 + 1).average().ifPresent(System.out::println);
		Stream.of(1.0, 2.0, 3.0).mapToInt(Double::intValue).mapToObj(i -> "a" + i).forEach(System.out::println);
	}//Streams8

}