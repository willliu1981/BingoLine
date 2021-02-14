package com.bingo.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Component;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import java.awt.Rectangle;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class MainView extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainView frame = new MainView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 615, 573);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("New menu");
		menuBar.add(mnNewMenu);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("New menu item");
		mnNewMenu.add(mntmNewMenuItem_1);

		JMenuItem mntmNewMenuItem = new JMenuItem("New menu item");
		mnNewMenu.add(mntmNewMenuItem);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel_main_slat = new JPanel();
		panel_main_slat.setBackground(Color.BLACK);
		contentPane.add(panel_main_slat, BorderLayout.CENTER);
		panel_main_slat.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel_main_slat.add(panel, BorderLayout.WEST);
		panel.setLayout(new BorderLayout(0, 0));
		
		PlayView panel_play_view_0 = new PlayView();
		panel.add(panel_play_view_0);
		
		PlayView panel_play_view_1 = new PlayView();
		panel.add(panel_play_view_1);
		
		PlayView panel_play_view_2 = new PlayView();
		panel.add(panel_play_view_2);
		
		PlayView panel_play_view_3 = new PlayView();
		panel.add(panel_play_view_3);
		
		PlayView panel_play_view_4 = new PlayView();
		panel.add(panel_play_view_4);
		
		PlayView panel_play_view = new PlayView();
		panel_main_slat.add(panel_play_view, BorderLayout.CENTER);

		JPanel panel_top_slat = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_top_slat.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		contentPane.add(panel_top_slat, BorderLayout.NORTH);

		JButton btnNewButton = new JButton("Repaint");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				repaint_grid(evt);
			}
		});
		panel_top_slat.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("New button");
		panel_top_slat.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("New button");
		panel_top_slat.add(btnNewButton_2);

		JPanel panel_bottom_slat = new JPanel();
		panel_bottom_slat.setPreferredSize(new Dimension(10, 30));
		contentPane.add(panel_bottom_slat, BorderLayout.SOUTH);
		panel_bottom_slat.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel = new JLabel("copyright since 2021");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_bottom_slat.add(lblNewLabel);
	}

	private void repaint_grid(ActionEvent evt) {
		
	}

}
