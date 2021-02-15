package com.test.test;

import java.util.HashMap;
import java.util.Map;

public class Test4 {

	public static void main(String[] args) {
		Map<Car,Integer>map=new HashMap<>();
		Car c1=new Car("c1");
		Car c2=new Car("c2");
		Car c3=new Car("c3");
		map.put(c1, 1);
		map.put(c2, 2);
		map.put(c3, 3);
		map.forEach((x,y)->{
			System.out.println(String .format("%s %d",x.name,y));
		});
		
		System.out.println("------");
		map.put(c1, 4);
		map.forEach((x,y)->{
			System.out.println(String .format("%s %d",x.name,y));
		});
	}
	
	static class Car{
		String name;
		public Car(String name) {
			this.name=name;
		}
	}

}
