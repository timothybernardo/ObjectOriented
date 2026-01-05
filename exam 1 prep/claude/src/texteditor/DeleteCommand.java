package texteditor;

public class DeleteCommand implements Command {
  private Document document;
  private String deletedText;
  private int position;
  private int length;

  public DeleteCommand(Document document, int position, int length) {
    this.document = document;
    this.position = position;
    this.length = length;
  }

  @Override
  public void execute() {
    // Save the text before deleting it
    String content = document.getContent();
    deletedText = content.substring(position, position + length);
    document.deleteText(position, length);
  }

  @Override
  public void undo() {
    // Restore the deleted text
    document.insertText(position, deletedText);
  }
}

