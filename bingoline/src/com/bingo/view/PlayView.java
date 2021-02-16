package com.bingo.view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import javax.swing.JPanel;

import com.bingo.model.BingoNumber;
import com.tool.graphic.Draws;

public class PlayView extends JPanel {
	private Map<Integer, BingoNumber> numbers = new HashMap<>();
	private AtomicInteger ai = new AtomicInteger();

	public static void main(String a[]) {
		PlayView view = new PlayView();
		view.numbers.forEach((k, v) -> {
			System.out.format("%d : %s\n", k, v);
		});
		view.ruffle();
		System.out.println();
		view.numbers.forEach((k, v) -> {
			System.out.format("%d : %s\n", k, v);
		});

	}

	/**
	 * Create the panel.
	 */
	public PlayView() {
		setBounds(new Rectangle(0, 0, 200, 200));
		setBackground(Color.ORANGE);
		FlowLayout flowLayout = (FlowLayout) getLayout();
		for (int y = 1, idx = 1; y <= 5; y++) {
			for (int x = 1; x <= 5; x++, idx++) {
				numbers.put(idx, new BingoNumber(idx, x, y));
			}
		}
	}

	public void ruffle() {
		BingoNumber[] nums = new BingoNumber[25];
		numbers.values().toArray(nums);
		for (int i = 0; i < nums.length; i++) {
			int idx = (int) (Math.random() * 24);
			BingoNumber.swapPoint(nums[i], nums[idx]);
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Draws draws = new Draws(this);
		draws.setOuter_gap(20);
		draws.setInner_gap(10);
		draws.setOuter_arc(10);
		draws.setInner_arc(5);
		draws.setSlatWidth(5, 1);

		g.setColor(Color.green);
		g.fillRoundRect(draws.getX1() + draws.getOuter_gap(), draws.getY1() + draws.getOuter_gap(),
				draws.getInnerW() - draws.getOuter_gap() * 2, draws.getInnerH() - draws.getOuter_gap() * 2,
				draws.getOuter_arc(), draws.getOuter_arc());
		// 畫格子
		g.setColor(Color.black);
		draws.drawChecker(g);

		// 畫數字
		g.setColor(Color.white);
		g.setFont(new Font(g.getFont().getName(), Font.BOLD, 28));
		draws.drawNumber(g, numbers, -28, 0, 8);

	}

}
