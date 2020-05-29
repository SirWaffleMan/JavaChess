package com.blu3flux.omnichess.graphics.window;

import java.awt.Dimension;

import javax.swing.JPanel;

public class PlayPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private ChessBoard chessBoard;
	
	public PlayPanel() {
		chessBoard = new ChessBoard();
		
		chessBoard.setPreferredSize(new Dimension(600, 600));
		
		add(chessBoard);
	}

}
