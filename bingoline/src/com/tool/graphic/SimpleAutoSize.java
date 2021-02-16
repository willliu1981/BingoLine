package com.tool.graphic;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.MediaTracker;
import java.awt.Panel;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JPanel;

public class SimpleAutoSize {
	private final static String[] constrains = { BorderLayout.NORTH, BorderLayout.EAST, BorderLayout.WEST,
			BorderLayout.SOUTH, BorderLayout.CENTER };

	private static Map<Object, JPanel> toMap(JPanel outer) {
		Map<Object, JPanel> inners = new HashMap<>();
		Arrays.asList(constrains).stream().forEach(x -> {
			inners.put(x, (JPanel) ((BorderLayout) outer.getLayout()).getLayoutComponent(x));
		});
		return inners;
	}

	public static void autoSize(JPanel outer, int gap) {
		GraphicScale scale = new GraphicScale(outer);
		if (scale.getInnerW() > scale.getInnerH()) {
			int offset = scale.getInnerW() - scale.getInnerH();
			offset /= 4;
			((FlowLayout) ((JPanel) ((BorderLayout) outer.getLayout()).getLayoutComponent(BorderLayout.WEST))
					.getLayout()).setHgap(gap + offset);
			((FlowLayout) ((JPanel) ((BorderLayout) outer.getLayout()).getLayoutComponent(BorderLayout.EAST))
					.getLayout()).setHgap(gap + offset);
		} else {
			int offset = scale.getInnerH() - scale.getInnerW();
			System.out.println("xxxx2:" + scale.getComponent().getWidth());
			offset /= 2;
			((FlowLayout) ((JPanel) ((BorderLayout) outer.getLayout()).getLayoutComponent(BorderLayout.NORTH))
					.getLayout()).setVgap(gap + offset);
			((FlowLayout) ((JPanel) ((BorderLayout) outer.getLayout()).getLayoutComponent(BorderLayout.SOUTH))
					.getLayout()).setVgap(gap + offset);
		}
		outer.revalidate();
	}

	public static int getSlatWidth(int width, int quantity, int gap) {
		return (width - gap * (quantity + 1)) / quantity;
	}

	/*
	 * public static void autoSize(JPanel outer, int... gaps) { Map<Object, JPanel>
	 * inners = toMap(outer); int[] _gaps = new int[4]; for (int i = 0; i <
	 * _gaps.length; i++) { _gaps[i] = i < gaps.length ? gaps[i] : 0; } Insets
	 * gapInset = new Insets(_gaps[0], _gaps[1], _gaps[2], _gaps[3]); GraphicScale
	 * scale = new GraphicScale(outer);
	 * 
	 * }
	 *///

}
