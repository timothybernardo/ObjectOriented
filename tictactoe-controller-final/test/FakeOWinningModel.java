import main.java.tictactoe.Player;
import main.java.tictactoe.TicTacToe;

public class FakeOWinningModel implements TicTacToe {
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
    return Player.O;
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
