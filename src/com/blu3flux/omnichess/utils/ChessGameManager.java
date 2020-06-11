package com.blu3flux.omnichess.utils;

import com.blu3flux.omnichess.chess.Bishop;
import com.blu3flux.omnichess.chess.King;
import com.blu3flux.omnichess.chess.Knight;
import com.blu3flux.omnichess.chess.Pawn;
import com.blu3flux.omnichess.chess.Piece;
import com.blu3flux.omnichess.chess.PieceColor;
import com.blu3flux.omnichess.chess.Queen;
import com.blu3flux.omnichess.chess.Rook;
import com.blu3flux.omnichess.graphics.window.ChessBoard;

public class ChessGameManager {
	
	private String FEN;
	private PieceColor playerToMove;
	private ChessBoard board;
	
	public ChessGameManager(ChessBoard cb) {
		this.board = cb;
		playerToMove = PieceColor.WHITE;
	}
	
	public void setFEN(String fen) {
		this.FEN = fen;
		String pieceLocations = fen.split(" ")[0];
		String [] rows = pieceLocations.split("/");
		
		board.clearPieces();
		
		int file = 0;
		int rank = 0;
		
		for(int i = 0; i < rows.length; i++) {
			for(int j = 0; j < rows[i].length(); j++) {
				
				if(Character.isDigit(rows[i].charAt(j))) {
					String num = String.valueOf(rows[i].charAt(j));
					file += Integer.parseInt(num);
					if(file > 7)
						continue;
					j+=1;
				}
				
				char piece = rows[i].charAt(j);
				setPiece(piece, file, rank);
				file++;
			}
			file = 0;
			rank++;
		}
		
	}
	
	public PieceColor getPlayerToMove() {
		return playerToMove;
	}
	
	public ChessBoard getBoard() {
		return board;
	}
	
	public void setPiece(char piece, int file, int rank) {
		switch(piece) {
		case 'P':
			board.addPiece(new Pawn(PieceColor.WHITE, file, rank));
			break;
		case 'N':
			board.addPiece(new Knight(PieceColor.WHITE, file, rank));
			break;
		case 'B':
			board.addPiece(new Bishop(PieceColor.WHITE, file, rank));
			break;
		case 'R':
			board.addPiece(new Rook(PieceColor.WHITE, file, rank));
			break;
		case 'Q':
			board.addPiece(new Queen(PieceColor.WHITE, file, rank));
			break;
		case 'K':
			board.addPiece(new King(PieceColor.WHITE, file, rank));
			break;
		case 'p':
			board.addPiece(new Pawn(PieceColor.BLACK, file, rank));
			break;
		case 'n':
			board.addPiece(new Knight(PieceColor.BLACK, file, rank));
			break;
		case 'b':
			board.addPiece(new Bishop(PieceColor.BLACK, file, rank));
			break;
		case 'r':
			board.addPiece(new Rook(PieceColor.BLACK, file, rank));
			break;
		case 'q':
			board.addPiece(new Queen(PieceColor.BLACK, file, rank));
			break;
		case 'k':
			board.addPiece(new King(PieceColor.BLACK, file, rank));
			break;
		}
	}

	public void handleMove(Piece selectedPiece, int file, int rank) {
		selectedPiece.setRank(rank);
		selectedPiece.setFile(file);
	}
}
