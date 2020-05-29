package com.blu3flux.omnichess.graphics.window;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

import com.blu3flux.omnichess.graphics.theme.ThemeManager;

public class AnalysisPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private JPanel leftPanel;
	private JPanel centerPanel;
	private JPanel rightPanel;
	
	private EvaluationBar evalBar;
	private ChessBoard chessBoard;
	private MoveList moveList;
	
	public AnalysisPanel() {
		
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		
		leftPanel = new JPanel();
		centerPanel = new JPanel();
		rightPanel = new JPanel();
		
		leftPanel.setBackground(ThemeManager.getInstance().getSecondaryColor());
		centerPanel.setBackground(ThemeManager.getInstance().getSecondaryColor());
		rightPanel.setBackground(ThemeManager.getInstance().getSecondaryColor());
		
		evalBar = new EvaluationBar();
		chessBoard = new ChessBoard();
		moveList = new MoveList();
		
		leftPanel.add(evalBar);
		centerPanel.add(chessBoard);
		rightPanel.add(moveList);
		
		evalBar.setPreferredSize(new Dimension(40, 600));
		chessBoard.setPreferredSize(new Dimension(600, 600));
		moveList.setPreferredSize(new Dimension(300, 600));

		gbc.gridx = 0;
		gbc.gridy = 0;
		add(leftPanel, gbc);
		gbc.gridx = 1;
		gbc.gridy = 0;
		add(centerPanel, gbc);
		gbc.gridx = 2;
		gbc.gridy = 0;
		add(rightPanel, gbc);
	}
}
