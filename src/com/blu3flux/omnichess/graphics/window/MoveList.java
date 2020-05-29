package com.blu3flux.omnichess.graphics.window;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class MoveList extends JPanel{

	private static final long serialVersionUID = 1L;

	public MoveList() {
		
	}
	
	protected void paintComponent(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getWidth(), getHeight());
		
		g.setColor(Color.WHITE);
		g.drawString("1. e4 e5", 0, 30);
	}
}
