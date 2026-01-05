package texteditor;

public class InsertCommand implements Command {
  private Document document;
  private String text;
  private int position;

  public InsertCommand(Document document, String text, int position) {
    this.document = document;
    this.text = text;
    this.position = position;
  }

  @Override
  public void execute() {
    document.insertText(position, text);
  }

  @Override
  public void undo() {
    document.deleteText(position, text.length());
  }
}
