package texteditor;

public class Document {
  private StringBuilder content;

  public Document() {
    this.content = new StringBuilder();
  }

  public void insertText(int position, String text) {
    content.insert(position, text);
  }

  public void deleteText(int position, int length) {
    content.delete(position, position + length);
  }

  public String getContent() {
    return content.toString();
  }
}
