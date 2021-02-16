package com.tool.graphic;

import java.awt.Graphics;
import java.util.Map;

import javax.swing.JComponent;

import com.bingo.model.BingoNumber;

public class Draws {
	GraphicScale scale;
	int outer_gap;
	int inner_gap;
	int outer_arc;
	int inner_arc;
	int slatWidth;

	public Draws(JComponent comp) {
		this.scale = new GraphicScale(comp);
	}

	public static int calculateSlatWidth(int width, int quantity, int gap) {
		return (width - gap * (quantity + 1)) / quantity;
	}

	public GraphicScale getScale() {
		return scale;
	}

	public int getOuter_gap() {
		return outer_gap;
	}

	public void setOuter_gap(int outer_gap) {
		this.outer_gap = outer_gap;
	}

	public int getInner_gap() {
		return inner_gap;
	}

	public void setInner_gap(int inner_gap) {
		this.inner_gap = inner_gap;
	}

	public int getOuter_arc() {
		return outer_arc;
	}

	public void setOuter_arc(int outer_arc) {
		this.outer_arc = outer_arc;
	}

	public int getInner_arc() {
		return inner_arc;
	}

	public void setInner_arc(int inner_arc) {
		this.inner_arc = inner_arc;
	}

	public int getSlatWidth() {
		return slatWidth;
	}

	public void setSlatWidth(int quantity) {
		this.setSlatWidth(quantity, 0);
	}

	public void setSlatWidth(int quantity, int fix_w) {
		this.slatWidth = calculateSlatWidth(this.scale.getInnerH() - this.outer_gap * 2, quantity, this.inner_gap)
				+ fix_w;
	}

	public int getX1() {
		return this.scale.getComponent().getInsets().left;
	}

	public int getX2() {
		return this.scale.getComponent().getInsets().left + this.getInnerW();
	}

	public int getY1() {
		return this.scale.getComponent().getInsets().top;
	}

	public int getY2() {
		return this.scale.getComponent().getInsets().top + this.getInnerH();
	}

	public int getInnerW() {
		return this.scale.getComponent().getWidth()
				- (this.scale.getComponent().getInsets().left + this.scale.getComponent().getInsets().right);
	}

	public int getInnerH() {
		return this.scale.getComponent().getHeight()
				- (this.scale.getComponent().getInsets().top + this.scale.getComponent().getInsets().bottom);
	}

	public int getComponentW() {
		return this.scale.getComponent().getWidth();
	}

	public int getComponentH() {
		return this.scale.getComponent().getHeight();
	}

	public JComponent getComponent() {
		return this.scale.getComponent();
	}

	public void drawChecker(Graphics g) {
		for (int y = 0; y < 5; y++) {
			for (int x = 0; x < 5; x++) {
				g.fillRoundRect(
						this.getOuter_gap() + this.getInner_gap() + x * (this.getSlatWidth() + this.getInner_gap()),
						this.getOuter_gap() + this.getInner_gap() + +y * (this.getSlatWidth() + this.getInner_gap()),
						this.getSlatWidth(), this.getSlatWidth(), this.getInner_arc(), this.getInner_arc());
			}
		}
	}
	
	public void drawNumber(Graphics g,Map<Integer, BingoNumber> numbers ,int fix_x,int fix_w,int fix_unit_w) {
		numbers.values().iterator().forEachRemaining(x -> {

			g.drawString(x.getNumber().toString(),
					(x.getNumber() < 10 ? fix_unit_w : 0) + fix_x
							+ x.getPoint().x * (fix_w + this.getInner_gap() + this.getSlatWidth()),
					x.getPoint().y * (this.getInner_gap() + this.getSlatWidth()));
		});
	}

}
