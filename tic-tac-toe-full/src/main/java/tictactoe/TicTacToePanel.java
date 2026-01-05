package main.java.tictactoe;

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class TicTacToePanel extends JPanel {

  public static final int LOGICAL_X = 30;
  public static final int LOGICAL_Y = 30;
  private final ReadonlyTicTacToeModel model;

  public TicTacToePanel(ReadonlyTicTacToeModel model) {
    // whenever you give a model to a view, make sure it's only one that
    // they can look into and cannot change
    if (model == null) {
      throw new IllegalArgumentException();
    }
    this.model = model;
    // this.addClickListener();
  }

  // keep listener private as no one else needs to know
  private void addClickListener(FeaturesListener listener) {
    this.addMouseListener(new MouseClickListener(listener, this));
    // ask for features listener to link it!
    // creates a mouse listener of a mouse adapter that listens to clicks!
  }

  public void subscribe(FeaturesListener listener) {
    addClickListener(listener);
  }

  // This is how you paint on a panel
  @Override
  protected void paintComponent(Graphics g) {
    // following 2 commands needed to paint
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g.create();
    // logical to panel
    // getWidth() physical / 30 logical
    // getHeight() / 30
    g2d.scale(getWidth() / LOGICAL_X, getHeight() / LOGICAL_Y);

    // model to logical
    // 30 logical / 3 col
    // 30 logical / 3 row
    drawLine(g2d, 0, 1, 3, 1);
    drawLine(g2d, 0, 2, 3, 2);
    drawLine(g2d, 1, 0, 1, 3);
    drawLine(g2d, 2, 0, 2, 3);
    // start point and end point of line
//    int physicalToModelX = getWidth() / 3;
//    int physicalToModelY = getHeight() / 3;
//    g2d.drawLine(1 * physicalToModelX, 0, 1 * physicalToModelX, getHeight());
//    g2d.drawLine(2 * physicalToModelX, 0, 2 * physicalToModelX, getHeight());
//    g2d.drawLine(0, 1 * physicalToModelY, getWidth(), 1 * physicalToModelY);
//    g2d.drawLine(0, 2 * physicalToModelY, getWidth(), 2 * physicalToModelY);
  }

  private void drawLine(Graphics2D g2d, int row1, int col1, int row2, int col2) {
    double modelRowToLogicalY = LOGICAL_Y / 3.0;
    double modelColToLogicalX = LOGICAL_X / 3.0;

    g2d.drawLine((int) (col1 * modelColToLogicalX), (int) (row1 * modelRowToLogicalY),
        (int) (col2 * modelColToLogicalX), (int) (row2 * modelRowToLogicalY));
  }
}
