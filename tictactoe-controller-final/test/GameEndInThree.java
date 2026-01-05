import main.java.tictactoe.Player;
import main.java.tictactoe.TicTacToe;

public class GameEndInThree implements TicTacToe {
  private int numMoves;

  public GameEndInThree() {
  }

  @Override
  public void move(int row, int col) {
    this.numMoves--;
  }

  @Override
  public Player getTurn() {
    return null;
  }

  @Override
  public boolean isGameOver() {
    return this.numMoves <= 0;
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
