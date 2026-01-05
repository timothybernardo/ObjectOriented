import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;

import java.awt.*;

//The publisher!!!
public class JFrameView extends JFrame implements IView {
  private JLabel display;
  private JButton echoButton, exitButton;
  private JTextField input;

  public JFrameView(String caption) {
    super(caption);

    setSize(500, 300);
    setLocation(200, 200);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //this.setResizable(false);
//		this.setMinimumSize(new Dimension(300,300));


    this.setLayout(new FlowLayout());

    display = new JLabel("To be displayed");
    //label = new JLabel(new ImageIcon("Jellyfish.JPG"));


    this.add(display);

    //the textfield
    input = new JTextField(10);
    this.add(input);

    //echobutton
    echoButton = new JButton("Echo");
    echoButton.setActionCommand("Echo button");
    this.add(echoButton);

    //exit button
    exitButton = new JButton("Exit");
    exitButton.setActionCommand("Exit Button");
    this.add(exitButton);

    pack();
  }

  @Override
  public void display() {
    setVisible(true);
  }

  @Override
  public void toggleColor() {
    // set color of text!
    if (display.getForeground().equals(Color.BLACK)) {
      display.setForeground(Color.RED);
    } else {
      display.setForeground(Color.BLACK);
    }
  }

  @Override
  public void refresh() {
    this.requestFocus();
    this.repaint();
  }


  @Override
  public void setListener(FeaturesListener listener) {
    // echoButton.addActionListener(evt -> listener.echoText(input.getText()));
    echoButton.addActionListener(
        new EchoListener(listener, input));
    exitButton.addActionListener(evt -> listener.quitProgram());
    this.addKeyListener(new ToggleColorKeyAdapater(listener)); // add key listener to frame!
  }

  class ToggleColorKeyAdapater extends KeyAdapter {
    // extending the adapter implements the listener automatically
    private FeaturesListener listener;

    public ToggleColorKeyAdapater(FeaturesListener listener) {
      this.listener = listener;
    }

    @Override
    public void keyTyped(KeyEvent evt) {
      if (evt.getKeyChar() == 'd') {
        listener.toggleColor();
      }
    }
  }

  @Override
  public void setEchoOutput(String s) {
    display.setText(s);
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
