# Visitor

The Visitor design pattern is a behavioral pattern that allows separating complex algorithms from the structure of objects on which they operate.

This pattern is used when operations need to be performed on a structure of objects composed of different classes, but the structure of these classes should not be modified to handle changes in the operations. Instead, a new Visitor class is defined that implements the operations to be performed on the structure of objects.

Each class in the object structure accepts an instance of the Visitor and allows it to perform the necessary operations on it. Thus, the Visitor design pattern enables adding new operations without having to modify existing classes in the object structure.

Let's assume we have an application that processes different types of documents (e.g. PDF, Word, Excel, etc.) and we need to implement a functionality to calculate the number of words in each document. Each type of document has its own internal structure and therefore needs a different processing approach to calculate the number of words.

To solve this problem, we can use the Visitor pattern. We can define a Visitor interface with a method for each type of document, which calculates the number of words in that type of document. Then, we can create a concrete class for each type of document and make it implement the Visitor interface. Finally, we can create a Document class that accepts visitors (visit) and provides an accept method that accepts a visitor and calls the appropriate method based on the type of document.

## Diagram class of example
![ClassDiagram](http://www.plantuml.com/plantuml/png/hL2x2i8m5DtlLzmnHVe73WMhivFE8RcLGDgKF5f1_NURI4i9BXM7d73VvvpAUMvzQ3MepfDjk22iZGWjTVwYdFB6uWC6eoGECJpN9pOzx6LJhD9NOoMBWEC4wyhnBaYpX4WH2tZ1bsFp5Iu4zPxb78RFduQ5vivXPB5r9Z7SEfIu_tGgleC9QoTBdAJZE1TWb-8R-QMN5V-tUp5v_opBw5oMYQkoL5e1a0jTsdDjK54dGwlV)


# Example

```java
interface DocumentVisitor {
    void visitPDF(PDF pdf);
    void visitWord(Word word);
    void visitExcel(Excel excel);
}

interface Document {
    void accept(DocumentVisitor visitor);
}

class PDF implements Document {
    // Implementación específica de PDF
    @Override
    public void accept(DocumentVisitor visitor) {
        visitor.visitPDF(this);
    }
}

class Word implements Document {
    // Implementación específica de Word
    @Override
    public void accept(DocumentVisitor visitor) {
        visitor.visitWord(this);
    }
}

class Excel implements Document {
    // Implementación específica de Excel
    @Override
    public void accept(DocumentVisitor visitor) {
        visitor.visitExcel(this);
    }
}

class WordWordCountVisitor implements DocumentVisitor {
    private int wordCount = 0;

    @Override
    public void visitPDF(PDF pdf) {
        // No hacer nada para PDF
    }

    @Override
    public void visitWord(Word word) {
        // Contar la cantidad de palabras en Word
        wordCount = word.getContent().split("\\s+").length;
    }

    @Override
    public void visitExcel(Excel excel) {
        // No hacer nada para Excel
    }

    public int getWordCount() {
        return wordCount;
    }
}

public class Main {
    public static void main(String[] args) {
        // Creamos una lista de documentos
        List<Document> documents = Arrays.asList(new PDF(), new Word(), new Excel(), new Word());

        // Creamos un visitante que cuenta la cantidad de palabras en documentos de Word
        WordWordCountVisitor wordCountVisitor = new WordWordCountVisitor();

        // Procesamos cada documento y llamamos al visitante en los documentos de Word
        for (Document document : documents) {
            document.accept(wordCountVisitor);
            System.out.println("Word count for " + document.getClass().getSimpleName() + ": " + wordCountVisitor.getWordCount());
        }
    }
}