package com.zy.cloud.mc.test.java8;

import java.util.Optional;
import java.util.function.Supplier;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OptionalTest {

	final Logger log = LoggerFactory.getLogger(getClass());

	@Test
	public void test1() {
		Optional<String> op = Optional.of("Java");
		log.info("{}", op.isPresent());
		log.info(op.get());
		log.info(op.orElse("HTML"));
		op.ifPresent(s -> System.out.println(s.charAt(0)));
	}

	@Test
	public void test2() {
		Optional.of(new Outer())
			.flatMap(o -> Optional.ofNullable(o.nested))
			.flatMap(n -> Optional.ofNullable(n.inner))
			.flatMap(i -> Optional.ofNullable(i.str))
			.ifPresent(System.out::println);
	}
	
	@Test
	public void test3() {
		Optional.of(new Outer())
			.map(Outer::getNested)
			.map(Nested::getInner)
			.map(Inner::get)
			.ifPresent(System.out::println);
	}
	
	@Test
	public void test4() {
		Outer outer = new Outer();
		resolve(() -> outer.getNested().getInner().get()).ifPresent(System.out::println);
	}

	public static <T> Optional<T> resolve(Supplier<T> resolve) {
		try {
			T result = resolve.get();
			return Optional.ofNullable(result);
		} catch (NullPointerException e) {
			return Optional.empty();
		}
	}

	static class Inner {
		String str = "hello";

		public String get() {
			return str;
		}
	}

	static class Nested {
		Inner inner = new Inner();

		public Inner getInner() {
			return inner;
		}
	}

	static class Outer {
		Nested nested = new Nested();

		public Nested getNested() {
			return nested;
		}
	}

}