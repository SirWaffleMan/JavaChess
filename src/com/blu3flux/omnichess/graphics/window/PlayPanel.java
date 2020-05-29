package com.blu3flux.omnichess.graphics.window;

import javax.swing.JPanel;

public class PlayPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private ChessboardPanel chessPanel;
	
	public PlayPanel() {
		chessPanel = new ChessboardPanel(600);
		add(chessPanel);
	}

}
