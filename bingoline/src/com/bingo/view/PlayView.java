package com.bingo.view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import com.tool.graphic.GraphicScale;
import java.awt.FlowLayout;

public class PlayView extends JPanel {

	/**
	 * Create the panel.
	 */
	public PlayView() {
		setBackground(Color.ORANGE);
		FlowLayout flowLayout = (FlowLayout) getLayout();

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		GraphicScale scale=new GraphicScale(this);
		
		
		g.setColor(Color.green);
		g.fillRoundRect(scale.getX1()+10, scale.getY1()+10, scale.getW()-20, scale.getH()-20,10,10);
		
		
		
	}
	
	
	

}