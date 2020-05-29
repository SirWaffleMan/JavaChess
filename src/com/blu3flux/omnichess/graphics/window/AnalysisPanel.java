package com.blu3flux.omnichess.graphics.window;

import java.awt.Dimension;

import javax.swing.JPanel;

public class AnalysisPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private JPanel leftPanel;
	private JPanel centerPanel;
	private JPanel rightPanel;
	
	private EvaluationBar evalBar;
	private ChessBoard chessBoard;
	private MoveList moveList;
	
	public AnalysisPanel() {
		
		leftPanel = new JPanel();
		centerPanel = new JPanel();
		rightPanel = new JPanel();
		
		evalBar = new EvaluationBar();
		chessBoard = new ChessBoard(600);
		moveList = new MoveList();
		
		leftPanel.add(evalBar);
		centerPanel.add(chessBoard);
		rightPanel.add(moveList);
		
		evalBar.setPreferredSize(new Dimension(40, 600));
		moveList.setPreferredSize(new Dimension(300, 600));

		add(leftPanel);
		add(centerPanel);
		add(rightPanel);
	}

}
