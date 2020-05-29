package com.blu3flux.omnichess.graphics.window;

import javax.swing.JPanel;

public class AnalysisPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private ChessboardPanel chessPanel;
	
	public AnalysisPanel() {
		chessPanel = new ChessboardPanel(600);
		add(chessPanel);
	}

}
