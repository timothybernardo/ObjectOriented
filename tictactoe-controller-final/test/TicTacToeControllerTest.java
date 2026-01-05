import static org.junit.Assert.assertEquals;

import java.io.StringReader;
import java.util.Arrays;
import main.java.tictactoe.TicTacToe;
import main.java.tictactoe.TicTacToeController;
import org.junit.Test;
import main.java.tictactoe.TicTacToe;
import main.java.tictactoe.TicTacToeModel;
import main.java.tictactoe.TicTacToeConsoleController;

/**
 * Test cases for the tic tac toe controller, using mocks for readable and appendable.
 */
public class TicTacToeControllerTest {

  // ADDITIONAL TEST CASES TO IMPLEMENT:
  // Play game to completion, where there is a winner
  // Input where the q comes instead of an integer for the row
  // Input where the q comes instead of an integer for the column
  // Input where non-integer garbage comes instead of an integer for the row
  // Input where non-integer garbage comes instead of an integer for the column
  // Input where the move is integers, but outside the bounds of the board
  // Input where the move is integers, but invalid because the cell is occupied
  // Multiple invalid moves in a row of various kinds
  // Input including valid moves interspersed with invalid moves, game is played to completion
  // What happens when the input ends "abruptly" -- no more input, but not quit, and game not over
  // THIS IS NOT AN EXHAUSTIVE LIST

  @Test
  public void testSingleValidMove() {
    TicTacToe m = new TicTacToeModel();
    StringBuilder gameLog = new StringBuilder();
    TicTacToeController c = new TicTacToeConsoleController(new StringReader("2 2 q"), gameLog);
    c.playGame(m);
    assertEquals("   |   |  \n"
        + "-----------\n"
        + "   |   |  \n"
        + "-----------\n"
        + "   |   |  \n"
        + "Enter a move for X:\n"
        + "   |   |  \n"
        + "-----------\n"
        + "   | X |  \n"
        + "-----------\n"
        + "   |   |  \n"
        + "Enter a move for O:\n"
        + "Game quit! Ending game state:\n"
        + "   |   |  \n"
        + "-----------\n"
        + "   | X |  \n"
        + "-----------\n"
        + "   |   |  \n", gameLog.toString());
  }

  @Test
  public void testBogusInputAsRow() {
    TicTacToe m = new TicTacToeModel();
    StringReader input = new StringReader("!#$ 2 q");
    StringBuilder gameLog = new StringBuilder();
    TicTacToeController c = new TicTacToeConsoleController(input, gameLog);
    c.playGame(m);
    // split the output into an array of lines
    String[] lines = gameLog.toString().split("\n");
    // check that it's the correct number of lines
    assertEquals(13, lines.length);
    // check that the last 6 lines are correct
    String lastMsg = String.join("\n",
        Arrays.copyOfRange(lines, lines.length - 6, lines.length));
    assertEquals("Game quit! Ending game state:\n"
        + "   |   |  \n"
        + "-----------\n"
        + "   |   |  \n"
        + "-----------\n"
        + "   |   |  ", lastMsg);
    // note no trailing \n here, because of the earlier split
  }

  @Test
  public void testTieGame() {
    TicTacToe m = new TicTacToeModel();
    // note the entire sequence of user inputs for the entire game is in this one string:
    StringReader input = new StringReader("2 2 1 1 3 3 1 2 1 3 2 3 2 1 3 1 3 2");
    StringBuilder gameLog = new StringBuilder();
    TicTacToeController c = new TicTacToeConsoleController(input, gameLog);
    c.playGame(m);
    String[] lines = gameLog.toString().split("\n");
    assertEquals(60, lines.length);
    assertEquals("Game is over! Tie game.", lines[lines.length - 1]);
  }

  @Test(expected = IllegalStateException.class)
  public void testFailingAppendable() {
    TicTacToe m = new TicTacToeModel();
    StringReader input = new StringReader("2 2 1 1 3 3 1 2 1 3 2 3 2 1 3 1 3 2");
    Appendable gameLog = new FailingAppendable();
    TicTacToeController c = new TicTacToeConsoleController(input, gameLog);
    c.playGame(m);
  }

  // I want a unit test to show the controller does not try to infer if the game
  // is over by looking at the board state directly
  @Test(timeout = 3000)
  public void testControllerDoesNotLookAtBoard() {
    Readable in = new StringReader("2 2");
    Appendable out = new StringBuilder();
    TicTacToe model = new FakeGameOverMock();
    TicTacToeController controller = new TicTacToeConsoleController(in, out);
    controller.playGame(model);
    String[] lines = out.toString().split("\n");
    assertEquals("Game is over! Tie game.", lines[lines.length - 1]);
  }

  // write a test that passes if and only if the controller behaves correctly when the game ends
  // and 0 wins the game
  @Test
  public void testGameOverWith0() {
    Readable in = new StringReader("2 2");
    Appendable out = new StringBuilder();
    TicTacToe model = new FakeOWinningModel();
    TicTacToeController controller = new TicTacToeConsoleController(in, out);
    controller.playGame(model);
    String[] lines = out.toString().split("\n");
    assertEquals("Game is over! O wins.", lines[lines.length - 1]);
  }

  // Write a test that passes if and only if the controller prints the correct invalid move
  // message if the user gives the controller illogical move. (Let's use "Invalid move. Play again."
  // as the message.)
  // Hint: What does the model do if given an illogical move?
  @Test
  public void testControllerPrintsCorrectIllogicalMove() {
    Readable in = new StringReader("1 1 q");
    Appendable out = new StringBuilder();
    TicTacToe model = new IllogicalMoveMock();
    TicTacToeController controller = new TicTacToeConsoleController(in, out);
    controller.playGame(model);
    String[] lines = out.toString().split("\n");
    assertEquals("Invalid move. Play again.", lines[lines.length - 1]);
  }

  // game end in three
}
