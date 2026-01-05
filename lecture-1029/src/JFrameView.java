import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Publisher for Pub-sub pattern
public class JFrameView extends JFrame implements IView {
  private JLabel display;
  private JButton echoButton, exitButton;
  private JTextField input;

  public JFrameView(String caption) {
    super(caption);

    setSize(500, 300);  // x grows right, y grows down, sets size of frame
    setLocation(200, 200);  // places where frame appears on screen!
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// takes in an integer to tell what to do
    //this.setResizable(false);
//		this.setMinimumSize(new Dimension(300,300));


    this.setLayout(new FlowLayout()); // You have to set up a layout manager before doing anything
    // all flowlayout does is if you give it content, it puts it side by side, by ORDER.

    display = new JLabel("String!"); // creates a label with "String", can put image
    //label = new JLabel(new ImageIcon("Jellyfish.JPG"));


    this.add(display); // add to frame

    // the textfield, how many characters in param
    input = new JTextField(10);
    this.add(input);

    // echo button
    echoButton = new JButton("Echo");  // made a button! this is a component!
    // components just *exist* when you make them, you have to add it to frame/panel to exist
    echoButton.setActionCommand("Echo button");  // if its echo, it "echoes" text

    this.add(echoButton);

    //exit button
    exitButton = new JButton("Exit");
    exitButton.setActionCommand("Exit Button");
    this.add(exitButton);

    pack(); // resizes window to be perfect size
  }

  @Override
  public void display() {
    setVisible(true);
  }

  @Override
  public void toggleColor() {
    if (display.getForeground().equals(Color.BLACK)) {
      display.setForeground(Color.RED);
    } else {
      display.setForeground(Color.BLACK);
    }
  }


  @Override
  public void setListener(FeaturesListener listener) {
    echoButton.addActionListener(
        new EchoListener(listener, input));
    exitButton.addActionListener(evt -> listener.quitProgram());

    KeyListener keyListener = new KeyListener() {
      @Override
      public void keyTyped(KeyEvent e) {
        if (e.getKeyChar() == 'd') {
          toggleColor();
        }
      }

      @Override
      public void keyPressed(KeyEvent e) {

      }

      @Override
      public void keyReleased(KeyEvent e) {

      }
    };
    this.addKeyListener(keyListener);
  }

  @Override
  public void setEchoOutput(String s) {
    display.setText(s);
    this.requestFocus(); // requests focus to the frame, that way, we are not focusing on any other
    //                      elements
  }

  @Override
  public String getInputString() {
    return input.getText();
  }

  @Override
  public void clearInputString() {
    input.setText("");
  }
}
