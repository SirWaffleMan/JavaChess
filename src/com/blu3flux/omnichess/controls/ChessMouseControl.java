package com.blu3flux.omnichess.controls;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.blu3flux.omnichess.chess.Piece;
import com.blu3flux.omnichess.graphics.window.ChessBoard;

public class ChessMouseControl extends MouseAdapter{
	
	ChessBoard board;
	
	Piece selectedPiece;
	
	public ChessMouseControl(ChessBoard b) {
		this.board = b;
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		
		int file = (int)((float)e.getX() / (float)board.getWidth() * 8);
		int rank = (int)((float)e.getY() / (float)board.getHeight() * 8);
		
		selectedPiece = board.getPiece(file, rank);
		board.setSelectedPiece(selectedPiece);
		
		if(selectedPiece == null) {
			return;
		}
		
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		
		int file = (int)((float)e.getX() / (float)board.getWidth() * 8);
		int rank = (int)((float)e.getY() / (float)board.getHeight() * 8);
		
		if(selectedPiece != null) {
			selectedPiece.setRank(rank);
			selectedPiece.setFile(file);
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
		
	}
}
