# Memento Patter

It is a behavior design pattern which allows saving and restoring to some previous state of an object without the need to reveal its implementation.A clear example of this design pattern is in software applications, such as text editors, in which if an error was made, we can return to a previous state where no error was made.

## Class Diagram of example:

![Memento_Patter](//www.plantuml.com/plantuml/png/ZP712e9048Rl-nHxLC8Na10lGPTEzWAB3YgfApjZ5E6xjrEJQ0kH5-7__vd_6ysHZAEfxrJP6KHzXXiTgfQiqm-b_PDeybAg2tBjKB-adKOW3aPhAnQl5Y_-dZ5NOF44FGnaHNM0lWkY_gqkTgnc9KYY_EAHo9yyimgEFRQCSLyw1ASWKrvuph_sKfB9td729iJ-c7PStSgDgm-RPCjDgIuT60BS-3uGeFdeX9mBZ6Iphx5TXIg7eUAV-WG0)

## Example
Again, let's take a text editor. Previously, these editors did not have the option of reverting to a previous state in order to correct a mistake, so they had to redo all the work; if it was not time to redo everything.

We proceed to create the ``Text editor`` class which will have the role of organizer and which will have the ``save()`` method that creates a ``Memento`` object that represents the current state of the editor.

```Java
public class TextEditor {
    private String text;
    
    public void setText(String text) {
        this.text = text;
    }
    
    public String getText() {
        return text;
    }
    
    public Memento save() {
        return new Memento(text);
    }
    
    public void restore(Memento memento) {
        this.text = memento.getText();
    }
}
```

The ``Memento`` class is the class that stores the editor state and is used to restore the editor state at a later time.

```Java
public class Memento {
    private String text;
    
    public Memento(String text) {
        this.text = text;
    }
    
    public String getText() {
        return text;
    }
}
```

The ``TextEditorHistory`` class is the caretaker, which maintains a stack of "Memento" objects and has "push()" and "pop()" methods to add and remove objects from the stack.

```Java
public class TextEditorHistory {
    private Stack<Memento> mementoStack = new Stack<>();
    
    public void push(Memento memento) {
        mementoStack.push(memento);
    }
    
    public Memento pop() {
        return mementoStack.pop();
    }
}
```

a ``TextEditor`` object is created and a restore point is saved with the ``push()`` method of the ``TextEditorHistory`` class. Then more text is written and another restore point is saved. Finally, the previous state of the editor is restored by calling the ``restore()`` method of the ``TextEditor`` class and passing the corresponding ``Memento`` object.

```Java
editor.setText("Hello World!");
history.push(editor.save());

editor.setText("This is a example of Memento Patter.");
history.push(editor.save());

editor.restore(history.pop());

System.out.println(editor.getText());// Out: Hello World!.
```

[Back](../behavioral/README.md)