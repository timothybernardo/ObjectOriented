package main.java.tictactoe;

import javax.swing.JFrame;
import javax.swing.JPanel;

// OUR PUBLISHER
public class TicTacToeViewFrame extends JFrame
    implements TicTacToeView {

  private final TicTacToePanel panel;


  public TicTacToeViewFrame(ReadonlyTicTacToeModel model) {
    this.setSize(400, 400);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.panel = new TicTacToePanel(model); // frame needs to pass model to panel
    this.add(panel);
  }

  @Override
  public void refresh() {
    this.repaint(); // whatever we are painting gets updated every time its called
  }

  @Override
  public void makeVisible() {
    setVisible(true);
  }

  @Override
  public void subscribe(FeaturesListener listener) {
    this.panel.subscribe(listener); // we need the mouse listener to call our onclick method
    // in this case, we added mouse listener to the panel. frame passes listener
  }

}
