package Level2;

import java.util.Scanner;

public class TicTacToe {
    private static final int BOARD_SIZE = 3;
    private static final char EMPTY_CELL = ' ';
    private static final char PLAYER_X = 'X';
    private static final char PLAYER_O = 'O';

    private char[][] board;
    private char currentPlayer;
    private int playerXWins;
    private int playerOWins;
    private int draws;

    public TicTacToe() {
        board = new char[BOARD_SIZE][BOARD_SIZE];
        currentPlayer = PLAYER_X;
        initializeBoard();
        playerXWins = 0;
        playerOWins = 0;
        draws = 0;
    }

    private void initializeBoard() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                board[i][j] = EMPTY_CELL;
            }
        }
    }

    public void playGame() {
        Scanner scanner = new Scanner(System.in);

        boolean playAgain = true;
        while (playAgain) {
            boolean gameOver = false;

            while (!gameOver) {
                displayBoard();

                int row, col;
                do {
                    System.out.println("Player " + currentPlayer + ", enter your move (row and column): ");
                    row = scanner.nextInt() - 1;
                    col = scanner.nextInt() - 1;
                } while (!isValidMove(row, col));

                board[row][col] = currentPlayer;

                if (checkForWin(row, col)) {
                    displayBoard();
                    System.out.println("Player " + currentPlayer + " wins!");
                    updateScores(currentPlayer);
                    gameOver = true;
                } else if (checkForDraw()) {
                    displayBoard();
                    System.out.println("It's a draw!");
                    draws++;
                    gameOver = true;
                }

                currentPlayer = (currentPlayer == PLAYER_X) ? PLAYER_O : PLAYER_X;
            }

            System.out.println("Do you want to play again? (yes/no)");
            String response = scanner.next().toLowerCase();
            playAgain = response.equals("yes") || response.equals("y");

            initializeBoard();
            currentPlayer = PLAYER_X;
        }

        scanner.close();

        System.out.println("Cumulative Scores:");
        System.out.println("Player X Wins: " + playerXWins);
        System.out.println("Player O Wins: " + playerOWins);
        System.out.println("Draws: " + draws);
    }

    private boolean isValidMove(int row, int col) {
        if (row < 0 || row >= BOARD_SIZE || col < 0 || col >= BOARD_SIZE) {
            System.out.println("Invalid move. Row and column must be within 1 to " + BOARD_SIZE + ".");
            return false;
        }
        if (board[row][col] != EMPTY_CELL) {
            System.out.println("Invalid move. Cell is already occupied.");
            return false;
        }
        return true;
    }

    private boolean checkForWin(int row, int col) {

        if (board[row][0] == board[row][1] && board[row][1] == board[row][2]) {
            return true;
        }

        if (board[0][col] == board[1][col] && board[1][col] == board[2][col]) {
            return true;
        }

        if (row == col && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            return true;
        }

        if (row + col == BOARD_SIZE - 1 && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            return true;
        }
        return false;
    }

    private boolean checkForDraw() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (board[i][j] == EMPTY_CELL) {
                    return false;
                }
            }
        }
        return true;
    }

    private void updateScores(char winner) {
        if (winner == PLAYER_X) {
            playerXWins++;
        } else if (winner == PLAYER_O) {
            playerOWins++;
        }
    }

    private void displayBoard() {
        System.out.println("-------------");
        for (int i = 0; i < BOARD_SIZE; i++) {
            System.out.print("| ");
            for (int j = 0; j < BOARD_SIZE; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println("\n-------------");
        }
    }

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.playGame();
    }
}
