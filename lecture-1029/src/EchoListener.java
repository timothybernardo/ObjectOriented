import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;

public class EchoListener implements ActionListener {
  private FeaturesListener listener;
  private JTextField input;

  public EchoListener(FeaturesListener listener, JTextField text) {
    this.listener = listener;
    this.input = text;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    // the echoText event is to be fired!!
    listener.echoText(input.getText());
  }
}
