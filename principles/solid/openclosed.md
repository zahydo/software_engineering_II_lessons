## Open/Closed

The Open-Closed principle states that code should be designed to be easily extensible without having to change existing code. This is achieved by using abstractions to define common behaviors and creating new implementations of these abstractions to provide specific functionality. This makes the code easier to maintain and extend.

### Bad example:

This example violates the Open-Closed principle because each new file type you want to process requires modifying the existing "FileProcessor" class to add a new specific method. Instead of extending existing functionality, you are modifying the existing class, which makes the code more difficult to maintain and extend.

```Java
public class FileProcessor {
  public void processPdfFile(String filePath) {
    // Implementación específica para procesar archivos PDF
    System.out.println("Procesando archivo PDF en: " + filePath);
  }

  public void processExcelFile(String filePath) {
    // Implementación específica para procesar archivos Excel
    System.out.println("Procesando archivo Excel en: " + filePath);
  }

  public void processCsvFile(String filePath) {
    // Implementación específica para procesar archivos CSV
    System.out.println("Procesando archivo CSV en: " + filePath);
  }
}

public class Application {
  public static void main(String[] args) {
    // Crear instancia del procesador de archivo
    FileProcessor fileProcessor = new FileProcessor();

    // Procesar archivos utilizando métodos específicos
    fileProcessor.processPdfFile("ruta/al/archivo.pdf");
    fileProcessor.processExcelFile("ruta/al/archivo.xlsx");
    fileProcessor.processCsvFile("ruta/al/archivo.csv");
  }
}
```

### Good example:

This a good example because it uses abstractions, such as the "FileProcessor" interface, to define a common set of behaviors that entities must follow. Then, new implementations of this interface are created to provide specific functionality for each file type, without the need to modify the existing code. This approach makes the code easier to maintain and extend, since support for new file types can be added simply by creating new implementations of the "FileProcessor" interface, without the need to modify the existing class or the code that has already been written.

```Java
public interface FileProcessor {
  public void processFile(String filePath);
}

public class PdfFileProcessor implements FileProcessor {
  public void processFile(String filePath) {
    // Implementación específica para procesar archivos PDF
    System.out.println("Procesando archivo PDF en: " + filePath);
  }
}

public class ExcelFileProcessor implements FileProcessor {
  public void processFile(String filePath) {
    // Implementación específica para procesar archivos Excel
    System.out.println("Procesando archivo Excel en: " + filePath);
  }
}

public class CsvFileProcessor implements FileProcessor {
  public void processFile(String filePath) {
    // Implementación específica para procesar archivos CSV
    System.out.println("Procesando archivo CSV en: " + filePath);
  }
}

public class Application {
  public static void main(String[] args) {
    // Crear instancias de cada procesador de archivo
    FileProcessor pdfProcessor = new PdfFileProcessor();
    FileProcessor excelProcessor = new ExcelFileProcessor();
    FileProcessor csvProcessor = new CsvFileProcessor();

    // Procesar archivos utilizando los procesadores correspondientes
    pdfProcessor.processFile("ruta/al/archivo.pdf");
    excelProcessor.processFile("ruta/al/archivo.xlsx");
    csvProcessor.processFile("ruta/al/archivo.csv");
  }
}
```

### Related principles

- [Code For The Maintainer](../../principles/general/codeformantainer.md)
- [Boy-Scout Rule](../../principles/general/boyscoutrule.md)

### Related patterns

- Separation of Concerns
- Code For The Maintainer

---

[Back to the list](./README.md)
