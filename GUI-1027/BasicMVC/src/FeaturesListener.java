// Lives in the view package
// Can think of these as the commands the controller will execute!
public interface FeaturesListener {
  void echoText(String text);

  void quitProgram();
}