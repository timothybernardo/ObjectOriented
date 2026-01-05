import main.java.tictactoe.Player;
import main.java.tictactoe.TicTacToe;

/**
 * Mocks the model that an invalid move was given.
 */
public class IllogicalMoveMock implements TicTacToe {
  @Override
  public void move(int row, int col) {
    throw new IllegalArgumentException();
  }

  @Override
  public Player getTurn() {
    return null;
  }

  @Override
  public boolean isGameOver() {
    return false;
  }

  @Override
  public Player getWinner() {
    return null;
  }

  @Override
  public Player[][] getBoard() {
    return new Player[0][];
  }

  @Override
  public Player getMarkAt(int row, int col) {
    return null;
  }
}
