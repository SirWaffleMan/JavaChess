package com.blu3flux.omnichess.graphics.window;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;

import com.blu3flux.omnichess.graphics.theme.ThemeManager;
import com.blu3flux.omnichess.utils.ChessGameManager;

public class AnalysisPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	
	ChessGameManager manager;
	
	private JPanel leftPanel;
	private JPanel centerPanel;
	private JPanel rightPanel;
	
	private EvaluationBar evalBar;
	private ChessBoard chessBoard;
	private AnalysisExplorer analysisExplorer;
	
	public AnalysisPanel() {
		
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(20,20,20,20);
		
		leftPanel = new JPanel();
		centerPanel = new JPanel();
		rightPanel = new JPanel();
		
		leftPanel.setBackground(ThemeManager.getInstance().getSecondaryColor());
		centerPanel.setBackground(ThemeManager.getInstance().getSecondaryColor());
		rightPanel.setBackground(ThemeManager.getInstance().getSecondaryColor());
		
		evalBar = new EvaluationBar();
		chessBoard = new ChessBoard();
		analysisExplorer = new AnalysisExplorer();
		
		manager = new ChessGameManager(chessBoard);
		
		leftPanel.add(evalBar);
		centerPanel.add(chessBoard);
		rightPanel.add(analysisExplorer);
		
		evalBar.setPreferredSize(new Dimension(40, 600));
		chessBoard.setPreferredSize(new Dimension(600, 600));
		analysisExplorer.setPreferredSize(new Dimension(300, 600));

		gbc.gridx = 0;
		gbc.gridy = 0;
		add(leftPanel, gbc);
		gbc.gridx = 1;
		gbc.gridy = 0;
		add(centerPanel, gbc);
		gbc.gridx = 2;
		gbc.gridy = 0;
		add(rightPanel, gbc);
		
		String FEN = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1";
		manager.setFEN(FEN);
	}

	public void resizeComponents(int width, int height) {

		if(width >= 1300 && width >= 920) {
			chessBoard.setPreferredSize(new Dimension(800, 800));
			evalBar.setPreferredSize(new Dimension(40, 800));
			analysisExplorer.setPreferredSize(new Dimension(300, 800));
		}else if(width >= 1200) {
			chessBoard.setPreferredSize(new Dimension(600, 600));
			evalBar.setPreferredSize(new Dimension(40, 600));
			analysisExplorer.setPreferredSize(new Dimension(300, 600));
		}else if(width >= 1000) {
			chessBoard.setPreferredSize(new Dimension(400, 400));
			evalBar.setPreferredSize(new Dimension(40, 400));
			analysisExplorer.setPreferredSize(new Dimension(300, 400));
		}else {
			chessBoard.setPreferredSize(new Dimension(200, 200));
			evalBar.setPreferredSize(new Dimension(40, 200));
			analysisExplorer.setPreferredSize(new Dimension(300, 200));
		}
		
		evalBar.invalidate();
		evalBar.validate();
		evalBar.repaint();
	
		chessBoard.invalidate();
		chessBoard.validate();
		chessBoard.repaint();
		
		analysisExplorer.invalidate();
		analysisExplorer.validate();
		analysisExplorer.repaint();
	}
}
