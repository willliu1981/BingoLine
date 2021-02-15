package com.bingo.controller;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Insets;
import java.awt.Panel;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JPanel;

import com.tool.graphic.GraphicScale;

public class BorderLayoutAutoSize {
	private final static String[] constrains = { BorderLayout.NORTH, BorderLayout.EAST, BorderLayout.WEST,
			BorderLayout.SOUTH, BorderLayout.CENTER };

	private static Map<Object, JPanel> toMap(JPanel outer) {
		Map<Object, JPanel> inners = new HashMap<>();
		Arrays.asList(constrains).stream().forEach(x -> {
			inners.put(x, (JPanel) ((BorderLayout) outer.getLayout()).getLayoutComponent(x));
		});
		return inners;
	}

	public static void autoSize(JPanel outer, int... gaps) {
		Map<Object, JPanel> inners = toMap(outer);
		int[] _gaps = new int[4];
		for (int i = 0; i < _gaps.length; i++) {
			_gaps[i] = i < gaps.length ? gaps[i] : 0;
		}
		Insets gapInset = new Insets(_gaps[0], _gaps[1], _gaps[2], _gaps[3]);
		GraphicScale scale = new GraphicScale(outer);
		
		
		
		
	}

}
