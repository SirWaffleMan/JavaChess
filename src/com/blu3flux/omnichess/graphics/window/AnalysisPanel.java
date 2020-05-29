package com.blu3flux.omnichess.graphics.window;

import java.awt.Dimension;

import javax.swing.JPanel;

public class AnalysisPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private EvaluationBar evalBar;
	private ChessBoard chessPanel;
	
	public AnalysisPanel() {
		evalBar = new EvaluationBar();
		chessPanel = new ChessBoard(600);
		
		evalBar.setPreferredSize(new Dimension(40, 600));
		
		add(evalBar);
		add(chessPanel);
	}

}
