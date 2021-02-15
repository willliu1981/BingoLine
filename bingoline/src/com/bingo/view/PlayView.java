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

import com.bingo.controller.SimpleAutoSize;
import com.bingo.model.BingoNumber;
import com.tool.graphic.GraphicScale;

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
		GraphicScale scale = new GraphicScale(this);
		int outer_gap = 20;
		int inner_gap = 10;
		int outer_arc = 10;
		int inner_arc = 5;
		int slatWidth = 1 + SimpleAutoSize.getSlatWidth(scale.getInnerH() - outer_gap * 2, 5, inner_gap);
		g.setColor(Color.green);
		g.fillRoundRect(scale.getX1() + outer_gap, scale.getY1() + outer_gap, scale.getInnerW() - outer_gap * 2,
				scale.getInnerH() - outer_gap * 2, outer_arc, outer_arc);
		// 畫格子
		g.setColor(Color.black);
		for (int y = 0; y < 5; y++) {
			for (int x = 0; x < 5; x++) {
				g.fillRoundRect(outer_gap + inner_gap + x * (slatWidth + inner_gap),
						outer_gap + inner_gap + +y * (slatWidth + inner_gap), slatWidth, slatWidth, inner_arc,
						inner_arc);
			}
		}
		// 畫數字
		g.setColor(Color.white);
		g.setFont(new Font(g.getFont().getName(), Font.BOLD, 28));
		BingoNumber nums[] = new BingoNumber[25];
		this.numbers.values().iterator().forEachRemaining(x -> {
			int fix_x = -28;
			int fix_w = -0;
			int fix_unit_w = 8;
			g.drawString(x.getNumber().toString(),
					(x.getNumber() < 10 ? fix_unit_w : 0) + fix_x + x.getPoint().x * (fix_w + inner_gap + slatWidth),
					x.getPoint().y * (inner_gap + slatWidth));

		});
	}

}
