package com.tool.graphic;


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
		return comp.getInsets().left + this.getW();
	}

	public int getY1() {
		return comp.getInsets().top;
	}

	public int getY2() {
		return comp.getInsets().top + this.getH();
	}

	public int getW() {
		return comp.getWidth() - (comp.getInsets().left + comp.getInsets().right);
	}

	public int getH() {
		return comp.getHeight() - (comp.getInsets().top + comp.getInsets().bottom);
	}

}
