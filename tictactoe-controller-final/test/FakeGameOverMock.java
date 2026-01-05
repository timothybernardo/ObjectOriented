import main.java.tictactoe.Player;
import main.java.tictactoe.TicTacToe;

/**
 * Mocks the model into believing the game is in fact
 * over, but if you observe the board, it never actually starts.
 */
public class FakeGameOverMock implements TicTacToe {
  @Override
  public void move(int row, int col) {
  }

  @Override
  public Player getTurn() {
    return null;
  }

  @Override
  public boolean isGameOver() {
    return true;
  }

  @Override
  public Player getWinner() {
    return null;
  }

  @Override
  public Player[][] getBoard() {
    return new Player[3][3];
  }

  @Override
  public Player getMarkAt(int row, int col) {
    return null;
  }
}
