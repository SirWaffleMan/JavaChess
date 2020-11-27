package com.blu3flux.omnichess.chess;

import com.blu3flux.omnichess.utils.FENValidator;

public class ChessGame {

    private String fen;
    private Piece[][] board;
    private PieceColor playerToMove;
    private String castlingAvailability;
    private String enPassant;
    private int halfMoveClock;
    private int fullMoveNumber;

    public ChessGame(){
        fen = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1";
        setBoard(fen);
    }

    public void setBoard(String fen){

        if(!FENValidator.checkValidFEN(fen)){
            System.err.println("This is an invalid fen!");
            return;
        }

        // parse FEN string
        String[] fenFields = fen.split(" ");
        String piecePlacement = fenFields[0];
        String activeColor = fenFields[1];
        String castlingAvailability = fenFields[2];
        String enPassantTargetSquare = fenFields[3];
        String halfMoveClock = fenFields[4];
        String fullMoveNumber = fenFields[5];

        // set board and flags
        this.placeChessPieces(piecePlacement);
        this.playerToMove = (activeColor.equals("w")) ? PieceColor.WHITE : PieceColor.BLACK;
        this.castlingAvailability = castlingAvailability;
        this.enPassant = enPassantTargetSquare;
        this.halfMoveClock = Integer.parseInt(halfMoveClock);
        this.fullMoveNumber = Integer.parseInt(fullMoveNumber);

    }

    private void placeChessPieces(String piecePlacement){
        this.board = new Piece[8][8];

        String [] piecePlacementRanks = piecePlacement.split("/");
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                char piece = piecePlacementRanks[i].charAt(j);

                // if character is number, it means empty spaces
                if(Character.isDigit(piece)){
                    j += Character.getNumericValue(piece);
                    continue;
                }

                switch(piece){
                    case 'k':
                        board[i][j] = new King(PieceColor.BLACK);
                        break;
                    case 'q':
                        board[i][j] = new Queen(PieceColor.BLACK);
                        break;
                    case 'r':
                        board[i][j] = new Rook(PieceColor.BLACK);
                        break;
                    case 'b':
                        board[i][j] = new Bishop(PieceColor.BLACK);
                        break;
                    case 'n':
                        board[i][j] = new Knight(PieceColor.BLACK);
                        break;
                    case 'p':
                        board[i][j] = new Pawn(PieceColor.BLACK);
                        break;
                    case 'K':
                        board[i][j] = new King(PieceColor.WHITE);
                        break;
                    case 'Q':
                        board[i][j] = new Queen(PieceColor.WHITE);
                        break;
                    case 'R':
                        board[i][j] = new Rook(PieceColor.WHITE);
                        break;
                    case 'B':
                        board[i][j] = new Bishop(PieceColor.WHITE);
                        break;
                    case 'N':
                        board[i][j] = new Knight(PieceColor.WHITE);
                        break;
                    case 'P':
                        board[i][j] = new Pawn(PieceColor.WHITE);
                        break;
                    default:
                        System.err.println("There was an error placing chess pieces!");
                        break;
                }

            }
        }
    }

}
