package com.blu3flux.omnichess.graphics.window;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import com.blu3flux.omnichess.OmniChessApplication;
import com.blu3flux.omnichess.assets.ChessSet;
import com.blu3flux.omnichess.chess.Bishop;
import com.blu3flux.omnichess.chess.King;
import com.blu3flux.omnichess.chess.Knight;
import com.blu3flux.omnichess.chess.Pawn;
import com.blu3flux.omnichess.chess.Piece;
import com.blu3flux.omnichess.chess.PieceColor;
import com.blu3flux.omnichess.chess.Queen;
import com.blu3flux.omnichess.chess.Rook;
import com.blu3flux.omnichess.controls.ChessMouseControl;
import com.blu3flux.omnichess.graphics.theme.ThemeManager;

public class ChessBoard extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private ChessMouseControl mouse;
	
	private ChessSet set;
	
	private ArrayList<Piece> pieces;
	private Piece selectedPiece;
	
	private BufferedImage wPawn, wKnight, wBishop, wRook, wQueen, wKing;
	private BufferedImage bPawn, bKnight, bBishop, bRook, bQueen, bKing;
	
	public ChessBoard() {
		mouse = new ChessMouseControl(this);
		pieces = new ArrayList<Piece>();
		this.set = OmniChessApplication.getAssets().getSelectedChessSet();
		
		ByteArrayInputStream wPawnByteStream = new ByteArrayInputStream(set.getWPawnBytes());
		ByteArrayInputStream wKnightByteStream = new ByteArrayInputStream(set.getWKnightBytes());
		ByteArrayInputStream wBishopByteStream = new ByteArrayInputStream(set.getWBishopBytes());
		ByteArrayInputStream wRookByteStream = new ByteArrayInputStream(set.getWRookBytes());
		ByteArrayInputStream wQueenByteStream = new ByteArrayInputStream(set.getWQueenBytes());
		ByteArrayInputStream wKingByteStream = new ByteArrayInputStream(set.getWKingBytes());
		
		ByteArrayInputStream bPawnByteStream = new ByteArrayInputStream(set.getBPawnBytes());
		ByteArrayInputStream bKnightByteStream = new ByteArrayInputStream(set.getBKnightBytes());
		ByteArrayInputStream bBishopByteStream = new ByteArrayInputStream(set.getBBishopBytes());
		ByteArrayInputStream bRookByteStream = new ByteArrayInputStream(set.getBRookBytes());
		ByteArrayInputStream bQueenByteStream = new ByteArrayInputStream(set.getBQueenBytes());
		ByteArrayInputStream bKingByteStream = new ByteArrayInputStream(set.getBKingBytes());
		
		try {
			wPawn = ImageIO.read(wPawnByteStream);
			wKnight = ImageIO.read(wKnightByteStream);
			wBishop = ImageIO.read(wBishopByteStream);
			wRook = ImageIO.read(wRookByteStream);
			wQueen = ImageIO.read(wQueenByteStream);
			wKing = ImageIO.read(wKingByteStream);
			
			bPawn = ImageIO.read(bPawnByteStream);
			bKnight = ImageIO.read(bKnightByteStream);
			bBishop = ImageIO.read(bBishopByteStream);
			bRook = ImageIO.read(bRookByteStream);
			bQueen = ImageIO.read(bQueenByteStream);
			bKing = ImageIO.read(bKingByteStream);
			
			wPawnByteStream.close();
			wKnightByteStream.close();
			wBishopByteStream.close();
			wRookByteStream.close();
			wQueenByteStream.close();
			wKingByteStream.close();
			
			bPawnByteStream.close();
			bKnightByteStream.close();
			bBishopByteStream.close();
			bRookByteStream.close();
			bQueenByteStream.close();
			bKingByteStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		addMouseListener(mouse);
		addMouseMotionListener(mouse);
	}
	
	protected void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		// Draw background
		g.setColor(ThemeManager.getInstance().getPrimaryColor());
		g.fillRect(0, 0, getWidth(), getHeight());
	
		// Draw chess board
		int squareSize = getWidth() / 8;
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				if( (i + j) % 2 == 0)
					g.setColor(Color.WHITE);
				else
					g.setColor(new Color(118,150,86));
				
				int x = i * squareSize;
				int y = j * squareSize;
				g.fillRect(x, y, squareSize, squareSize);
			}
		}
		
		// Draw chess pieces
		drawChessPieces(g);
		
	}
	
	public void clearPieces() {
		pieces.clear();
	}
	
	private void drawChessPieces(Graphics g) {
		
		int size = getWidth()/8;
		
		for(Piece piece : pieces) {
			
			if(piece == selectedPiece) {
				g.drawImage(piece.getImage(),
						piece.getX(),
						piece.getY(),
						size, size, this);
				continue;
			}
			
			g.drawImage(piece.getImage(),
						piece.getFile() * size,
						piece.getRank() * size,
						size, size, this);
		}
	}

	public void addPiece(Piece piece) {
		
		if(piece instanceof Pawn) {
			if(piece.getColor() == PieceColor.WHITE)
				piece.setImage(wPawn);
			else
				piece.setImage(bPawn);
		}
		else if(piece instanceof Knight) {
			if(piece.getColor() == PieceColor.WHITE)
				piece.setImage(wKnight);
			else
				piece.setImage(bKnight);
		}
		else if(piece instanceof Bishop) {
			if(piece.getColor() == PieceColor.WHITE)
				piece.setImage(wBishop);
			else
				piece.setImage(bBishop);
		}
		else if(piece instanceof Rook) {
			if(piece.getColor() == PieceColor.WHITE)
				piece.setImage(wRook);
			else
				piece.setImage(bRook);
		}
		else if(piece instanceof Queen) {
			if(piece.getColor() == PieceColor.WHITE)
				piece.setImage(wQueen);
			else
				piece.setImage(bQueen);
		}
		else if(piece instanceof King) {
			if(piece.getColor() == PieceColor.WHITE)
				piece.setImage(wKing);
			else
				piece.setImage(bKing);
		}
		pieces.add(piece);
	}
	
	public void removeSelectedPiece() {
		selectedPiece = null;
	}

	public void setSelectedPiece(Piece p) {
		selectedPiece = p;
	}

	public Piece getPiece(int file, int rank) {
		for(Piece p : pieces) {
			if(p.getFile() == file && p.getRank() == rank) {
				return p;
			}
		}
		return null;
	}

	public Piece getSelectedPiece() {
		return selectedPiece;
	}
}
