package com.test.test;

import java.util.Arrays;

import com.bingo.model.BingoNumber;

public class Test6 {

	public static void main(String[] args) {
		BingoNumber b1=new BingoNumber();
		BingoNumber b2=new BingoNumber();
		BingoNumber b3=new BingoNumber();
		
		b1.setNumber(3);
		b2.setNumber(2);
		b3.setNumber(1);
		
		BingoNumber [] bs= {b1,b2,b3};
		Arrays.asList(bs).forEach(System.out::println);
		
		int max =Arrays.asList(bs).stream().reduce((a,b)->{
			if(b.getNumber()<a.getNumber()) {
				int temp=a.getNumber();
				a.setNumber(b.getNumber());
				b.setNumber(temp);
			}
			return b;
		}).get().getNumber();
		
		System.out.println(max);
		Arrays.asList(bs).forEach(System.out::println);
		
	}

}
