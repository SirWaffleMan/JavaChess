package com.blu3flux.omnichess.graphics.window;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import com.blu3flux.omnichess.graphics.theme.ThemeManager;

public class ChessboardPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	
	public ChessboardPanel(int size) {
		setPreferredSize(new Dimension(size, size));
	}
	
	protected void paintComponent(Graphics g) {
		
		// Draw background
		g.setColor(ThemeManager.getInstance().getPrimaryColor());
		g.fillRect(0, 0, getWidth(), getHeight());
	
		// Draw chess board
		int squareSize = getWidth() / 8;
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				if( (i + j) % 2 == 0)
					g.setColor(Color.WHITE);
				else
					g.setColor(new Color(118,150,86));
				
				int x = i * squareSize;
				int y = j * squareSize;
				g.fillRect(x, y, squareSize, squareSize);
			}
		}
		
		
		
		
	}
}
