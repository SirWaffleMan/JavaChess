package com.blu3flux.omnichess.graphics;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import com.blu3flux.omnichess.graphics.theme.DefaultTheme;
import com.blu3flux.omnichess.graphics.theme.ThemeManager;

public class Window extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTabbedPane tabPanel;
	private JPanel playPanel;
	private JPanel analysisPanel;
	private JPanel themePanel;
	private ThemeManager themeMan;
	
	public Window(int width, int height, String title, DefaultTheme theme) {
		// Theme Manager
		themeMan = new ThemeManager(theme);
		
		// Tab panel configurations
		playPanel = new JPanel();
		analysisPanel = new JPanel();
		themePanel = new JPanel();
		
		tabPanel = new JTabbedPane();
		tabPanel.addTab("Play", playPanel);
		tabPanel.addTab("Analysis", analysisPanel);
		tabPanel.addTab("Theme", themePanel);
		for (int i = 0; i < tabPanel.getTabCount(); i++) {
			tabPanel.getComponentAt(i).setBackground(themeMan.getPrimaryColor());
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
