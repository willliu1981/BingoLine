package com.bingo.view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import com.bingo.controller.SimpleAutoSize;
import com.tool.graphic.GraphicScale;
import java.awt.FlowLayout;
import java.awt.Rectangle;
import java.util.concurrent.atomic.AtomicInteger;

public class PlayView extends JPanel {
	private int[] nums = new int[25];
	private AtomicInteger ai = new AtomicInteger();

	/**
	 * Create the panel.
	 */
	public PlayView() {
		setBounds(new Rectangle(0, 0, 200, 200));
		setBackground(Color.ORANGE);
		FlowLayout flowLayout = (FlowLayout) getLayout();
		for (int i = 0; i < nums.length; i++) {
			nums[i] = i + 1;
		}
	}
	
	public void ruffle() {
		for(int i=0;i<nums.length;i++) {
			int temp=nums[i];
			int idx=(int)(Math.random()*24);
			nums[i]=nums[idx];
			nums[idx]=temp;
		}
	}
	
	public void doRuffle() {
		ai.set(0);
		class MyThread extends Thread{
			@Override
			public void run() {
				
			}
		}
		
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		GraphicScale scale = new GraphicScale(this);
		int outer_gap = 20;
		int inner_gap = 10;
		int outer_arc = 10;
		int inner_arc = 5;
		int slatWidth = SimpleAutoSize.getSlatWidth(scale.getInnerH() - outer_gap * 2, 5, inner_gap);
		slatWidth += 1;// fix
		g.setColor(Color.green);
		g.fillRoundRect(scale.getX1() + outer_gap, scale.getY1() + outer_gap, scale.getInnerW() - outer_gap * 2,
				scale.getInnerH() - outer_gap * 2, outer_arc, outer_arc);
		g.setColor(Color.black);
		for (int y = 0; y < 5; y++) {
			for (int x = 0; x < 5; x++) {
				g.fillRoundRect(outer_gap + inner_gap + x * (slatWidth + inner_gap),
						outer_gap + inner_gap + +y * (slatWidth + inner_gap), slatWidth, slatWidth, inner_arc,
						inner_arc);
			}
		}
	}

}
