package com.tool.graphic;

import java.awt.Component;

import javax.swing.JComponent;

public class GraphicScale {
	private JComponent comp;

	public GraphicScale(JComponent comp) {
		this.comp = comp;
	}

	public int getX1() {
		return comp.getInsets().left;
	}

	public int getX2() {
		return comp.getInsets().left + this.getInnerW();
	}

	public int getY1() {
		return comp.getInsets().top;
	}

	public int getY2() {
		return comp.getInsets().top + this.getInnerH();
	}

	public int getInnerW() {
		return comp.getWidth() - (comp.getInsets().left + comp.getInsets().right);
	}

	public int getInnerH() {
		return comp.getHeight() - (comp.getInsets().top + comp.getInsets().bottom);
	}

	public int getComponentW() {
		return this.comp.getWidth();
	}

	public int getComponentH() {
		return this.comp.getHeight();
	}
	
	public JComponent getComponent() {
		return this.comp;
	}

}
