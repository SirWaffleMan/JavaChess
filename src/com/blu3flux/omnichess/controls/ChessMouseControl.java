package com.blu3flux.omnichess.controls;

import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.blu3flux.omnichess.chess.Piece;
import com.blu3flux.omnichess.graphics.window.ChessBoard;

public class ChessMouseControl extends MouseAdapter{

	ChessBoard board;

	Piece selectedPiece;

	public ChessMouseControl(ChessBoard board) {
		this.board = board;
	}

	@Override
	public void mousePressed(MouseEvent e) {

		int file = (int)((float)e.getX() / (float)board.getWidth() * 8);
		int rank = 7 - (int)((float)e.getY() / (float)board.getHeight() * 8);

		System.out.println("file: " + file);
		System.out.println("rank: " + rank);
	}

	@Override
	public void mouseReleased(MouseEvent e) {

		int file = (int)((float)e.getX() / (float)board.getWidth() * 8);
		int rank = (int)((float)e.getY() / (float)board.getHeight() * 8);

	}

	@Override
	public void mouseDragged(MouseEvent e) {

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		int file = (int)((float)e.getX() / (float)board.getWidth() * 8);
		int rank = (int)((float)e.getY() / (float)board.getHeight() * 8);
	}
}