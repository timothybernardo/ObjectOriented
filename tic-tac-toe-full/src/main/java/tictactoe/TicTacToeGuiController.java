package main.java.tictactoe;

// SUBSCRIBER
public class TicTacToeGuiController implements TicTacToeController, FeaturesListener {
  private TicTacToeView view;
  private TicTacToe model;

  public TicTacToeGuiController(TicTacToeView view) {
    if (view == null) {
      throw new IllegalArgumentException("View cannot be null");
    }
    this.view = view;
    this.view.subscribe(this);
  }

  @Override
  public void onClick(int posX, int posY) {
    System.out.println(posX + "," + posY);
  }

  @Override
  public void playGame(TicTacToe model) {
    this.model = model;
    view.makeVisible();
  }
}