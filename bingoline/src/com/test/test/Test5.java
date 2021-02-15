package com.test.test;

import java.util.HashMap;
import java.util.Map;

public class Test5 {

	public static void main(String[] args) {
		Map<Car, Boolean> map = new HashMap<>();
		Car c1 = new Car("c1", 1000);
		Car c2 = new Car("c2", 2000);
		Car c3 = new Car("c3", 3000);

		map.put(c1, true);
		map.put(c2, true);
		map.put(c3, true);

		System.out.println(map);

		map.put(new Car("c1", 4000), false);
		System.out.println(map);
		
		c2.price=6666;
		map.put(c2, false);
		System.out.println(map);

	}

	static class Car {
		String name;
		Integer price;

		Car(String name, int price) {
			this.name = name;
			this.price = price;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) {
				return true;
			}
			if (o == null) {
				return false;
			}
			if (this.getClass() != o.getClass()) {
				return false;
			}
			Car c = (Car) o;
			if (this.name == null) {
				if (c.name != null) {
					return false;
				}
			} else {
				if (!this.name.equals(c.name)) {
					return false;
				}
			}

			return true;
		}

		@Override
		public int hashCode() {
			return this.name.hashCode();
		}

		public String toString() {
			return String.format("%s %d", this.name, this.price);
		}

	}
}
