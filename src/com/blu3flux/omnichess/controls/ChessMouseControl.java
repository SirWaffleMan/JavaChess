package com.blu3flux.omnichess.controls;

import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.blu3flux.omnichess.chess.Piece;
import com.blu3flux.omnichess.graphics.window.ChessBoard;
import com.blu3flux.omnichess.utils.ChessGameManager;

public class ChessMouseControl extends MouseAdapter{
	
	ChessGameManager manager;
	ChessBoard board;
	
	Piece selectedPiece;
	
	public ChessMouseControl(ChessGameManager m) {
		this.manager = m;
		this.board = manager.getBoard();
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		
		int file = (int)((float)e.getX() / (float)board.getWidth() * 8);
		int rank = (int)((float)e.getY() / (float)board.getHeight() * 8);
		
		selectedPiece = board.getPiece(file, rank);
		board.setSelectedPiece(selectedPiece);
		
		if(selectedPiece != null) {
			int x = e.getX() - board.getWidth()/16;
			int y = e.getY() - board.getHeight()/16;
			selectedPiece.setX(x);
			selectedPiece.setY(y);
		}
		
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		
		int file = (int)((float)e.getX() / (float)board.getWidth() * 8);
		int rank = (int)((float)e.getY() / (float)board.getHeight() * 8);
		
		if(selectedPiece != null) {
			manager.handleMove(selectedPiece, file, rank);
		}
		
		selectedPiece = null;
		board.setSelectedPiece(null);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		if(selectedPiece != null) {
			
			int x = e.getX() - board.getWidth()/16;
			int y = e.getY() - board.getHeight()/16;
			
			selectedPiece.setX(x);
			selectedPiece.setY(y);
		}
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {
		int file = (int)((float)e.getX() / (float)board.getWidth() * 8);
		int rank = (int)((float)e.getY() / (float)board.getHeight() * 8);
		
		if(board.isPiece(file, rank)) {
			board.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}else {
			board.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		}
	}
}
