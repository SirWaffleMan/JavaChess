package com.blu3flux.omnichess.graphics.window;

import java.awt.Color;
import java.awt.Graphics;
import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import com.blu3flux.omnichess.OmniChessApplication;
import com.blu3flux.omnichess.assets.ChessSet;
import com.blu3flux.omnichess.chess.Bishop;
import com.blu3flux.omnichess.chess.King;
import com.blu3flux.omnichess.chess.Knight;
import com.blu3flux.omnichess.chess.Pawn;
import com.blu3flux.omnichess.chess.Piece;
import com.blu3flux.omnichess.chess.Queen;
import com.blu3flux.omnichess.chess.Rook;
import com.blu3flux.omnichess.controls.ChessMouseControl;
import com.blu3flux.omnichess.graphics.theme.ThemeManager;

public class ChessBoard extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private ChessMouseControl mouse;
	
	private ChessSet set;
	
	private Piece wPawn, wKnight, wBishop, wRook, wQueen, wKing;
	private Piece bPawn, bKnight, bBishop, bRook, bQueen, bKing;
	
	public ChessBoard() {
		mouse = new ChessMouseControl();
		this.set = OmniChessApplication.getAssets().getSelectedChessSet();
		
		wPawn = new Pawn();
		wKnight = new Knight();
		wBishop = new Bishop();
		wRook = new Rook();
		wQueen = new Queen();
		wKing = new King();
		
		bPawn = new Pawn();
		bKnight = new Knight();
		bBishop = new Bishop();
		bRook = new Rook();
		bQueen = new Queen();
		bKing = new King();
		
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
			wPawn.setImage(ImageIO.read(wPawnByteStream));
			wKnight.setImage(ImageIO.read(wKnightByteStream));
			wBishop.setImage(ImageIO.read(wBishopByteStream));
			wRook.setImage(ImageIO.read(wRookByteStream));
			wQueen.setImage(ImageIO.read(wQueenByteStream));
			wKing.setImage(ImageIO.read(wKingByteStream));
			
			bPawn.setImage(ImageIO.read(bPawnByteStream));
			bKnight.setImage(ImageIO.read(bKnightByteStream));
			bBishop.setImage(ImageIO.read(bBishopByteStream));
			bRook.setImage(ImageIO.read(bRookByteStream));
			bQueen.setImage(ImageIO.read(bQueenByteStream));
			bKing.setImage(ImageIO.read(bKingByteStream));
			
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
	
	private void drawChessPieces(Graphics g) {
		
		int size = getWidth()/8;
		
		// 8th rank
		g.drawImage(bRook.getImage(), 0 * size, 0 * size, size, size, this);
		g.drawImage(bKnight.getImage(), 1 * size, 0 * size, size, size, this);
		g.drawImage(bBishop.getImage(), 2 * size, 0 * size, size, size, this);
		g.drawImage(bQueen.getImage(), 3 * size, 0 * size, size, size, this);
		g.drawImage(bKing.getImage(), 4 * size, 0 * size, size, size, this);
		g.drawImage(bBishop.getImage(), 5 * size, 0 * size, size, size, this);
		g.drawImage(bKnight.getImage(), 6 * size, 0 * size, size, size, this);
		g.drawImage(bRook.getImage(), 7 * size, 0 * size, size, size, this);
		
		// 7th rank
		g.drawImage(bPawn.getImage(), 0 * size, 1 * size, size, size, this);
		g.drawImage(bPawn.getImage(), 1 * size, 1 * size, size, size, this);
		g.drawImage(bPawn.getImage(), 2 * size, 1 * size, size, size, this);
		g.drawImage(bPawn.getImage(), 3 * size, 1 * size, size, size, this);
		g.drawImage(bPawn.getImage(), 4 * size, 1 * size, size, size, this);
		g.drawImage(bPawn.getImage(), 5 * size, 1 * size, size, size, this);
		g.drawImage(bPawn.getImage(), 6 * size, 1 * size, size, size, this);
		g.drawImage(bPawn.getImage(), 7 * size, 1 * size, size, size, this);
		
		// 2nd rank
		g.drawImage(wPawn.getImage(), 0 * size, 6 * size, size, size, this);
		g.drawImage(wPawn.getImage(), 1 * size, 6 * size, size, size, this);
		g.drawImage(wPawn.getImage(), 2 * size, 6 * size, size, size, this);
		g.drawImage(wPawn.getImage(), 3 * size, 6 * size, size, size, this);
		g.drawImage(wPawn.getImage(), 4 * size, 6 * size, size, size, this);
		g.drawImage(wPawn.getImage(), 5 * size, 6 * size, size, size, this);
		g.drawImage(wPawn.getImage(), 6 * size, 6 * size, size, size, this);
		g.drawImage(wPawn.getImage(), 7 * size, 6 * size, size, size, this);
		
		// 1st rank
		g.drawImage(wRook.getImage(), 0 * size, 7 * size, size, size, this);
		g.drawImage(wKnight.getImage(), 1 * size, 7 * size, size, size, this);
		g.drawImage(wBishop.getImage(), 2 * size, 7 * size, size, size, this);
		g.drawImage(wQueen.getImage(), 3 * size, 7 * size, size, size, this);
		g.drawImage(wKing.getImage(), 4 * size, 7 * size, size, size, this);
		g.drawImage(wBishop.getImage(), 5 * size, 7 * size, size, size, this);
		g.drawImage(wKnight.getImage(), 6 * size, 7 * size, size, size, this);
		g.drawImage(wRook.getImage(), 7 * size, 7 * size, size, size, this);
	}
}
