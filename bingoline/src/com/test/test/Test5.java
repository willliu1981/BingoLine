package com.test.test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.bingo.model.BingoNumber;

public class Test5 {

	public static void main(String[] args) {
		/*
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
		
		Object cc=new Car(null, 0);
		cc=(Car)cc;
		
		Car c=(Car)cc;
		*///
		
		Map<BingoNumber,Integer> map=new HashMap<>();
		BingoNumber b1=new BingoNumber();
		BingoNumber b2=new BingoNumber();
		BingoNumber b3=new BingoNumber();
		b1.setNumber(1);
		b1.setPoint(1,1);
		b2.setNumber(2);
		b2.setPoint(2,2);
		b3.setNumber(3);
		b3.setPoint(3,3);
		
		map.put(b1, 10);
		map.put(b2, 20);
		map.put(b3, 30);
		System.out.println(map);
		
		BingoNumber b4=new BingoNumber();
		b4.setNumber(1);
		b4.setPoint(4,4);
		map.put(b4, 40);
		System.out.println(map);
		
		b1.setPoint(5,5);
		map.put(b1, 50);
		System.out.println(map);
		
		int[] ii= {2,4,1,6,4,7};
		
		int sum=Arrays.stream(ii).reduce(0, (a,b)->a+b);
		
		
		
				/*
		int sum=Arrays.asList(ii).stream().reduce(0, (x,y)->{
			return x+y;
		});
		*///
				
		System.out.println(sum);
		
		
	}

	static class Car {
		String name;
		Integer price;

		Car(String name, int price) {
			this.name = name;
			this.price = price;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Integer getPrice() {
			return price;
		}

		public void setPrice(Integer price) {
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
