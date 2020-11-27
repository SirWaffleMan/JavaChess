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
import com.blu3flux.omnichess.chess.*;
import com.blu3flux.omnichess.graphics.theme.ThemeManager;
import com.blu3flux.omnichess.controls.ChessMouseControl;

public class ChessBoard extends JPanel{

	private static final long serialVersionUID = 1L;

	private Chessable gameManager;

	private ChessMouseControl mouse;
	
	private ChessSet set;
	
	private BufferedImage wPawn, wKnight, wBishop, wRook, wQueen, wKing;
	private BufferedImage bPawn, bKnight, bBishop, bRook, bQueen, bKing;
	
	public ChessBoard(Chessable manager) {

		this.gameManager = manager;
		mouse = new ChessMouseControl(this);
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

		addImages();
		
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
	
	private void drawChessPieces(Graphics g) {

		int size = getWidth() / 8;

		Piece[][] board = gameManager.getPiecePlacement();

		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){

				Piece piece = board[i][j];

				// Skip if empty square
				if(piece == null)
					continue;

				g.drawImage(piece.getImage(),j * size, i*size, size, size, this);
			}
		}
	}

	private void addImages(){

		Piece[][] board = gameManager.getPiecePlacement();

		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				Piece piece = board[i][j];

				if(piece == null)
					continue;

				if(piece instanceof Pawn){
					if(piece.getColor() == PieceColor.WHITE){
						piece.setImage(wPawn);
					}else{
						piece.setImage(bPawn);
					}
				}
				else if(piece instanceof Knight){
					if(piece.getColor() == PieceColor.WHITE){
						piece.setImage(wKnight);
					}else{
						piece.setImage(bKnight);
					}
				}
				else if(piece instanceof Bishop){
					if(piece.getColor() == PieceColor.WHITE){
						piece.setImage(wBishop);
					}else{
						piece.setImage(bBishop);
					}
				}
				else if(piece instanceof Rook){
					if(piece.getColor() == PieceColor.WHITE){
						piece.setImage(wRook);
					}else{
						piece.setImage(bRook);
					}
				}
				else if(piece instanceof Queen){
					if(piece.getColor() == PieceColor.WHITE){
						piece.setImage(wQueen);
					}else{
						piece.setImage(bQueen);
					}
				}
				else if(piece instanceof King){
					if(piece.getColor() == PieceColor.WHITE){
						piece.setImage(wKing);
					}else{
						piece.setImage(bKing);
					}
				}

			}
		}
	}
}
