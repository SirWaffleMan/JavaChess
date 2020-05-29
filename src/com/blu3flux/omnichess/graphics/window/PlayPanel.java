package com.blu3flux.omnichess.graphics.window;

import javax.swing.JPanel;

public class PlayPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private ChessBoard chessBoard;
	
	public PlayPanel() {
		chessBoard = new ChessBoard(600);
		add(chessBoard);
	}

}
