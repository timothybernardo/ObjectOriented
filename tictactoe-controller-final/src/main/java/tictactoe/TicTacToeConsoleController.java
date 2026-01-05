package main.java.tictactoe;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Controller that reads input from any Readable source and appends
 * to any Appendable source. Stops when quit or the game is over.
 */
public class TicTacToeConsoleController implements TicTacToeController {

  private final Appendable out;
  private final Scanner scan;

  /**
   * Creates the controller to read from in and print to out.
   *
   * @param in  input source
   * @param out output dest
   * @throws IllegalArgumentException if in or out are null
   */
  public TicTacToeConsoleController(Readable in, Appendable out) {
    if (in == null || out == null) {
      throw new IllegalArgumentException("Readable and Appendable can't be null");
    }
    this.out = out;
    scan = new Scanner(in);
  }

  @Override
  public void playGame(TicTacToe model) {
    try {
      while (!model.isGameOver()) {
        try {
          printGameState(model);
          printPrompt(model);
          readInputs(model);
        } catch (QuitException ex) {
          transmitGameQuit(model);
          return;
        }
      }
      transmitGameOver(model);
    } catch (IOException | NoSuchElementException ex) {
      throw new IllegalStateException("Bad IO");
    }
  }

  private void transmitGameOver(TicTacToe model) throws IOException {
    printGameState(model);
    String endMsg =
        switch (model.getWinner()) {
          case null -> "Tie game.";
          case X -> "X wins.";
          case O -> "O wins.";
        };
    transmit("Game is over! " + endMsg);
  }

  private void transmitGameQuit(TicTacToe model) throws IOException {
    transmit("Game quit! Ending game state:");
    printGameState(model);
  }

  private void transmit(String message) throws IOException {
    out.append(message + "\n");
  }

  private void printGameState(TicTacToe model) throws IOException {
    transmit(model.toString());
  }

  private void printPrompt(TicTacToe model) throws IOException {
    transmit("Enter a move for " + model.getTurn() + ":");
  }

  private void readInputs(TicTacToe model) throws IOException {
    int row;
    row = readInt();
    int col = readInt();
    try {
      model.move(row, col);
    } catch (IllegalArgumentException | IllegalStateException ex) {
      transmit("Illegal move.");
    }
  }

  private int readInt() throws IOException {
    int ans;
    while (scan.hasNext()) {
      try {
        ans = scan.nextInt() - 1;
        return ans;
      } catch (InputMismatchException ex) {
        String token = scan.next();
        if (token.equals("q") || token.equals("Q")) {
          throw new QuitException();
        }
        transmit("ERR: Enter a valid number");
      }
    }
    throw new NoSuchElementException(); //We must have run out of input!
  }

  //Private class we are using to name a specific exception
  //Not public because client shouldn't know. But could have been
  //package-private. But it's one line, so I'm okay with hiding it here.
  class QuitException extends RuntimeException {
  }
}
