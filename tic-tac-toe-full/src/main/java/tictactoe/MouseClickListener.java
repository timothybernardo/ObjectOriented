package main.java.tictactoe;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;

public class MouseClickListener extends MouseAdapter {

  private final FeaturesListener listener;
  private final JPanel panel;

  public MouseClickListener(FeaturesListener listener, JPanel panel) {
    if (listener == null || panel == null) {
      throw new IllegalArgumentException();
    }
    this.listener = listener;
    this.panel = panel;
  }

  @Override
  public void mouseClicked(MouseEvent evt) {
    // CONVERT FROM PANEL COORDS TO MODEL COORDS
    // ratio is panel y multiplied by ratio (3 rows/height of panel)
    double row = evt.getY() * (3.0 / panel.getHeight());
    // ratio is panel x multiplied by ratio (3 rows/width of panel)
    double col = evt.getX() * (3.0 / panel.getWidth());
    listener.onClick((int) row, (int) col);
  }
}