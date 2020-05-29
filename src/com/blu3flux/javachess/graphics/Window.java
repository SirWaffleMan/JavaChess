package com.blu3flux.javachess.graphics;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Window extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel mainPanel;
	
	public Window(int width, int height, String title) {
		// Main Panel configurations
		mainPanel = new JPanel();
		mainPanel.setBackground(Color.BLACK);
		
		// Set window configurations
		setPreferredSize(new Dimension(width, height));
		setTitle(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setContentPane(mainPanel);
		pack();
		setVisible(true);
	}

}
