package com.blu3flux.omnichess.graphics.window;

import java.awt.Dimension;

import javax.swing.JPanel;

public class AnalysisPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private EvaluationBar evalBar;
	private ChessBoard chessBoard;
	private MoveList moveList;
	
	public AnalysisPanel() {
		evalBar = new EvaluationBar();
		chessBoard = new ChessBoard(600);
		moveList = new MoveList();
		
		evalBar.setPreferredSize(new Dimension(40, 600));
		moveList.setPreferredSize(new Dimension(300, 600));

		add(evalBar);
		add(chessBoard);
		add(moveList);
	}

}
