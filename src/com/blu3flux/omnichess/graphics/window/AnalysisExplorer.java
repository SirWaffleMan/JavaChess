package com.blu3flux.omnichess.graphics.window;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class AnalysisExplorer extends JPanel{
	private static final long serialVersionUID = 1L;

	public AnalysisExplorer() {
		
	}
	
	protected void paintComponent(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getWidth(), getHeight());
	}
}
