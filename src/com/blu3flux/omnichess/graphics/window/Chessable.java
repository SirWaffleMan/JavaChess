package com.blu3flux.omnichess.graphics.window;

import com.blu3flux.omnichess.chess.ChessGame;
import com.blu3flux.omnichess.chess.Piece;

public interface Chessable {
    ChessGame chessGame = new ChessGame();

    public void handleMove(String move);
    private ChessGame getChessGameManager(){return chessGame;}
    public Piece[][] getPiecePlacement();
}
