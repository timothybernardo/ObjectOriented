import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;

public class EchoListener implements ActionListener {
  private FeaturesListener listener;
  private JTextField text;

  public EchoListener(FeaturesListener listener, JTextField text) {
    this.listener = listener;
    this.text = text;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    listener.echoText(text.getText());
  }
}
