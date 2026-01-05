import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class JFrameView extends JFrame implements ActionListener {

  private final JLabel echoLabel;
  private final JTextField input;

  public JFrameView() {
    this.setSize(600, 400); // x grows right, y grows down, sets size of frame
    this.setTitle("My First Frame!");
    this.setDefaultCloseOperation(EXIT_ON_CLOSE); // takes in an integer to tell      what to do
    this.setLocation(500, 300); // places where frame appears on screen!
    this.setBackground(Color.MAGENTA); // sets FRAME color!
//    this.getContentPane().setBackground(new Color(50, 50, 20)); // sets PANE color
    // you can make your own color using new Color(r, g, b)

    this.setLayout(new FlowLayout()); // You have to set up a layout manager before doing anything
    // all flowlayout does is if you give it content, it puts it side by side, by ORDER.

    echoLabel = new JLabel("String!"); // creates a label with "String", can put image
    this.add(echoLabel); // add to frame

    input = new JTextField(30); // customize how many characters you can fit in param
    this.add(input);

    JButton button = new JButton("Echo!"); // made a button! this is a component!
    // components just *exist* when you make them, you have to add it to frame/panel to exist
    button.setActionCommand("echo"); // if its echo, it "echoes" text
    button.addActionListener(this);
    // Swing knows that whenever they get an ActionListener,
    // the button handles it
    this.add(button);

    JButton quitButton = new JButton("Quit");
    quitButton.setActionCommand("quit"); // if its quit, it quits the program
    quitButton.addActionListener(this);
    this.add(quitButton);

    this.pack(); // resizes window to be "perfect" size
    this.setVisible(true);
  }

  // Callbacks: methods called when some event happens
  @Override
  public void actionPerformed(ActionEvent e) {
    // change the label's text to whatever is in the input field
    // clear the text field
    switch (e.getActionCommand()) {
      case "echo" -> {
        String echoText = input.getText();
        echoLabel.setText(echoText);
        input.setText("");
      }
      case "quit" -> {
        System.exit(0);
      }
    }
  }
}
