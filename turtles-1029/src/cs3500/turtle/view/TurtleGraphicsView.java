package cs3500.turtle.view;

import java.awt.*;
import java.awt.event.ActionEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import javax.swing.*;

import cs3500.turtle.model.Position2D;
import cs3500.turtle.tracingmodel.Line;

/**
 * This is an implementation of the IView interface
 * that uses Java Swing to draw the results of the
 * turtle. It shows any error messages using a
 * pop-up dialog box, and shows the turtle position
 * and heading
 */
public class TurtleGraphicsView extends JFrame implements IView {
  private JButton commandButton, quitButton;
  private JPanel buttonPanel;
  private TurtlePanel turtlePanel;
  private JScrollPane scrollPane;
  private JTextField input;

  public TurtleGraphicsView() {
    super();
    this.setTitle("Turtles!");
    this.setSize(500, 500);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    //use a borderlayout with drawing panel in center and button panel in south
    this.setLayout(new BorderLayout());
    turtlePanel = new TurtlePanel();
    turtlePanel.setPreferredSize(new Dimension(500, 500));
    scrollPane = new JScrollPane(turtlePanel);
    this.add(scrollPane, BorderLayout.CENTER);

    //button panel
    buttonPanel = new JPanel();
    buttonPanel.setLayout(new FlowLayout());
    this.add(buttonPanel, BorderLayout.SOUTH);

    //input textfield
    input = new JTextField(15);
    buttonPanel.add(input);

    //buttons
    commandButton = new JButton("Execute");
    buttonPanel.add(commandButton);

    //quit button
    quitButton = new JButton("Quit");
    buttonPanel.add(quitButton);

    this.pack();
  }

  @Override
  public void makeVisible() {
    this.setVisible(true);
  }

  @Override
  public void refresh() {
    //Need to reset the text field as well
    input.setText("");
    this.repaint();
  }

  // TODO: Complete the PubSub Pattern as the Publisher
  @Override
  public void setFeaturesListener(Features feats) {
    commandButton.addActionListener(evt -> feats.executeCommand(input.getText()));
    quitButton.addActionListener(evt -> feats.quitProgram());
  }

  // TODO: Add methods here to notify the TurtlePanel about what to draw.
  // Taking advantage of the package-private fields. Should I allow this?!
  @Override
  public void setPosition(Position2D pos) {
    turtlePanel.pos = pos;
  }

  @Override
  public void setHeading(double heading) {
    turtlePanel.headingDegrees = heading;
  }

  @Override
  public void setLines(List<Line> lines) {
    turtlePanel.curLines = new ArrayList<>(lines);
  }

  @Override
  public void showErrorMessage(String error) {
    JOptionPane.showMessageDialog(this, error, "Error", JOptionPane.ERROR_MESSAGE);
  }

}
