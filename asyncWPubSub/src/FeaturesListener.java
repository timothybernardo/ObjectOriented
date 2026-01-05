
//Lives in the view package
// Any class interested in responding to these events should
// implement this interface (and become a subscriber)
//Can think of these as the commands the controller will execute
public interface FeaturesListener {

  void echoText(String text);

  void quitProgram();

  void toggleColor(); // new features become new behaviors in interface
}
