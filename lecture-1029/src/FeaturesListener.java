
//Lives in the view package

/**
 * Events that the view will send off to any class
 * that wants to respond to them
 */
public interface FeaturesListener {

  void echoText(String text);

  void quitProgram();

  void toggleColor();

}
