package texteditor;

import java.util.Stack;

public class EditorInvoker {
  private Stack<Command> undoStack = new Stack<>();
  private Stack<Command> redoStack = new Stack<>();

  public void executeCommand(Command command) {
    command.execute();
    undoStack.push(command);
    // Clear redo stack when new command is executed
    redoStack.clear();
  }

  public void undo() {
    if (!undoStack.isEmpty()) {
      Command command = undoStack.pop();
      command.undo();
      redoStack.push(command);
    }
  }

  public void redo() {
    if (!redoStack.isEmpty()) {
      Command command = redoStack.pop();
      command.execute();
      undoStack.push(command);
    }
  }

  public boolean canUndo() {
    return !undoStack.isEmpty();
  }

  public boolean canRedo() {
    return !redoStack.isEmpty();
  }
}