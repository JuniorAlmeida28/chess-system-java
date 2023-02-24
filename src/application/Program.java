package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class Program {
    public static void main(String[] args) {
        Scanner en = new Scanner(System.in);
        ChessMatch chessMatch = new ChessMatch();

        while (true) {
            try {
                UI.clearScreen();
                UI.printBoard(chessMatch.getPieces());
                System.out.println();
                System.out.print("Origem: ");
                ChessPosition source = UI.readChessPosition(en);

                System.out.println();
                System.out.print("Destino: ");
                ChessPosition target = UI.readChessPosition(en);

                ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
            } catch (ChessException e) {
                System.out.println(e.getMessage());
                en.nextLine();
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
                en.nextLine();
            }
        }
    }
}
