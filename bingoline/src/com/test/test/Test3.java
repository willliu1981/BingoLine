package com.test.test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Test3 {

	public static void main(String[] args) {

		Map <Car,Object >map=new HashMap<>();
		Integer i1=1;
		
		Car c=new Car("a1");
		map.put(c,"1");
		
		System.out.println(map.get(c).equals("1"));
		
		
		Car[] cars= {new Car("c1"),new Car("c2")};
		
		Arrays.asList(cars).forEach(System.out::println);
		
	}

	static class Car{
		String name;
		Car(String n){
			this.name=n;
		}
		
		public String toString() {
			return this.name;
		}
	}
	
}
