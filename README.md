# TicTacToe Game 🎮

This Java program implements a simple command-line version of the classic TicTacToe game.

## Features 🚀

- Allows two players to play TicTacToe on a 3x3 board.
- Tracks and displays the cumulative scores of each player (X and O) and the number of draws.
- Provides validation for user inputs to ensure valid moves.

## How to Play 🎯

1. Run the `main` method in the `TicTacToe` class.
2. The game starts with Player X making the first move.
3. Players take turns entering their moves by specifying the row and column.
4. The game ends when a player wins by forming a horizontal, vertical, or diagonal line of their symbol (X or O), or when the board is full resulting in a draw.
5. After each game, players have the option to play again or exit the program.

## Instructions 📝

- Input for row and column should be integers between 1 and 3, representing the position on the board.
- Players are prompted to enter their moves alternatively.
- After each game, players are asked if they want to play again. Typing "yes" or "y" will start a new game, any other input will terminate the program.
- Cumulative scores for Player X, Player O, and draws are displayed at the end of the program.

## Running the Program 🏃‍♂️

1. Compile the `TicTacToe.java` file using a Java compiler.
2. Run the compiled class file.
3. Follow the on-screen instructions to play the game.

## Example Gameplay 🕹️

|   |   |   |
|---|---|---|
|   |   |   |
|   |   |   |
|   |   |   |

Player X, enter your move (row and column):
1 1

| X |   |   |
|---|---|---|
|   |   |   |
|   |   |   |

Player O, enter your move (row and column):
2 2

| X |   |   |
|---|---|---|
|   | O |   |
|   |   |   |

Player X, enter your move (row and column):
2 1

| X |   |   |
|---|---|---|
| X | O |   |
|   |   |   |

Enjoy playing TicTacToe! 😄
