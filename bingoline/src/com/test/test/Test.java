package com.test.test;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JPanel;

public class Test {

	public static void main(String[] args) {
		
		JPanel jp = new JPanel();
		JPanel jp2 = new JPanel();
		jp.setLayout(new BorderLayout());


		JPanel p2 = new JPanel();
		jp.add(p2, BorderLayout.WEST);
		p2.setName("w2");

		JPanel p1 = new JPanel();
		jp.add(p1, BorderLayout.WEST);
		p1.setName("w1");
		
//		for(Component comp:jp.getComponents()) {
//			System.out.println("test:" + comp.getName());
//			if(comp.getName().equalsIgnoreCase("w"))
//			((FlowLayout)((JPanel)comp).getLayout()).setHgap(50);
//		}
		
	System.out.println	(((BorderLayout)jp.getLayout()).getLayoutComponent(BorderLayout.WEST).getName());
	System.out.println	(((BorderLayout)jp.getLayout()).getLayoutComponent(jp2, BorderLayout.WEST).getName());
	
	}

}
