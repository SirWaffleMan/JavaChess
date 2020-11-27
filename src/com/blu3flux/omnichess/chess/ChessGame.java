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

    // Moves are in Long Algebraic Notation
    public boolean move(String move){

        //TODO: Check valid chess move notation

        String[] parsedMove = parseMove(move);
        String str_piece = parsedMove[0];
        String str_source = parsedMove[1];
        String str_dest = parsedMove[2];


        // check if piece exists
        Piece piece = getPiece(str_piece);
        if(piece == null)
            return false;

        // Check if player "owns" piece
        if(piece.getColor() != playerToMove)
            return false;

        // Check if player already has piece in destination
        Piece destination = getPiece(str_dest);
        if(destination != null && destination.getColor() != playerToMove)
            return false;

        //TODO: Check if piece can move to destination
        makeMove(parsedMove);

        return true;
    }

    private void makeMove(String [] move){
        Piece piece = getPiece(move[0]);
        int src_rank = getRankIndex(move[1]);
        int src_file = getFileIndex(move[1]);
        int dest_rank = getRankIndex(move[2]);
        int dest_file = getFileIndex(move[2]);

        // Place piece in destination
        this.board[dest_rank][dest_file] = piece;

        // remove old location
        this.board[src_rank][src_file] = null;
    }

    // Returns the parsed move (piece, source, destination)
    private String[] parseMove(String move){
        char [] minorMajorPieces = new char[]{'K', 'Q', 'R', 'B', 'N'};
        String[] parsedMove = new String[3];

        // Get piece
        for(char minorMajorPiece : minorMajorPieces){
            if(move.charAt(0) == minorMajorPiece)
                parsedMove[0] = String.valueOf(minorMajorPiece);
        }
        if(parsedMove[0] == null){
            parsedMove[0] = "";
        }

        // Get source
        parsedMove[1] = move.substring(1, 2);

        // get destination
        parsedMove[2] = move.substring(3, 4);

        return parsedMove;
    }

    private Piece getPiece(String coordinate){
        if(coordinate.length() != 2)
            return null;

        int fileIndex = getFileIndex(coordinate);
        int rankIndex = getRankIndex(coordinate);

        return this.board[rankIndex][fileIndex];
    }

    private int getFileIndex(String coordinate){
        char file = coordinate.charAt(0);
        return (int)(file - 'a');
    }

    private int getRankIndex(String coordinate){
        char rank = coordinate.charAt(1);
        return 7 - Character.getNumericValue(rank) - 1;
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
