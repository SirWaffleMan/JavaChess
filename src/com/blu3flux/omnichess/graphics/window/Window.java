package com.blu3flux.omnichess.graphics.window;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import com.blu3flux.omnichess.graphics.theme.DefaultTheme;
import com.blu3flux.omnichess.graphics.theme.ThemeManager;

public class Window extends JFrame implements ComponentListener{

	private static final long serialVersionUID = 1L;
	private JTabbedPane tabPanel;
	private PlayPanel playPanel;
	private AnalysisPanel analysisPanel;
	private ThemePanel themePanel;
	
	public Window(int width, int height, String title, DefaultTheme theme) {
		// Theme Manager
		ThemeManager themeMan = ThemeManager.getInstance();
		themeMan.setTheme(theme);
		
		// Tab panel configurations
		playPanel = new PlayPanel();
		analysisPanel = new AnalysisPanel();
		themePanel = new ThemePanel();
		
		tabPanel = new JTabbedPane();
		tabPanel.addTab("Play", playPanel);
		tabPanel.addTab("Analysis", analysisPanel);
		tabPanel.addTab("Theme", themePanel);
		tabPanel.setForeground(themeMan.getFontColor());
		tabPanel.setBackground(themeMan.getPrimaryColor());
		for (int i = 0; i < tabPanel.getTabCount(); i++) {
			tabPanel.getComponentAt(i).setBackground(themeMan.getSecondaryColor());
		}

		// Set window configurations
		setPreferredSize(new Dimension(width, height));
		setTitle(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setContentPane(tabPanel);
		pack();
		setVisible(true);
		addComponentListener(this);
	}

	@Override
	public void componentResized(ComponentEvent e) {
		playPanel.resizeComponents(getWidth(), getHeight());
		analysisPanel.resizeComponents(getWidth(), getHeight());
	}

	@Override
	public void componentMoved(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentShown(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentHidden(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

}
