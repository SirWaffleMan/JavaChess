package com.blu3flux.javachess.graphics;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class Window extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel mainPanel;
	private JTabbedPane tabPanel;
	private JPanel playPanel;
	private JPanel analysisPanel;
	
	public Window(int width, int height, String title) {
		// Tab panel configurations
		playPanel = new JPanel();
		analysisPanel = new JPanel();
		
		tabPanel = new JTabbedPane();
		tabPanel.addTab("Play", playPanel);
		tabPanel.addTab("Analysis", analysisPanel);
		for (int i = 0; i < tabPanel.getTabCount(); i++) {
			tabPanel.getComponentAt(i).setBackground(Color.DARK_GRAY);
		}
		
		// Set window configurations
		setPreferredSize(new Dimension(width, height));
		setTitle(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setContentPane(tabPanel);
		pack();
		setVisible(true);
	}

}
