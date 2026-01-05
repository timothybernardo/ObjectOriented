//The subscriber!
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
    view.refresh();
  }

  @Override
  public void quitProgram() {
    System.exit(0);
  }

  @Override
  public void toggleColor() {
    view.toggleColor(); // controller does not know how to toggle colors!
    // example of view's interface being built as we develop
    view.refresh();
  }
}
