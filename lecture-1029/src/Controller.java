import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// The subscriber in pub-sub with view
public class Controller implements FeaturesListener {
  private IModel model;
  private IView view;

  public Controller(IModel m, IView v) {
    model = m;
    view = v;
    view.setListener(this);
    view.display();
  }

  @Override
  public void echoText(String text) {
    model.setString(text);

    //clear input textfield
    view.clearInputString();
    //finally echo the string in view
    text = model.getString();
    view.setEchoOutput(text);
  }

  @Override
  public void quitProgram() {
    System.exit(0);
  }

  @Override
  public void toggleColor() {
    view.toggleColor();
  }
}
