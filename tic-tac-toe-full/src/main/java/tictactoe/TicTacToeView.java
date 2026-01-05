package main.java.tictactoe;

/**
 * A view for Tic-Tac-Toe: display the game board and provide visual interface for users.
 */
public interface TicTacToeView {

  /**
   * Refresh the view to reflect any changes in the game state.
   */
  void refresh();

  /**
   * Make the view visible to start the game session.
   */
  void makeVisible();

  /**
   * Adds a subscriber.
   */
  void subscribe(FeaturesListener listener);

}
