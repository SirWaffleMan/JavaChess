package com.blu3flux.omnichess.graphics.window;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;

import com.blu3flux.omnichess.graphics.theme.ThemeManager;
import com.blu3flux.omnichess.utils.ChessGameManager;

public class PlayPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private ChessGameManager manager;
	
	private JPanel leftPanel;
	private JPanel centerPanel;
	private JPanel rightPanel;
	
	private ChessBoard chessBoard;
	private MoveList moveList;
	
	public PlayPanel() {
		
		chessBoard = new ChessBoard();
		moveList = new MoveList();
		
		manager = new ChessGameManager(chessBoard);
		
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
		
		chessBoard.setPreferredSize(new Dimension(600, 600));
		moveList.setPreferredSize(new Dimension(300, 600));
		
		centerPanel.add(chessBoard);
		rightPanel.add(moveList);
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		add(leftPanel, gbc);
		gbc.gridx = 1;
		gbc.gridy = 0;
		add(centerPanel, gbc);
		gbc.gridx = 2;
		gbc.gridy = 0;
		add(rightPanel, gbc);
		
		String FEN = "r1bqkbnr/pppp1ppp/2n5/4p3/2B1P3/5N2/PPPP1PPP/RNBQK2R b KQkq - 3 3";
		manager.setFEN(FEN);
	}
	
public void resizeComponents(int width, int height) {
		
		if(width >= 1300 && width >= 920) {
			chessBoard.setPreferredSize(new Dimension(800, 800));
			moveList.setSize(new Dimension(300, 800));
		}else if(width >= 1200) {
			chessBoard.setPreferredSize(new Dimension(600, 600));
			moveList.setSize(new Dimension(300, 600));
		}else if(width >= 1000) {
			chessBoard.setPreferredSize(new Dimension(400, 400));
			moveList.setSize(new Dimension(300, 400));
		}else {
			chessBoard.setPreferredSize(new Dimension(200, 200));
			moveList.setSize(new Dimension(300, 200));
		}
	
		chessBoard.invalidate();
		chessBoard.validate();
		chessBoard.repaint();
		
		moveList.invalidate();
		moveList.validate();
		moveList.repaint();
	}

}
